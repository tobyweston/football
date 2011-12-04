package bad.robot.football;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UnmarshallerTest {

    private final Unmarshaller unmarshaller = new Unmarshaller();

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowExceptionForMissingFile() throws IOException, ParseException {
        unmarshaller.unmarshall("rubarb.foo");
    }

    @Test
    public void shouldUnmarshall() throws IOException, ParseException {
        List<Result> results = unmarshaller.unmarshall("scores.csv");
        List<Result> expected = new ArrayList<Result>() {{
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2011"), "Bristol City", 4, "Arsenal", 2));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2011"), "Brompton", 2, "West Smithfields", 4));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2011"), "Tottenham", 2, "Aston Villa", 0));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2011"), "Chelsea", 1, "Liverpool", 2));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2011"), "Everton", 2, "Wolverhampton", 1));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2011"), "Man City", 3, "Newcastle", 2));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2011"), "Norwich", 1, "Arsenal", 2));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("14/11/2011"), "Stoke", 2, "QPR", 3));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("14/11/2011"), "Sunderland", 0, "Fulham", 1));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2011"), "Swansea", 0, "Man Utd", 1));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2011"), "West Brom", 2, "Bolton", 1));
            add(new Result(new SimpleDateFormat("dd/MM/yyyy").parse("19/11/2011"), "Wigan", 3, "Blackburn", 3));
        }};
        assertThat(results, is(equalTo(expected)));
    }


}
