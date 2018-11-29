/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capone.Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Caz-Desktop
 */
public class Keyboard implements KeyListener{
    
    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right;
    
    
    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        
        //just to print which keys are pressed
        for (int i = 0; i < keys.length; i++){
            if (keys[i]){
                System.out.println("Key: " + i);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       
    }
}
