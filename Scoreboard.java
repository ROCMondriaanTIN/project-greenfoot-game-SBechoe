import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Scoreboard extends Actor
{
    private int xPositieSilver = 30;
    private int xPositieGold = 30;
    private int xPositieLife = 30;
    private int score = 18;
    private int leven = 2;
    private int coinnr = 0;
    
    public Scoreboard()
    {
        coinnr = 0;
    }
    
    public void act() 
    {
        
    } 
    
    public void checkKey()
    {
        KeyHud key = (KeyHud) getWorld().getObjects(KeyHud.class).get(0);
        if(getWorld().getObjects(Key.class).size()== 0){
             key.setImage("hud_keyGreen.png");
        }else{
            key.setImage("hud_keyGreem_disabled.png");
        }
    }
    
    public void updateLife(boolean minLeven)
    {   
        if(minLeven==true)
        {
            leven--;   
            if(leven==0)
            {
                Greenfoot.setWorld(new GameOver());
            }
        }
        if(score==20){
           leven++;
           getWorld().addObject(new LifeHud(), xPositieLife, 40);
           xPositieLife+=50;
           score = 0;
           coinnr = 0;
        }
    }
    
    public void updateScore(String color) {
        if (color.equals("goldCoin")) {
            score+=2;
            getWorld().addObject(new Gold(true), 20 * coinnr, 190);
            coinnr++;
            updateLife(false);
        } else if(color.equals("silverCoin")){
            score++;
            getWorld().addObject(new Silver(true), 20 * coinnr, 140);
            coinnr++;
            updateLife(false);
        }
    }
}
