package bad.robot.football;

import java.util.EventListener;
import java.util.List;

public interface LeagueUpdatedListener extends EventListener {

    public void leagueUpdated(List<Placing> placings);


}
