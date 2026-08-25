public class Position {
    private int positionId;
    private PositionName positionName;

    public Position() {
    }

    public Position(PositionName positionName, int positionId) {
        this.positionName = positionName;
        this.positionId = positionId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }
}
