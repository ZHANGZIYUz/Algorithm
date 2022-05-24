import java.util.Arrays;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

public class Main {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length];//动态规划，通过创造一个数组用来存放每次的最大值，空间换时间
        sum[0] = nums[0];//初始化，第一个元素最大值就是自己
        if (length == 1) {
            return nums[0];
        }
        for (int i = 1; i < length; i++) {
            sum[i] = Math.max(sum[i-1]+nums[i],nums[i]);//转移方程在左边，就是最大连续子序列的和就是上一个最大子序列加上自身和自身数值之中的最大值
        }
        int Max = sum[0];
        for(int i=1;i<length;i++){
            if(Max<sum[i]){
                Max = sum[i];
            }
        }
        return Max;
    }

    public static void main(String[] args) {
        int[] p = {5,4,-1,7,8};
        Main m = new Main();
        System.out.println(m.maxSubArray(p));
    }
}
