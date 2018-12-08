
package com.capone.Level;

import java.util.Random;

/**
 *
 * @author Caz-Desktop
 */
public class RandomLevel extends NewLevel {
    
    private static final Random random = new Random();
    
    public RandomLevel(int width, int height) {
        super(width, height);
        createRandomLevel();
    }
  
    protected void createRandomLevel(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tiles[x+y*width] = random.nextInt(4);
                
            }
        }
    }
    
}
