package ru.geekbrains.java_2.lesson_e;

public class MathThread extends Thread {

    private static float[] arr;

    MathThread(float[] arr1){
        this.arr = arr1;
    }

    @Override
    public void run(){
        for(int i=0 ; i<arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
