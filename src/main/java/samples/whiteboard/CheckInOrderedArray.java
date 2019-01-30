package samples.whiteboard;

public class CheckInOrderedArray {

    public boolean checkElementInArrayRecursive(int element, int[] arr){
        return checkElementInArrayRecursive(element, arr, 0, arr.length-1);
    }

    private boolean checkElementInArrayRecursive(int element, int[] arr, int startPos,  int endPos){
        if (startPos<=endPos){
            int center = startPos + (endPos - startPos+1)/2;
            if (arr[center] == element)return true;
            if (arr[center] > element)
                return checkElementInArrayRecursive(element, arr, startPos, center-1);
            if (arr[center] < element)
                return checkElementInArrayRecursive(element, arr, center+1, endPos);

        }
        return false;
    }

    public boolean checkElementInArray(int element, int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int center = start+(end-start+1)/2;
            if (arr[center] == element) return true;
            if (arr[center] > element){
                end = center-1;
            }
            else {
                start = center + 1;
            }
        }
        return false;
    }
}
