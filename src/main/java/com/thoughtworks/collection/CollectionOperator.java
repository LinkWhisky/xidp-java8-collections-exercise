package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        if (left > right) {
            for (int i = left; i >=right ; i--) {
                resultList.add(i);
            }
        }
        else {
            for (int i = left; i <= right; i++) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> allList = getListByInterval(left,right);
        return allList.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElements(int[] array) {
        return Arrays.stream(array).filter( x -> x%2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElement(int[] array) {
        return Arrays.stream(array).skip(array.length-1).findFirst().orElse(array[0]);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstArrayList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondArrayList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return firstArrayList.stream().filter(secondArrayList::contains).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstArrayList = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> secondArrayList = Arrays.stream(secondArray).collect(Collectors.toList());
        firstArrayList.addAll(secondArrayList);
        return firstArrayList.stream().distinct().collect(Collectors.toList());
    }
}
