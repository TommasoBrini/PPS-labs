package e2.model;

import e2.Pair;

public interface Piece {

    /**
     *
     * @return true if the position of pieces is not set, false otherwise
     */
    boolean isEmpty();

    /**
     *
     * @return the position of the piece
     */
    Pair<Integer, Integer> getPosition();

    /**
     *
     * @param row
     * @param col
     * @return true if the piece can move in new position
     */
    boolean move(int row, int col);
}
