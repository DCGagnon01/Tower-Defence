import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class TurretInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurretInfo extends Menu
{
    public int damage;
    public int speed;

    public TurretInfo(int damage, int speed)
    {
        this.damage = damage;
        this.speed = speed;

        GreenfootImage img = new GreenfootImage(200, 100);
        setImage(img);
        set(damage, speed);
    }

    public void set(int damage, int speed)
    {
        this.damage = damage;
        this.speed = speed;
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 20));
        img.setColor(Color.WHITE);
        img.drawString("Damage: "+this.damage, 2, 40);
        img.drawString("Speed: "+this.speed, 2, 80);
    }
}
