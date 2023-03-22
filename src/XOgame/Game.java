package XOgame;

import javax.lang.model.element.Name;
import java.util.Scanner;

public class Game {
    Board board = new Board();
    player player1 = new player(), player2=new player();
    Scanner scanner = new Scanner(System.in);
    void SetData()
    {
        System.out.println("Please enter Player 1 Name: ");
        player1.Name=scanner.next();
        System.out.println("Please enter player 1 sign: ");
        player1.Sign=scanner.next().charAt(0);
        System.out.println("Please enter Player 2 Name: ");
        player2.Name=scanner.next();
        player2.Sign=(player1.Sign=='x')?'o':'x';
    }
   public  void play()
    {
        int index,SetDataFlag=1;
        char flag='y';
        while (flag=='y'||flag=='Y')
        {
            board.Draw();
            if(SetDataFlag==1)
            {
                SetData();
            }
            SetDataFlag=0;
            //player1 turns start
            System.out.println("Player 1 turn : ");
            index=scanner.nextInt();
            board.Insert(index, player1.Sign);
            board.Draw();
            //check draw or win
            if(board.IsDraw())
            {
                System.out.println("Draw!");
                System.out.println("Do you want to play again ?");
                flag=scanner.next().charAt(0);
                SetDataFlag=1;
                continue;
            }
            else if(board.IsWin())
            {
                System.out.println("Player1 won!");
                System.out.println("Do you want to play again ?");
                flag=scanner.next().charAt(0);
                SetDataFlag=1;
                continue;
            }
            //player 2 turns start
            System.out.println("Player 2 turn : ");
            index=scanner.nextInt();
            board.Insert(index, player2.Sign);
            if(board.IsDraw())
            {
                System.out.println("Draw!");
                System.out.println("Do you want to play again ?");
                flag=scanner.next().charAt(0);
                SetDataFlag=1;
            } else if (board.IsWin()) {
                System.out.println("player2 won !");
                System.out.println("Do you want to play again ?");
                flag=scanner.next().charAt(0);
                SetDataFlag=1;
            }
        }
    }
}
