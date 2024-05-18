package Object;

import GameSet.gamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Object {
    public BufferedImage image;
    public boolean collision = false;
    public String name;
    public int x, y;
    gamePanel gp = new gamePanel();
    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
