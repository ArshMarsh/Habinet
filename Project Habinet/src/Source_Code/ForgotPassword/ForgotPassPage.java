package ForgotPassword;

import javax.swing.*;

/**
 * @author Maher Athar Ilyas
 */
public class ForgotPassPage extends JFrame {
    // Properties

    // Constructors
    public ForgotPassPage() {
        JFrame frame = new JFrame();

        frame.add(new ForgotPanel());

        frame.setSize(1280, 800);
        frame.setTitle("Forgot Password Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // Methods

}