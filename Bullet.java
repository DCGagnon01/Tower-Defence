import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Ammo
{
    Zombie zombie;
    public int damage;
    public Bullet(Zombie zombie, int damage)
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
                getWorld().removeObject(this);
            }
        }
        else
            getWorld().removeObject(this);
    }    
}
