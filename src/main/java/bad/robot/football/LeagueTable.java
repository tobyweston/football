package bad.robot.football;

public interface LeagueTable extends Iterable<Placing> {

    void add(Result... results);
}
