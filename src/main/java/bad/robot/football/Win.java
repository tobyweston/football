package bad.robot.football;


public class Win implements Result {

    private final String team;

    public Win(String team) {
        this.team = team;
    }

    @Override
    public void update(Placing placing) {
        if (placing.affectedBy(team))
            placing.addPoints(3);
    }

}
