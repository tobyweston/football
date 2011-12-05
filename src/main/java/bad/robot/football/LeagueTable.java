package bad.robot.football;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeagueTable implements Iterable<Placing> {

    private final List<Placing> placings = new ArrayList<Placing>();

    public LeagueTable(String... teams) {
        for (String team : teams)
            placings.add(new Placing(team, 0));
    }

    public void add(Game game) {
        for (Placing placing : placings)
            game.update(placing);
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
