/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Graphics;

import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author jduclos1
 */
public class Screen {
 
    private int width, height;
    public int[] pixel;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    
    public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
    
    private Random random = new Random();
    
    int time = 0;
    int counter = 0;
    
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixel = new int[width * height];
        
        for (int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }
    
    public void render(int xOffset, int yOffset){       
        for (int y = 0 ; y < height ; y++){
          int yp = y + yOffset;
           if (yp < 0 || yp >= height) continue;
           for (int x = 0 ; x < width ; x++){
               int xp = x + xOffset;
               if (xp < 0 || xp >= width) continue;
                pixel[xp + yp * width] = Sprite.s1.pixels[(x&15) + (y&15) * Sprite.s1.SIZE];
                
            }
        }
    }
    
    public void clear(){
        for (int i = 0; i < pixel.length; i++){
            pixel[i] = 0;
        }
    }
}
