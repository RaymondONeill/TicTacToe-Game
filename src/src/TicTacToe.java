import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        // ^^^^ this sets the frame and the borders of the game ^^^^
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.orange);
        textField.setFont(new Font("Ink Free", Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);
        // ^^^ this is everything for the text that we will need for this game. ^^^
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        // ^^^ this is the title panel that will display "Tic-Tac-Toe" ^^^
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.WHITE);
        frame.add(button_panel);
        for(int i =0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        // ^^^ this is the grid layout for the game we have a for loop to fill and resize the grid ^^^
        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 9; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O's turn.");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X's turn.");
                        check();
                }}
            }
        }
        // ^^^ this is the actual function that lets the game be played. sadly there is no computer option yet so far. ^^^
    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch(InterruptedException k) {
            k.printStackTrace();
        }
        // ^^^ added a 2-second delay before assigning a turn. ^^^

        if(random.nextInt(2) == 0){
            player1_turn = true;
            textField.setText("X turn.");
        }
        else { player1_turn = false;
            textField.setText("O turn.");
        }
        // ^^^ this is the function to assign the turn to X or O. ^^^
    }

    public void check(){
        // checks if x wins

        if((buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        // checks if o wins

        if((buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((buttons[1].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }

        // ^^^ this entire function checks the board and looks for the winning 3. ^^^

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins.");
        // ^^^ this sets the buttons to green and shows the winner. ^^^
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins.");
        // ^^^ this sets the buttons to green and shows the winner. ^^^
    }


}
