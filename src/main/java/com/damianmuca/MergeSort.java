package com.damianmuca;

public class MergeSort implements SortingAlgorithm {

  @Override
  public int[] sort(int[] toSort) {
    return mergeSort(toSort);
  }

  private int[] mergeSort(int[] array) {
    if (array.length < 2) {
      return array;
    }
    int middle = array.length / 2;

    int[] left = new int[middle];
    System.arraycopy(array, 0, left, 0, middle);

    int[] right = new int[array.length - middle];
    System.arraycopy(array, middle, right, 0, array.length - middle);

    int[] leftSorted = mergeSort(left);
    int[] rightSorted = mergeSort(right);
    return merge(leftSorted, rightSorted);
  }

  private int[] merge(int[] a1, int[] a2) {
    int[] mergedArray = new int[a1.length + a2.length];
    int a1Index = 0;
    int a2Index = 0;
    while (a1Index < a1.length && a2Index < a2.length) {
      int addIndex = a1Index + a2Index;
      if (a1[a1Index] < a2[a2Index]) {
        mergedArray[addIndex] = a1[a1Index];
        a1Index++;
      } else {
        mergedArray[addIndex] = a2[a2Index];
        a2Index++;
      }
    }

    while (a1Index < a1.length) {
      mergedArray[a1Index + a2Index] = a1[a1Index];
      a1Index++;
    }
    while (a2Index < a2.length) {
      mergedArray[a1Index + a2Index] = a2[a2Index];
      a2Index++;
    }

    return mergedArray;
  }
}
