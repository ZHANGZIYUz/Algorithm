//有n头牛（1<=n<=50,000)要挤奶。给定每头牛挤奶的时间区间[A,B](1<=A<=B<=1,000,000，A,B为整数)。牛需要呆在畜栏里才能挤奶。
//一个畜栏同一时间只能容纳一头牛。问至少需要多少个畜栏，才能完成全部挤奶工作，以及每头牛都放哪个畜栏里？注意：在同一个畜栏的两头牛，它们挤奶时间区间不能在端点重合。
import java.util.Scanner;

public class Greedy {
    public static void main(String[] args) {
        int[][] cow = new int[100][2];//0表示开始时间，1表示结束时间
        int[] home = new int[100];//牛棚数组
        int count = 0;//开的牛棚个数
        int number;
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
        for (int i = 0; i < number; i++) {
            cow[i][0] = input.nextInt();
            cow[i][1] = input.nextInt();
        }
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(home[j]==0){
                    home[j] = cow[i][1];
                    count++;
                    break;
                } else if(home[j]<cow[i][0]){
                    home[j] = cow[i][1];
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
