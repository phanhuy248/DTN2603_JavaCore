package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Position {
    private int positionId;
    private PositionName positionName;

    public Position(PositionName positionName, int positionId) {
        this.positionName = positionName;
        this.positionId = positionId;
    }

}
