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

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */


    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int top=n-r_q;
        int bottom=r_q-1;
        int left=c_q-1;
        int right= n-c_q;

        int topright=Math.min(top, right);
        int bottomright=Math.min(bottom, right);
        int bottomleft=Math.min(bottom, left);
        int topleft=Math.min(top, left);
        
        for (List<Integer> a: obstacles){
            int row=a.get(0);
            int column=a.get(1);
            
        if (column == c_q) {
            if (row > r_q) {
                top = Math.min(top, row - r_q - 1);
            } else {
                bottom = Math.min(bottom, r_q - row - 1);
            }
        }
        if (row == r_q) {
            if (column > c_q) {
                right = Math.min(right, column - c_q - 1);
            } else {
                left = Math.min(left, c_q - column - 1);
            }
        }
            
            
            if(Math.abs(c_q - column) == Math.abs(r_q - row)){
            
            int dist = Math.abs(row - r_q) - 1; 
            
            if (row > r_q && column > c_q) {
                topright = Math.min(topright, dist);
            } else if (row > r_q && column < c_q) {
                topleft = Math.min(topleft, dist);
            } else if (row < r_q && column < c_q) {
                bottomleft = Math.min(bottomleft, dist);
            } else if (row < r_q && column > c_q) {
                bottomright = Math.min(bottomright, dist);
            }
            }
            
        }
        return top+left+bottom+right+topleft+bottomleft+bottomright+topright;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna