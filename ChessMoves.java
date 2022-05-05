import java.io.*;
import java.util.*;

public class ChessMoves {

    public static void main(String args[])throws FileNotFoundException
    {
        ChessBoard board = new ChessBoard();

        readFile(board);
        board.printBoard();
    }

    // reads files and calls functions from ChessBoard
    public static void readFile(ChessBoard board) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("input2.txt"));
        System.out.println("\nReading file...\n");

        String line;
        String[] linePart;
        boolean passedBlank = false;
        boolean firstPrint = false;

        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            linePart = line.split(" ");
            String text = linePart[0];

            int col = Integer.parseInt(linePart[1]);
            int row = Integer.parseInt(linePart[2]);

            // moving piece
            if (text.equals("move"))
            {
                if (firstPrint == false)
                {   
                    firstPrint = true;
                    board.printBoard();
                }
                    
                int newCol = Integer.parseInt(linePart[3]);
                int newRow = Integer.parseInt(linePart[4]);

                try 
                {
                    board.MovePiece(col, row, newCol, newRow);
                }
                catch (OutOfBoardException | IllegalChessMoveException ex)
                {
                    System.out.println(ex.getMessage());
                }
                
            }
            else // adding piece
            {
                board.addPiece(text, col, row); 
            }
        }
    }
}