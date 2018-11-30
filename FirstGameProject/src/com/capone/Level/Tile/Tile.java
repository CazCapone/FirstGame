/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Level.Tile;

import com.capone.Graphics.Screen;
import com.capone.Graphics.Sprite;

/**
 *
 * @author Caz-Desktop
 */
public class Tile {
    
    public int x, y;
    public Sprite sprite;
    
    public Tile(Sprite sprite){
        this.sprite = sprite;
        
    }
    
    public void render(int x, int y, Screen screen){
        
    }
    
    public boolean solid(){
        return false;
    }
    
}
