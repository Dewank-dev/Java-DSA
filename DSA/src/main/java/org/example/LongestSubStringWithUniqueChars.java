package org.example;

import java.util.HashMap;


//Input: s = “geeksforgeeks”
//Output: 7
//Explanation: The longest substrings without repeating characters are “eksforg” and “ksforge”, with lengths of 7.
//
//
//Input: s = “aaa”
//Output: 1
//Explanation: The longest substring without repeating characters is “a”
//
//
//Input: s = “abcdefabcbb”
//Output: 6
//Explanation: The longest substring without repeating characters is “abcdef”.
public class LongestSubStringWithUniqueChars {


    // get all substring
    // break the inner loop if any duplicate char shows up
    // get the max length and return it.
    public int longestUniqueSubstr(String s) {
        int maxLen = 0;
        // taking all possible substring
        for(int i =0;i<s.length();i++) {
            String str = "";
            for(int j = i;j<s.length();j++) {
                // if any duplicate is there break the loop
                if(str.contains(""+s.charAt(j))){
                    break;
                } else {
                    str+= s.charAt(j);
                }
            }
            // check the max len
            maxLen = Math.max(maxLen, str.length());
        }

        return maxLen;
    }


    // We are hashing it and using sliding window with it
    // putting each char with its index in map
    // the window is between left and right, if any duplicate shows up with idx >= left
    // we are moving left to idx + 1, as all the string formed till then will be less than current
    public int longestUniqueSubstrOpt(String s) {
        // code here
        int maxLen = 0;
        int left = 0;
        int right =0;
        HashMap<Character,Integer> map= new HashMap<>();
        while(right < s.length()) {

            if(map.containsKey(s.charAt(right))){
                int pos = map.get(s.charAt(right));
                if( pos >= left) {
                    left = pos+1;
                }
            }
            map.put(s.charAt(right),right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
