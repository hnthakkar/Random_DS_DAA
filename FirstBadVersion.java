public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int leftIndex = 1;
        int rightIndex = n;

        if (isBadVersion(leftIndex)) {
            return leftIndex;
        }

        int midIndex = (leftIndex + rightIndex) / 2;

        while (leftIndex < rightIndex) {
            if (isBadVersion(midIndex)) {
                rightIndex = midIndex;
            } else {
                leftIndex = midIndex;
            }

            if (rightIndex - leftIndex <= 1) {
                break;
            }
            midIndex = leftIndex + (rightIndex - leftIndex)/2;
        }

        return rightIndex;
    }

    public static boolean isBadVersion(int number) {
        if (number >= 5) {
            return true;
        }
        return false;
    }
}
