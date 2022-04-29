package Register;
import javax.swing.*;

import java.awt.*;
/**
 * @author Maher Athar Ilyas
 */
public class RegisterPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    private RegisterForm form ;

    public RegisterPanel(){       

        components();
        
    }

    public void components(){

        form =  new RegisterForm();   
        
        //hgap = frameH / 2 - formH /2
        //vgap = frameV / 2 - formV /2 - 30

        // Centers the form
        setLayout(new FlowLayout(0, 410 , 190));
       
        add(form);

   }


    protected void paintComponent(Graphics g) {
        //Paints the Gradient
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height =  getHeight();
        
        Color color1 = new Color(91, 134, 229);
        Color color2 = new Color(54, 209, 220);
        
        GradientPaint gp = new GradientPaint (0,0, color2, width, 100, color1);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        
    }
}