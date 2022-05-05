public class Knight extends ChessPiece { 

    private final String name = "knight";
    private int col;
    private int row;

    public Knight(int col, int row)
    {
        this.col = col;
        this.row = row;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getCol() { return col; }

    @Override
    public  int getRow() { return row; }

    @Override
    public boolean Move(int newCol, int newRow)
    {
        if ((newRow == row + 2) || (newRow == row - 2) && (newCol == col + 1) || (newCol == col - 1))
            return true;

        if ((newRow == row + 1) || (newRow == row - 1) && (newCol == col + 2) || (newCol == col - 2))
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