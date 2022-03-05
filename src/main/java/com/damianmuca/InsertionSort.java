package com.damianmuca;

public class InsertionSort implements SortingAlgorithm {

  public int[] sort(int[] toSort) {
    if (toSort.length < 2) {
      return toSort;
    }

    int[] sortedArray = new int[toSort.length];
    sortedArray[0] = toSort[0];
    for (int i = 1; i < toSort.length; i++) {
      int toInsertIndex = i;
      int toInsertValue = toSort[i];
      while (toInsertIndex > 0 && toInsertValue < sortedArray[toInsertIndex - 1]) {
        sortedArray[toInsertIndex] = sortedArray[toInsertIndex-1];
        toInsertIndex--;
      }
      sortedArray[toInsertIndex] = toInsertValue;
    }
    return sortedArray;
  }
}
