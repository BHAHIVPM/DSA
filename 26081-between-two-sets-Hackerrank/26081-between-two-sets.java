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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    Collections.sort(a);
        Collections.sort(b);
        if(a.get(a.size()-1)>= b.get(0))
        {
            return 0;
        }
        System.out.print(a);
                System.out.print(a);

        List<Integer> fact=new ArrayList<>();
        for(int i=a.get(a.size()-1); i<=b.get(0); i++){
            boolean che=true;
            for(int j=0; j<a.size(); j++){
                if(i%a.get(j)!=0){
                    che=false;
                    break;
                }
            }
            if(che){
                fact.add(i);
            }
        }
                System.out.print(fact);

        List<Integer> cout=new ArrayList<>();
                for(int i=0; i<fact.size(); i++){
            boolean che=true;
            for(int j=0; j<b.size(); j++){
                if(b.get(j)%fact.get(i)!=0){
                    che=false;
                    break;
                }
            }
            if(che){
                cout.add(i);
            }
        }
                System.out.print(cout);


return cout.size();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna