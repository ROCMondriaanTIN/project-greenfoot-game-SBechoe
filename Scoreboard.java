import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scoreboard extends Actor
{
    private int xPositieSilver = 30;
    private int xPositieGold = 30;
    private int xPositieLife = 130;
    private int score = 15;
    private int leven = 2;
    
    public void act() 
    {
        
    } 
    
    public void checkKey()
    {
        KeyHud key= (KeyHud) getWorld().getObjects(KeyHud.class).get(0);
        if(getWorld().getObjects(Key.class).size()== 0){
             key.setImage("hud_keyGreen.png");
        }
        else
        {
            key.setImage("hud_keyGreem_disabled.png");
        }
    }
    
    public void updateLife()
    {
        if(score==20){
           leven++;
           getWorld().addObject(new LifeHud(), xPositieLife, 40);
           xPositieLife+=50;
           score = 0;
           
           xPositieSilver=30;
           xPositieGold=30;
        }
        
        /*if(leven == 0){
            Greenfoot.setWorld(new GameOver());
        }*/
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
