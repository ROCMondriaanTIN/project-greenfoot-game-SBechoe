import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldCoin extends Mover
{
    /**
     * Act - do whatever the GoldCoin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyVelocity();
        setImage("coinGold.png");
    }    
}
