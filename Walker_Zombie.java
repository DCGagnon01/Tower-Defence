import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Walker_Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Walker_Zombie extends Zombie
{
    public int moveSpeed = 1;
    public Walker_Zombie(int health, int currentWave, int rotation)
    {
        super.health = health+3;
        super.slow = 0;
        if(currentWave < 3)
            moveSpeed = 1;
        else
            moveSpeed = 2;
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
            land.setMoneyCounter(5);
            land.removeObject(this);
        }
    }
}
