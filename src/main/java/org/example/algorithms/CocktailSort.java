package org.example.algorithms;

public class CocktailSort implements SortAlgorithm {
    boolean cocktailForward = true;
    public static int currIndex = 0;
    public static int portionSorted = 0;
    public static int forwardPortionSorted = 0;
    static int swaps = 0;

    public CocktailSort(){
    }

    @Override
    public void sort(int[] array){
        if (cocktailForward){
            if (currIndex >= array.length - 1 - portionSorted){
                portionSorted++;
                cocktailForward = false;
                currIndex = array.length - 1 - portionSorted;
            }
            if (array[currIndex] > array[currIndex+1]){
                swap(array, currIndex, currIndex+1);
            }
            currIndex++;
        }
        if (!cocktailForward){
            if (currIndex <= portionSorted) {
                forwardPortionSorted++;
                cocktailForward = true;
                currIndex = forwardPortionSorted;
            }
            if (array[currIndex] < array[currIndex-1]){
                swap(array, currIndex, currIndex-1);
            }
            currIndex--;
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
        forwardPortionSorted = 0;
        this.cocktailForward = true;
        swaps = 0;
    }

}
