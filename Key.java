import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Mover
{
    public Key()
    {
        setImage("hud_keyGreen.png");
    }
    
    public void act() 
    {
       applyVelocity();
    }    
}
