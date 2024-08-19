package MyBinarySearch;

public class celingOfNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7};
        System.out.println(Ceiling(arr,3));
        System.out.println(Floor(arr,3));
    }
    static int Ceiling(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                return mid;
            } else if (target<arr[mid]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    static int Floor(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                return mid;
            } else if (target<arr[mid]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

}
