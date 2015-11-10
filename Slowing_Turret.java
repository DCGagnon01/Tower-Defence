import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Slowing_Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slowing_Turret extends Turrets
{
    public boolean placed = false;
    public int range = 80;
    public int slow = 100;
    public int speed = 140;
    public int totalSpeed = 140;
    public int upgradeCost = 150;
    public int sellPrice = (int)(345/2);
    public int level = 1;

    public Slowing_Turret()
    {
        setRotation(270);
    }

    public void act()
    {
        if(placed == true)
        {
            getZombies();
            checkSelect();
            if(speed != totalSpeed)
                speed++;
        }
    }

    public void checkSelect()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Land land = (Land)getWorld();
            setInfo();
            land.removeObjects(land.getObjects(Radius.class));
            Radius radius = new Radius(range+((int)(range*.75)));
            land.addObject(radius, getX(), getY());
        }
    }

    private void getZombies()
    {
        List<Zombie> targets = new ArrayList<Zombie>(getObjectsInRange(range, Zombie.class));
        targetZombie(targets);
    }

    private void targetZombie(List<Zombie> targets)
    {
        if(targets.isEmpty() == false)
        {
            turnTowards(targets.get(0).getX(), targets.get(0).getY());
            if(speed >= totalSpeed)
            {
                Spray spray = new Spray(targets.get(0), slow);
                spray.setRotation(getRotation());
                Greenfoot.playSound("Spray.wav");
                getWorld().addObject(spray, getX(), getY());
                speed = 0;
            }
            else
                speed++;
        }
    }

    public void setInfo()
    {
        Land land = (Land)getWorld();
        land.setTurretInfo(slow, totalSpeed);
        land.setUSInfo(upgradeCost, sellPrice);
        land.passUpgrade(this, 3, upgradeCost, sellPrice, level);
    }

    public void levelUp()
    {
        level++;
        range += 15;
        slow += 40;
        speed = 0;
        totalSpeed -= 20;
        upgradeCost += 25;
        sellPrice = (int)(345/2)+(upgradeCost/2);
        setInfo();
        Land land = (Land)getWorld();
        land.removeObjects(land.getObjects(Radius.class));
        Radius radius = new Radius(range+((int)(range*.75)));
        land.addObject(radius, getX(), getY());
    }

    public boolean checkLocation()
    {
        Path path = (Path)getOneObjectAtOffset(0, 0, Path.class);
        Turrets turret = (Turrets)getOneObjectAtOffset(0, 0, Turrets.class);
        if((path == null) && (turret == null))
            return true;
        else
            return false;
    }
}
