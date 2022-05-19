import java.util.Scanner;
/*
给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有一股股票。你也可以先购买，然后在同一天出售。
返回 你能获得的 最大 利润 。
*/

public class Main {
    public static int maxProfit(int[] prices){
        int length = prices.length;
        int[][] Money = new int[length][2];//动态规划，以空间换时间，创建一个二维数组，其中[i][0]表示此时没有股票持有现金[i][1]表示此时持有的股票
        Money[0][0] = 0;//初始化时一开始持有的现金为零
        Money[0][1] = -prices[0];//初始化时一开始如果买股票钱数为股票价格的复数
        for(int i=1;i<length;i++){
            Money[i][0] = Math.max(Money[i-1][0],Money[i-1][1]+prices[i]);//每次遍历，持有的现金数是之前一次持有的现金数和之前一次持有股票卖掉股票的钱数之中找一个最大值
            Money[i][1] = Math.max(Money[i-1][1],Money[i-1][0]-prices[i]);//每次遍历，持有的股票时的钱数是之前一次持有的股票钱数(不卖股票)和之前一次现金数买股票之后之中找一个最大值
        }
        return Money[length-1][0];//返回最后一次持有现金的钱数
    }

    public static void main(String[] args) {
        int[] p = {7,1,5,3,6,4};
        int sum = Main.maxProfit(p);
        System.out.println(sum);
    }
}