import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class UpgradeSellInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeSellInfo extends Menu
{
    public int upgradeCost;
    public int sellPrice;
    
    public UpgradeSellInfo(int upgradeCost, int sellPrice)
    {
        this.upgradeCost = upgradeCost;
        this.sellPrice = sellPrice;
        
        GreenfootImage img = new GreenfootImage(200, 200);
        setImage(img);
        set(upgradeCost, sellPrice);
    }
    
    public void set(int upgradeCost, int sellPrice)
    {
        this.upgradeCost = upgradeCost;
        this.sellPrice = sellPrice;
        GreenfootImage img = getImage();
        img.clear();
        img.setFont(new Font("Arial", 0, 60));
        img.setColor(Color.YELLOW);
        img.drawString(""+this.upgradeCost, 0, 70);
        img.drawString(""+this.sellPrice, 0, 158);
    }
}
