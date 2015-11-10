import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MoneyCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyCounter extends Menu
{
    public int money = 75;

    public MoneyCounter()
    {
        GreenfootImage img = new GreenfootImage(200, 80);
        setImage(img);
        update();
    }

    public void update(int amount)
    {
        money = money + amount;
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 60));
        img.setColor(Color.YELLOW);
        img.drawString(""+money, 5, 70);
    }
    
    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 60));
        img.setColor(Color.YELLOW);
        img.drawString(""+money, 5, 70);
    }
}
