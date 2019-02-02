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
		System.out.println(So.minMoves2(nums));
	}
}
/*
 * 分析：
 * 正向思考：计算数组最大元素与最小元素的差，给小于最大元素的数组元素都加上这个数，判断数组的元素是否已全部相等，如果不相等，接着执行上述操作，直到全部相等，
 * 为了得到最大元素和最小元素，可以使用数组排序。
 * 逆向思考：每次移动让除去最大元素的剩余n-1个数加1，相当于每次移动让选定的数减1，所以最少移动次数其实就是所有元素减去最小元素的和。
 */
class Solution {
    public int minMoves1(int[] nums) {
    	int count = 0;
    	while(compare(nums) == false){
    		Arrays.sort(nums);//数组排序
    		int n =nums[nums.length-1]-nums[0];
    		for(int i = 0; i<nums.length-1; i++){
    			nums[i] += n;
    		}
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
    public int minMoves2(int[] nums) {
    	int sum = nums[0];
    	int min = nums[0];
    	for(int i=1; i<nums.length; i++){
    		sum += nums[i];
    		if(nums[i] <min)
    			min = nums[i];
    	}
    	return sum -nums.length*min; 
    }
}