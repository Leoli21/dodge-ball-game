import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/***
 * 
 * @author Leo Li
 * Dodge Ball Game
 *
 */
public class DodgeBallFrame extends JFrame implements ActionListener
{
	private ArrayList<Ball> player1Balls;
	private ArrayList<Ball> player2Balls;
	private StickFigure player1;
	private StickFigure player2;
	private Timer t;
	public DodgeBallFrame()
	{
		player1Balls = new ArrayList<Ball>();
		player2Balls = new ArrayList<Ball>();
		this.setBounds(100,100,600,400);
		this.setLayout(null);
		this.setTitle("Dodge Ball Game");
				
		player1 = new StickFigure(50,200);
		player2 = new StickFigure(350,200);
		add(player1);
		add(player2);
		
		t = new Timer(25,this);
		t.start();
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				//Movement
				if(e.getKeyCode() == e.VK_A)
				{
					if(player1.getX() < 0)
						player1.setDx(0);
					player1.setDx(-5);
				}
				else if(e.getKeyCode() == e.VK_D)
				{
					if(player1.getX()+player1.getWidth() > getWidth()-getInsets().right-getInsets().left)
						player1.setDx(0);
					player1.setDx(5);
				}
				else if(e.getKeyCode() == e.VK_W)
				{
					if(player1.getY() < 0)
						player1.setDy(0);
					player1.setDy(-5);
				}
				else if(e.getKeyCode() == e.VK_S)
				{
					if(player1.getY()+player1.getHeight() > getHeight()-getInsets().top-getInsets().bottom)
						player1.setDy(0);
					player1.setDy(5);
				}
				//Throwing Ball
				else if(e.getKeyCode() == e.VK_E)
				{
					if(player1Balls.size() < 3)
					{	
						Ball p1Ball = new Ball(player1.getX()+player1.getWidth(), player1.getY() + player1.getHeight()/4);
						p1Ball.setDx(5);
						player1Balls.add(p1Ball);
						add(p1Ball);
					}
					else
					{
						remove(player1Balls.get(0));
						player1Balls.remove(0);		
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_A)
					player1.setDx(0);
				else if(e.getKeyCode() == e.VK_D)
					player1.setDx(0);
				else if(e.getKeyCode() == e.VK_W)
					player1.setDy(0);
				else if(e.getKeyCode() == e.VK_S)
					player1.setDy(0);
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_LEFT)
				{
					if(player2.getX() < 0)
						player2.setDx(0);
					player2.setDx(-5);
				}
				else if(e.getKeyCode() == e.VK_RIGHT)
				{
					if(player2.getX()+player2.getWidth() > getWidth()-getInsets().right-getInsets().left)
						player2.setDx(0);
					player2.setDx(5);
				}
				else if(e.getKeyCode() == e.VK_UP)
				{
					if(player2.getY() < 0)
						player2.setDy(0);
					player2.setDy(-5);
				}
				else if(e.getKeyCode() == e.VK_DOWN)
				{
					if(player2.getY()+player2.getHeight() > getHeight()-getInsets().top-getInsets().bottom)
						player2.setDy(0);
					player2.setDy(5);
				}
				//Throwing Ball
				else if(e.getKeyCode() == e.VK_NUMPAD0)
				{
					if(player2Balls.size() < 3)
					{							
						Ball p2Ball = new Ball(player2.getX(), player2.getY() + player2.getHeight()/4);
						p2Ball.setDx(-5);
						player2Balls.add(p2Ball);
						add(p2Ball);
					}
					else
					{
						remove(player2Balls.get(0));
						player2Balls.remove(0);
		
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_LEFT)
					player2.setDx(0);
				else if(e.getKeyCode() == e.VK_RIGHT)
					player2.setDx(0);
				else if(e.getKeyCode() == e.VK_UP)
					player2.setDy(0);
				else if(e.getKeyCode() == e.VK_DOWN)
					player2.setDy(0);
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{
		new DodgeBallFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Insets insets = this.getInsets();
		if(player1.getX() < 0)
			player1.setLocation(1,player1.getY());
		
		else if(player1.getX()+player1.getWidth() > getWidth()-getInsets().right-getInsets().left)
			player1.setLocation(getWidth()-getInsets().right-getInsets().left-player1.getWidth(),player1.getY());
		
		else if(player1.getY() < 0)
			player1.setLocation(player1.getX(), 1);	
		
		else if(player1.getY()+player1.getHeight() > getHeight()-getInsets().top-getInsets().bottom)
			player1.setLocation(player1.getX(), getHeight()-getInsets().top-getInsets().bottom-player1.getHeight());
		player1.update();
		
		if(player2.getX() < 0)
			player2.setLocation(1,player2.getY());
		
		else if(player2.getX()+player2.getWidth() > getWidth()-getInsets().right-getInsets().left)
			player2.setLocation(getWidth()-getInsets().right-getInsets().left-player2.getWidth(),player2.getY());
		
		else if(player2.getY() < 0)
			player2.setLocation(player2.getX(), 1);	
		
		else if(player2.getY()+player2.getHeight() > getHeight()-getInsets().top-getInsets().bottom)
			player2.setLocation(player2.getX(), getHeight()-getInsets().top-getInsets().bottom-player2.getHeight());
		player2.update();
		
		for(int i = 0; i < player1Balls.size(); i++)
		{
			Ball p1Ball = player1Balls.get(i);
			repaint();
			p1Ball.update();
			if(ball1Collision(i))
			{
				JOptionPane.showMessageDialog(this,"GAME OVER\nPlayer 1 Wins!");
				remove(p1Ball);
				t.stop();
				this.dispose();
				break;
			}	
			if(p1Ball.getX() < 0)
			{
				remove(p1Ball);
			}
			else if(p1Ball.getX() + p1Ball .getWidth() > this.getWidth()-insets.right-insets.left)
			{
				remove(p1Ball);
			}
			else if(p1Ball.getY() < 0)
			{
				remove(p1Ball);
			}
			else if(p1Ball.getY() + p1Ball.getHeight() > this.getHeight()-insets.top-insets.bottom)
			{
				remove(p1Ball);
			}
		}
		
		for(int i = 0; i < player2Balls.size();i ++)
		{
			repaint();
			Ball p2Ball = player2Balls.get(i);
			p2Ball.update();
			if(ball2Collision(i))
			{
				JOptionPane.showMessageDialog(this,"GAME OVER\nPlayer 2 Wins!");
				System.out.println("Work");
				remove(p2Ball);
				t.stop();
				this.dispose();
				break;
			}
			if(p2Ball.getX() < 0)
			{
				remove(p2Ball);
			}
			else if(p2Ball.getX() + p2Ball .getWidth() > this.getWidth()-insets.right-insets.left)
			{
				remove(p2Ball);
			}
			else if(p2Ball.getY() < 0)
			{
				remove(p2Ball);
			} 
			else if(p2Ball.getY() + p2Ball.getHeight() > this.getHeight()-insets.top-insets.bottom)
			{
				remove(p2Ball);
			}
		}
	}
	
	public boolean ball1Collision(int ball1Index)
	{
		Rectangle player2Rectangle = player2.getBounds();
		Rectangle player1BallRectangle = player1Balls.get(ball1Index).getBounds();
		
		if(player1BallRectangle.intersects(player2Rectangle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean ball2Collision(int ball2Index)
	{
		Rectangle player1Rectangle = player1.getBounds();
		Rectangle player2BallRectangle = player2Balls.get(ball2Index).getBounds();
		
		if(player2BallRectangle.intersects(player1Rectangle))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
