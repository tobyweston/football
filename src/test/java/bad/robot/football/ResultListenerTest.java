package bad.robot.football;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@RunWith(JMock.class)
public class ResultListenerTest {

    private final Mockery context = new Mockery();

    private final Unmarshaller unmarshaller = context.mock(Unmarshaller.class);
    private final ResultListener listener = new ResultListener(unmarshaller);

    @Test
    public void shouldUnmarshallScores() throws IOException {
        final Reader reader = new StringReader("nothing");
        context.checking(new Expectations() {{
            one(unmarshaller).unmarshall(reader);
        }});
        listener.onResultReceipt(reader);
    }

}
