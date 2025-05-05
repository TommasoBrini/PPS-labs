package e2.model;

import e2.Pair;

public class PieceImpl implements Piece{

    private Pair<Integer,Integer> position;

    public PieceImpl(Pair<Integer,Integer> position){
        this.position = position;
    }


    @Override
    public boolean isEmpty() {
        return this.position == null;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean move(int row, int col) {
        return false;
    }

    protected void setPosition(Pair<Integer, Integer> position){
        this.position = position;
    }
}
