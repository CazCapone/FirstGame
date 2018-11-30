/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Level;

import com.capone.Graphics.Screen;

/**
 *
 * @author Caz-Desktop
 */
public class Level {
    
    protected int width, height;
    protected int[] tiles;
    
    public Level(int width, int height){
        this.width = width;
        this.height = height;
        tiles = new int[width*height];
        createRandomLevel();
    }
    
    public Level(String path){
         loadLevel(path);
    }

    private void createRandomLevel() {
        
    }

    private void loadLevel(String path) {
        
    }
    
    private void time(){
        
    }
    
    public void update(){
        
    }
    
    public void render(int xScroll, int yScroll, Screen screen){
        
    }
}
