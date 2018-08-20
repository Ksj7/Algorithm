import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Pair {
        int year;
        String data;

        Pair(int y, String d) {
            year = y;
            data = d;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Pair p[] = new Pair[25];
        p[0] = new Pair(1967, "DavidBowie");
        p[1] = new Pair(1969, "SpaceOddity");
        p[2] = new Pair(1970, "TheManWhoSoldTheWorld");
        p[3] = new Pair(1971, "HunkyDory");
        p[4] = new Pair(1972, "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars");
        p[5] = new Pair(1973, "AladdinSane");
        p[6] = new Pair(1973, "PinUps");
        p[7] = new Pair(1974, "DiamondDogs");
        p[8] = new Pair(1975, "YoungAmericans");
        p[9] = new Pair(1976, "StationToStation");
        p[10] = new Pair(1977, "Low");
        p[11] = new Pair(1977, "Heroes");
        p[12] = new Pair(1979, "Lodger");
        p[13] = new Pair(1980, "ScaryMonstersAndSuperCreeps");
        p[14] = new Pair(1983, "LetsDance");
        p[15] = new Pair(1984, "Tonight");
        p[16] = new Pair(1987, "NeverLetMeDown");
        p[17] = new Pair(1993, "BlackTieWhiteNoise");
        p[18] = new Pair(1995, "1.Outside");
        p[19] = new Pair(1997, "Earthling");
        p[20] = new Pair(1999, "Hours");
        p[21] = new Pair(2002, "Heathen");
        p[22] = new Pair(2003, "Reality");
        p[23] = new Pair(2013, "TheNextDay");
        p[24] = new Pair(2016, "BlackStar");

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<Pair> al = new ArrayList<>();
            for (int j = 0; j < 25; j++) {
                if (s - p[j].year <= 0 && e - p[j].year >= 0) {
                    al.add(new Pair(p[j].year, p[j].data));
                }
            }
            System.out.println(al.size());
            if(al.size() > 0) {
                for (Pair y : al) {
                    System.out.println(y.year + " " + y.data);
                }
            }
        }
    }


}

