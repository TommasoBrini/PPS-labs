package e2.model;

import e2.Pair;

public class Knight extends PieceImpl{

    public Knight(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean move(int row, int col){
        // Below a compact way to express allowed moves for the knight
        int x = row-this.getPosition().getX();
        int y = col-this.getPosition().getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            this.setPosition(new Pair<>(row, col));
            return true;
        }
        return false;
    }

}
