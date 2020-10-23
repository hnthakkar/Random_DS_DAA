public class InsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int i = 0;
        for (; i < length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        return i;
    }
}
