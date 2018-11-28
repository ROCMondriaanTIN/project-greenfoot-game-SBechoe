import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterCoinBlue extends Coin
{
    public CharacterCoinBlue(){
        setImage("hud_p2.png");
    }
    public void act() 
    {
        applyVelocity();   
    }    
}
