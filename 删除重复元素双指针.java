//题目：给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，
//使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
//这题的思路就是利用了双指针的思路，首先一个指针指向开头，另外一个指针指向后面的元素
//靠后面的指针遍历完一整个数组，如果后面指针指向的元素和前面指针指向的元素相等，就加一
//不相等的话就将后面指针的值赋给前面指针的后一位，前面的指针加一
//这样的话时间复杂度就是O(n),空间复杂度就是O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return (i+1);
    }
}
