public class SearchRange {

    public static void main(String[] args) {
        searchRange(new int[]{}, 0);
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = -1;
        int lastIndex = -1;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] <= target) {
                if (nums[i] == target) {
                    if (firstIndex == -1) {
                        firstIndex = i;
                    }
                    lastIndex = i;
                }
            } else {
                break;
            }
        }

        return new int[] {firstIndex, lastIndex};
    }
}
