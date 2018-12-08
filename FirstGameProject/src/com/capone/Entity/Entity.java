/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Entity;

import com.capone.Graphics.Screen;
import com.capone.Level.NewLevel;
import java.util.Random;

/**
 *
 * @author jduclos1
 */
public class Entity {
    
    public int x, y;
    private boolean removed = false;
    protected NewLevel level;
    protected final Random rand = new Random();
    
    public void update(){
        
    }
    
    public void render(Screen screen){
        
    }
    
    public void remove() {
        //remove from level
        removed = true;
    }
    
    public boolean isRemoved() {
        return removed;
    }
    
}
