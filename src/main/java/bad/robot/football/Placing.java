package bad.robot.football;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Placing {

    private final String team;
    private int points;

    public Placing(String team, int points) {
        this.team = team;
        this.points = points;
    }

    public String getTeam() {
        return team;
    }

    public void addWin() {
        points += 3;
    }

    public void addDraw() {
        points += 1;
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
        return "Placing{team='" + team + '\'' + ", points=" + points + '}';
    }
}
