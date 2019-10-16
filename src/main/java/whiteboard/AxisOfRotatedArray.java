package whiteboard;

/**
 * A sorted array is rotated at some unknown point, how to efficiently search an element in it. Can be better then O(n)
 */
public class AxisOfRotatedArray {

    public int findAxis(int[] arr){
        return axisBinarySearch(arr, 0, arr.length);
    }

    private int axisBinarySearch(int[] arr, int left, int right) {
        if(left < right){
            int mid = (left+right)/2;

        }
        return 0;
    }

}
