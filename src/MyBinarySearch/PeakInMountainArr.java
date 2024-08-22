package MyBinarySearch;

public class PeakInMountainArr {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,7,5,4};
        System.out.println(peakMountainArr(arr));
    }
//    static int peakMountainArr(int[] arr){
//        int max = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] > arr[max]){
//                max = i;
//            }
//        }
//        return max;
//    }
//    static int peakMountainArr(int[] arr){
//        int max = 0;
//        int i=0;
//        while(i<arr.length){
//            if(arr[i]>arr[max]) {
//                max = i;
//            }
//            i++;
//        }
//        return max;

//    static int peakMountainArr(int[] arr){
//        int start = 0;
//        int end = arr.length-1;
//        while(start <= end){
//            int mid = start+(end-start)/2;
//            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
//                return mid;
//            }
//            else if (arr[mid] < arr[mid-1]) {
//                end = mid-1;
//            }
//            else{
//                start = mid+1;
//            }
//        }
//        return start;
//    }

        static int peakMountainArr(int[] arr) {
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > arr[mid + 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }


}
