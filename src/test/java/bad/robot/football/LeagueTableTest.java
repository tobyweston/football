package bad.robot.football;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.collection.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class LeagueTableTest {

    @Test
    public void createsLeagueWithJustWins() {
        LeagueTable leagueTable = new LeagueTable("Man City");
        leagueTable.add(new Game(asDate("10/10/2011"), "Man City", 2, "Man United", 1));
        assertThat(leagueTable, hasItems(new Placing("Man City", 3)));
    }

    @Test
    public void createsLeagueWithJustLoses() {
        LeagueTable leagueTable = new LeagueTable("Man United");
        leagueTable.add(new Game(asDate("10/10/2011"), "Man City", 2, "Man United", 1));
        assertThat(leagueTable, hasItems(new Placing("Man United", 0)));
    }

    @Test
    public void createsLeagueWithJustDraws() {
        LeagueTable leagueTable = new LeagueTable("Man City", "Man United");
        leagueTable.add(new Game(asDate("10/10/2011"), "Man City", 3, "Man United", 3));
        assertThat(leagueTable, hasItems(new Placing("Man City", 1), new Placing("Man United", 1)));
    }

    @Test
    public void createsLeagueTable() throws ParseException {
        LeagueTable leagueTable = new LeagueTable("Man City", "Man United", "West Ham");
        leagueTable.add(new Game(asDate("10/10/2011"), "Man City", 2, "Man United", 1));
        leagueTable.add(new Game(asDate("11/10/2011"), "Man City", 1, "Man United", 1));
        leagueTable.add(new Game(asDate("11/10/2011"), "Man City", 2, "West Ham", 3));
        assertThat(leagueTable, hasItems(
                new Placing("Man City", 4),
                new Placing("Man United", 1),
                new Placing("West Ham", 3)));
    }

    private static Date asDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
