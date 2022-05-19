import java.util.Arrays;
//就是检查一个数组是否有重复的数字，但思想就是先排序之后再相邻之间比较就可以判断是否有重复的数字了，这样的话可以减少时间复杂度

public class Main {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        Main m = new Main();
        System.out.println(m.containsDuplicate(a));
    }
}
