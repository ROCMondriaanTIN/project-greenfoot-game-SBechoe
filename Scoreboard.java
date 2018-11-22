import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scoreboard extends Actor
{
    private int xPositieSilver = 30;
    private int xPositieGold = 30;
    private int xPositieLife = 30;
    private int score = 0;
    private int leven = 2;
    
    public void act() 
    {
       updateLife();
    } 

    public void updateLife()
    {
        if(score==20){
           leven++;
           getWorld().addObject(new HudLife(), xPositieLife, 40);
           xPositieLife+=50;
           score = 0;
        }
    }
    
    public void checkKey()
    {
        if(getWorld().getObjects(Key.class).size()== 0){
            getWorld().addObject(new HudKeyClosed(), 30, 90);
        }else{
            getWorld().addObject(new HudKeyOpen(), 30, 90);
        }
    }
    
    public void updateScoreSilver()
    {
       score++;
       getWorld().addObject(new Silver(true), xPositieSilver, 140);
       xPositieSilver +=15;
       updateLife();
    }
    
    public void updateScoreGold()
    {
        score+=2;
        getWorld().addObject(new Gold(true), xPositieGold, 190);
        xPositieGold +=15;
        updateLife();
    }
}
