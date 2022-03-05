package com.damianmuca;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class SortingAlgorithmTest<T extends InsertionSort> {

  private static final int[] SORTED_ARRAY_EVEN = new int[]{
      Integer.MIN_VALUE, -10000, -1, -1, 0, 0, 1, 1, 10000, Integer.MAX_VALUE};
  private static final int[] REVERSE_SORTED_ARRAY_EVEN = new int[]{
      Integer.MAX_VALUE, 10000, 1, 1, 0, 0, -1, -1, -10000, Integer.MIN_VALUE};

  private T sortingAlgorithm;

  protected abstract T createInstance();

  @BeforeMethod
  public void setUp() {
    sortingAlgorithm = createInstance();
  }

  @Test
  public void sort_shouldReturnInput_whenArrayIsEmpty() {
    int[] emptyArray = new int[]{};

    assertEquals(sortingAlgorithm.sort(emptyArray), emptyArray);
  }

  @Test
  public void sort_shouldReturnInput_whenArrayContainsOneElement() {
    int[] oneElementArray = new int[]{10};

    assertEquals(sortingAlgorithm.sort(oneElementArray), oneElementArray);
  }

  @Test
  public void sort_shouldReturnInput_whenArrayAlreadySorted() {
    int[] sort = sortingAlgorithm.sort(SORTED_ARRAY_EVEN);
    assertEquals(sort, SORTED_ARRAY_EVEN);
  }

  @Test
  public void sort_shouldSortRandomlyShuffledArray() {
    int[] notSortedArray = new int[]{-1000, Integer.MAX_VALUE, 0, 1000, -5, 7,
        Integer.MIN_VALUE, 150_000};

    int[] sortedArray = sortingAlgorithm.sort(notSortedArray);

    int[] expectedSortedArray = new int[]{Integer.MIN_VALUE, -1000, -5, 0, 7,
        1000, 150_000, Integer.MAX_VALUE};
    assertEquals(sortedArray, expectedSortedArray);
  }

  @Test
  public void sort_shouldSortReverseSortedArray_evenNumberOfElements() {
    assertEquals(sortingAlgorithm.sort(REVERSE_SORTED_ARRAY_EVEN),
        SORTED_ARRAY_EVEN);
  }

  @Test
  public void sort_shouldSortReverseSortedArray_oddNumberOfElements() {
    int[] reverseSortedArray = new int[]{
        Integer.MAX_VALUE, 10000, 1, 1, 0, 0, -1, -10000, Integer.MIN_VALUE};

    int[] sortedArray = sortingAlgorithm.sort(reverseSortedArray);

    int[] expectedSortedArray = new int[]{
        Integer.MIN_VALUE, -10000, -1, 0, 0, 1, 1, 10000, Integer.MAX_VALUE};
    assertEquals(sortedArray, expectedSortedArray);
  }

  @Test
  public void sort_shouldNotModifyInputArrayReference() {
    int[] arrayToSort = new int[]{10, -20, 0};

    sortingAlgorithm.sort(arrayToSort);

    assertEquals(arrayToSort, new int[]{10, -20, 0});
  }
}
