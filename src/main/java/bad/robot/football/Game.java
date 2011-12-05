package bad.robot.football;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {

    private final Date date;
    private final Result result;

    public Game(Date date, String homeTeam, int homeScore, String awayTeam, int awayScore) {
        this.date = date;
        this.result = calculateResult(homeTeam, homeScore, awayTeam, awayScore);
    }

    private Result calculateResult(String homeTeam, int homeScore, String awayTeam, int awayScore) {
        if (homeScore > awayScore)
            return new Win(homeTeam);
        if (awayScore > homeScore)
            return new Win(awayTeam);
        if (homeScore == awayScore)
            return new Draw(homeTeam, awayTeam);
        return null;
    }

    public void update(Placing placing) {
        result.update(placing);
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
        return new SimpleDateFormat("dd/MM/yyyy").format(date);// + " " + homeTeam + " " + homeScore + "-" + awayScore + " " + awayTeam;
    }

}
