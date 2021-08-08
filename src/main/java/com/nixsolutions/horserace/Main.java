package com.nixsolutions.horserace;

import com.nixsolutions.data.HorseImpl;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("This program is a simulation of the racetrack. " +
                "\nThere are 10 horses participating in the race. " +
                "\nPlease select your favorite horse (1-10) and press Enter.");

        Scanner in = new Scanner(System.in);
        Integer num = in.nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FinishingLineImpl finishingLine = new FinishingLineImpl();

        for (int i = 0; i < 10; i++) {

            System.out.println("Horse № " + (i + 1) + " is ready to run!");
            String strId = Integer.toString(i + 1);
            HorseImpl horse = new HorseImpl(strId, finishingLine);
            executorService.execute(horse);
        }

        executorService.shutdown();
        executorService.awaitTermination(60000, TimeUnit.SECONDS);
        /*finishingLine.printRaceResult();*/


        for (int i = 0; i < 10; i++) {
            if (finishingLine.ranking.get(i).equals(num.toString())) {
                System.out.println(" Your horse № " + num + " came to the finish line - " + (i + 1));
            }
        }
    }
}