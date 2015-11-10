import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Land here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Land extends World
{
    public int totalTime = 150;
    public int time = totalTime;
    public int zombiesOut = 0;
    public int zombies = 0;
    private int totalZombies = 5;
    public int currentWave = 1;
    public boolean wave = false;
    public boolean started = false;

    public int rotation = 0;
    public int x = 0;
    public int y = 0;
    public int map = 0;

    MoneyCounter moneyCounter;
    HealthCounter healthCounter;
    WaveCounter waveCounter;
    TurretInfo turretInfo;
    UpgradeSellInfo usInfo;
    BuyMachineGun bMachineGun;
    BuyMissileLauncher bMissileLauncher;
    BuySlowingTurret bSlowingTurret;
    Price price;
    Upgrade upgrade;
    Sell sell;
    Start start;
    Health health;
    Money money;
    InfoPane infoPane;
    /**
     * Constructor for objects of class Land.

     */
    public Land()
    {    
        super(900, 600, 1);
        //super(1145, 604, 1);

        setPaintOrder(Radius.class, Zombie.class, Ammo.class, Turrets.class, Path.class, HealthCounter.class, MoneyCounter.class, Upgrade.class, Sell.class, TurretInfo.class, UpgradeSellInfo.class, BuyMachineGun.class, BuyMissileLauncher.class, BuySlowingTurret.class, Price.class, Menu.class);

        //addObject(new Maps("Map1.png"), getWidth()/6, 300);
        //addObject(new Maps("Map2.png"), getWidth()/2, 300);
        //addObject(new Maps("Map3.png"), (getWidth()/6)*5, 300);
    }

    public void started()
    {
        if(!started)
        {
            Greenfoot.setWorld(new Map1());
            started = true;
        }
    }

    public void act()
    {
        if(map > 0)
        {
            startWave();
            checkClick();
        }
    }

    public void startWave()
    {
        totalZombies = 5 + currentWave;
        totalTime = 150 - (currentWave*8);
        if(totalTime < 50)
            totalTime = 50;
        if((time >= totalTime) && (wave == true) && (zombiesOut < totalZombies))
        {
            if((currentWave%10) == 0)
            {
                addObject(new Tank_Zombie(((int)(currentWave*.75)), currentWave, rotation), x, y);
                zombies++;
                zombiesOut = totalZombies;
            }
            else if((Greenfoot.getRandomNumber(3)+1 == 3) && (currentWave > 3))
            {
                addObject(new Infected_Zombie(((int)(currentWave*.75)), currentWave, rotation), x, y);
            }
            else
                addObject(new Walker_Zombie(((int)(currentWave*.75)), currentWave, rotation), x, y);
            zombies++;
            zombiesOut++;
            if(zombiesOut >= totalZombies)
            {
                wave = false;
                zombiesOut = 0;
                currentWave++;
                waveCounter.wave = currentWave;
                waveCounter.Update();
            }
            time = 0;
        }
        else
            time++;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    public void constructMap1()
    {

    }

    public void constructMap2()
    {

    }

    public void constructMap3()
    {

    }

    public void checkClick()
    {
        Land land = (Land)this;
        if(Greenfoot.mouseClicked(land))
        {
            upgrade.setObject(null, 4, 0, 0);
            sell.setObject(null, 4, 0);
            turretInfo.set(0, 0);
            usInfo.set(0, 0);
            removeObjects(getObjects(Radius.class));
        }
    }

    public void addClass()
    {
        moneyCounter = new MoneyCounter();
        addObject(moneyCounter, 853, 128);

        healthCounter = new HealthCounter();
        addObject(healthCounter, 853, 36);

        upgrade = new Upgrade();
        addObject(upgrade, 713, 465);

        sell = new Sell();
        addObject(sell, 713, 554);

        turretInfo = new TurretInfo(0, 0);
        addObject(turretInfo, 760, 383);

        usInfo = new UpgradeSellInfo(0, 0);
        addObject(usInfo, 869, 514);

        bMachineGun = new BuyMachineGun();
        addObject(bMachineGun, 697, 199);

        bMissileLauncher = new BuyMissileLauncher();
        addObject(bMissileLauncher, 697, 258);

        bSlowingTurret = new BuySlowingTurret();
        addObject(bSlowingTurret, 697, 322);

        price = new Price();
        addObject(price, 840, 290);

        start = new Start();
        addObject(start, 31, 550);

        infoPane = new InfoPane();
        addObject(infoPane, 775, 300);

        money = new Money();
        addObject(money, 703, 137);

        health = new Health();
        addObject(health, 702, 44);

        waveCounter = new WaveCounter();
        addObject(waveCounter, 57, 580); 
    }

    public void setHealth()
    {
        healthCounter.health--;
        healthCounter.update();
    }

    public int getMoneyAmount()
    {
        return moneyCounter.money;
    }

    public void setMoneyCounter(int amount)
    {
        moneyCounter.update(amount);
    }

    public void passUpgrade(Object obj, int type, int upgradeCost, int sellPrice, int level)
    {
        upgrade.setObject(obj, type, upgradeCost, level);
        sell.setObject(obj, type, sellPrice);
    }

    public void setTurretInfo(int damage, int speed)
    {
        turretInfo.set(damage, speed);
    }

    public void setUSInfo(int upgradeCost, int sellPrice)
    {
        usInfo.set(upgradeCost, sellPrice);
    }
}
