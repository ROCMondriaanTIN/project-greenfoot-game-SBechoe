import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Silver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Silver extends Coin
{
    public void act() 
    {
        applyVelocity();
        //removeCoin();
    }
    
    public void removeCoin()
    {
        if(getWorld().getObjects(Gold.class).size()== 0){
            setImage("bomb.png");
        }
    }
}
