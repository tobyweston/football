package bad.robot.football;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface Unmarshaller {
    List<Result> unmarshall(Reader reader) throws IOException;
}
