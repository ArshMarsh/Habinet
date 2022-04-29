package Login;

import javax.swing.JFrame;

/**
 * Frame for Login Page
 * @author Maher Athar Ilyas
 * @version 28.04.2021
*/ 
public class LoginFrame
{
	public LoginFrame(){
		
		JFrame frame = new JFrame(); 

        frame.add(new LoginPanel());
       
        frame.setSize(1280, 800);
        frame.setTitle("Login Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);	
		
	}
	
}