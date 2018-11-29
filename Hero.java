        import greenfoot.*;
        
        /**
         *
         * @author R. Springer
         */
    public class Hero extends Mover {
        private final double gravity;
        private final double acc;
        private final double drag;
            
        private int leven = 2;
        
        private int currentImage = 0;
        private GreenfootImage jump;
        private GreenfootImage image = getImage();
        private String[] walkingPlayerImg =     {"p1_walk01.png", "p1_walk02.png", "p1_walk03.png", "p1_walk04.png", "p1_walk05.png", 
                                            "p1_walk06.png", "p1_walk07.png", "p1_walk08.png","p1_walk09.png", "p1_walk10.png", "p1_walk11.png"};
        Scoreboard sb; 
        
        private int charStatus;
       
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
                sb.updateLife();
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
                    this.setLocation(164, 1406);
                    setImage("p1.png");
                    break;
                }
            }
            //Dood gaan door water
            for (Actor waterTile : getIntersectingObjects(WaterTile.class)) {
                if (waterTile != null){
                    this.setLocation(164, 1406);
                    setImage("p1.png");
                    break;
                }
            
            }
            //Dood gaan ing door spikes
            for (Actor spikes : getIntersectingObjects(Spikes.class)) {
                if (spikes != null) {
                    this.setLocation(164, 1406);
                    setImage("p1.png");
                    break;
                }
            }
            //Munten verzamelen
            for (Actor coin : getIntersectingObjects(Coin.class)) {
                if (coin != null) {
                    if (this.isTouching(Gold.class)){
                        Actor goud = getOneIntersectingObject(Gold.class);  
                        getWorld().removeObject(goud);
                        sb.updateScoreGold();
                        break;
                    }else if (this.isTouching(Silver.class)){
                        Actor zilver = getOneIntersectingObject(Silver.class);  
                        getWorld().removeObject(zilver);
                        sb.updateScoreSilver();
                        break;
                    }else if (this.isTouching(CharacterCoinBlue.class)){
                        Actor blue = getOneIntersectingObject(CharacterCoinBlue.class);  
                        getWorld().removeObject(blue);
                        charStatus = 3;
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
        
        public void offSide()
        {
            if(this.isAtEdge()==true)
            {
                leven -=1;
                this.setLocation(180, 1406);
            }
        }
       
        public boolean onGround(){
            Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
            return platform!= null;
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
