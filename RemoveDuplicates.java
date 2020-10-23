public class RemoveDuplicates {

    public static void main(String[] args) {
        removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
    }

    public static int removeDuplicates(int[] nums) {
        if (nums != null && nums.length > 0) {
            int len = nums.length;
            int currentElement = nums[0];
            int uniqueElemIndex = 0;
            int uniqueElemCounter = 1;
            for (int i = 1; i < len; i++) {
                if (currentElement == nums[i]) {
                    continue;
                }
                nums[++uniqueElemIndex] = nums[i];
                currentElement = nums[i];
                uniqueElemCounter++;
            }
            System.out.println(uniqueElemCounter);
            return uniqueElemCounter;
        }

        return 0;
    }
}
