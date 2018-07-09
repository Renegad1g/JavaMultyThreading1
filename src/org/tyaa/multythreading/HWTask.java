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
public class HWTask implements Runnable {

    private HardWork mHardWork;
    private String mWord;
    private Worker mWorker;
    private int mId;
    public volatile boolean stop = false;
    
    //TODO 
    //1 Добавить два параметра в HWTask: сколько раз выполнить цикл и
    //число фиб. под каким номером вычислять
    //2 Добавить в Worker третий метод, который будет выводить в консоль
    //знак ! (вызывать его из третьего потока выполнения так,
    //чтобы ! печатался после слова World\n в той же строке
    public HWTask(HardWork _hardWork, String _word, Worker _worker, int _id) {
        
        mHardWork = _hardWork;
        mWord = _word;
        mWorker = _worker;
        mId = _id;
    }

    @Override
    public void run() {
        
        for (int i = 0; i < 100; i++) {
            
            if (!stop) {
                
                synchronized(mWorker){
                    
                    while(mId != mWorker.getState()){
                    
                        try {
                            mWorker.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HWTask.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    mHardWork.fib(30);
                        
                    if(mId == 1){

                        mWorker.sayHello();
                    } else {

                        mWorker.sayWorld();
                    }
                    
                    System.out.print(i + " ");
                    
                    mWorker.notify();
                    
                    /*if (mId == mWorker.getState()) {

                        mHardWork.fib(30);
                        //System.out.print(mWord);
                        if(mId == 1){

                            mWorker.sayHello();
                        } else {

                            mWorker.sayWorld();
                        }
                    }*/
                }
            } else {
                //throw new InterruptedException();
                break;
            }
        }
    }
}
