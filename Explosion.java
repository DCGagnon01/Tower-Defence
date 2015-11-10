import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Ammo
{
    int scale = 50;
    public void act()
    {
        GreenfootImage img = getImage();
        scale++;
        if(scale != 75)
            img.scale(scale, scale);
        if(scale == 75)
            getWorld().removeObject(this);
    }
}
