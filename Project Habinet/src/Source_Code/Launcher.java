import javax.swing.JFrame;
import Login.*;

/**
 * Launches the Application
 * @author Maher Athar Ilyas
 * @version 28.04.2021
*/ 
public class Launcher
{
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame(); 

        frame.add(new LoginPanel());
       
        frame.setSize(1280, 800);
        frame.setTitle("Welcome to Habinet : Social Media of Productivity");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);	
		
	}
	
}