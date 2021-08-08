package com.nixsolutions.horserace;

import com.nixsolutions.data.Horse;

import java.util.ArrayList;
import java.util.List;

public class FinishingLineImpl implements FinishingLine {

    List<String> ranking = new ArrayList<String>(10);

    public FinishingLineImpl() {
    }

    @Override
    public void arrive(Horse horse) {
        ranking.add(horse.getId());
    }

    public void printRaceResult() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Horse with № " + ranking.get(i) + " came to the finish line - " + (i + 1));
        }
    }
}
