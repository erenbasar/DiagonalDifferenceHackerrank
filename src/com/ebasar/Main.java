package com.ebasar;

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

public class Main {

    public static void main(String[] args) {
        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
        group.add(Arrays.asList(1, 2, 3));
        group.add(Arrays.asList(4, 5, 6));
        group.add(Arrays.asList(7, 8, 2));
        System.out.println(Result.diagonalDifference(group));
    }


    class Result {

        /*
         * Complete the 'diagonalDifference' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */

        public static int diagonalDifference(List<List<Integer>> arr) {
            int diagonalOne = 0;
            int diagonalTwo = 0;


            for(int i = 0;i < arr.size(); i++){
                for(int j = 0; j< arr.get(i).size();j++){
                    if(i==j)
                        diagonalOne += arr.get(i).get(j);
                    if(arr.size()-(i+1)==j)
                        diagonalTwo += arr.get(i).get(j);
                }
            }

            return Math.abs(diagonalOne-diagonalTwo);

        }


    }


    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> arr = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = Result.diagonalDifference(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
