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

    public void add(Result result) {
        this.points = result.addTo(points);
    }

    public boolean affectedBy(String team) {
        return this.team.equals(team);
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
        return team + ", " + String.valueOf(points);
    }
}
