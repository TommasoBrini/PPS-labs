package e2;

import e2.model.Knight;
import e2.model.Piece;
import e2.model.PieceImpl;

import java.util.*;

public class LogicsImpl implements Logics {

	private final Piece pawn;
	private final Piece knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new PieceImpl(this.randomEmptyPosition());
        this.knight = new Knight(this.randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn){
		this.size = size;
		this.pawn = new PieceImpl(pawn);
		this.knight = new Knight(knight);
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? this.randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		this.checkBounds(row,col);
		this.knight.move(row, col);
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}

	private void checkBounds(int row, int col){
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
	}


	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean isEmpty() {
		return this.knight.getPosition()==null && this.pawn.getPosition()==null;
	}
}
