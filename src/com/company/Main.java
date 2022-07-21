package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Main {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int nx2 = matrix.size();

        List<Integer> maxList = new ArrayList<Integer>();
        for (int i =0; i<nx2/2; i++){
            for(int j=0; j<nx2/2; j++){
                int maxNum = findMaximum(matrix,i, j);
                maxList.add(maxNum);
            }
        }
        System.out.println();
        int sum = maxList.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
    public static int findMaximum(List<List<Integer>> matrix, int row, int column){
        int nx2 = matrix.size();
        int oppositeColumn = matrix.get(row).get(nx2-1-column);
        int oppositeRow = matrix.get(nx2-1-row).get(column);
        int oppositeDiagonal = matrix.get(nx2-1-row).get(nx2-1-column);
        int num = matrix.get(row).get(column);
        List<Integer> result = Arrays.asList(num, oppositeColumn, oppositeRow, oppositeDiagonal);
        System.out.println(result);

        int max = Collections.max(result);
        return max;
    }
}
