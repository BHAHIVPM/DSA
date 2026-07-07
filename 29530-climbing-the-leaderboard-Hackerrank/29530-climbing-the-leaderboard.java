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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */


        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    
        List<Integer> rank=new ArrayList();
      List<Integer> uniqueScores = new ArrayList<>();
    for (int score : ranked) {
        if (uniqueScores.isEmpty() || uniqueScores.get(uniqueScores.size() - 1) != score) {
            uniqueScores.add(score);
        }
    }
                
                rank.add(1);
    for (int i=1; i<uniqueScores.size();i++){
        if(uniqueScores.get(i)==uniqueScores.get(i-1)){
            rank.add(rank.get(i-1));
            continue;
        }
        if(uniqueScores.get(i)<uniqueScores.get(i-1)){
            rank.add(rank.get(i-1)+1);
            continue;
        }    
    }            

System.out.print(rank);

    Integer current=player.size()-1;
    List<Integer> rankNew=new ArrayList();
    for(int i=0; i<player.size();i++){
        rankNew.add(i);
    }
    
    for (int i=0; i<uniqueScores.size();i++){

  while (current >= 0 && player.get(current) >= uniqueScores.get(i)) {
            if (player.get(current) == uniqueScores.get(i)) {
                rankNew.set(current, rank.get(i));
            } else {
                // The player score is strictly greater than the leaderboard score
                rankNew.set(current, rank.get(i));
            }
            current--; // Check the next lower player score
        }
    
    }
while (current >= 0) {
        rankNew.set(current, rank.get(rank.size() - 1) + 1);
        current--;
    }
    System.out.print(rankNew);
    return rankNew;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna