package e2;

import e2.model.Knight;
import e2.model.Piece;
import e2.model.PieceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    private static final Pair<Integer,Integer> KNIGHT_POSITION = new Pair<>(0,0);
    private static final Pair<Integer,Integer> PAWN_POSITION = new Pair<>(1,2);

    private Piece knight;
    private Piece pawn;

    private void createDefaultPositionPieces(){
        this.knight = new Knight(KNIGHT_POSITION);
        this.pawn = new PieceImpl(PAWN_POSITION);
    }

    @Test
    public void testPiecesNotEmpty(){
        this.createDefaultPositionPieces();
        assertFalse(this.knight.isEmpty());
        assertFalse(this.pawn.isEmpty());
    }

    @Test
    public void testPiecesPosition(){
        this.createDefaultPositionPieces();
        assertEquals(KNIGHT_POSITION, this.knight.getPosition());
        assertEquals(PAWN_POSITION, this.pawn.getPosition());
    }

    @Test
    public void testMoveKnight(){
        this.createDefaultPositionPieces();
        Pair<Integer, Integer> newPosition = new Pair<>(2,1);
        this.knight.move(newPosition.getX(), newPosition.getY());
        assertEquals(newPosition, this.knight.getPosition());
    }

    @Test
    public void testMovePawn(){
        this.createDefaultPositionPieces();
        assertFalse(this.pawn.move(2,1));
    }

    @Test
    public void testWrongMoveKnight(){
        this.createDefaultPositionPieces();
        Pair<Integer, Integer> newPosition = new Pair<>(5,1);
        assertFalse(this.knight.move(newPosition.getX(), newPosition.getY()));
    }

}
