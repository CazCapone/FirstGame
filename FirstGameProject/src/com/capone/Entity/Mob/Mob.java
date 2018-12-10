/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Entity.Mob;

import com.capone.Entity.Entity;
import com.capone.Graphics.Sprite;

/**
 *
 * @author jduclos1
 */
public abstract class Mob extends Entity{
    
    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;
    
    public void move(int x, int y) {
        if (x > 0) dir = 1;
        if (x < 0) dir = 3;
        if (y > 0) dir = 2;
        if (y < 0) dir = 0;
        
        if (!collision()){
            //x = -1, 0, 1
            this.x += x;
            this.y += y;
        }
    }
    
    public void update() {
        
    }
    
    private boolean collision(){
        return false;
    }
    
    public void render() {
        
    }
}
