import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class ReverseSum {
    public static void solve() {
        try (MyScanner in = new MyScanner(System.in)) {
            int height = 0;
            int table[][] = new int[1][];
            int colSumArr[] = new int[1];
            int strSumArr[] = new int[1];
            int maxLineLength = 0;            
            while (in.hasNextLine()) {
                String currentLine = in.nextLine();
                try (MyScanner currentLineScanner = new MyScanner(currentLine);) {                    
                    if (height == strSumArr.length) {
                        strSumArr = Arrays.copyOf(strSumArr, 2 * strSumArr.length);
                    }
                    if (height == table.length) {
                        table = Arrays.copyOf(table, 2 * height);
                    }
                    int currentLineArray[] = new int[1];
                    int currentLineArrayEnd = 0;
                    while (currentLineScanner.hasNextInt()) {
                        if (currentLineArrayEnd == colSumArr.length) {
                            colSumArr = Arrays.copyOf(colSumArr, 2 * colSumArr.length);
                        }
                        if (currentLineArrayEnd == currentLineArray.length) {
                            currentLineArray = Arrays.copyOf(currentLineArray, 2 * currentLineArrayEnd);
                        }
                        int currentInt = currentLineScanner.nextInt();
                        strSumArr[height] += currentInt;
                        currentLineArray[currentLineArrayEnd] = currentInt;
                        colSumArr[currentLineArrayEnd++] += currentInt;
                    }
                    table[height] = Arrays.copyOf(currentLineArray, currentLineArrayEnd);
                    maxLineLength = Math.max(maxLineLength, table[height++].length);
                    currentLineScanner.close();
                } catch (IOException e) {
                    System.out.println("123");
                }
            }
            strSumArr = Arrays.copyOf(strSumArr, height);
            colSumArr = Arrays.copyOf(colSumArr, maxLineLength);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    System.out.print(strSumArr[i] + colSumArr[j] - table[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("123");
        }
    }
    public static void main(String[] args) {
        solve();
    }
}
