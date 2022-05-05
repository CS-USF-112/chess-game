public abstract class ChessPiece{

    // by calling Move() 
    // we already know that the piece exists and there 
    // is no piece in newCol & newRow
    // *absreact code

    // all chess pieces can be acces through here

    public abstract boolean Move(int newCol, int newRow);

    public abstract String getName();

    public abstract int getCol();

    public abstract int getRow();

    public abstract void changePosition(int newCol, int newRow);
}