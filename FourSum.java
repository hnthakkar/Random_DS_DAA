import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
    }

    private static List<List<Integer>> returnList = new ArrayList<>();
    private static Set<String> set = new HashSet<>();

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int inputLength = nums.length;

        for (int i = 0; i < inputLength - 3; i++) {
            threeSum(nums, i+1, nums[i], inputLength, target);
        }

        System.out.println(returnList);
        return returnList;
    }

    public static void threeSum(int[] nums, int fromIndex, int a, int inputLength, int target) {
        for (int i = fromIndex; i < inputLength -2; i++) {
            twoSum(nums, i+1, a, nums[i], inputLength, target);
        }
    }

    public static void twoSum(int[] nums, int fromIndex, int a, int b, int inputLength, int target) {
        int leftIndex = fromIndex;
        int rightIndex = inputLength - 1;

        while (leftIndex < rightIndex) {
            if (a + b + nums[leftIndex] + nums[rightIndex] == target) {
                if (!set.contains("" + a + b + nums[leftIndex] + nums[rightIndex])) {
                    List<Integer> foundList = new ArrayList<>();
                    foundList.add(a);
                    foundList.add(b);
                    foundList.add(nums[leftIndex]);
                    foundList.add(nums[rightIndex]);
                    returnList.add(foundList);
                    set.add("" + a + b + nums[leftIndex] + nums[rightIndex]);
                }
                leftIndex++;
            } else if (a + b + nums[leftIndex] + nums[rightIndex] < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
    }
}

