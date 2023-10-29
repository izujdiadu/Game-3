import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Game implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons =  new JButton[9];
	boolean player1_turn;
	
	
	Game(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(67,80,120));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);

		
		
		textfield.setBackground(Color.RED);
		textfield.setForeground(Color.CYAN);
		textfield.setFont(new Font("Ink Free", Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,600,100);
		
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.gray);
		
		for (int i = 0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.red);
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("Saitama turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.GREEN);
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("Goku turn");
						check();
					}
				}
			}
		}
		
	}

	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("Goku turn");
		}
		else {
			player1_turn = false;
			textfield.setText("Saitama turn");
		}
	}
	
	public void check() {
		
		
		if((buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X")) {
			Goku(0,1,2);
		}
		if((buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X")) {
			Goku(3,4,5);
		}
		if((buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X")) {
			Goku(6,7,8);
		}
		if((buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X")) {
			Goku(0,3,6);
		}
		if((buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X")) {
			Goku(1,4,7);
		}
		if((buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X")) {
			Goku(2,5,8);
		}
		if((buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X")) {
			Goku(0,4,8);
		}
		if((buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X")) {
			Goku(2,4,6);
		}
		
		
		
		
		if((buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O")) {
			Saitama(0,1,2);
		}
		if((buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O")) {
			Saitama(3,4,5);
		}
		if((buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O")) {
			Saitama(6,7,8);
		}
		if((buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O")) {
			Saitama(0,3,6);
		}
		if((buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O")) {
			Saitama(1,4,7);
		}
		if((buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O")) {
			Saitama(2,5,8);
		}
		if((buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O")) {
			Saitama(0,4,8);
		}
		if((buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O")) {
			Saitama(2,4,6);
		}
		
		
				
	}
	
	public void Goku(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textfield.setText("Goku solo");
	}
	
	public void Saitama(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textfield.setText("Saitama solo");
	}
}
