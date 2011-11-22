package bad.robot.football;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
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
    private final LeagueUpdatedListener sms = context.mock(LeagueUpdatedListener.class);
    private final ResultListener listener = new ResultListener(leagueTable, unmarshaller, sms);

    private static final List<Result> results = new ArrayList<Result>();
    
    @Before
    public void initialiseResults() throws IOException {
        results.add(new Result(asDate("10/10/2011"), "Bristol City", 4, "Arsenal", 2));
        results.add(new Result(asDate("10/10/2011"), "Brompton", 2, "West Smithfields", 4));
        results.add(new Result(asDate("11/10/2011"), "Tottenham", 2, "Aston Villa", 0));
    };

    @Test
    public void shouldUnmarshallScores() throws IOException {
        final Reader reader = anyReader();
        context.checking(new Expectations() {{
            one(unmarshaller).unmarshall(reader); will(returnValue(emptyList()));
            ignoring(leagueTable);
            ignoring(sms);
        }});
        listener.onResultReceipt(reader);
    }

    @Test
    public void shouldUpdateLeagueTable() throws IOException {
        context.checking(new Expectations() {{
            one(unmarshaller).unmarshall(with(any(Reader.class))); will(returnValue(results));
            one(leagueTable).add(results.toArray(new Result[]{}));
            ignoring(sms);
        }});
        listener.onResultReceipt(anyReader());
    }

    @Test
    public void shouldUpdateNewLeaguePositionsViaMessagingService() throws IOException {
        context.checking(new Expectations() {{
            one(unmarshaller).unmarshall(with(any(Reader.class))); will(returnValue(results));
            ignoring(leagueTable);
            one(sms).leagueUpdated(with(any(LeagueTable.class)));
        }});
        listener.onResultReceipt(anyReader());
    }

    private static StringReader anyReader() {
        return new StringReader("nothing");
    }

}
