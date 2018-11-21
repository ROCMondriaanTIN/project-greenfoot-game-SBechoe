import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Silver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Silver extends Coin
{
    public boolean isGepakt;
    public Silver(boolean isGepakt)
    {
        this.isGepakt = isGepakt;
    }
    
    public void act() 
    {
        if(isGepakt==false)
        {
            applyVelocity();
        }
    }
}
