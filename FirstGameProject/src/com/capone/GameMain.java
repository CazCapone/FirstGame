package com.capone;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author jduclos1
 */
public class GameMain extends Canvas implements Runnable {
    
    //Screen res with height @ 16:9 ratio
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    
    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    
    public GameMain(){
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size); 
        frame = new JFrame();
    }
    
    public synchronized void start(){
        running = true;
        thread = new Thread(this, "MainScreen");
        thread.start();
    }
    
    public synchronized void stop() throws InterruptedException{
        running = false;
        thread.join();
    }
    
    public static void main (String[] args){
        GameMain game = new GameMain();
        game.frame.setResizable(false);
        game.frame.setTitle("My Game");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        
        game.start();
        
    }

    @Override
    public void run() {
        //game loop
        while (running) {
            update();
            render();
        }
    }

    private void update() {
        
    }

    private void render() {
        BufferStrategy buffer = getBufferStrategy();
        if (buffer == null ){
            createBufferStrategy(3);
            return;
        }
    }
    
    
}
