import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Price here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Price extends Menu
{
    public Price()
    {
        GreenfootImage img = new GreenfootImage(200, 300);
        setImage(img);
        update();
    }

    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 35));
        img.setColor(Color.WHITE);
        img.drawString("50", 2, 70);
        img.drawString("125", 2, 130);
        img.drawString("345", 2, 195);
    }  
}
