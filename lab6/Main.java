package lab6;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> MyData = new ArrayList<>();
    private static long startTime;
    private static long stopTime;
    private static long elapsedTime;
    private static long maxTime;
    private static long startTime2;
    private static long stopTime2;
    public static long time2;

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("State max runnable time(sec):");
        maxTime = input.nextLong() * 1000;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled\\src\\lab6\\data.txt"))) {
            String sCurrentLine;

            while ((sCurrentLine = reader.readLine()) != null) {
                MyData.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Start");
        System.out.println("<-PARALLEL->" + "\n" +
                "-----------------------------------------");

        countThread first = new countThread();
        MaxLengthThread second = new MaxLengthThread();
        onAverageThread third = new onAverageThread();

        startTime = System.currentTimeMillis();
        first.start();
        second.start();
        third.start();
        while (first.isAlive() || second.isAlive() || third.isAlive()) {
            try {
                first.join();
                second.join();
                third.join();
            } catch (InterruptedException e) {

            }
        }


        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        if(elapsedTime>maxTime)
        {
            System.err.println("The process of consistent running has exceeded your time limit");
            System.exit(0);
        }
        System.out.println("1-st THREAD result: "+countThread.ANDcounter+"\n"+"2-nd THREAD result: "+MaxLengthThread.MaxLWord+"\n"+"3-rd THREAD result "+onAverageThread.cCounter+"\n"+"\n"+"Time(sec): "+elapsedTime/1000+"\n" +
                "\n<-CONSECUTIVE->\n"+"-----------------------------------------");

        startTime2 = System.currentTimeMillis();
        second.run();
        first.run();
        third.run();
        stopTime2 = System.currentTimeMillis();
        time2 = stopTime2 - startTime2;

        if(time2>maxTime)
        {
            System.err.println("The process of consistent running has exceeded your time limit");
            System.exit(1);
        }
        System.out.println("1-st THREAD result: "+countThread.ANDcounter+"\n"+"2-nd THREAD result: "+MaxLengthThread.MaxLWord+"\n"+"3-rd THREAD result "+onAverageThread.cCounter+"\n"+"\n"+"Time(sec): "+time2/1000+"\n"+
                "-----------------------------------------");
    }
}