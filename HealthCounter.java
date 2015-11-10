import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class HealthCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthCounter extends Menu
{
    public int health = 15;

    public HealthCounter()
    {
        GreenfootImage img = new GreenfootImage(200, 80);
        setImage(img);
        update();
    }

    public void act()
    {
        if(health <= 0)
            Greenfoot.stop();
    }

    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 60));
        img.setColor(Color.RED);
        img.drawString(""+health, 5, 70);
    }
}
