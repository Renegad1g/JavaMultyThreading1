/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.multythreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yurii
 */
public class MultyThreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*1*/
        /*Thread t1 = new Thread(() -> {
            
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultyThreading.class.getName()).log(Level.SEVERE, null, ex);
                }
                fib(40);
                System.out.print("Hello ");
            }
        });
        
        Thread t2 = new Thread(() -> {
            
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultyThreading.class.getName()).log(Level.SEVERE, null, ex);
                }
                fib(40);
                System.out.println("World!");
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(MultyThreading.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        t1.interrupt();
        t2.interrupt();
        
        System.out.println("The end.");*/
        
        /*2*/
        
        Worker worker = new Worker();
        
        HWTask hWTask1 =
            new HWTask(MultyThreading::fib, "Hello ", worker, 1);
        HWTask hWTask2 =
            new HWTask(MultyThreading::fib, "World!\n", worker, 2);
        
        Thread t1 = new Thread(hWTask1);
        Thread t2 = new Thread(hWTask2);
        
        t1.start();
        t2.start();
        
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MultyThreading.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hWTask1.stop = true;
        hWTask2.stop = true;*/
    }
    
    private static long fib(long x){
    
        if(x == 1 || x == 2){
            return 1;
        }
        return fib(x - 1) + fib(x - 2);
    }
}
