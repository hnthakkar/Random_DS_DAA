public class MostWater {

    public static void main(String[] args) {
        maxArea(new int[] {1,8,6,2,5,4,8,3,7});
    }

    public static int maxArea(int[] height) {
        int leftBarPosition = 0;
        int rightBarPosition = height.length - 1;
        int max = 0;

        while (leftBarPosition < rightBarPosition) {
            int leftBarHeight = height[leftBarPosition];
            int rightBarHeight = height[rightBarPosition];

            int currentMax = (rightBarPosition - leftBarPosition) * Math.min(leftBarHeight, rightBarHeight);
            if (currentMax > max) {
                max = currentMax;
            }

            int currentLeftBarPosition = leftBarPosition;
            int currentRightBarPosition = rightBarPosition;

            if (leftBarHeight <= rightBarHeight) {
                while (height[leftBarPosition] <= height[currentLeftBarPosition]) {
                    if (leftBarPosition < rightBarPosition) {
                        leftBarPosition++;
                    } else {
                        break;
                    }
                }
            } else {
                while (height[rightBarPosition] <= height[currentRightBarPosition]) {
                    if (leftBarPosition < rightBarPosition) {
                        rightBarPosition--;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(max);
        return max;
    }
}
