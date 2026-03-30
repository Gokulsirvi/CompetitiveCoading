import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};

            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] result1 = twoSum(nums1, 9);
        System.out.println("Input: [2,7,11,15], Target: 9");
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // [0, 1]

        int[] nums2 = {3, 2, 4};
        int[] result2 = twoSum(nums2, 6);
        System.out.println("\nInput: [3,2,4], Target: 6");
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // [1, 2]

        int[] nums3 = {3, 3};
        int[] result3 = twoSum(nums3, 6);
        System.out.println("\nInput: [3,3], Target: 6");
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // [0, 1]
    }
}
// ```

// **Output:**
// ```
// Input: [2,7,11,15], Target: 9
// Output: [0, 1]

// Input: [3,2,4], Target: 6
// Output: [1, 2]

// Input: [3,3], Target: 6
// Output: [0, 1]
