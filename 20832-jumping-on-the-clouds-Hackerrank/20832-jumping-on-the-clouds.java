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
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        int cur=0;
      if(c.size()==0){
                return 0;
            }
            
            int jump=0;
        for (int i=0; i<c.size(); i++){
         if(cur==c.size()-1){
            return jump;
         }
         
         if(c.get(cur+1)==0){
            System.out.println(i+"==1");
            if(cur+2< c.size()-1){
                            System.out.println(i+"==2");

             if( c.get(cur+2)==0){
                            System.out.println(i+"==3");

                jump++;
                cur=cur+2;
             }else{
                            System.out.println(i+"==4");

                jump++;
                cur++;
             }
            }else{
                            System.out.println(i+"==5");

                return jump+1;
            }
         }else{
            if(cur+2< c.size()){

             if( c.get(cur+2)==0){
                 

                jump++;
                cur=cur+2;
             }else{
          

              return jump;
             }
            }else{
              

                return jump;
            }
         }
         System.out.println("-----"+cur);
         
        }
        System.out.println("=======");
return jump;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna