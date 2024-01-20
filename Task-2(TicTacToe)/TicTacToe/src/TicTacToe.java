import java.awt.*;
import java.awt.event.*;
import java.io.StringReader;

import javax.swing.*;


public class TicTacToe {
  int boardWidth=600;
  int boardHeight=650; // extra 50 for displaying the message on top
  
  JFrame frame=new JFrame("Tic-Tac-Toe");
  JLabel textLabel=new JLabel();
  JPanel textPanel=new JPanel();
  JPanel boardPanel=new JPanel();

  JButton[][] board=new JButton[3][3];
  String playerX="X";
  String playerO="O";
  String currentPlayer=playerX;

  boolean gameOver=false;
  int turns= 0;
   int winner = -1;
   int playerXwins=0, playerOwins=0;

  TicTacToe(){
    frame.setVisible(true);
    frame.setSize(boardWidth,boardHeight);

    frame.setResizable(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    textLabel.setBackground(Color.darkGray);
    textLabel.setForeground(Color.white);
    textLabel.setFont(new Font("Arial",  Font.BOLD,  50));
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    textLabel.setText("Tic-Tac-Toe");
    textLabel.setOpaque(true);

    textPanel.setLayout(new BorderLayout());
    textPanel.add(textLabel);
    frame.add(textPanel,BorderLayout.NORTH);

    boardPanel.setLayout(new GridLayout(3,3));
    boardPanel.setBackground(Color.pink);
    frame.add(boardPanel);
  
    
    for(int i=0;i<3;i++)  //3 rows
    {
        for(int j=0;j<3;j++) //3 columns
        {
            JButton tile=new JButton();
           // tile = new JButton("Play Again?"); 
            board[i][j]=tile;
            boardPanel.add(tile);

            tile.setBackground(Color.darkGray);
            tile.setForeground(Color.white);
            tile.setFont(new Font("Arial", Font.BOLD,100));
            tile.setFocusable(false);
            
            tile.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                JButton tile=(JButton)e.getSource();
                if(tile.getText() == "")
                {
                      tile.setText(currentPlayer);
                      turns++;

                      checkWinner();
                      if(!gameOver){
                          currentPlayer= currentPlayer == playerX? playerO : playerX;
                          textLabel.setText(currentPlayer + "'s turn");
                      }
                }
                //resetGame();
                
              }
            });
        }
    }

  }

  void checkWinner()
  {
    //horizontal checking for winner
      for(int r=0;r<3;r++)
      {
        if(board[r][0].getText() == "") continue;

        if(board[r][0].getText() == board[r][1].getText() && 
        board[r][1].getText() == board[r][2].getText()) {
          for(int c=0;c<3;c++)
          {
            setWinner(board[r][c]);
          }
          gameOver = true;
          return;
        }
      }
    //vertical checking for winner
      for(int c=0;c<3;c++)
      {
        if(board[0][c].getText() == "") continue;

        if(board[0][c].getText() == board[1][c].getText() &&
           board[1][c].getText() == board[2][c].getText()) {
            for(int r=0;r<3;r++)
            {
              setWinner(board[r][c]);
            }
            gameOver = true;
            return;
           }
      }
    //Diagonal topleft checking for winner
      if(board[0][0].getText() == board[1][1].getText() &&
         board[1][1].getText() == board[2][2].getText() &&
         board[0][0].getText() != "") {
          for(int i=0;i<3;i++)
          {
            setWinner(board[i][i]);
          }
          gameOver = true;
          return;
         }
    //Diagonal topright checking for winner
      if(board[0][2].getText() == board[1][1].getText() &&
         board[1][1].getText() == board[2][0].getText() &&
         board[0][2].getText() != "") {
          setWinner(board[0][2]);
          setWinner(board[1][1]);
          setWinner(board[2][0]);
          gameOver = true;
          return;
         }

         if(turns==9)
         {
          for(int i=0;i<3;i++)
          {
            for(int j=0;j<3;j++)
            {
                setTie(board[i][j]);
            }
          }
          gameOver = true;
         }
  }

  void setWinner(JButton tile) {
      tile.setForeground(Color.blue.darker());
      tile.setBackground(Color.pink);
      textLabel.setText(currentPlayer + " is the winner!!");
  }

  void setTie(JButton tile) {
      tile.setForeground(Color.orange);
      tile.setBackground(Color.gray.darker());
      textLabel.setText("Tie");  
  }

  // public void resetGame() {
	// 	playerX = "X";
	// 	winner = -1;
	// 	gameOver = false;
	// 	for (int i = 0; i < 3; i++) {
	// 		for (int j = 0; j < 3; j++) {
	// 			 // all spots are empty
	// 		}
	// 	}
	// 	getJButton().setVisible(false);
	// }

  // public JButton getJButton(){
  //   return null;
  // }
}
