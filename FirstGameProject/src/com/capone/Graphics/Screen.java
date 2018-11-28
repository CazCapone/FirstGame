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
    
    public int[] tiles = new int[64*64];
    
    private Random random = new Random();
    
    int time = 0;
    int counter = 0;
    
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixel = new int[width * height];
        
        for (int i = 0; i < 64*64; i++){
            tiles[i] = random.nextInt(0xffffff);
        }
    }
    
    public void render(){       
        for (int y = 0 ; y < height ; y++){
            if (y < 0 || y >= height) break;
            for (int x = 0 ; x < width ; x++){
                if (x < 0 || x >= width) break;
                //int tileIndex = (x/16) + (y/16) * 64;
                //use Bitwise operator
                int tileIndex = (x >> 4) + (y >> 4) * 64;
                pixel[x + y * width] = tiles[tileIndex];
                
            }
        }
    }
    
    public void clear(){
        for (int i = 0; i < pixel.length; i++){
            pixel[i] = 0;
        }
    }
}
