package bad.robot.football;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class LeagueTableTest {

    @Test
    public void createsLeagueTableWithJustWins() {
        LeagueTable table = new LeagueTable("Man City");
        table.add(new Result(new Date(), "Man City", 2, "Man United", 1));
        assertThat(table, hasItem(new Placing("Man City", 3)));
    }

    @Test
    public void createsLeagueWithJustLoses() {
        LeagueTable table = new LeagueTable("Man City");
        table.add(new Result(new Date(), "Man City", 0, "Man United", 1));
        assertThat(table, hasItem(new Placing("Man City", 0)));
    }

    @Test
    public void createsLeagueWithJustDraws() {
        LeagueTable table = new LeagueTable("Man City", "Man United");
        table.add(new Result(new Date(), "Man City", 2, "Man United", 2));
        assertThat(table, hasItem(new Placing("Man City", 1)));
        assertThat(table, hasItem(new Placing("Man United", 1)));
    }

    @Test
    @Ignore
    public void createsMixedWinDrawAndLosesLeagueTable() {
    }

}
