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
 * @author jduclos1
 */
public class GrassTile extends Tile{

    public GrassTile(Sprite sprite) {
        super(sprite);
    }
    
    public void render(int x, int y, Screen screen){
        screen.renderTile(x, y, this);
    }
    
}
