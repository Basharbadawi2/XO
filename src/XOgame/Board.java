package XOgame;

import javax.sound.midi.SysexMessage;

public class Board {
    char[] board = new char[] {'0','1','2','3','4','5','6','7','8','9'};
        void Draw() {
            System.out.println(board[0] + "  " + board[1] + "  " + board[2] + '\n');
            System.out.println(board[3] + "  " + board[4] + "  " + board[5] + '\n');
            System.out.println(board[6] + "  " + board[7] + "  " + board[8] + '\n');
        }
        boolean isBusy(int index )
        {
            return (board[index]=='x'||board[index]=='o');
        }
        void Insert(int index , char Sign)
        {
            if(isBusy(index)) {
                System.out.println("Busy!");
                return;
            }
            board[index]=Sign;
        }
        boolean IsWin()
        {
            if (    board[1]==board[2]&&board[2]==board[3]||
                    board[4]==board[5]&&board[5]==board[8]||
                    board[7]==board[8]&&board[8]==board[9]||
                    board[1]==board[4]&&board[4]==board[7]||
                    board[2]==board[5]&&board[5]==board[8]||
                    board[3]==board[6]&&board[6]==board[9]||
                    board[3]==board[5]&&board[5]==board[7]||
                    board[1]==board[5]&&board[5]==board[9]
            ) {
            return true;
            }
            return  false;
        }
        boolean IsFull()
        {
            for(int i=0; i<=9; i++)
            {
                if(!isBusy(i))
                {
                    return  false;
                }
            }
            return true;
        }
        boolean IsDraw()
        {
            return (IsFull()&&!IsWin());
        }

}
