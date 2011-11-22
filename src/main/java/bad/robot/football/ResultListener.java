package bad.robot.football;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ResultListener {

    private final LeagueTable leagueTable;
    private final Unmarshaller unmarshaller;

    public ResultListener(LeagueTable leagueTable, Unmarshaller unmarshaller) {
        this.leagueTable = leagueTable;
        this.unmarshaller = unmarshaller;
    }

    public void onResultReceipt(Reader reader) throws IOException {
        List<Result> results = unmarshaller.unmarshall(reader);
        leagueTable.add(results.toArray(new Result[] {}));
    }
}
