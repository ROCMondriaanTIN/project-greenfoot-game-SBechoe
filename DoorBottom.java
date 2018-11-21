import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorBottom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorBottom extends Mover
{
    /**
     * Act - do whatever the DoorBottom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyVelocity();
        setImage("door_closedMid.png");
        openDoorBottom();
    }    
    
    public void openDoorBottom()
    {
       if(getWorld().getObjects(Key.class).size()== 0){
            setImage("door_openMid.png");
        }
    }
}
