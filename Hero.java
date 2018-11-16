
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage walk02;    
    private GreenfootImage walk03;
    private GreenfootImage walk04;
    private GreenfootImage walk05;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        getImage().scale(50, 70);
        
        walk02 = new GreenfootImage("p1_walk02.png");
        walk03 = new GreenfootImage("p1_walk03.png");
        walk04 = new GreenfootImage("p1_walk04.png");
        walk05 = new GreenfootImage("p1_walk05.png");
    }

    @Override
    public void act() {
        handleInput();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();        
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                this.setLocation(164, 1406);
                //getWorld().removeObject(this);
                break;
            }
        }
        
        for (Actor waterTile : getIntersectingObjects(WaterTile.class)) {
            if (waterTile != null) {
                this.setLocation(164, 1406);
                //getWorld().removeObject(this);
                break;
            }
        }
        
        for (Actor spikes : getIntersectingObjects(Spikes.class)) {
            if (spikes != null) {
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
            velocityY = -15;
            /*setImage("p1_jump.png");
            getImage().scale(50, 70);*/
        }

        if (Greenfoot.isKeyDown("left")) {
            velocityX = -5;
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 5;
            setImage(walk02);
            /*for ()
            {
                if (getImage() == walk02)
                {
                    setImage(walk03);
                }
                if(getImage() == walk03)
                {
                    setImage(walk04);
                }
                if(getImage() == walk04)
                {
                    setImage(walk05);
                }
            }*/
        }
        
        getImage().scale(50, 70);
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
