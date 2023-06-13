package org.example.algorithms;

import org.example.SortingArray;

public class BubbleSort {
    public static int currIndex = 0; // index
    public static int portionSorted = 0; // portion of array that's been sorted
    public static int swaps = 0; // number of swaps made

    public BubbleSort() {
    }

    // makes one swap at a time (if required) according to bubble Sort algorithm
    public void sort(int[] array) {

        if (currIndex >= array.length - 1 - portionSorted) {
            currIndex = 0;
            portionSorted++;
        }

        if (array[currIndex] > array[currIndex + 1]) {
            swap(array, currIndex, currIndex + 1);
            currIndex++;
        } else {
            currIndex++;
        }
    }

    // method that swaps two elements in array
    public void swap(int[] array, int x, int y){
        this.swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // method that resets all default parameters in algorithm
    public void reset(){
        this.currIndex = 0;
        this.portionSorted = 0;
        this.swaps = 0;
    }

}
