package com.company;

import java.io.*;

public class CreatePiCalculationPlan {


    public static void main(String[] args)throws IOException {
        int x=3;
double sum=(4.0/1.0);
        File file = new File("PiCalculationPlan.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("0. : "+"(4/1)"+"\n");
//        System.out.println("(4/1)");
        for(int i=1;i<500;i++){
            if(i%2==0){
                bw.write((i)+". : "+"+(4/"+x+")"+"\n");
//                System.out.println("+(4/"+x+")");
//                sum=sum+(4.0/x);
            }
            else{
                bw.write((i)+". : "+"-(4/"+x+")"+"\n");
//                System.out.println("-(4/"+x+")");
//                sum=sum-(4.0/x);
            }
            x=x+2;
        }
        bw.flush();
        bw.close();
    }

}
