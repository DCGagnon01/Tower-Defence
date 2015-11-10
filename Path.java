import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends Actor
{
    GreenfootImage img = getImage();
    int width = img.getWidth();
    int height = img.getHeight();
    int rotation = getRotation();

    public int dir;

    public Path(int dir)
    {
        this.dir = dir;
    }

    public void act()
    {
        sendDirection();
        checkClick();
    }

    public void checkClick()
    {
        Land land = (Land)getWorld();;
        if(Greenfoot.mouseClicked(this))
        {
            land.passUpgrade(null, 4, 0, 0, 0);
            land.setTurretInfo(0, 0);
            land.setUSInfo(0, 0);
            land.removeObjects(land.getObjects(Radius.class));
        }
    }

    public void sendDirection()
    {
        List<Zombie> zombie = new ArrayList<Zombie>(getIntersectingObjects(Zombie.class));
        if(!zombie.isEmpty())
        {
            for(int i=0; i<zombie.size(); i++)
            {
                if((dir == 0) && (isCloseToY(zombie.get(i))))
                    zombie.get(i).setRotation(0);
                else if((dir == 1) && (isCloseToX(zombie.get(i))))
                    zombie.get(i).setRotation(90);
                else if((dir == 2) && (isCloseToY(zombie.get(i))))
                    zombie.get(i).setRotation(180);
                else if((dir == 3) && (isCloseToX(zombie.get(i))))
                    zombie.get(i).setRotation(270);
            }
        }
    }

    public boolean isCloseToY(Object obj)
    {
        Zombie zombie = (Zombie)obj;

        int y = (getY() - zombie.getY());
        if((y >= -2) && (y <= 2))
            return true;
        else
            return false;
    }

    public boolean isCloseToX(Object obj)
    {
        Zombie zombie = (Zombie)obj;

        int x = (getX() - zombie.getX());
        if((x >= -2) && (x <= 2))
            return true;
        else
            return false;
    }
}

