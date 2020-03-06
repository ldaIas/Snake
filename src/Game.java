import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Game extends JFrame implements KeyListener {
	private GameBoard board;
	private boolean isRunning = true;
	JLabel label;

	private static int FPS;
	public Game() {
		board = new GameBoard();
	}

	public void initialize() {
		FPS = board.init(12, 5);
		setTitle("Snake");
		setSize(board.getLen()*20, board.getHeight()*20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
		addKeyListener(this);
	}
	
	public void run() {
		
		initialize();
		while(isRunning) {
			long time = System.currentTimeMillis();
			
			
			setTitle("Snake: " + board.getScore());
			isRunning = board.update();
			Graphics g = getGraphics();
			board.draw(g);
			
			time = (1000 / FPS) - (System.currentTimeMillis() - time);
			
			if(time > 0) {
				try {
					Thread.sleep(time);
				}
				catch(Exception e) {};
			}

		}
		setVisible(false);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP){
            //up();
        	System.out.println("up");
        }

        if (code == KeyEvent.VK_DOWN){
            //down();
        	System.out.println("down");
        }

        if (code == KeyEvent.VK_LEFT){
           // left();
        	System.out.println("left");
        }

        if (code == KeyEvent.VK_RIGHT){
            //right();
        	System.out.println("right");
        }
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP){
            board.up();
        }

        if (code == KeyEvent.VK_DOWN){
            board.down();
        }

        if (code == KeyEvent.VK_LEFT){
           board.left();
        }

        if (code == KeyEvent.VK_RIGHT){
            board.right();
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	public static void main(String[] args) {
		Game snake = new Game();
		snake.run();
		
	}
}
