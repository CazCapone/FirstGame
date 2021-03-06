package com.capone;

import com.capone.Graphics.Screen;
import com.capone.Inputs.Keyboard;
import com.capone.Level.NewLevel;
import com.capone.Level.RandomLevel;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

/**
 *
 * @author jduclos1
 */
public class GameMain extends Canvas implements Runnable {
    
    //Screen res with height @ 16:9 ratio
    public static int width = 300;
    public static int height = 168;
    public static int scale = 3;
    public static String title = "My Game";
    
    private Screen screen;
    
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private NewLevel level;
    private boolean running = false;
    
    private BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private DataBufferInt pixels = (DataBufferInt) img.getRaster().getDataBuffer();
    private int[] pixel = pixels.getData();

    
    public GameMain(){
        
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size); 
        
        screen = new Screen(width, height);
        frame = new JFrame();
        level = new RandomLevel(64, 64);
        
        key = new Keyboard();
        addKeyListener(key);
        
    }

    @Override
    public void run() {
        //create vars
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1_000_000_000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0; 
        //sets 
        requestFocus();
        
        //game loop
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            //System.out.println("testing 3");
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            //Fps 
            if (System.currentTimeMillis() - timer > 1000 ){
                timer += 1000;
                //add FPS to title bar
                frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    int x = 0, y = 0;
    
    private void update() {
        
       key.update();
        
       if (key.up) y--;
       if (key.down) y++;
       if (key.left) x--;
       if (key.right) x++;
       
    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this, "MainScreen");
        thread.start();
    }
    
    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void render() {
        //Create buffer strat
        BufferStrategy buffer = getBufferStrategy();
        if (buffer == null ){
            createBufferStrategy(3);
            return;
        }
        
        screen.clear();
        level.render(x, y, screen);
        
        for (int i = 0; i < pixel.length; i++){
            pixel[i] = screen.pixels[i];
        }
        
        Graphics g = buffer.getDrawGraphics();
        //create graphics loop
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        
        //cleans up graphics
        g.dispose();
        buffer.show();
    }
    
        public static void main (String[] args){
        GameMain game = new GameMain();
        game.frame.setResizable(false);
        game.frame.setTitle(GameMain.title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        
        game.start();
        
    }
    
    
}
