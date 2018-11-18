import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage image = getImage();
    private String[] walkingPlayerImg =     {"p1_walk01.png", "p1_walk02.png", "p1_walk03.png", "p1_walk04.png", "p1_walk05.png", "p1_walk06.png", "p1_walk07.png", "p1_walk08.png",
                                                "p1_walk09.png", "p1_walk10.png", "p1_walk11.png"};
    private int currentImage = 0;
    
    private GreenfootImage jump;
    private int leven = 5;
    
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        getImage().scale(50, 70);
       
        jump = new GreenfootImage ("p1_jump.png");
    }
  
    @Override
    public void act() {
        getWorld().showText("Aantal Levens: "+leven, 20 , 20);
        handleInput();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();        
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            leven-=1;
            if (enemy != null) {
                this.setLocation(164, 1406);
                setImage("p1.png");
                break;
            }
        }
        
        for (Actor waterTile : getIntersectingObjects(WaterTile.class)) {
            leven-=1;
            if (waterTile != null){
                if (leven == 0){
                    Greenfoot.setWorld(new GameOver());
                }
                this.setLocation(164, 1406);
                setImage("p1.png");
                break;
            }
        
        }
        
        for (Actor spikes : getIntersectingObjects(Spikes.class)) {
            if (spikes != null) {
                this.setLocation(164, 1406);
                setImage("p1.png");
                break;
            }
        }
        
        for (Actor goldCoin : getIntersectingObjects(GoldCoin.class)) {
            if (goldCoin != null) {
                getWorld().removeObject(goldCoin);
                break;
            }
        }
    }

    public void handleInput() {
        
        if (Greenfoot.isKeyDown("space")&&onGround()) {
            velocityY = -15;    
            setImage(jump);
            getImage().scale(50, 70);
        }
        
        if (Greenfoot.isKeyDown("left")) {
            velocityX = -5;
            if (onGround()==false){
                setImage(jump); 
                getImage().mirrorHorizontally();
            }
            else{
                currentImage++;
                if (currentImage>=walkingPlayerImg.length){
                    currentImage=0;
                }
                GreenfootImage newImage = new GreenfootImage (walkingPlayerImg[currentImage]);  
                newImage.mirrorHorizontally();
                setImage(newImage);
            }
            
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 5;
            if (onGround()==false){
                setImage(jump);                
            }
            else{
                currentImage++;
                if (currentImage>=walkingPlayerImg.length){
                    currentImage=0;
                }
                GreenfootImage newImage = new GreenfootImage (walkingPlayerImg[currentImage]);  
                setImage(newImage);
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
    
    public boolean onGround(){
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        return platform!= null;
    }
}
