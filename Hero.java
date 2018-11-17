
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private int frame;
    private int frame2;
    private GreenfootImage walk02;    
    private GreenfootImage walk03;
    private GreenfootImage walk05;
    private GreenfootImage jump;
    private int leven = 5;
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        getImage().scale(50, 70);
        frame = 0;
        
        walk02 = new GreenfootImage("p1_walk02.png");
        walk03 = new GreenfootImage("p1_walk03.png");
        walk05 = new GreenfootImage("p1_walk05.png");
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
                //getWorld().removeObject(this);
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
                break;
            }
        
        }
        
        for (Actor spikes : getIntersectingObjects(Spikes.class)) {
            if (spikes != null) {
                leven-=1;
                this.setLocation(164, 1406);
                //getWorld().removeObject(this);
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
        
        if (Greenfoot.isKeyDown("space")) {
            if (!this.isTouching(Platform.class))
            {velocityY = -15;
            animateJumping();
            getImage().scale(50, 70);}
        }
        
        if (Greenfoot.isKeyDown("left")) {
            velocityX = -5;
            
            animateWalking();
            
            //getImage().mirrorVertically();
             
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 5;
            setImage(walk02);
            animateWalking();
        }
        getImage().scale(50, 70);
    }
    
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    public void animateWalking()
    {
        if(frame == 0) {
            setImage(walk02);
        }
        else if(frame == 1) {
            setImage(walk03);
        }
        else if(frame == 2) {
            setImage(walk05);
        }
        else if(frame == 3) {
            setImage(walk02);
            frame = 0;
            return;
        }
        frame++;
    }
    
    public void animateJumping()
    {
        if(frame2 == 0) {setImage(jump);}
        else if(frame2 == 1) {setImage(jump);}
        else if(frame2 > 1) {
            setImage(jump);
        }
        frame2++;
    }
}
