package com.vytrack.utilites;

public class Methods {
    public void timer() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
