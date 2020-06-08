package com.company;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {
    static long startTime=0;
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int von = 1;
        int bis = 100;
        int spanne=bis-von;
        startTime = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        List<PiWorker> pnList=new ArrayList<>();

        for (int i = 0;; i++) {
            for(int j=0;j<1;j++) {
                pnList.add(new PiWorker(von, bis));
                von=von+spanne;
                bis=bis+spanne;
            }

            pool.invokeAll(pnList);
            pnList=new ArrayList<>();
            System.out.println(sum);
        }

    }

    public static void ifBestTime(int time) throws IOException {
        File file = new File("ScoreWithThreads.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int bestTime = Integer.parseInt(br.readLine());
        if (time < bestTime) {
            System.out.println("Congratulasion to the new Best Time");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("" + time);
            bw.flush();
            bw.close();
        } else {
            System.out.println("The best time is:" + bestTime);

        }
    }
//    static double sum=(4.0/1.0)-(4.0/3.0);
static double sum=(4.0/1.0);
    public synchronized void addToSum(double x) throws IOException {
        sum=sum+x;
        char[] c=(sum+"").toCharArray();
        //6 Stellen / 3.141592 / 1 Sekunden
//        if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'){
//            finished();
//        }

        //7 Stellen / 3.1415926 / 9 Sekunden
        if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'){
            finished();
        }

        //8 Stellen / 3.14159265 / 70 Sekunden
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'&&c[9]=='5'){
//                    finished();
//                }

        //9 Stellen / 3.141592653 / ArrayOutofBoundsException
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'&&c[9]=='5'&&c[10]=='3'){
//                    finished();
//                }

        //10 Stellen / 3.1415926535 / ArrayOutofBoundsException
//                if(c[0]=='3'&& c[1]=='.'&&c[2]=='1'&&c[3]=='4'&&c[4]=='1'&&c[5]=='5'&&c[6]=='9'&&c[7]=='2'&&c[8]=='6'&&c[9]=='5'&&c[10]=='3'&&c[11]=='5'){
//                    finished();
//                }
    }

    public synchronized void finished() throws IOException {
        long stopTime = System.currentTimeMillis();
        int time = (int) (stopTime - startTime) / 1000;
        System.out.println("pi="+sum);
        System.out.println("");
        System.out.println("Pi Programm stopped after: " + time + " Seconds");
        ifBestTime(time);
        System.exit(1);
    }
}



