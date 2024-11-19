package com.dsapractice.Subarray;
//leetcode-560 Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

//idea : map(key-sum,value-occurence of sum) Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum.
// If the same sum occurs again, we increment the count corresponding to that sum in the hashmap.
// Further, for every sum encountered, we also determine the number of times the
// sum sum−k has occurred already, since it will determine the number of times a subarray with sum k has occurred up to the current index.
// We increment the count by the same amount.

import java.util.HashMap;

public class NoOfSubarrayWithSumEqualsK {
    public static int fun(int[] a,int k) {
        int sum=0,count=0;
        HashMap<Integer,Integer>mp=new HashMap<>();
         for(int i=0;i<a.length;i++){
             sum=sum+a[i];
             int tarket=sum-k;
             if(mp.containsKey(tarket)){
                 count=count+mp.get(tarket);//if any subarray sum equals to k already +nt ,how many times it is present
             }
             mp.put(sum,mp.getOrDefault(sum,0)+1);
         }
         return count;
    }
    public static void main(String[] args) {
        int []arr={3,4,7,2,-3,1,4,2};
       int res= fun(arr,7);
       System.out.println(res);
    }


}
