package SortingAlgos;

import java.util.ArrayList;
import java.util.List;
/*
 * Given an integer array nums, return the number of reverse pairs in the array.

   A reverse pair is a pair (i, j) where:

		0 <= i < j < nums.length and
	 	nums[i] > 2 * nums[j].
 * 
 * 
 * */

//New type of merge in this//
class ReversePairs {
    public int reversePairs(int[] nums) {
      return mergeSort(nums,0,nums.length-1);
}
    
    public int mergeSort(int[] nums , int left , int right){
       int ans = 0;
        if(right>left){
           
            int mid = (left+right)/2;
            ans+=mergeSort(nums, left , mid);
            ans+=mergeSort(nums,mid+1,right);
            ans+=merge(nums,left,mid+1,right);
            return ans;
        }
        
        return ans;
    }
    
    public int merge(int[] nums , int left , int mid , int right){
        int cnt = 0;
        int j = mid;
        for(int i = left ; i < mid ; i++){
            while(j<=right&&nums[i]>2*(long)nums[j]){
                j++;
            }
            cnt+=(j-mid);
        }
        
        List<Integer> temp = new ArrayList<>();
        int i = left;
        j = mid;
        while(i<mid&&j<=right){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }else{
                temp.add(nums[j]);
                j++;
            }
        }
        
        while(i<mid){
            temp.add(nums[i++]);
        }
        while(j<=right){
            temp.add(nums[j++]);
        }
        
        for(int k = left ; k <=right ; k++){
            nums[k] = temp.get(k-left);
        }
        
        return cnt;
    }
}
    
    