import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorTop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorTop extends Mover
{
    /**
     * Act - do whatever the DoorTop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       applyVelocity();
       setImage("door_closedTop.png");
       openDoorTop();
    }    
    
    public void openDoorTop()
    {
       if(getWorld().getObjects(Key.class).size()== 0){
            setImage("door_openTop.png");
        }
    }
}
