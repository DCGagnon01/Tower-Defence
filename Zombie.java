import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    public int health = 3;
    public boolean isDead = false;
    public int slow = 0;
    public void setDirection(int dir)
    {
        if(dir == 270)
            setRotation(90);
        else if(dir == 0)
            setRotation(0);
        else if(dir == 90)
            setRotation(270);
        else
            setRotation(180);
    }

    public void dead()
    {
        isDead = true;
    }

    public void enterFort()
    {
        if(getY() >= 598)
        {
            Land land = (Land)getWorld();
            land.zombies = land.zombies-1;
            land.setHealth();
            isDead = true;
            land.removeObject(this);
        }
    } 

    public void injure(int damage)
    {
        health -= damage;
    }
}
