import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Minesweeper extends JFrame implements ActionListener, MouseListener {

    JToggleButton[][] board;
    JPanel boardPanel;
    boolean firstClick;
    int numMines;
    ImageIcon mineIcon, flagIcon;
    GraphicsEnvironment ge;
    Font mineFont;
    ImageIcon[] numbers;



    public Minesweeper(){
        firstClick = true;
        numMines = 10;
        try{
            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            mineFont = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/aravpatel/IntellijProjects/Minesweeper/src/mine-sweeper.ttf"));

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        createBoard(10, 20);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void createBoard(int row, int col){
        if(boardPanel != null){
            this.remove(boardPanel);
        }
        boardPanel = new JPanel();
        board = new JToggleButton[row][col];
        boardPanel.setLayout(new GridLayout(row, col));

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){

                board[r][c] = new JToggleButton();
                board[r][c].putClientProperty("row", r);
                board[r][c].putClientProperty("column", c);
                board[r][c].putClientProperty("state", 0); //what constitutes a mine? -1


                board[r][c].setBorder(BorderFactory.createBevelBorder(0));
                board[r][c].setFocusPainted(false);

                board[r][c].addMouseListener(this);


                boardPanel.add(board[r][c]);

            }
        }
        this.setSize(40*col, 40*row);
        this.add(boardPanel);
        this.revalidate();

    }

    public static void main(String[]args){
        Minesweeper app = new Minesweeper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        int row = (int)((JToggleButton)e.getComponent()).getClientProperty("row");
        int col = (int)((JToggleButton)e.getComponent()).getClientProperty("column");

        if(e.getButton() == MouseEvent.BUTTON1){
            if(firstClick){
                setMinesAndCounts(row, col);
                firstClick = false;
            }
        }
    }
    public void setMinesAndCounts(int currRow, int currCol){

        int count = numMines;
        int dimR = board.length;
        int dimC = board[0].length;

        while(count > 0){
            int randRow = (int)(Math.random()*dimR);
            int randCol = (int)(Math.random()*dimC);
            int state = (int)((JToggleButton)board[randRow][randCol]).getClientProperty("state");
            if(state == 0 && (Math.abs(randRow-currRow) > 1 || Math.abs(randCol - currCol) > 1)){
                board[randRow][randCol].putClientProperty("state", -1);
                count--;
            }
        }

        //comment this out when necessary
        for(int r=0; r<dimR; r++){
            for(int c=0; c<dimC; c++){

                int state = (int)((JToggleButton)board[r][c]).getClientProperty("state");
                board[r][c].setText("" + state);
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
