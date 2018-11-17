import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {
        super(1700, 900, 1, false);
        GreenfootImage bg = new GreenfootImage("GameOverBg.png");
        bg.scale(getWidth(), getHeight());
        this.setBackground(bg);
        addObject(new Hero(), 600, 200);
    }
}
