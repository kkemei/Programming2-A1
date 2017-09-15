public class LeaderboardTesting {
    public static void main (String args[]){
        makeRankings(1,"Kip",1500);
        makeRankings(2,"Dan",1000);
        makeRankings(3,"Mike",500);

    }

    private static void makeRankings(int rank, String name, int score){
        System.out.println(rank +"     ||     " + name + "     ||     " + score);
    }
}
