package bad.robot.football;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnsortedLeagueTable implements LeagueTable {

    private final List<Placing> placings = new ArrayList<Placing>();

    public UnsortedLeagueTable(String... teams) {
        for (String team : teams)
            placings.add(new Placing(team, 0));
    }

    @Override
    public void add(Result... results) {
        for (Result result : results) {
            for (Placing placing : placings) {
                result.updateHomeTeam(placing);
                result.updateAwayTeam(placing);
            }
        }
    }

    @Override
    public Iterator<Placing> iterator() {
        return placings.iterator();
    }

    @Override
    public String toString() {
        return placings.toString();
    }
}