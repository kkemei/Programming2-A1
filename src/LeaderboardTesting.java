public class LeaderboardTesting {
    public static void main (String args[]){
        makeRank(1,"Kip",1500);
        makeRank(2,"Dan",1000);
        makeRank(3,"Mike",500);
    }

    private static void makeRank(int rank, String name, int score){
        System.out.println(rank +"     ||     " + name + "     ||     " + score);
    }
}
