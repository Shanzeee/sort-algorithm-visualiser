package org.example.algorithms;

public class PancakeSort implements SortAlgorithm{

    public int portionSorted = 0;
    public int currMax = 0;
    public boolean flip = false;
    static int swaps = 0;

    public PancakeSort(){
    }

    public void sort(int[] array){
        if (portionSorted < array.length) {
            if (!flip) {
                currMax = getMax(array, array.length - portionSorted);
                flipFront(array, currMax + 1);
                flip = true;
            } else {
                flipFront(array, array.length - portionSorted);
                portionSorted++;
                flip = false;
            }
        }
    }

    public void flipFront(int[] array, int num){
        for (int i=0; i<num/2; i++){
            swap(array, i, num - i -1);
        }
    }

    public void swap(int[] array, int x, int y){
        swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void reset(){
        this.currMax = 0;
        this.portionSorted = 0;
        this.flip = false;
        swaps = 0;
    }

    public int getMax(int[] array, int n){
        int index = 0;
        int max = array[0];
        for (int i=0; i < n; i++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }
        return index;
    }
}
