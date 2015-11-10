import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sell extends Menu
{  
    MachineGun_Turret machineGun;
    MissileLauncher_Turret missileLauncher;
    Slowing_Turret slowingTurret;

    public int sellPrice = 0;
    public Sell()
    {

    }

    public void act()
    {
        ifClicked();
    }

    public void ifClicked()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Land land = (Land)getWorld();
            if(machineGun != null)
            {
                land.setMoneyCounter(sellPrice);
                land.removeObject(machineGun);
                machineGun = null;
                land.upgrade.machineGun = null;
                land.setUSInfo(0, 0);
                land.setTurretInfo(0, 0);
            }
            else if(missileLauncher != null)
            {
                land.setMoneyCounter(sellPrice);
                land.removeObject(missileLauncher);
                missileLauncher = null;
                land.upgrade.missileLauncher = null;
                land.setUSInfo(0, 0);
                land.setTurretInfo(0, 0);
            }
            else if(slowingTurret != null)
            {
                land.setMoneyCounter(sellPrice);
                land.removeObject(slowingTurret);
                slowingTurret = null;
                land.upgrade.slowingTurret = null;
                land.setUSInfo(0, 0);
                land.setTurretInfo(0, 0);
            }
            getWorld().removeObjects(getWorld().getObjects(Radius.class));
        }
    }

    public void setObject(Object obj, int type, int sellPrice)
    {
        switch(type)
        {
            case 1:
            this.sellPrice = sellPrice;
            machineGun = (MachineGun_Turret)obj;
            missileLauncher = null;
            slowingTurret = null;
            break;
            case 2:
            this.sellPrice = sellPrice;
            machineGun = null;
            missileLauncher = (MissileLauncher_Turret)obj;
            slowingTurret = null;
            break;
            case 3:
            this.sellPrice = sellPrice;
            machineGun = null;
            missileLauncher = null;
            slowingTurret = (Slowing_Turret)obj;
            break;
            case 4:
            this.sellPrice = sellPrice;
            machineGun = null;
            missileLauncher = null;
            slowingTurret = null;
            break;
        }
    }
}
