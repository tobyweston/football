package bad.robot.football;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {

    private final Date date;
    private final String homeTeam;
    private final int homeScore;
    private final String awayTeam;
    private final int awayScore;

    public Result(Date date, String homeTeam, int homeScore, String awayTeam, int awayScore) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.homeScore = homeScore;
        this.awayTeam = awayTeam;
        this.awayScore = awayScore;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(date) + " " + homeTeam + " " + homeScore + "-" + awayScore + " " + awayTeam;
    }

    public void updateHomeTeam(Placing placing) {
        if (placing.affectedBy(homeTeam))
            update(placing, homeScore, awayScore);
    }

    public void updateAwayTeam(Placing placing) {
        if (placing.affectedBy(awayTeam))
            update(placing, awayScore, homeScore);
    }

    private void update(Placing placing, int first, int second) {
        if (first > second)
            placing.addWin();
        else if (first == second)
            placing.addDraw();
    }
}
