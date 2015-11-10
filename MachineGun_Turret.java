import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class MachineGun_Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MachineGun_Turret extends Turrets
{
    public boolean placed = false;
    public int range = 80;
    public int damage = 1;
    public int speed = 90;
    public int totalSpeed = 90;
    public int upgradeCost = 75;
    public int sellPrice = (int)(50/2);
    public int level = 1;

    public MachineGun_Turret()
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
                Bullet bullet = new Bullet(targets.get(0), damage);
                bullet.setRotation(getRotation());
                Greenfoot.playSound("Gunshot.wav");
                getWorld().addObject(bullet, getX(), getY());
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
        land.passUpgrade(this, 1, upgradeCost, sellPrice, level);
    }

    public void levelUp()
    {
        level++;
        range += 10;
        damage += 1;
        speed = 0;
        totalSpeed -= 10;
        upgradeCost += 25;
        sellPrice = (int)(50/10)+(upgradeCost/2);
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
        Menu menu = (Menu)getOneObjectAtOffset(0, 0, Menu.class);
        if((path == null) && (turret == null) && (menu == null))
            return true;
        else
            return false;
    }
}

