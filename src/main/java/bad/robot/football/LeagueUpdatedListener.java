package bad.robot.football;

import java.util.EventListener;

public interface LeagueUpdatedListener extends EventListener {

    public void leagueUpdated(LeagueTable leagueTable);


}
