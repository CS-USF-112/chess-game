public class Rook extends ChessPiece{ 

    private final String name = "rook";
    private int col;
    private int row;

    public Rook(int col, int row)
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
        // moving sideways
        if (newCol != col && newRow == row)
            return true;

        // moving up or down
        if (newCol == col && newRow != row)
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