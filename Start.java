import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Menu
{
    public Start()
    {
        GreenfootImage img = new GreenfootImage(50, 30);
        setImage(img);
        update();
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Land land = (Land)getWorld();
            land.wave = true;
        }
    }

    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 20));
        img.setColor(Color.WHITE);
        img.drawString("Start", 5, 20);
    }
}
