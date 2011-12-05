package bad.robot.football;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Unmarshaller {

    public List<Game> unmarshall(String filename) throws IOException, ParseException {
        List<Game> games = new ArrayList<Game>();
        CSVReader reader = new CSVReader(getFileAsReader(filename));
        String[] line = reader.readNext();
        while ((line = reader.readNext()) != null)
            games.add(resultFromArray(line));
        return games;
    }

    private Game resultFromArray(String[] line) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(line[0]);
        String homeTeam = line[1].trim();
        int homeScore = Integer.parseInt(line[2].trim());
        String awayTeam = line[3].trim();
        int awayScore = Integer.parseInt(line[4].trim());
        return new Game(date, homeTeam, homeScore, awayTeam, awayScore);
    }

    private static InputStreamReader getFileAsReader(String filename) throws FileNotFoundException {
        InputStream stream = Unmarshaller.class.getResourceAsStream(filename);
        if (stream == null)
            throw new FileNotFoundException(filename);
        return new InputStreamReader(stream);
    }

}
