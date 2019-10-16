package datastructures;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
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

    private void merge(T[] arr, int first, int mid, int last) {
        List<T> sorted = new ArrayList<>();
        int first1 = first;
        int first2 = mid;
        while (first1 < mid && first2<=last){
            if(arr[first1].compareTo(arr[first2]) < 0){
                sorted.add(arr[first1]);
                first1++;
            } else {
                sorted.add(arr[first2]);
                first2++;
            }
        }
        for (int i=first1; i<mid; i++){
            sorted.add(arr[i]);
        }
        for (int i=first2; i<=last; i++){
            sorted.add(arr[i]);
        }
        for (int i=first, j=0; i<=last; i++, j++){
            arr[i]=sorted.get(j);
        }
    }


    public Integer[] quickSort(Integer[] arr){
        countSwaps(arr, 0, arr.length-1, 0);
       return arr;
    }

    static int countSwaps(Integer[] arr, int left, int right, int count){
        if ( left >= right ) return count;

        int pivot = arr[(left + right)/2];
        int l = left;
        int r = right;

        while(l < r){
            while (arr[l] < pivot) {l++;}
            while (arr[r] > pivot) {r--;}
            if(l < r) {
                count++;
                swap(arr, l, r);
            }

        }
        count += countSwaps(arr, left, l-1, 0);
        count += countSwaps(arr, l+1, right, 0);

        return count;
    }
    static void swap(Integer[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
//    private void quickSort(T[] arr, int left, int right) {
//        if (left>=right) return;
//
//        T pivot = arr[(left+right)/2];
//        int index = partition(arr, left, right, pivot);
//        quickSort(arr, left,index-1);
//        quickSort(arr, index+1, right);
//    }
//
//    private int partition(T[] arr, int left, int right, T pivot) {
//        while (left<right){
//            while (arr[left].compareTo(pivot)<0){
//                left++;
//            }
//            while (arr[right].compareTo(pivot)>0){
//                right--;
//            }
//            if (left<right) {
//                switchElements(arr, left, right);
//            }
//
//        }
//        return left;
//    }

//    private int partition(T[] arr, int left, int right, T pivot) {
//        while (left<right){
//            while (arr[left].compareTo(pivot)<0){
//                left++;
//            }
//            while (arr[right].compareTo(pivot)>0){
//                right--;
//            }
//            if (left<right) {
//                switchElements(arr, left, right);
//            }
//            left++;
//            right--;
//
//        }
//        return left;
//    }

    private void switchElements(T[] arr, int begin, int end) {
        T temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

}
