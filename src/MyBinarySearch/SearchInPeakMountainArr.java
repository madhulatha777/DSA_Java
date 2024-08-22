package MyBinarySearch;

public class SearchInPeakMountainArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(peakMountainArr(arr,3));
    }
    static int peakMountainArr(int[] arr,int target) {
        int peak = peak(arr);
        int ans = agnosticBinsearch(arr,0,peak,target,true);
        if(ans==-1)
           ans = agnosticBinsearch(arr,peak+1,arr.length-1,target,false);

        return ans;
    }
    static int peak(int[] arr){
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

    static int agnosticBinsearch(int[] arr,int start,int end,int target,boolean isAsc){
        boolean Asc = arr[start]<arr[end];
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target == arr[mid]){
                return mid;
            }
            if(Asc){
                if(target<arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(target<arr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

}
