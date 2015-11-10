import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map3 extends Land
{

    /**
     * Constructor for objects of class Map3.
     * 
     */
    public Map3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        addClass();
        
        addObject(new Path(0), 25, 500);
        addObject(new Path(3), 75, 500);
        addObject(new Path(3), 75, 450);
        addObject(new Path(3), 75, 400);
        addObject(new Path(3), 75, 350);
        addObject(new Path(3), 75, 300);
        addObject(new Path(3), 75, 250);
        addObject(new Path(3), 75, 200);
        addObject(new Path(3), 75, 150);
        addObject(new Path(0), 75, 100);
        addObject(new Path(0), 125, 100);
        addObject(new Path(0), 175, 100);
        addObject(new Path(1), 225, 100);
        addObject(new Path(1), 225, 150);
        addObject(new Path(1), 225, 200);
        addObject(new Path(1), 225, 250);
        addObject(new Path(1), 225, 300);
        addObject(new Path(1), 225, 350);
        addObject(new Path(1), 225, 400);
        addObject(new Path(1), 225, 450);
        addObject(new Path(0), 225, 500);
        addObject(new Path(0), 275, 500);
        addObject(new Path(0), 325, 500);
        addObject(new Path(3), 375, 500);
        addObject(new Path(3), 375, 450);
        addObject(new Path(3), 375, 400);
        addObject(new Path(3), 375, 350);
        addObject(new Path(3), 375, 300);
        addObject(new Path(3), 375, 250);
        addObject(new Path(3), 375, 200);
        addObject(new Path(3), 375, 150);
        addObject(new Path(0), 375, 100);
        addObject(new Path(0), 425, 100);
        addObject(new Path(0), 475, 100);
        addObject(new Path(1), 525, 100);
        addObject(new Path(1), 525, 150);
        addObject(new Path(1), 525, 200);
        addObject(new Path(1), 525, 250);
        addObject(new Path(1), 525, 300);
        addObject(new Path(1), 525, 350);
        addObject(new Path(1), 525, 400);
        addObject(new Path(1), 525, 450);
        addObject(new Path(1), 525, 500);
        addObject(new Path(1), 525, 550);
        addObject(new Path(1), 525, 600);

        rotation = 0;
        x = 2;
        y = 500;
        map = 3;
    }
    
    public void act()
    {
        super.act();
        if(currentWave >= 12 && zombies == 0)
        {
            Greenfoot.stop();
        }
    }
}
