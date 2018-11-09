/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Graphics;

import javafx.scene.paint.Color;

/**
 *
 * @author jduclos1
 */
public class Screen {
 
    private int width, height;
    public int[] pixel;
    
    int time = 0;
    int counter = 0;
    
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixel = new int[width * height];
    }
    
    public void render(){
        counter++;
        if (counter % 100 == 0) {
            time++;
        }
        
        for (int y = 0 ; y < height ; y++){
            for (int x = 0 ; x < width ; x++){
              //  pixel[x + y * width] = 0xff00ff;
                pixel[40 + time * width] = 0xff00ff;
                
            }
        }
    }
    
    public void clear(){
        for (int i = 0; i < pixel.length; i++){
            pixel[i] = 0;
        }
    }
}
