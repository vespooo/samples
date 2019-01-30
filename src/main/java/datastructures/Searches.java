package datastructures;

import java.lang.reflect.Array;

public class Searches<T extends Comparable> {

    public int linearSearch(T[] arr, T value){
        for (int i=0; i< arr.length; i++){
            if(arr[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(T[] arr, T value){
       return binarySearch(0,arr.length-1, arr, value);
    }

    private int binarySearch(int first, int last, T[] arr, T value) {
        if(last>=first){
            int mid = first + (last-first+1)/2;
            if(arr[mid].compareTo(value)>0){
                return  binarySearch(first, mid-1, arr, value);
            } else if(arr[mid].compareTo(value)<0){
                return binarySearch(mid+1, last, arr, value);
            } else return mid;
        }
        return -1;
    }
}
