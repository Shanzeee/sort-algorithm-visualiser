package org.example.algorithms;

public class BubbleSort implements SortAlgorithm{
    public static int currIndex = 0;
    public static int portionSorted = 0;
    public static int swaps = 0;

    public BubbleSort() {
    }


    @Override
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


    @Override
    public void swap(int[] array, int x, int y){
        swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    @Override
    public void reset(){
        currIndex = 0;
        portionSorted = 0;
        swaps = 0;
    }

}
