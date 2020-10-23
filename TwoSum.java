import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        ArrayDataStore[] input = new ArrayDataStore[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ArrayDataStore ad = new ArrayDataStore(i, nums[i]);
            input[i] = ad;
        }

        Arrays.sort(input, new ArrayDataStoreSorter());

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int sum = 0;

        while (leftIndex < rightIndex) {
            sum = input[leftIndex].value + input[rightIndex].value;
            if (sum == target) {
                return new int[] {input[leftIndex].index, input[rightIndex].index};
            } else if(sum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return new int[2];
    }
}

class ArrayDataStore {
    int index;
    int value;

    public ArrayDataStore (int pIndex, int pValue) {
        index = pIndex;
        value = pValue;
    }
}

class ArrayDataStoreSorter implements Comparator<ArrayDataStore> {
    public int compare (ArrayDataStore ad1, ArrayDataStore ad2) {
        return ad1.value - ad2.value;
    }
}
