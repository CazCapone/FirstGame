/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jduclos1
 */
public class SpriteSheet {
    
    private String path;
    public final int SIZE;
    public int[] pixels;
    
    public static SpriteSheet tiles = new SpriteSheet("/spritesheet.png", 512);  

    public SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        pixels = new int[SIZE*SIZE];
        load();
    }
    
    private void load() {
        BufferedImage img;
        try {
            img = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = img.getWidth();
            int h = img.getHeight();
            img.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    
    
    
}
