package bad.robot.football;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class ResultListener {

    private final LeagueTable leagueTable;
    private final Unmarshaller unmarshaller;
    private final LeagueUpdatedListener listener;

    public ResultListener(LeagueTable leagueTable, Unmarshaller unmarshaller, LeagueUpdatedListener listener) {
        this.leagueTable = leagueTable;
        this.unmarshaller = unmarshaller;
        this.listener = listener;
    }

    public void onResultReceipt(Reader reader) throws IOException {
        List<Result> results = unmarshaller.unmarshall(reader);
        leagueTable.add(toArray(results));
        listener.leagueUpdated(Collections.<Placing>emptyList());
    }

    private static Result[] toArray(List<Result> results) {
        return results.toArray(new Result[] {});
    }

}
