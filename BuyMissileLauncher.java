import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyMissileLauncher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyMissileLauncher extends Menu
{
    boolean hasTurret = false;
    public int cost = 125;
    MissileLauncher_Turret missileLauncher;
    public BuyMissileLauncher()
    {
        setRotation(270);
    }

    public void act()
    {
        checkDrag();
    }

    public void checkDrag()
    {
        Land land = (Land)getWorld();
        if(Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(cost <= land.getMoneyAmount())
            {
                if(hasTurret == false)
                {
                    land.removeObjects(land.getObjects(Radius.class));
                    missileLauncher = new MissileLauncher_Turret();
                    land.addObject(missileLauncher, mouse.getX(), mouse.getY());
                    hasTurret = true;
                    land.setMoneyCounter(-cost);
                }
            }
            if(hasTurret == true)
                missileLauncher.setLocation(mouse.getX(), mouse.getY());
        }
        if((Greenfoot.mouseDragEnded(null)) && (missileLauncher != null))
        {
            grid();
            if(missileLauncher.checkLocation())
            {
                missileLauncher.placed = true;
                hasTurret = false;
                missileLauncher = null;
            }
            else
            {
                land.removeObject(missileLauncher);
                missileLauncher = null;
                land.setMoneyCounter(cost);
                hasTurret = false;
            }
        }
    }

    public void grid()
    {
        Land land = (Land)getWorld();
        int maxWidthNum = land.getWidth()/50;
        int maxHeightNum = land.getHeight()/50;
        int x = 0;
        int y = 0;
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int xAdd = 0;
        int yAdd = 0;
        if(land.map == 1)
        {
            x1 = 25;
            x2 = -25;
            y1 = 0;
            y2 = -50;
            xAdd = 0;
            yAdd = 25;
        }
        else if(land.map == 2 || land.map == 3)
        {
            x1 = 0;
            x2 = -50;
            y1 = 25;
            y2 = -25;
            xAdd = 25;
            yAdd = 0;
        }
        for(int i=1; i<maxWidthNum; i++)
        {
            if((((i*50)-(missileLauncher.getX())) <= x1) && (((i*50)-(missileLauncher.getX())) >= x2))
                x = i*50;
        }

        for(int i=1; i<maxHeightNum; i++)
        {
            if((((i*50)-(missileLauncher.getY())) <= y1) && (((i*50)-(missileLauncher.getY())) >= y2))
                y = i*50;
        }
        missileLauncher.setLocation(x+xAdd, y+yAdd);
    }
}
