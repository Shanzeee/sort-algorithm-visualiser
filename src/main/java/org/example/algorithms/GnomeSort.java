package org.example.algorithms;

public class GnomeSort implements SortAlgorithm{
    public static int currIndex = 0;
    static int swaps = 0;

    public GnomeSort(){
    }


    @Override
    public void sort(int[] array){
        if (array[currIndex+ 1] < array[currIndex]){
            swap(array, currIndex, currIndex+1);
            currIndex = 0;
        }
        else {
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
        swaps = 0;
    }
}
