package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  private static final int SIZE = 5;
  private static final int DEFAULT_KNIGHT_ROW = 0;
  private static final int DEFAULT_KNIGHT_COLUMN = 0;
  private static final int DEFAULT_PAWN_ROW = 2;
  private static final int DEFAULT_PAWN_COLUMN = 1;

  private Logics logics;

  private void createRandomLogics(){
    this.logics = new LogicsImpl(SIZE);
  }

  private void createDefaultLogics(){
    this.logics = new LogicsImpl(SIZE, new Pair<>(DEFAULT_KNIGHT_ROW, DEFAULT_KNIGHT_COLUMN), new Pair<>(DEFAULT_PAWN_ROW, DEFAULT_PAWN_COLUMN));
  }

  @Test
  public void testRandomEmptyPosition(){
    this.createRandomLogics();
    assertFalse(this.logics.isEmpty());
  }

  @Test
  public void testHit(){
    this.createDefaultLogics();
    assertTrue(this.logics.hit(DEFAULT_PAWN_ROW, DEFAULT_PAWN_COLUMN));
  }

  @Test
  public void testKnightPosition(){
    this.createDefaultLogics();
    assertTrue(this.logics.hasKnight(DEFAULT_KNIGHT_ROW, DEFAULT_KNIGHT_COLUMN));
  }

  @Test
  public void testPawnPosition(){
    this.createDefaultLogics();
    assertTrue(this.logics.hasPawn(DEFAULT_PAWN_ROW, DEFAULT_PAWN_COLUMN));
  }

  @Test
  public void testKnightMoveNotHit(){
    this.createDefaultLogics();
    int newRow = 1;
    int newColumn = 2;
    assertFalse(this.logics.hit(newRow, newColumn));
    assertTrue(this.logics.hasKnight(newRow, newColumn));
  }

  @Test
  public void testHitOutOfBounds(){
    this.createRandomLogics();
    assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(-1,-1));
  }

}
