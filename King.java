public class King extends ChessPiece {
    
    private final String name = "king";
    private int col;
    private int row;

    public King(int col, int row)
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
        // move left
        if (newCol - 1 == col || newRow == row)
            return true;
        
        //move right
        else if (newCol + 1 == col || newRow == row)
            return true;

        // move up
        else if (newCol == col || newRow + 1 == row)
            return true;

        // move down
        else if (newCol == col || newRow - 1 == row)
            return true;

        // left and down
        else if (newCol -1 == col || newRow - 1 == row)
            return true;
        
        // up and right
        else if (newCol + 1 == col || newRow + 1 == row)
            return true;

        // down and right
        else if (newCol - 1 == col || newRow + 1 == row)
            return true;

         // up and left
        else if (newCol + 1 == col || newRow - 1 == row)
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