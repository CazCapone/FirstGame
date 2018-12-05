
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
        screen.renderTile(x << 4, y << 4, this);
    }
    
}
