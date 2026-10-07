import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int key = arr.get(i);

            while (j >= 0 && key < arr.get(j)) {
                arr.set(j + 1, arr.get(j));
                j -= 1;
            }
            arr.set((j + 1), key);
            for (int e = 0; e < n; e++) {
                System.out.print(arr.get(e) + " ");
            }
            System.out.print("\n");
        }

    }

}

public class ISP2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
