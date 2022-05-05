public class Pawn extends ChessPiece {

    private final String name = "pawn";
    private int col;
    private int row;

    private boolean firstMove;
    
    public Pawn(int col, int row)
    {
        this.firstMove = true;
        this.col = col;
        this.row = row;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getCol() { return col; }

    @Override
    public int getRow() { return row; }

    @Override
    public boolean Move(int newCol, int newRow)
    {
        int move = 1;

        if (firstMove)
        {
            move = 2;
            firstMove = false;
        }

        if (col != newCol)
            return false;
        
        if (newRow == row + 1 || newRow == row + move )
            return true;

        return false;
    }

    @Override
    public void changePosition(int newCol, int newRow)
    {
        this.col = newCol;
        this.row = newRow;
    }
}