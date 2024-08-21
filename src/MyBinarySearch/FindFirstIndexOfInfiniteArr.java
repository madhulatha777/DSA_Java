package MyBinarySearch;

public class FindFirstIndexOfInfiniteArr {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,12,13,14,15,16,17,18,19,20,24};
        System.out.println(Range(nums,4));
    }
    static int Range(int[] nums,int target){
        int start = 0;
        int end = 1;
        while(target > nums[end]){
            int newStart = end+1;
            end = end+(end-start+1)*2;
            start = newStart;
        }
        return binarySearch(nums,target,start,end);
    }
    static int binarySearch(int[] nums,int target,int start,int end) {
        while(start<=end) {
            //int middle = (start+end)/2;  int start+end exceeds if both the start and end values are too large
            int mid = start+(end-start)/2;
            if(nums[mid]<target) {
                start = mid+1;
            }
            else if(nums[mid]>target) {
                end = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
