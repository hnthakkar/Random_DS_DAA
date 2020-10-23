public class PlusOne {

    public static void main(String[] args) {
        plusOne(new int[] {9,9});
    }

    public static int[] plusOne(int[] digits) {
        int lsb = digits.length - 1;
        boolean hasCarry = false;
        while (lsb >= 0) {
            digits[lsb] += 1;
            if (digits[lsb] > 9) {
                digits[lsb] = digits[lsb] % 10;
                hasCarry = true;
            } else {
                hasCarry = false;
                break;
            }
            lsb--;
        }

        if (hasCarry) {
            int[] retArray = new int[digits.length + 1];
            retArray[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                retArray[i] = digits[i-1];
            }
            digits = retArray;
        }
        return digits;
    }
}
