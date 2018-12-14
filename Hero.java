import greenfoot.*;

public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    
    private int charStatus;
    private int currentImage = 0;
    
    private GreenfootImage jump;
    private GreenfootImage image = getImage();
    private String[] walkingPlayerImg1 =     {"p1_walk01.png", "p1_walk02.png", "p1_walk03.png", "p1_walk04.png", "p1_walk05.png", 
                                        "p1_walk06.png", "p1_walk07.png", "p1_walk08.png","p1_walk09.png", "p1_walk10.png", "p1_walk11.png"};
    private String[] walkingPlayerImg2 =     {"p2_walk01.png", "p2_walk02.png", "p2_walk03.png", "p2_walk04.png", "p2_walk05.png", 
                                        "p2_walk06.png", "p2_walk07.png", "p2_walk08.png","p2_walk09.png", "p2_walk10.png", "p2_walk11.png"};
    Scoreboard sb; 
    
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
                
        setImage("p1.png");
        getImage().scale(50, 70);
        jump = new GreenfootImage ("p1_front.png");
    }
    
    @Override
    public void act() {
        if(sb == null){
            sb = new Scoreboard();
            getWorld().addObject(sb, -10, -10);
            sb.checkKey();
            sb.updateLife(false);
        }
                        
        handleInput();
        offSide();
        charSwitch();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity(); 
        
        //Dood gaan door enemy
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                setImage("p1.png");
                sb.updateLife(true);
                checkWorld();
                break;
            }
        }
        
        //Dood gaan door water
        for (Actor waterTile : getIntersectingObjects(WaterTile.class)) {
            if (waterTile != null){
                setImage("p1.png");
                sb.updateLife(true);
                checkWorld();
                break;
            }
        }
        //Dood gaan ing door spikes
        for (Actor spikes : getIntersectingObjects(Spikes.class)) {
            if (spikes != null) {
                setImage("p1.png");
                sb.updateLife(true);
                checkWorld();
                break;
            }
        }
        //Munten verzamelen
        for (Actor coin : getIntersectingObjects(Coin.class)) {
            if (coin != null) {
                if (this.isTouching(Gold.class)){
                    Actor goud = getOneIntersectingObject(Gold.class);  
                    getWorld().removeObject(goud);
                    sb.updateScore("goldCoin");
                    break;
                }else if (this.isTouching(Silver.class)){
                    Actor zilver = getOneIntersectingObject(Silver.class);  
                    getWorld().removeObject(zilver);
                    sb.updateScore("silverCoin");
                    break;
                }else if (this.isTouching(CharacterCoinBlue.class)){
                    Actor blue = getOneIntersectingObject(CharacterCoinBlue.class);  
                    getWorld().removeObject(blue);
                    charStatus = 2;
                    break;
                }
            }
        }
        //Sleutel pakken
        for (Actor keys : getIntersectingObjects(Key.class)) {
            if (keys != null) {
                Actor key = getOneIntersectingObject(Key.class);  
                getWorld().removeObject(key);
                sb.checkKey();
                break;
            }
        }
    }
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("space")/*&&onGround()*/) {
            velocityY = -15;    
            setImage(jump);
            getImage().scale(50, 70);
        }
            
        if (Greenfoot.isKeyDown("left")) {
            velocityX = -5;
            if (onGround()==false){
                setImage(jump); 
            }
            else{
                currentImage++;
                if (currentImage>=walkingPlayerImg1.length){
                    currentImage=0;
                }
                GreenfootImage walkImage = new GreenfootImage (walkingPlayerImg1[currentImage]);  
                walkImage.mirrorHorizontally();
                setImage(walkImage);
            }
        }else if (Greenfoot.isKeyDown("right")) {
            velocityX = 5;
            if (onGround()==false){
                setImage(jump);                
            }
            else{
                currentImage++;
                if (currentImage>=walkingPlayerImg1.length){
                    currentImage=0;
                }
                GreenfootImage walkImage = new GreenfootImage (walkingPlayerImg1[currentImage]);
                setImage(walkImage);
            }
        }
        getImage().scale(50, 70);
    }
    
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    public void offSide()
    {
        if(this.isAtEdge()==true)
        {
            //leven -=1;
            this.setLocation(180, 1406);
        }
    }
   
    public boolean onGround(){
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        return platform!= null;
    }
    
    public void checkWorld()
    {
        if(getWorld().getClass()==Level1.class)
        {
           this.setLocation(180, 1370);
        }
        if(getWorld().getClass()==TestLevel.class)
        {
           this.setLocation(120, 612);
        }
        if(getWorld().getClass()==GameOver.class)
        {
           this.setLocation(120, 612);
        }
    }
    
    public void charSwitch() {
        switch (charStatus) {
            case 1:  setImage("p1.png");
                     break;
            case 2:  setImage("p2_stand.png");
                     break;
            case 3:  setImage("p3_stand.png");
                     break;
        }
    }
}
