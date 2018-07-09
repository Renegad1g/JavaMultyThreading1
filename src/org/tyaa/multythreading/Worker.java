/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.multythreading;

/**
 *
 * @author yurii
 */
public class Worker {
    
    private int state = 1;
    
    public void sayHello(){
    
        System.out.print("Hello ");
        state = 2;
    }
    
    public void sayWorld(){
    
        System.out.print("World\n");
        state = 1;
    }
    
    public int getState(){
    
        return state;
    }
}
