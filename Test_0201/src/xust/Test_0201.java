package xust;

import java.util.Arrays;

/*
1. ��С�ƶ�����ʹ����Ԫ�����
����һ������Ϊ n �ķǿ��������飬�ҵ�����������Ԫ����ȵ���С�ƶ�������ÿ���ƶ�����ʹ n - 1 ��Ԫ������ 1��
ʾ��:
����:
[1,2,3]
���:
3
����:
ֻ��Ҫ3���ƶ���ע��ÿ���ƶ�����������Ԫ�ص�ֵ����
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
    		Arrays.sort(nums);//��������
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