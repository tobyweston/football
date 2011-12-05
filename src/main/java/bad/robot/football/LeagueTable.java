package bad.robot.football;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeagueTable implements Iterable<Placing> {

    private final Set<Placing> placings = new HashSet<Placing>();

    public LeagueTable(String... teams) {
        for (String team : teams)
            placings.add(new Placing(team, 0));
    }

    public void add(Result result) {
        result.update(findPlacingFor(result.getHomeTeam()));
        result.update(findPlacingFor(result.getAwayTeam()));
    }

    private Placing findPlacingFor(String team) {
        for (Placing placing : placings)
            if (placing.getTeam().equals(team))
                return placing;
        return null;
    }

    @Override
    public Iterator<Placing> iterator() {
        return placings.iterator();
    }

    @Override
    public String toString() {
        return Arrays.toString(placings.toArray());
    }
}
