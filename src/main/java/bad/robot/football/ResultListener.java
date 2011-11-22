package bad.robot.football;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ResultListener {

    private final Unmarshaller unmarshaller;

    public ResultListener(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void onResultReceipt(Reader reader) throws IOException {
        List<Result> results = unmarshaller.unmarshall(reader);

    }
}
