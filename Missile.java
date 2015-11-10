import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Ammo
{
    Zombie zombie;
    public int damage;
    public Missile(Zombie zombie, int damage)
    {
        this.zombie = zombie;
        this.damage = damage;
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
                zombie.injure(damage);
                getWorld().addObject(new Explosion(), zombie.getX(), zombie.getY());
                Greenfoot.playSound("Explosion.wav");
                getWorld().removeObject(this);
            }
        }
        else
            getWorld().removeObject(this);
    }
}    
