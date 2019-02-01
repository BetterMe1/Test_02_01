package xust;

import java.util.Arrays;

/*
1. 最小移动次数使数组元素相等
给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
示例:
输入:
[1,2,3]
输出:
3
解释:
只需要3次移动（注意每次移动会增加两个元素的值）：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Test_0201 {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {1,2,3};
		System.out.println(So.minMoves(nums));
	}
}
class Solution {
    public int minMoves(int[] nums) {
    	int count = 0;
    	while(compare(nums) == false){
    		Arrays.sort(nums);//数组排序
    		int n =nums[nums.length-1]-nums[0];
    		nums[nums.length-1] -= n;
            count += n;
    	}
    	return count;
    }
    private boolean compare(int[] nums) {
    	int c = nums[0];
    	for(int i=1; i<nums.length; i++){
    		if(nums[i] !=c){
    			return false;
    		}
    	}
    	return true;
    }
}