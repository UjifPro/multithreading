package ru.geekbrains.java_2.lesson_e;

import java.sql.SQLOutput;

public class Multithread {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;
    static float[] arr = new float[SIZE];


    public static float singleThread(float[] arr){
        long a = System.currentTimeMillis();
            MathThread t1 = new MathThread(arr);
            t1.run();
            t1.interrupt();
        return (System.currentTimeMillis()-a)*0.001f ;
    }

    public static float multiThread(float[] arr){
        long a = System.currentTimeMillis();
            float[] a1 = new float[h];
            float[] a2 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            System.arraycopy(arr, h, a2, 0, h);

            MathThread t1 = new MathThread(a1);
            t1.run();
            t1.interrupt();

            MathThread t2 = new MathThread(a2);
            t2.run();
            t2.interrupt();

            while (t1.isInterrupted() && t2.isInterrupted()){
                System.arraycopy(a1, 0, arr, 0, h);
                System.arraycopy(a2, 0, arr, h, h);
            }
        return (System.currentTimeMillis()-a)*0.001f;
    }

    public static void Init(){
        for (int i=0 ; i<SIZE; i++){
            arr[i]=1;
        }
    }

    public static void main(String[] args) {


        Init();
        System.out.println(singleThread(arr));

        Init();
        System.out.println(multiThread(arr));

    }



}
