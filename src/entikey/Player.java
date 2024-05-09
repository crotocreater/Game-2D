package entikey;

import GamePakage.GamePanell;
import GamePakage.KeyControl;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.print.DocFlavor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.Objects;

public class Player extends Entikey{
    public GamePanell gamePanell;
    public KeyControl keyControl;

    public Player(GamePanell gamePanell, KeyControl keyControl){

        this.gamePanell = gamePanell;
        this.keyControl = keyControl;
        setDefaultValues();
        setPlayerImage();
    }


    public void setDefaultValues(){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        direction = "down";
    }


    public void setPlayerImage(){
        try {
            up1 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_up_1.png"));
            up2 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_up_2.png"));
            down1 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_down_1.png"));
            down2 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_down_2.png"));
            left1 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_left_1.png"));
            left2 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_left_2.png"));
            right1 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_right_1.png"));
            right2 = ImageIO.read(new File("E:\\java\\Java2\\Game2d\\imagePlae\\boy_right_2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void update(){
        if (keyControl.up) {
            y -= speed;
            direction = "up";
        }else if (keyControl.down){
            y+=speed;
            direction = "down";
        }
        if(keyControl.left){
            x -= speed;

            direction = "left";
        } else if (keyControl.right) {
            x += speed;

            direction = "right";
        }
        if (keyControl.up || keyControl.down || keyControl.right || keyControl.left){
            spriteCouter++;
            if(spriteCouter>10){
                if (spriteNum == 1){
                    spriteNum = 2;
                }else {
                    spriteNum = 1;
                }
                spriteCouter = 0;
            }
        }

    }



    public void draw(Graphics2D g2){
        BufferedImage bufferedImage = null;
        if (direction.equals("up")){
            if (spriteNum == 1){
                bufferedImage = up1;
            }else {
                bufferedImage = up2;
            }
        }
        if (direction.equals("down")){
            if (spriteNum == 1){
                bufferedImage = down1;
            }else {
                bufferedImage = down2;
            }
        }
        if (direction.equals("left")){
            if (spriteNum == 1){
                bufferedImage = left1;
            }else {
                bufferedImage = left2;
            }
        }
        if (direction.equals("right")){
            if (spriteNum == 1){
                bufferedImage = right1;
            }else {
                bufferedImage = right2;
            }
        }
        g2.drawImage(bufferedImage, x, y, gamePanell.tileSize, gamePanell.tileSize, null);
    }
}
