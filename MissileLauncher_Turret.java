import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class MissileLauncher_Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissileLauncher_Turret extends Turrets
{
    public boolean placed = false;
    public int range = 120;
    public int damage = 2;
    public int speed = 220;
    public int totalSpeed = 220;
    public int upgradeCost = 100;
    public int sellPrice = (int)(125/2);
    public int level = 1;

    public MissileLauncher_Turret()
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
                Missile missile = new Missile(targets.get(0), damage);
                missile.setRotation(getRotation());
                getWorld().addObject(missile, getX(), getY());
                speed = 0;
            }
            else
                speed++;
        }
    }

    public void setInfo()
    {
        Land land = (Land)getWorld();
        land.setTurretInfo(damage, totalSpeed);
        land.setUSInfo(upgradeCost, sellPrice);
        land.passUpgrade(this, 2, upgradeCost, sellPrice, level);
    }

    public void levelUp()
    {
        level++;
        range += 10;
        damage += 2;
        speed = 0;
        totalSpeed += 5;
        upgradeCost += 50;
        sellPrice = (int)(125/2)+(upgradeCost/2);
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
