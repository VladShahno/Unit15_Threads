package com.nixsolutions.data;

import com.nixsolutions.horserace.FinishingLine;

import java.util.Random;

public class HorseImpl implements Horse, Runnable {

    private int distance;
    private String id;
    private FinishingLine finishingLine;

    public HorseImpl(String id, FinishingLine finishingLine) {
        this.id = id;
        distance = 0;
        this.finishingLine = finishingLine;
    }

    @Override
    public void run() {

        Random rand = new Random();

        int minSleep = 400;
        int maxSleep = 500;
        int diff = maxSleep - minSleep;

        int n = rand.nextInt(diff) + 1;
        n += minSleep;

        while (distance < 1000) {
            try {
                Thread.sleep(n);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int minDist = 100;
            int maxDist = 200;
            int diffDist = maxDist - minDist;

            int dist = rand.nextInt(diff) + 1;
            dist += minDist;

            distance += dist;
        }
        finishingLine.arrive(this);
    }

    @Override
    public String getId() {
        return id;
    }
}
