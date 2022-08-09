package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> notEvenDayPeoples = new ArrayList();
        ArrayList<Integer> evenDayPeoples = new ArrayList();
        Integer maxGain = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            int days = scanner.nextInt();
            boolean isLegalDaysCount = 2 <= days && days <= Math.pow(10.0, 5.0);
            if (isLegalDaysCount) {
                for (int i = 0; i < days; i++) {
                    int peopleCount = scanner.nextInt();
                    boolean legalPeopleCount = 1 <= peopleCount && peopleCount <= Math.pow(10.0, 3.0);
                    boolean evenDay = i % 2 != 0;
                    if (evenDay && legalPeopleCount) {
                        evenDayPeoples.add(peopleCount);
                    } else if (!evenDay && legalPeopleCount) {
                        notEvenDayPeoples.add(peopleCount);
                    } else System.out.println("not legal people count");
                }
            }
            int deltaEven = getMaxValue(evenDayPeoples) - getMinValue(notEvenDayPeoples);
            int deltaNotEven = getMaxValue(notEvenDayPeoples) - getMinValue(evenDayPeoples);
            maxGain = (deltaEven > deltaNotEven) ? deltaEven : deltaNotEven;

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(notEvenDayPeoples.toString() + '\n' + evenDayPeoples.toString());
        System.out.println(maxGain);
    }

    public static Integer getMaxValue(ArrayList<Integer> collections) {
        Integer result = collections.stream().max(Integer::compareTo).get();
        return result;
    }

    public static Integer getMinValue(ArrayList<Integer> collections) {
        Integer result = collections.stream().min(Integer::compareTo).get();
        return result;
    }
}