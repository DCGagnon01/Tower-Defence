import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Menu
{
    MachineGun_Turret machineGun;
    MissileLauncher_Turret missileLauncher;
    Slowing_Turret slowingTurret;

    public int upgradeCost = 0;
    public int level = 0;
    public Upgrade()
    {

    }

    public void act()
    {
        ifClicked();
    }

    public void ifClicked()
    {
        Land land = (Land)getWorld();
        if(Greenfoot.mouseClicked(this) && (upgradeCost <= land.getMoneyAmount()))
        {
            if((machineGun != null) && (machineGun.level < 5))
            {
                land.setMoneyCounter(-upgradeCost);
                machineGun.levelUp();
            }
            else if((missileLauncher != null) && (missileLauncher.level < 5))
            {
                land.setMoneyCounter(-upgradeCost);
                missileLauncher.levelUp();
            }
            else if((slowingTurret != null) && (slowingTurret.level < 5))
            {
                land.setMoneyCounter(-upgradeCost);
                slowingTurret.levelUp();
            }
        }
    }

    public void setObject(Object obj, int type, int upgradeCost, int level)
    {
        switch(type)
        {
            case 1:
            this.upgradeCost = upgradeCost;
            this.level = level;
            machineGun = (MachineGun_Turret)obj;
            missileLauncher = null;
            slowingTurret = null;
            break;
            case 2:
            this.upgradeCost = upgradeCost;
            this.level = level;
            machineGun = null;
            missileLauncher = (MissileLauncher_Turret)obj;
            slowingTurret = null;
            break;
            case 3:
            this.upgradeCost = upgradeCost;
            this.level = level;
            machineGun = null;
            missileLauncher = null;
            slowingTurret = (Slowing_Turret)obj;
            break;
            case 4:
            this.upgradeCost = upgradeCost;
            this.level = level;
            machineGun = null;
            missileLauncher = null;
            slowingTurret = null;
            break;
        }
    }
}
