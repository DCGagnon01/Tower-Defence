import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Infected_Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Infected_Zombie extends Zombie
{
    public int moveSpeed = 2;
    public Infected_Zombie(int health, int currentWave, int rotation)
    {
        super.health = health+2;
        super.slow = 0;
        if(currentWave < 6)
            moveSpeed = 2;
        else
            moveSpeed = 3;
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
            land.setMoneyCounter(10);
            land.removeObject(this);
        }
    }
}
