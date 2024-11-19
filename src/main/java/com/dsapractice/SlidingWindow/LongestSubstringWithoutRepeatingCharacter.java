//Given a string s, find the length of the longest substring without repeating characters
//Input: s = "abcabcbb","pwwkew"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Leetcode-3

//the idea is add the ele in hashset until its different when repeated ele comes start removing left and
//start increasing left and then remove the left repeated one and add the right ele and return length


package com.dsapractice.SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {

    public static int LengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0,left=0,right=0;
           while(right<s.length()){
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, set.size());
            }
            else{ //repeated ele came so start moving left and remove ele from set
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));//removing the repeated ele
                maxLength = Math.max(maxLength, set.size());
                set.add(s.charAt(right));//adding the rightmost ele new one
            }
        }
           return maxLength;
    }

    public static void main(String[] args) {
         String str="abcabcbb";
         System.out.println(LengthOfLongestSubstring(str));
    }
}
