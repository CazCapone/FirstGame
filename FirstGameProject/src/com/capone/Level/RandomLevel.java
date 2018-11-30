/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Level;

import java.util.Random;

/**
 *
 * @author Caz-Desktop
 */
public class RandomLevel extends Level {
    
    private final Random random = new Random();
    
    public RandomLevel(int width, int height) {
        super(width, height);
    }
    
    protected void createRandomLevel(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tiles[x+y*width] = random.nextInt(4);
                
            }
        }
    }
    
}
