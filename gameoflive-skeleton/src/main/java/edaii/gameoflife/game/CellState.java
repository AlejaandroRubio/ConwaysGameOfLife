package edaii.gameoflife.game;

import java.util.Objects;

public class CellState {
    private final boolean m_alive;

    private CellState(boolean alive){
        this.m_alive = alive;
    }

    public static CellState create(boolean alive){
        return new CellState(alive);
    }

    public static CellState create(int state){
        if(!GameConstants.isValidState(state)){
            throw new InvalidCellStateException();
        }
        final boolean alive = state == GameConstants.CELL_ALIVE;
        return new CellState( alive );
    }

    public boolean isAlive() {
        return m_alive;
    }

    public boolean isDead() {
        return !m_alive;
    }

    public int toInt() {
        return m_alive ? GameConstants.CELL_ALIVE : GameConstants.CELL_DEAD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellState cellState = (CellState) o;
        return m_alive == cellState.m_alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_alive);
    }
}
