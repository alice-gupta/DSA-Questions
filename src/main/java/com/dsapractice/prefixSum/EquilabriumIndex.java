// Q>>You are given an array A of integers of size N.
//Your task is to find the equilibrium index of the given array
//The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
//If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
//Note:
//Array indexing starts from 0.
//If there is no equilibrium index then return -1.
//If there are more than one equilibrium indexes then return the minimum index.
//A = [-7, 1, 5, 2, -4, 3, 0]
//sum[0,i-1]=sum[i+1,n-1] ->[l,r]->psum[r]-psum[l-1]->psum[n-1]-psum[i+1-1]
// psum[i-1]=psum[n-1]-psum[i]
//or make one psum and one sufix sum when psum[i]==ssum[i] return i;

package com.dsapractice.prefixSum;

public class EquilabriumIndex {

    public static int equilibriumPoint(long[] arr){
        int n = arr.length;
        long[] psum = new long[n];
        psum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }

        for(int i=0;i<n;i++){
            if(i==0){
                if(0==psum[n-1]-psum[i]){ //if 0 is eqm index for value 0
                    return 0;
                }
            }
            else{
                if(psum[i-1]==psum[n-1]-psum[i]) {
                    return i;

                }
            }
        }
       return -1; //no eqm indx
    }

    public static void main(String[] args)
    {
        long[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(equilibriumPoint(arr));
    }
}
