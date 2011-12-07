package bad.robot.football;

public class Draw implements Result {

    private final String aTeam;
    private final String anotherTeam;

    public Draw(String aTeam, String anotherTeam) {
        this.aTeam = aTeam;
        this.anotherTeam = anotherTeam;
    }

    @Override
    public void update(Placing placing) {
        if (placing.affectedBy(aTeam) || placing.affectedBy(anotherTeam))
            placing.addPoints(1);
    }

}
