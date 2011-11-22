package bad.robot.football;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class File {
    public static InputStreamReader getFileAsReader(String filename) throws IOException {
        InputStream stream = CsvUnmarshaller.class.getResourceAsStream(filename);
        if (stream == null)
            throw new FileNotFoundException(filename);
        return new InputStreamReader(stream);
    }
}
