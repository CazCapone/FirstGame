package com.capone.Graphics;

import com.capone.Level.Tile.Tile;
import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author jduclos1
 */
public class Screen {
 
    public int width;
    public int height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    
    public int xOffset, yOffset;
    
    public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
    
    private Random random = new Random();
    
    int time = 0;
    int counter = 0;
    
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        
        for (int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }
      
    public void renderTile(int xp, int yp, Tile tile){
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++){
            int yAbs = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++){
                int xAbs = x + xp;
                if (xAbs < 0 || xAbs >= width || yAbs >= width) break; 
                pixels[xAbs+yAbs*width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }
    
    public void setOffset(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    
    public void clear(){
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }
}
