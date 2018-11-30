/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Graphics;

/**
 *
 * @author jduclos1
 */
public class Sprite {
    
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;
    
    //Create sprite (pixels, x coords on sheet, y coords, 
    public static Sprite s1 = new Sprite(16, 9, 2, SpriteSheet.tiles);
    
    
    public Sprite(int size, int x, int y, SpriteSheet sheet){
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x = x*size;
        this.y = y*size;
        this.sheet = sheet;
        load();
        
    }
    
    private void load(){
        //Grab a sprite from the sheet
        for (int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++){
                pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    
}
    
}
