import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map2 extends Land
{

    /**
     * Constructor for objects of class Map2.
     * 
     */
    public Map2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        addClass();

        addObject(new Path(0), 25, 100);
        addObject(new Path(0), 75, 100);
        addObject(new Path(0), 125, 100);
        addObject(new Path(0), 175, 100);
        addObject(new Path(0), 225, 100);
        addObject(new Path(0), 275, 100);
        addObject(new Path(0), 325, 100);
        addObject(new Path(0), 375, 100);
        addObject(new Path(0), 425, 100);
        addObject(new Path(0), 475, 100);
        addObject(new Path(0), 525, 100);
        addObject(new Path(1), 575, 100);
        addObject(new Path(1), 575, 150);
        addObject(new Path(1), 575, 200);
        addObject(new Path(2), 575, 250);
        addObject(new Path(2), 525, 250);
        addObject(new Path(2), 475, 250);
        addObject(new Path(2), 425, 250);
        addObject(new Path(2), 375, 250);
        addObject(new Path(2), 325, 250);
        addObject(new Path(2), 275, 250);
        addObject(new Path(2), 225, 250);
        addObject(new Path(1), 175, 250);
        addObject(new Path(1), 175, 300);
        addObject(new Path(1), 175, 350);
        addObject(new Path(0), 175, 400);
        addObject(new Path(0), 225, 400);
        addObject(new Path(0), 275, 400);
        addObject(new Path(0), 325, 400);
        addObject(new Path(0), 375, 400);
        addObject(new Path(0), 425, 400);
        addObject(new Path(0), 475, 400);
        addObject(new Path(0), 525, 400);
        addObject(new Path(1), 575, 400);
        addObject(new Path(1), 575, 450);
        addObject(new Path(1), 575, 500);
        addObject(new Path(2), 575, 550);
        addObject(new Path(2), 525, 550);
        addObject(new Path(2), 475, 550);
        addObject(new Path(2), 425, 550);
        addObject(new Path(2), 375, 550);
        addObject(new Path(1), 325, 550);
        addObject(new Path(1), 325, 600);

        rotation = 0;
        x = 2;
        y = 100;
        map = 2;
    }

    public void act()
    {
        super.act();
        if(currentWave >= 12 && zombies == 0)
        {
            Greenfoot.setWorld(new Map3());
        }
    }
}
