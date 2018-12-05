
package com.capone.Level;

import com.capone.Graphics.Screen;
import com.capone.Level.Tile.Tile;

/**
 *
 * @author Caz-Desktop
 */
public class NewLevel {
    
    protected int width, height;
    protected int[] tiles;
    
    public NewLevel(int width, int height){
        this.width = width;
        this.height = height;
        tiles = new int[width*height];
        createRandomLevel();
    }
    
    public NewLevel(String path){
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
        screen.setOffset(xScroll, yScroll);
        //leftmost corner
        int x0 = xScroll >> 4;
        //rightmost
        int x1 = (xScroll + screen.width) >> 4;
        //uppermost
        int y0 = yScroll >> 4;
        //bottommost
        int y1 = (yScroll + screen.height) >> 4;
        
        for (int y = y0; y < y1; y++){
            for (int x = x0; x < x1; x++){
                getTile(x, y).render(x, y, screen);
                
            }
        }
    }
    
    public Tile getTile(int x, int y){
        if (tiles[x+y*width] == 0) return Tile.grass;
        return Tile.voidTile;
    }
}
