package org.example;


//Input: arr[] = [1, 0, 1], k = 1
//Output: 3
//Explanation: Maximum subarray of consecutive 1's is of size 3 which can be obtained after flipping the zero present at the 1st index.
//Input: arr[] = [1, 0, 0, 1, 0, 1, 0, 1], k = 2
//Output: 5
//Explanation: By flipping the zeroes at indices 4 and 6, we get the longest subarray from index 3 to 7 containing all 1’s.
public class MaximumConsecutiveOnesAfterFlippingZeroes {


    // Checking all subarrays, and tracking count of zeros
    // if count <= k(max zeros we can replace) we can calcluate the maxlen
    // once count > k, break the loop
    public int maxOnes(int arr[], int k) {
        // code here
        int maxLen = 0;
        for(int i=0;i<arr.length;i++) {

            int zeros = 0;
            for(int j = i;j<arr.length;j++) {
                if(arr[j] == 0) {
                    zeros++;
                }

                if(zeros <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else if (zeros > k) {
                    break;
                }
            }
        }

        return maxLen;
    }


    // k is the maximum number of zeros allowed to flip

    // Using sliding window approach
    // Once count of zeros > k, move left till zeros < k
    public int maxOnesOpt(int arr[], int k) {
        // code here
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while( right < arr.length) {
            if(arr[right] == 0){
                zeros++;
            }

            while(zeros > k) {
                if(arr[left] == 0) {
                    zeros--;
                }

                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
