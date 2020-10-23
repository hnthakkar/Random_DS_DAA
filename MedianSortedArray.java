import java.math.BigDecimal;
import java.text.NumberFormat;

public class MedianSortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {}, new int[] {2,3}));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mergedLen = len1 + len2;

        int[] merged = new int[mergedLen];
        int num1Index = 0;
        int num2Index = 0;
        int mergedIndex = 0;
        while(num1Index < len1 || num2Index < len2) {
            if (num1Index >= len1) {
                merged[mergedIndex++] = nums2[num2Index++];
            } else if(num2Index >= len2) {
                merged[mergedIndex++] = nums1[num1Index++];
            } else if (nums1[num1Index] <= nums2[num2Index]) {
                merged[mergedIndex++] = nums1[num1Index++];
            } else {
                merged[mergedIndex++] = nums2[num2Index++];
            }
        }

        double median = Math.PI;
        if (mergedLen % 2 == 0) {
            int floorIndex = (mergedLen -1) / 2;
            int cielIndex = mergedLen / 2;
            median = (merged[floorIndex] + merged[cielIndex]) / 2.0;
        } else {
            median = merged[(mergedLen - 1) / 2];
        }

        return median;
    }
}
