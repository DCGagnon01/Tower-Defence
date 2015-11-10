import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class WaveCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveCounter extends Menu
{
    int wave = 1;
    public WaveCounter()
    {
        GreenfootImage img = new GreenfootImage(100, 20);
        setImage(img);
        Update();
    }
    
    public void Update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 20));
        img.setColor(Color.WHITE);
        img.drawString("Wave: "+wave, 5, 20);
    }
}
