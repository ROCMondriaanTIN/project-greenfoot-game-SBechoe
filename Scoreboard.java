import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scoreboard extends Actor
{
    private int xPositieSilver = 30;
    private int xPositieGold = 30;
    private int score = 20;
    private int leven = 2;
    
    public void act() 
    {
       updateLife();
    } 
    
    public void updateScoreSilver()
    {
       score++;
       getWorld().addObject(new HudCoinSilver(), xPositieSilver, 180);
       xPositieSilver +=15;
       updateLife();
    }
    
    public void updateScoreGold()
    {
        score+=2;
        getWorld().addObject(new HudCoinGold(), xPositieGold, 140);
        xPositieGold +=15;
        updateLife();
    }
    
    public void updateLife()
    {
        if(score==20){
           leven++;
           getWorld().addObject(new HudLife(), 30, 30); 
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
}
