package com.company;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;

public class PiWorker implements Callable<Double> {
    int von=0;
    int bis=0;
    double sum=0.0;

    public PiWorker(int i1,int i2) { this.von=i1;this.bis=i2; }

    @Override
    public Double call() throws Exception {
        Main m=new Main();

        double zwischendings=0.0;
        for(int i=von;i<bis;i++){
            zwischendings=(4.0/(((double)i*2.0)+1.0));
            if(i%2==0){
                sum=sum+zwischendings;
            }
            else{
                sum=sum-zwischendings;
            }
        }
        m.addToSum(sum);
        return sum;
    }
}
