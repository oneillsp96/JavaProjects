package Pong;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static PlayerPaddle player;
    public static AIPaddle ai;
    public static Ball ball;

    InputHandler IH;

    JFrame frame;
    public final int WIDTH = 400;
    public final int HEIGHT = WIDTH / 16 * 9;
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
    public final String TITLE = "Pong InDev";
    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    static boolean gameRunning = false;
    static boolean gameOver=false;
    
    
    int p1Score;
    int p2Score;

    public synchronized void start() {
        gameRunning = true;
        new Thread(this).start();

    }

    public static synchronized void stop() {
        gameRunning = false;
        System.exit(0);

    }

    @Override
    public void run() {
        while (gameRunning) {
            tick();
            render();

            try {
                Thread.sleep(7);
//entire program thread ticks, renders, then stops for 7 milliseconds before ticking again 

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    //constructor
    public Game() {

        frame = new JFrame();
        //sizes reference canvas
        setMinimumSize(gameSize);
        setPreferredSize(gameSize);
        setMaximumSize(gameSize);
        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null);

        //whenever frame is selected it will listen for keys input
        IH = new InputHandler(this);
        player = new PlayerPaddle(10, 60);
        ai = new AIPaddle(getWidth() - 20, 60);
        ball = new Ball(getWidth() / 2, getHeight() / 2);

    }

    public void tick() {
        //"this" class >>(Game)
        player.tick(this);
        ai.tick(this);
        ball.tick(this);
    }

    public void render() {
        //how to buffer/load pixels
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.setColor(Color.WHITE);
        g.drawString("Player 1: " + p1Score, 0, 10);
        g.drawString("Player 2: " + p2Score, getWidth() - 70, 10);

        player.render(g);
        ai.render(g);
        ball.render(g);

        //////////////////////////////////////////////////////////
        if (p1Score == 11) {
            g.drawString("Player 1 Wins!", 50, 50);
//            gameOver=true;
            gameRunning = false;
            new MainMenu();

//            try {
//                Thread.sleep(3000);
//            } catch (Exception e) {
//            }

        } else if (p2Score == 11) {
            g.drawString("Player 2 Wins!", 50, 50);
//            gameOver=true;
            
            gameRunning = false;
            new MainMenu();
//            try {
//                Thread.sleep(3000);
//            } catch (Exception e) {
//            }

        }

        g.dispose();
        bs.show();
    }

}
