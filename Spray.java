import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spray extends Ammo
{
    Zombie zombie;
    public int slow;
    public Spray(Zombie zombie, int slow)
    {
        this.zombie = zombie;
        this.slow = slow;
    }

    public void act() 
    {
        if(zombie.isDead == false)
        {
            move(4);
            turnTowards(zombie.getX(), zombie.getY());
            Zombie zombie = (Zombie)getOneIntersectingObject(Zombie.class);
            if(zombie != null)
            {
                zombie.slow = slow;
                getWorld().removeObject(this);
            }
        }
        else
            getWorld().removeObject(this);
    }    
}
