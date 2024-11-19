//Given a string s and an integer k, return the length of the longest substring of s such that
// the frequency of each character in this substring is greater than or equal to k.
//if no such substring exists, return 0.
//LeetCode-395

//idea:store the freq of each char in map iterate if ele without repeating char come in b/w which
//is less than that means that will not contribute to substring calc the length
//if char with values >k are coming then calc the length of substring
//return max of both Substring


package com.dsapractice.HashMap;

import java.util.HashMap;

public class LongestSubstringWithKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        int n = s.length(),l=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(k<=1){
            return s.length();//as all char are part of substring
        }
        if (n<k || n==0) return 0;

        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(l<n && map.get(s.charAt(l))>=k){
            l++;
        }
        if(l>n-1) return l;
        int longestSubstring1 = longestSubstring(s.substring(0,l),k);

        while(l<n && map.get(s.charAt(l))<k){ //chars less than will not contribute to longest substring so escape these chars
            l++;
        }
        int longestSubstring2 = (l<n) ? longestSubstring(s.substring(l),k) :0;

        return Math.max(longestSubstring1,longestSubstring2);
    }
    public static void main(String[] args) {
        String str="ababbc";
        System.out.println(longestSubstring(str,2));

    }
    //o/p=ababb=5
}
