import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Radius here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radius extends Menu
{
    int radius;
    public Radius(int radius)
    {
        this.radius = radius;
        GreenfootImage img = new GreenfootImage(radius, radius);
        Color color = new Color(0, 0, 255, 100);
        img.setColor(color);
        img.fillOval(0, 0, radius, radius);
        setImage(img);
    }
}
