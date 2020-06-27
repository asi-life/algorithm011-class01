//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Follow up: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10^4 
// It's guaranteed that nums[i] fits in a 32 bit-signed integer. 
// k >= 0 
// 
// Related Topics 数组

package com.wsz.leetcode.editor.cn;
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        int [] nums = {1,2,3,4,5,6,7};
        solution.rotate2(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        // 通过另外一个数组。将一部分拷贝到前面，另一部分拷贝到后面
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            temp[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int pre = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                current = next;
                nums[current] = pre;
                pre = temp;
                count++;
            } while (current != i);
        }
    }

    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int i = 0; count < nums.length; i++) {
            int current = i;
            int pre = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while(i != current);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
