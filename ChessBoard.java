import java.util.*;

public class ChessBoard {

    private String[][] board = new String[9][9];
    private ChessPiece[] pieces = new ChessPiece[32];

    public ChessBoard()
    {
        board[8][0] = "==="; 
        
        for(int i = 0; i < 8; i++) 
        {
            int row = (7 - i);
            board[i][0] = "=" + String.valueOf(row) + "="; 
        }
    
        for(int i = 1; i < 9; i++) 
        { 
            int col = i;
            board[8][i] = "=" + String.valueOf(col - 1) + "="; 
        }
    
        for(int i = 0; i < 8; i++) 
            for(int j = 1; j < 9; j++)
                board[i][j] = "---";
    }

    public void printBoard()
    {
        System.out.println("");
        for(int i = 0; i < 9; i++) 
        { 
            for(int j = 0; j < 9; j++) 
            {
                System.out.print(board[i][j] + " "); 
            }

            System.out.println(); 
        }
        System.out.println("");
    }

    public void MovePiece(int col, int row, int newCol, int newRow) throws IllegalChessMoveException, OutOfBoardException
    {
        // out of bounds
        if (col > 7 || row > 7 || newRow > 7 || newCol > 7)
            throw new OutOfBoardException("error -> tried to move piece outside board" +  "[" + col + "-" + row + "]" + " -> " + "[" + newCol + "-" + newRow + "]");

            // piece not found
        if (findPiece(col, row) == null)
            throw new IllegalChessMoveException("* invalid piece: " + "[" + col + "-" + row + "]" + " does not exist " );
            
        // find piece and change its position
        for (int i = 0; i < pieces.length; i++)
        {
            // find piece checking col and row
            if(pieces[i] != null && pieces[i].getCol() == col && pieces[i].getRow() == row)
            {
                //check if piece is able to move the desired day
                if (pieces[i].Move(newCol, newRow))
                {
                    pieces[i].changePosition(newCol, newRow);

                    //modifies board
                    String pieceLetter = Character.toString(pieces[i].getName().charAt(0));
                    board[7 - row][col + 1] = "---";
                    board[7 - newRow][newCol + 1] = "-" + pieceLetter + "-";
                    System.out.println("moved: " + "[" + col + "-" + row + "]" + " - "  + pieces[i].getName() + " -> " + "[" + newCol + "-" + newRow + "]" );
                }
                else
                {
                    throw new IllegalChessMoveException("* invalid move: " + "[" + col + "-" + row + "]" + " -> " + "[" + newCol + "-" + newRow + "]" );
                }
            }

        }
    }

    public void addPiece(String pieceName, int col, int row)
    {
        String pieceLetter = Character.toString(pieceName.charAt(0));

        for (int i = 0; i < pieces.length; i++)
        {
            if (pieces[i] == null)
            {
                if(pieceName.equals("bishop"))
                {
                    pieces[i] = new Bishop(col, row);
                    break;
                }
                    
                else if(pieceName.equals("knight"))
                {
                    pieces[i] = new Knight(col, row);
                    break;
                }
                    
                else if(pieceName.equals("pawn"))
                {
                    pieces[i] = new Pawn(col, row);
                    break;
                }
                    
                else if(pieceName.equals("rook"))
                {
                    pieces[i] = new Rook(col, row);
                    break;
                }
                
                else if(pieceName.equals("king"))
                {
                    pieces[i] = new King(col, row);
                    break;
                }  

                else if(pieceName.equals("queen"))
                {
                    pieces[i] = new Queen(col, row);
                    break;
                }
            }
        }
        
        board[7 - row][col + 1] = "-" + pieceLetter + "-";
        System.out.println("added: " + "[" + col + "-" + row + "]" + " - "  + pieceName);
    }

    public ChessPiece findPiece (int col, int row)
    {
        for (int i = 0; i < pieces.length; i++)
        {
            if (pieces[i] == null)
            {
                break;
                // no hay
            }

            // find piece checking col and row
            if(pieces[i].getCol() == col && pieces[i].getRow() == row)
                return pieces[i];
        }

        return null;
    }

}