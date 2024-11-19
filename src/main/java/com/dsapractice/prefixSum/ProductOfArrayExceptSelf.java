package com.dsapractice.prefixSum;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
// The key concept make one psum=psum[i-1]*nums[i-1] and ssum=ssum[i+1]*nums[i+1]
//res[i]=psum[i]*ssum[i]

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int []psum = new int[nums.length];
        psum[0]=1;
        int []ssum=new int[nums.length];
        ssum[nums.length-1]=1;

        for(int i=1;i<nums.length;i++){
            psum[i]=psum[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            ssum[i]=ssum[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            result[i]=psum[i]*ssum[i];
        }
      return result;
    }


        public static void main(String[] args) {
        int []arr={1,2,3,4,5};
          productExceptSelf(arr);
    }
}
