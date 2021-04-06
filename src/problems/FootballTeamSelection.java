package problems;

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




public class FootballTeamSelection {

    /*
     * Complete the 'getSelectionStatus' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY applications as parameter.
     */

    static final double MIN_HEIGHT = 5.8;
    static final double MAX_BMI = 23;
    static final int MIN_SCORES = 50;
    static final int MIN_DEFENDS = 30;
    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        List<Application> app = new ArrayList<>();
        applications.forEach( params -> app.add(new Application(params)));

        List<Application> apps = app.stream().filter(a -> a.height >= MIN_HEIGHT && a.bmi <= MAX_BMI).collect(Collectors.toList());

        List<Application> striker = apps.stream().filter(a -> a.scores >= MIN_SCORES).collect(Collectors.toList());
        striker.sort(Comparator.comparing(a -> a.scores));
        Collections.reverse(striker);

        List<Application> defender = apps.stream().filter(a -> a.defends >= MIN_DEFENDS).collect(Collectors.toList());
        defender.sort(Comparator.comparing(a -> a.defends));
        Collections.reverse(defender);

        HashMap<String, List<String>> status = new HashMap<>();
        int min = Math.min(striker.size(), defender.size());
        for(int i = 0, j = 0; i < min; ) {
            // System.out.print(striker.size() + "-" + defender.size());
            Application s = striker.get(i);
            List<String> msg1 = new ArrayList<>();
            msg1.add(s.name);
            msg1.add("SELECT");
            msg1.add("STRIKER");

            Application d = defender.get(j);
            List<String> msg2 = new ArrayList<>();
            msg2.add(d.name);
            msg2.add("SELECT");
            msg2.add("DEFENDER");
            if(!s.name.equals(d.name)) {
                status.put(s.name, msg1);
                status.put(d.name, msg2);
                i++;j++;
            } else {
                if(i > j) {
                    status.put(s.name, msg1);
                    i++;
                } else {
                    status.put(d.name, msg2);
                    j++;
                }
            }
        }

        for(Application a : app) {
            if(!status.containsKey(a.name)) {
                List<String> msg = new ArrayList<>();
                msg.add(a.name);
                msg.add("REJECT");
                msg.add("NA");
                status.put(a.name, msg);
            }
        }

        List<String> names = new ArrayList<>(status.keySet());
        names.sort(Comparator.naturalOrder());

        List<List<String>> res = new ArrayList<>();
        for(String name : names) {
            res.add(status.get(name));
        }

        return res;
    }

}

class Application {
    String name;
    double height;
    double bmi;
    int scores;
    int defends;

    public Application(List<String> params) {
        name = params.get(0);
        height = Double.parseDouble(params.get(1));
        bmi = Double.parseDouble(params.get(2));
        scores = Integer.parseInt(params.get(3));
        defends = Integer.parseInt(params.get(4));
    }
}