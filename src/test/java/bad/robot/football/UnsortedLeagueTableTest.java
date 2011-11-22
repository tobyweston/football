package bad.robot.football;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static bad.robot.football.DateAsString.asDate;
import static org.hamcrest.collection.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class UnsortedLeagueTableTest {

    @Test
    public void createsLeagueWithJustWins() throws IOException {
        UnsortedLeagueTable leagueTable = new UnsortedLeagueTable("Man City");
        leagueTable.add(new Result(asDate("10/10/2011"), "Man City", 2, "Man United", 1));
        assertThat(leagueTable, hasItems(new Placing("Man City", 3)));
    }

    @Test
    public void createsLeagueWithJustLoses() throws IOException {
        UnsortedLeagueTable leagueTable = new UnsortedLeagueTable("Man United");
        leagueTable.add(new Result(asDate("10/10/2011"), "Man City", 2, "Man United", 1));
        assertThat(leagueTable, hasItems(new Placing("Man United", 0)));
    }

    @Test
    public void createsLeagueWithJustDraws() throws IOException {
        UnsortedLeagueTable leagueTable = new UnsortedLeagueTable("Man City", "Man United");
        leagueTable.add(new Result(asDate("10/10/2011"), "Man City", 3, "Man United", 3));
        assertThat(leagueTable, hasItems(new Placing("Man City", 1), new Placing("Man United", 1)));
    }

    @Test
    public void createsLeagueTable() throws ParseException, IOException {
        UnsortedLeagueTable leagueTable = new UnsortedLeagueTable("Man City", "Man United", "West Ham");
        leagueTable.add(
                new Result(asDate("10/10/2011"), "Man City", 2, "Man United", 1),
                new Result(asDate("11/10/2011"), "Man City", 1, "Man United", 1),
                new Result(asDate("11/10/2011"), "Man City", 2, "West Ham", 3)
        );
        assertThat(leagueTable, hasItems(
                new Placing("Man City", 4),
                new Placing("Man United", 1),
                new Placing("West Ham", 3))
        );
    }

}
