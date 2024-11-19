package com.dsapractice.Subarray;
//leetcode-53:Given an integer array nums, find the subarray with the largest sum, and return its sum.
// use Kadane's algo keep adding the sum if sum >currsum replace it if sum<0 make it 0


public class MaximumSubarraySum {
    public  static int sum(int[] arr) {
        int sum = 0 ,maxSum =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int []arr={-2,1,-3,4,-1,2,1,-5,4};
         int res= sum(arr);
         System.out.println(res);
    }

}
