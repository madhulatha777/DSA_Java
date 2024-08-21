package MyBinarySearch;

public class FirstAndLastInd {
    public static void main(String[] args) {
        int[] nums ={5,7,7,8,8,10};
        System.out.println(FirLasInd(nums,8));
    }
    static int[] FirLasInd(int[] nums,int target){

        int[] ans = {-1, -1};
         int start = indexes(nums,target,true);
        int end = indexes(nums,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
//        int start = 0;
//        int end = nums.length-1;
//        while(start<=end){
//            int mid = start+(end-start)/2;
//            if(nums[mid] == target){
//                indexes(nums,target,true);
//            } else if (target<nums[mid]) {
//                end = mid-1;
//            } else {
//                start = mid + 1;
//            }
//        }

    }
    static int indexes(int[] nums,int target,boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if (target<nums[mid]) {
                end = mid-1;
            } else if(target>nums[mid]) {
                start = mid + 1;
            }
            else{
                ans = mid;
                if(findStartIndex){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}
