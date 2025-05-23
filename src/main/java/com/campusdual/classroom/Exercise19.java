package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        return getTridimensionalString(intArrayTri, flatTridimensionalArray(intArrayTri));

    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int [][] arrayFlattening = new int[intArrayTri[0].length][intArrayTri.length];

        for (int i = 0; i < intArrayTri[0].length; i++) {
            for (int j = 0; j < intArrayTri.length; j++) {
                for (int k = 0; k < intArrayTri[j][i].length; k++) {
                    arrayFlattening[j][i] += intArrayTri[k][j][i];
                }
            }
        }
        return arrayFlattening;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(getUnidimensionalString(intArrayBi[i]));
            if (i != intArrayBi.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();

    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder undidimensionalString = new StringBuilder();

        for (int i = 0; i < uniArray.length; i++) {
            undidimensionalString.append(uniArray[i]);
            if (i != uniArray.length - 1) {
                undidimensionalString.append(" ");
            }
        }
        return undidimensionalString.toString(); // Return String
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] arrayUni = new int[columns];
        for (int i = 0; i < columns; i++) {
            arrayUni[i] = i+1;
        }
        return arrayUni;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] arrayBi = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arrayBi[i][j] = i * columns + (j+1);
            }
        }
        return arrayBi;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] arrayTri = new int[depth][rows][columns];

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    arrayTri[i][j][k] = i * rows * columns + j * columns + (k+1);
                }
            }
        }
        return arrayTri;

    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
