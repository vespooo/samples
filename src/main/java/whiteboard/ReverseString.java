package whiteboard;

public class ReverseString {

    public static String reverse(String str){
        if(str.length()<=1) return str;
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            swap(arr, left, right);
            left++;
            right--;
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
