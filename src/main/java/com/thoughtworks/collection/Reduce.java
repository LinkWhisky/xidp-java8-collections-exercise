package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().reduce(this.arrayList.get(0), Integer::max);
    }

    public double getMinimum() {
        return this.arrayList.stream().reduce(this.arrayList.get(0), Integer::min);
    }

    public double getAverage() {
        return (double) this.arrayList.stream().reduce(0, Integer::sum) / arrayList.size();
    }

    public double getMedian() {
        if (arrayList.size() % 2 == 1) {
            return (double) arrayList.get(arrayList.size() / 2);
        }
        return (double) (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2;
    }

    public double getOrderedMedian() {
        List<Integer> sortedArrayList = this.arrayList.stream().sorted().collect(Collectors.toList());
        if (sortedArrayList.size()%2 == 1) {
            return (double) sortedArrayList.get(sortedArrayList.size()/2);
        }
        return  (double) (sortedArrayList.get(sortedArrayList.size()/2-1)+sortedArrayList.get(sortedArrayList.size()/2))/2;
    }

    public int getFirstEven() {
        return this.arrayList.stream().filter(x -> x%2 == 0).mapToInt(x -> x).findFirst().orElse(-1);
    }

    public int getIndexOfFirstEven() {
        return this.arrayList.indexOf(this.arrayList.stream().filter(x -> x%2 == 0).mapToInt(x -> x).findFirst().orElse(-1));
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.equals(this.arrayList);
    }



    public int getLastOdd() {
        List<Integer> oddList = this.arrayList.stream().filter(x -> x%2 ==1).collect(Collectors.toList());
        return oddList.stream().skip(oddList.size()-1).findFirst().orElse(-1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> oddList = this.arrayList.stream().filter(x -> x%2 ==1).collect(Collectors.toList());
        return this.arrayList.indexOf(oddList.stream().skip(oddList.size()-1).findFirst().orElse(-1));
    }
}
