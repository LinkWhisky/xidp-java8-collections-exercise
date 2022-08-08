package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder >= rightBorder) {
            int switchNumber = leftBorder;
            leftBorder = rightBorder;
            rightBorder = switchNumber;
        }
        List<Integer> arrayList = new ArrayList<>();
        for (int number = leftBorder; number <= rightBorder; number++) {
                arrayList.add(number);
        }
        return arrayList.stream().filter(number -> number%2 == 0).mapToInt(number -> number).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder >= rightBorder) {
            int switchNumber = leftBorder;
            leftBorder = rightBorder;
            rightBorder = switchNumber;
        }
        List<Integer> arrayList = new ArrayList<>();
        for (int number = leftBorder; number <= rightBorder; number++) {
            arrayList.add(number);
        }
        return arrayList.stream().filter(number -> number%2 == 1).mapToInt(number -> number).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(number->number*3+2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(number -> number%2 == 1 ? number*3+2 : number).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number%2 == 1).mapToInt(number -> number*3+5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> sortedArrayList = arrayList.stream().sorted().collect(Collectors.toList());
        if (sortedArrayList.size()%2 == 1) {
            return (double) sortedArrayList.get(sortedArrayList.size()/2);
        }
        return  (double) (sortedArrayList.get(sortedArrayList.size()/2-1)+sortedArrayList.get(sortedArrayList.size()/2))/2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number%2 == 0).mapToDouble(number -> number).average().orElse(0);
    }

    public boolean isIncludedInEven(List<Integer> arrayList, Integer specialElement) {
        return arrayList.stream().filter(number -> number%2 == 0).anyMatch(specialElement::equals);
    }

    public List<Integer> getUnrepeatedFromEven(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number%2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Stream<Integer> streamEvens = arrayList.stream().filter(number -> number%2 == 0);
        Stream<Integer> streamReversedOdds = arrayList.stream().filter(number -> number%2 == 1).sorted(Comparator.reverseOrder());
        return Stream.concat(streamEvens,streamReversedOdds).collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> processedList = new ArrayList<>();
        Integer postNumber = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0) {
                processedList.add((postNumber+arrayList.get(i))*3);
            }
            postNumber = arrayList.get(i);
        }
        return processedList;
    }
}
