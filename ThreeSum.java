import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int inputLength = nums.length;
        List<List<Integer>> returnList = new ArrayList<>();

        for (int i = 0; i < inputLength; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            returnList.addAll(twoSum(nums, i+1, nums[i]));
        }

        return returnList;
    }

    public List<List<Integer>> twoSum(int[] nums, int fromIndex, int targetSum) {
        int leftIndex = fromIndex;
        int rightIndex = nums.length - 1;
        List<List<Integer>> returnList = new ArrayList<>();
        Set<Integer> startSet = new HashSet<>();

        while (leftIndex < rightIndex) {
            if (nums[leftIndex] + nums[rightIndex] + targetSum == 0) {
                if (!startSet.contains(nums[leftIndex])) {
                    List<Integer> foundList = new ArrayList<>();
                    foundList.add(targetSum);
                    foundList.add(nums[leftIndex]);
                    foundList.add(nums[rightIndex]);
                    returnList.add(foundList);
                    startSet.add(nums[leftIndex]);
                }
                leftIndex++;
            } else if (nums[leftIndex] + nums[rightIndex] + targetSum < 0) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return returnList;
    }
}