package com.cbt.utilities;

public class utils {
    public static void wait(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
