package org.example.algorithms;

public class CocktailSort {
    boolean cocktailForward = true; // true if the cursor is moving forwards, false if backwards
    public static int currIndex = 0; // cursor
    public static int portionSorted = 0; // portion of elements sorted at the end
    public static int forwardPortionSorted = 0; // portion of elements sorted at the start
    static int swaps = 0;

    public CocktailSort(){
    }

    // sorts items one at a time (if required) according to Cocktail Shaker Sort algorithm
    public void sort(int[] array){
        // moving forward, biggest elements at the end
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
        // moving backward, smallest elements at the start
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

    // method that swaps two elements in an array
    public void swap(int[] array, int x, int y){
        swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // method that resets al default parameters
    public void reset(){
        currIndex = 0;
        portionSorted = 0;
        forwardPortionSorted = 0;
        this.cocktailForward = true;
        swaps = 0;
    }

}
