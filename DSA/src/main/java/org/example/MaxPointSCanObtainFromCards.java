package org.example;
// Need to pick k cards having largest sum.
// can pick cards either from begining or ending

//Input: cardPoints[] = [1, 2, 3, 4, 5, 6, 1], k = 3
//Output: 12
//Explanation: Taking the rightmost three cards yields a total score of 1 + 6 + 5 = 12.
//Input: cardPoints[] = [8, 6, 2, 4, 5], k = 5
//Output: 25
//Explanation: You need to take all the cards, so the score is 8 + 6 + 2 + 4 + 5 = 25.
public class MaxPointSCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        // First get sum of k elements from start
        for(int i =0 ;i<k;i++){
            lSum+=cardPoints[i];
        }
        maxSum = lSum;
        int left = k - 1;
        int right = cardPoints.length - 1;
        // Now Remove one from lsum and add rsum from last and compare the maxSum
        while(left >= 0) {
            lSum -= cardPoints[left];
            rSum += cardPoints[right];
            maxSum = Math.max(maxSum,lSum+rSum);

            right--;
            left--;
        }

        return maxSum;

    }
}
