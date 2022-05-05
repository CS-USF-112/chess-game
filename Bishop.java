public class Bishop extends ChessPiece {
    
    private final String name = "bishop";
    private int col;
    private int row;

    public Bishop(int col, int row)
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
        // detection does not need to take into account exact scenarios
        // as previous if statements check if the slot exists and is empty

        for (int i = 0; i < 7; i++)
            if (newCol == col + i && newRow == row + i)
                return true;

        for (int i = 0; i < 7; i++)
            if (newCol + i == col && newRow + i == row)
                return true;

        for (int i = 0; i < 7; i++)
            if (newCol + i == col && newRow == row + i)
                return true;

        for (int i = 0; i < 7; i++)
            if (newCol == col + i && newRow + i == row)
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