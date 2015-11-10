import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map1 extends Land
{

    /**
     * Constructor for objects of class Map1.
     * 
     */
    public Map1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        
        addClass();
        
        addObject(new Path(1), 100, 25);
        addObject(new Path(1), 100, 75);
        addObject(new Path(0), 100, 125);
        addObject(new Path(0), 150, 125);
        addObject(new Path(0), 200, 125);
        addObject(new Path(0), 250, 125);
        addObject(new Path(0), 300, 125);
        addObject(new Path(0), 350, 125);
        addObject(new Path(3), 400, 125);
        addObject(new Path(3), 400, 75);
        addObject(new Path(0), 400, 25);
        addObject(new Path(0), 450, 25);
        addObject(new Path(0), 500, 25);
        addObject(new Path(0), 550, 25);
        addObject(new Path(1), 600, 25);
        addObject(new Path(1), 600, 75);
        addObject(new Path(1), 600, 125);
        addObject(new Path(1), 600, 175);
        addObject(new Path(2), 600, 225);
        addObject(new Path(2), 550, 225);
        addObject(new Path(2), 500, 225);
        addObject(new Path(2), 450, 225);
        addObject(new Path(2), 400, 225);
        addObject(new Path(2), 350, 225);
        addObject(new Path(2), 300, 225);
        addObject(new Path(2), 250, 225);
        addObject(new Path(2), 200, 225);
        addObject(new Path(2), 150, 225);
        addObject(new Path(1), 100, 225);
        addObject(new Path(1), 100, 275);
        addObject(new Path(1), 100, 325);
        addObject(new Path(1), 100, 375);
        addObject(new Path(1), 100, 425);
        addObject(new Path(0), 100, 475);
        addObject(new Path(0), 150, 475);
        addObject(new Path(0), 200, 475);
        addObject(new Path(0), 250, 475);
        addObject(new Path(0), 300, 475);
        addObject(new Path(0), 350, 475);
        addObject(new Path(3), 400, 475);
        addObject(new Path(3), 400, 425);
        addObject(new Path(3), 400, 375);
        addObject(new Path(0), 400, 325);
        addObject(new Path(0), 450, 325);
        addObject(new Path(0), 500, 325);
        addObject(new Path(0), 550, 325);
        addObject(new Path(1), 600, 325);
        addObject(new Path(1), 600, 375);
        addObject(new Path(1), 600, 425);
        addObject(new Path(1), 600, 475);
        addObject(new Path(1), 600, 525);
        addObject(new Path(1), 600, 575);

        rotation = 270;
        x = 100;
        y = 2;
        map = 1;
    }
    
    public void act()
    {
        super.act();
        if(currentWave >= 12 && zombies == 0)
        {
            Greenfoot.setWorld(new Map2());
        }
    }
}
