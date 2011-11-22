package bad.robot.football;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static bad.robot.football.DateAsString.asDate;

public class CsvUnmarshaller implements Unmarshaller {

    @Override
    public List<Result> unmarshall(Reader reader) throws IOException {
        List<Result> results = new ArrayList<Result>();
        CSVReader csv = new CSVReader(reader);
        String[] line = csv.readNext();
        while ((line = csv.readNext()) != null)
            results.add(resultFromArray(line));
        return results;
    }

    private Result resultFromArray(String[] line) throws IOException {
        Date date = asDate(line[0]);
        String homeTeam = line[1].trim();
        int homeScore = Integer.parseInt(line[2].trim());
        String awayTeam = line[3].trim();
        int awayScore = Integer.parseInt(line[4].trim());
        return new Result(date, homeTeam, homeScore, awayTeam, awayScore);
    }

}
