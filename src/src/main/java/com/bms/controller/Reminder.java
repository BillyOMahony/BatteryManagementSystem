package com.bms.controller;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, seconds*1000);
	}

    class RemindTask extends TimerTask {
    	int numLoop = 3;
        public void run() {
        	
        	if (numLoop > 0) {
                System.out.println("Beep!");
                numLoop--;
            } else {
                System.out.println("Time's up!");
                //timer.cancel(); // Not necessary because
                                  // we call System.exit
                System.exit(0);   // Stops the AWT thread 
                                  // (and everything else)
            }
        }
    }

    public static void main(String args[]) {
        new Reminder(5);
        System.out.println("Task scheduled.");
    }
}