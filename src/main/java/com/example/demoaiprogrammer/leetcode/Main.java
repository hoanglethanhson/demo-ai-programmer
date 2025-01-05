package com.example.demoaiprogrammer.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        //get all positions of 0's
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> checkedRows = new ArrayList<>();
        List<Integer> checkedCols = new ArrayList<>();

        List<List<Integer>> zeroPos = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    zeroPos.add(List.of(i, j));
                }
            }
        }
        for (List<Integer> pos : zeroPos) {
            int i = pos.get(0);
            if (!checkedRows.contains(i)) {
                for (int k = 0; k < width; k++) {
                    matrix[i][k] = 0;
                }
                checkedRows.add(i);
            }
            int j = pos.get(1);
            if (!checkedCols.contains(j)) {
                for (int k = 0; k < height; k++) {
                    matrix[k][j] = 0;
                }
                checkedCols.add(j);
            }
        }
    }


}
