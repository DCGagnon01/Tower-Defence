import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maps extends Actor
{
    String img;
    public Maps(String img)
    {
        this.img = img;
        setImage(img);
    }

    public void act()
    {
        click();
    }

    public void click()
    {
        Land land = (Land)getWorld();
        if((Greenfoot.mouseClicked(this)) && (img.equals("Map1.png")))
        {
            Greenfoot.setWorld(new Map1());
        }
        if((Greenfoot.mouseClicked(this)) && (img.equals("Map2.png")))
        {
            land.constructMap2();
            land.addClass();
            land.removeObjects(land.getObjects(Maps.class));
        }
        if((Greenfoot.mouseClicked(this)) && (img.equals("Map3.png")))
        {
            land.constructMap3();
            land.addClass();
            land.removeObjects(land.getObjects(Maps.class));
        }
    }
}
