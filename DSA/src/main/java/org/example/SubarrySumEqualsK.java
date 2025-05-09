package org.example;

import java.util.HashMap;
import java.util.Map;
//[0,0,0,0,0,0,0...10] //55
public class SubarrySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0 , sum = 0;
        for(int i =0; i<nums.length;i++) {
            sum = sum + nums[i];
            if(sum == k){
                ans++;
            }
            if(map.containsKey(sum - k)){
                ans+= map.get(sum-k);
            }

            map.put(sum,1);

        }

        return ans;

    }
}
