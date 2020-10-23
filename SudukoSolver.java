import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SudukoSolver {

    private static final int numberOfRows = 9;
    private static final int numberOfColumns = 9;

    private static HashMap<String, ArrayList<Integer>> moreChances = new HashMap<>();
    private static HashMap<String, ArrayList<Integer>> notPossible = new HashMap<>();
    private static int[][] input = new int[numberOfRows][numberOfColumns];

    public static void main(String[] args) {
        try {
            readProblem();
            preCalculations();
            if (findSolution()) {
                printSolution();
            } else {
                System.out.println("Problem can't be solved..");
            }
        } catch(Exception e) {
            System.out.println("Problem!! Please try again..");
        }
    }

    private static void preCalculations() {

    }

    private static boolean findSolution() {

        return true;
    }

    /**
     * 1) Assuming number of rows and columns to be 9
     * 2) Empty space will be marked with '.'
     */
    private static boolean readProblem() {
        boolean validInput = true;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String line = scan.nextLine();
            if (line.length() == 9) {
                for (int j = 0; j < 9; j++) {
                    char ch = line.charAt(j);
                    if (ch == '.') {
                        input[i][j] = -1;
                        continue;
                    } else {
                        input[i][j] = Integer.parseInt(String.valueOf(ch));
                        // For backtracking purpose
                        // If length of possible/moreChance array is '1' means it was given or sure that's the number
                        ArrayList<Integer> chances = new ArrayList<>();
                        chances.add(input[i][j]);
                        moreChances.put(("" + i) + j, chances);

                        // include as not possible for other spots in the same row, column and sub-square
                        for (int z = 0; z < 9; z++) {
                            if ( z == i) {
                                continue;
                            }
                            // notPossible[z][j]
                        }
                    }
                }
            } else {
                System.out.println("Invalid Input");
                validInput = false;
                break;
            }
        }
        scan.close();
        if (validInput) {
            return true;
        } else {
            return false;
        }
    }

    private static void printSolution() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(input[i][j]);
                if ((j + 1) % 3 == 0) {
                    System.out.print('|');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print("\n");
            if ((i + 1) % 3 == 0) {
                System.out.print("__________________");
            }
        }
    }

    private static boolean validate (int atRow, int atColumn, int proposedNumber) {
        if (validateRow(atRow, proposedNumber) && validateColumn(atColumn, proposedNumber)
            && validateSquareBox(atRow, atColumn, proposedNumber)) {
            return true;
        }
        return false;
    }

    private static boolean validateRow(int rowNumber, int proposedNumber) {
        if (rowNumber < 0 || rowNumber >= numberOfRows) {
            return false;
        }

        for (int i = 0; i < numberOfColumns; i++) {
            if (input[rowNumber][i] == proposedNumber) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateColumn(int columnNumber, int proposedNumber) {
        if (columnNumber < 0 || columnNumber >= numberOfColumns) {
            return false;
        }

        for (int i = 0; i < numberOfRows; i++) {
            if (input[i][columnNumber] == proposedNumber) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateSquareBox(int atRowNumber, int atColumnNumber, int proposedNumber) {
        int[] rowRange = getBoundary(atRowNumber);
        int[] colRange = getBoundary(atColumnNumber);

        for (int i = rowRange[0]; i <= rowRange[1]; i++) {
            for (int j = colRange[0]; i <= colRange[1]; j++) {
                if (input[i][j] == proposedNumber) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] getBoundary(int inputValue) {
        if ( 0 <= inputValue && inputValue <= 2) {
            return new int[] {0, 2};
        } else if ( 3 <= inputValue && inputValue <= 5) {
            return new int[] {3, 5};
        } else {
            return new int[] {6, 8};
        }
    }
}
