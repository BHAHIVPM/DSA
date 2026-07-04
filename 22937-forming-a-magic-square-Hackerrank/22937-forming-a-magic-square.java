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
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    public static int formingMagicSquare(List<List<Integer>> s) {
  
  
  List<List<List<Integer>>> data=List.of(
  
        List.of(
                List.of(8,3,4),List.of(1,5,9),List.of(6,7,2)
        ),
        List.of(
                List.of(4,9,2),List.of(3,5,7),List.of(8,1,6)
        ),
        List.of(
                List.of(2,7,6),List.of(9,5,1),List.of(4,3,8)
        ),
        List.of(
                List.of(6,1,8),List.of(7,5,3),List.of(2,9,4)
        ),
        
        List.of(
                List.of(4,3,8),List.of(9,5,1),List.of(2,7,6)
        ),
        List.of(
                List.of(8,1,6),List.of(3,5,7),List.of(4,9,2)
        ),
        List.of(
                List.of(6,7,2),List.of(1,5,9),List.of(8,3,4)
        ),
        List.of(
                List.of(2,9,4),List.of(7,5,3),List.of(6,1,8)
        )
        
  
  );
  
  Integer count=0;
  Integer response=-1;
  for(List<List<Integer>> i: data){
      count=0;
      for(int j=0; j<i.size();j++){
                for(int m=0; m<i.get(j).size();m++){
                    System.out.println(Math.abs(s.get(j).get(m) - i.get(j).get(m)));
                    

          count+=(Math.abs(s.get(j).get(m) - i.get(j).get(m)));
      }
      }
 System.out.print(count+" -- ");

      count=Math.abs(count);
      response=response==-1?count : Math.min(response, count);
     
  }
  return response;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna