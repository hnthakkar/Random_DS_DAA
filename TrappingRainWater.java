public class TrappingRainWater {
    public static void main(String[] args) {
        trap(new int[]{4,9,4,5,3,2});
    }

    public static int trap(int[] height) {
        int trappedWater = 0;
        int numberOfElevations = height.length - 1;
        int leftElevationPosition = nextLeftElevationPosition(height, 0, numberOfElevations);
        int rightElevationPosition = leftElevationPosition + 2;

        while(rightElevationPosition <= numberOfElevations) {
            int[] nextTrap = nextHighElevationIndex(height, leftElevationPosition);
            if (nextTrap[0] != -1) {
                // we have a next higher elevation
                trappedWater += rightIncreasingTrappedWater(height, leftElevationPosition, nextTrap[1]);
            } else {
                trappedWater += rightDecreasingTrapWater(height, leftElevationPosition, nextTrap[1]);
            }
            leftElevationPosition = nextLeftElevationPosition(height, nextTrap[1], numberOfElevations);
            rightElevationPosition = leftElevationPosition + 2;
        }

        System.out.println(trappedWater);
        return trappedWater;
    }

    private static int nextLeftElevationPosition(int[] elevations, int fromIndex, int numberOfElevations) {
        while (fromIndex < numberOfElevations && elevations[fromIndex] == 0) {
            fromIndex++;
        }

        while ((fromIndex + 1) < numberOfElevations && elevations[fromIndex + 1] > elevations[fromIndex]) {
            fromIndex++;
        }
        return fromIndex;
    }

    private static int[] nextHighElevationIndex(int[] elevations, int nextHighFromIndex) {
        int[] retArray = new int[2];
        boolean hasNextHigh = false;
        int elevationLastIndex = elevations.length - 1;
        int nextHighFromHeight = elevations[nextHighFromIndex];
        int currentIndex = nextHighFromIndex + 2;
        // If next high not available, than return next highest among the following
        int nextMaxIndex = currentIndex;

        while (currentIndex <= elevationLastIndex) {
            if (elevations[currentIndex] >= nextHighFromHeight) {
                retArray[0] = 1; // has a next higher elevation
                retArray[1] = currentIndex; // send the index
                hasNextHigh = true;
                break;
            }

            if (elevations[currentIndex] > elevations[nextMaxIndex]) {
                nextMaxIndex = currentIndex;
            }
            currentIndex++;
        }

        if (!hasNextHigh) {
            retArray[0] = -1;
            retArray[1] = nextMaxIndex;
        }

        return retArray;
    }

    private static int rightIncreasingTrappedWater(int[] elevations, int fromIndex, int toIndex) {
        int trapped = 0;
        int maxHeight = elevations[fromIndex];
        for (int i = fromIndex + 1; i < toIndex; i++) {
            if (maxHeight > elevations[i]) {
                trapped += maxHeight - elevations[i];
            }
        }
        return trapped;
    }

    private static int rightDecreasingTrapWater(int[] elevations, int fromIndex, int toIndex) {
        int trapped = 0;
        int maxHeight = elevations[toIndex];
        for (int i = fromIndex + 1; i < toIndex; i++) {
            if (elevations[i] < maxHeight) {
                trapped += maxHeight - elevations[i];
            }
        }
        return trapped;
    }
}
