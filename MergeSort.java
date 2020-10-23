public class MergeSort {

    public static void main(String[] args) {
        merge(new int[3], 0,new int[]{1,2,3}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexToCopy = nums1.length - 1;
        int num1Index = m - 1;
        int num2Index = n - 1;
        while (num2Index >= 0 && num1Index >= 0) {
            if (nums1[num1Index] <= nums2[num2Index]) {
                nums1[indexToCopy--] = nums2[num2Index--];
            } else {
                nums1[indexToCopy--] = nums1[num1Index--];
            }
        }

        while(num2Index >= 0) {
            nums1[indexToCopy--] = nums2[num2Index--];
        }
        System.out.println("test");
    }
}
