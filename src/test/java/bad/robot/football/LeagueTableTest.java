package bad.robot.football;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.collection.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class LeagueTableTest {

    @Test
    public void createsLeagueTableWithJustWins() {
        LeagueTable table = new LeagueTable("Man City");
        table.add(new Game(new Date(), "Man City", 2, "Man United", 1));
        assertThat(table, hasItem(new Placing("Man City", 3)));
    }

    @Test
    public void createsLeagueWithJustLoses() {
        LeagueTable table = new LeagueTable("Man City");
        table.add(new Game(new Date(), "Man City", 0, "Man United", 1));
        assertThat(table, hasItem(new Placing("Man City", 0)));
    }

    @Test
    public void createsLeagueWithJustDraws() {
        LeagueTable table = new LeagueTable("Man City", "Man United");
        table.add(new Game(new Date(), "Man City", 2, "Man United", 2));
        assertThat(table, hasItem(new Placing("Man City", 1)));
        assertThat(table, hasItem(new Placing("Man United", 1)));
    }

    @Test
    public void createsMixedWinDrawAndLosesLeagueTable() {
        LeagueTable leagueTable = new LeagueTable("Man City", "Man United", "West Ham");
        leagueTable.add(new Game(new Date(), "Man City", 2, "Man United", 1));
        leagueTable.add(new Game(new Date(), "Man City", 1, "Man United", 1));
        leagueTable.add(new Game(new Date(), "Man City", 2, "West Ham", 3));
        assertThat(leagueTable, hasItems(
                new Placing("Man City", 4),
                new Placing("Man United", 1),
                new Placing("West Ham", 3)));
    }

}
