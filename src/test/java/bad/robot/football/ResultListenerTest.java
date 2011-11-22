package bad.robot.football;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static bad.robot.football.DateAsString.asDate;
import static java.util.Collections.emptyList;

@RunWith(JMock.class)
public class ResultListenerTest {

    private final Mockery context = new Mockery();

    private final LeagueTable leagueTable = context.mock(LeagueTable.class);
    private final Unmarshaller unmarshaller = context.mock(Unmarshaller.class);
    private final ResultListener listener = new ResultListener(leagueTable, unmarshaller);

    @Test
    public void shouldUnmarshallScores() throws IOException {
        final Reader reader = new StringReader("nothing");
        context.checking(new Expectations() {{
            one(unmarshaller).unmarshall(reader); will(returnValue(emptyList()));
            ignoring(leagueTable);
        }});
        listener.onResultReceipt(reader);
    }

    @Test
    public void shouldUpdateLeagueTable() throws IOException {
        final List<Result> results = new ArrayList<Result>() {{
            add(new Result(asDate("10/10/2011"), "Bristol City", 4, "Arsenal", 2));
            add(new Result(asDate("10/10/2011"), "Brompton", 2, "West Smithfields", 4));
            add(new Result(asDate("11/10/2011"), "Tottenham", 2, "Aston Villa", 0));
        }};
        final Reader reader = new StringReader("nothing");
        context.checking(new Expectations() {{
            one(unmarshaller).unmarshall(with(any(Reader.class))); will(returnValue(results));
            one(leagueTable).add(results.toArray(new Result[] {}));
        }});
        listener.onResultReceipt(reader);
    }

}
