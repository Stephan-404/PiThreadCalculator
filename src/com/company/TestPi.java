package com.company;

import java.io.*;

public class TestPi {
    public static void main(String[] args) throws IOException {
        double pi=4.0;
        double x=3.0;

        long startTime = System.currentTimeMillis();
            for (int i = 2;; i++) {
                if (i % 2 == 0) {
                    pi = pi - (4 / x);
                } else {
                    pi = pi + (4 / x);
                }
                x = x + 2;
                char[] c=(pi+"").toCharArray();
                //6 Stellen / 3.141592 / 1 Sekunden
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'){
//                    break;
//                }

                //7 Stellen / 3.1415926 / 9 Sekunden
                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'){
                    break;
                }

                //8 Stellen / 3.14159265 / 70 Sekunden
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'&&c[9]=='5'){
//                    break;
//                }

                //9 Stellen / 3.141592653 / ArrayOutofBoundsException
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'&&c[9]=='5'&&c[10]=='3'){
//                    break;
//                }

                //10 Stellen / 3.1415926535 / ArrayOutofBoundsException
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'&&c[9]=='5'&&c[10]=='3'&&c[11]=='5'){
//                    break;
//                }
            }
        long stopTime = System.currentTimeMillis();
        int time=(int)(stopTime - startTime)/1000;
        System.out.println("");
        System.out.println("Pi Programm stopped after: "+time+" Seconds");
        ifBestTime(time);
    }

    public static void ifBestTime(int time) throws IOException {
        File file=new File("Score.txt");
        BufferedReader br= new BufferedReader(new FileReader(file));
        int bestTime=Integer.parseInt(br.readLine());
        if(time<bestTime){
            System.out.println("Congratulasion to the new Best Time");
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            bw.write(""+time);
            bw.flush();
            bw.close();
        }
        else{
            System.out.println("The best time is:"+bestTime);
        }
    }
}
