package GamePakage;

import entikey.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanell extends JPanel implements Runnable{
    /// thiet lap kich  thuoc man hinh
    final int originalTitlesize = 16; // 16x16 = kích thước tối thiếu của một khung hình mặc định
    final int scale = 3; // độ phóng mặc định khi sẽ phóng lên = 16*3
    public  final int tileSize = originalTitlesize*scale;
    final int maxScreenCol = 16; // số cột mặc định
    final int getMaxScreenRow = 12; // số hàng mặc định
    final int screenWidth = tileSize* maxScreenCol;
    final int screenHeight = tileSize*getMaxScreenRow;

    KeyControl keyControl = new KeyControl();
    Thread gameThread;

    // set fps
    int FPS = 60;

    // game player setting

    Player player = new Player(this, keyControl);


    public GamePanell(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // tìm hiểu thêm về phương thức này
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // tìm hiểu thêm về phương thức này
        this.addKeyListener(keyControl);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {

        double  drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread !=null){
            currentTime = System.nanoTime();
            delta +=(currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta >=1){

                update();

                repaint();

                delta--;
                drawCount++;
            }
            if(timer >=1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }





    public  void update(){
        player.update();
    }

    // tim hieu ve ham nay
    public  void paintComponent(Graphics g){
        super.paintComponent(g);// tìm hiểu thêm về phương thức này
        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();// tìm hiểu thêm về phương thức này
    }
}
