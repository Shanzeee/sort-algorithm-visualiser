package org.example.algorithms;

public class SelectionSort implements SortAlgorithm {

    public static int current_index = 0;
    public static int portion_sorted = 0;
    public static int minNum = 0;
    static int swaps = 0;

    public SelectionSort(){
    }
    public void sort(int[] array){

        if (current_index >= array.length - 1){
            swap(array, portion_sorted, minNum);
            portion_sorted++;
            current_index = portion_sorted;
            minNum = portion_sorted;
        }
        else {
            current_index++;
        }

        if (array[current_index] < array[minNum]){
            minNum = current_index;
        }
    }

    public void swap(int[] array, int x, int y){
        swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void reset(){
        current_index = 0;
        portion_sorted = 0;
        minNum = 0;
        swaps = 0;
    }
}