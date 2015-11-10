import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tank_Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tank_Zombie extends Zombie
{
    public int moveSpeed = 1;
    public Tank_Zombie(int health, int currentWave, int rotation)
    {
        super.health = health+30;
        super.slow = 0;
        moveSpeed = 1;
        setDirection(rotation);
    }

    public void act() 
    {
        if(slow <= 0)
            move(moveSpeed);
        else
        {
            move(1);
            slow -= 2;
        }
        enterFort();
        death();
    }

    private void death()
    {
        if(health <= 0)
        {
            dead();
            Land land = (Land)getWorld();
            land.zombies -= 1;
            land.setMoneyCounter(20);
            land.removeObject(this);
        }
    }
}
