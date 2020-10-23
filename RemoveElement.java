public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {1}, 1));
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int currentIndex = 0;
        int replaceableIndex = getLastReplaceableIndex(nums, val, length);
        while (currentIndex < replaceableIndex) {
            if (nums[currentIndex] == val) {
                nums[currentIndex] = nums[replaceableIndex];
                nums[replaceableIndex] = val;
                replaceableIndex = getLastReplaceableIndex(nums, val, replaceableIndex);
            }
            currentIndex++;
        }

        if (currentIndex != replaceableIndex) {
            currentIndex--;
        }

        return currentIndex + 1;
    }

    public static int getLastReplaceableIndex (int[] nums, int val, int previousIndex) {
        while (--previousIndex >= 0) {
            if (nums[previousIndex] != val) {
                break;
            }
        }
        return previousIndex;
    }
}
