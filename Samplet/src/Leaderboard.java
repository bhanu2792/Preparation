import java.io.*;

public class Leaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
       int[] rank = rank(scores);
       
       for (int j =0; j < rank.length; j++) {
    	   System.out.println("Rank is ->" + rank[j]);
       }
       int[] finalList = new int[scores.length+1];
       int leaderPos;
          for (int i =0; i < alice.length; i++){
              int index = getIndex(scores, alice[i]);
              if (alice[i] >= scores[index]) 
            	  leaderPos = rank[index];
              else 
            	  leaderPos = rank[index] + 1;
              
              System.out.println("leaderPos is" + leaderPos);
             
              finalList[i] = leaderPos;
    
          }

       return finalList;
           }

static int getIndex(int[] scores, int k){
    int left = 0;
    int right = scores.length - 1;

    while (left < right)
    {
        int middle = (left + right) / 2;
        if (scores[middle] == k) return middle;
        else if (scores[middle] < k) right = middle - 1;
        else left = middle + 1;
    }

    return left;
}
    static int[] rank (int[] score){
      int[] ranks = new int[score.length+1];
      int rankNo =1;
      ranks[0] = rankNo;
      int i =1;
      System.out.println("oth Rank" + rankNo);
      for ( ; i < score.length; i++){
          if (score[i] != score[i-1]){
              rankNo++;
              ranks[i] = rankNo;
              System.out.println("if case Rank" + rankNo);
          }else {
        	  System.out.println("else case Rank" + rankNo);
              ranks[i] = rankNo;
          }
      }
      rankNo++;
      ranks[i] = rankNo;
     return ranks; 
    }

    public static void main(String[] args) throws IOException {
        

        int[] scores = {100,100,90,90,80,75,60};

       

     
        int[] alice = {50, 65, 77, 90, 102};
        

       
        int[] result = climbingLeaderboard(scores, alice);

       // System.out.println("result is " + result);
    }
}
