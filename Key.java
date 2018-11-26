import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Mover
{
    public boolean isGepakt;
    
    public Key(boolean isGepakt)
    {
        this.isGepakt = isGepakt;
    }
    
    public void act() 
    {
        if(isGepakt==false)
        {
            setImage("hud_keyGreen.png");
            applyVelocity();
        }
        
        //setImage("hud_keyGreem_disabled.png");
    }    
}
