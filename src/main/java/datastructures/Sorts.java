package datastructures;

import java.lang.reflect.Array;

public class Sorts<T extends Comparable<T>> {
    public T[] mergeSort(T[] array){
        mergeSort(array, 0, array.length-1);
        return array;
    }

    private void mergeSort(T[] array, int first, int last) {
        if(last<=first){
            return;
        }
        int mid = first + (last-first)/2;
        mergeSort(array, first, mid);
        mergeSort(array, mid+1, last);
        merge(array, first, mid+1 ,last);
    }

    private void merge(T[] arr, int first1, int first2, int last2) {
        while (first1 < last2){
            if(arr[first1].compareTo(arr[first2]) > 0){
                T temp = arr[first1];
                arr[first1] = arr[first2];
                arr[first2] = temp;
            }
            first1++;
        }

    }
}
