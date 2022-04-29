package ForgotPassword;

import javax.swing.*;

import java.awt.*;

/**
 * 
 * @author Maher Athar Ilyas
 */
public class ForgotPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ForgotPassForm form;

    public ForgotPanel() {

        components();

    }

    public void components() {

        form = new ForgotPassForm();

        // hgap = frameH / 2 - formH /2
        // vgap = frameV / 2 - formV /2 - 30
        // Centers the form
        setLayout(new FlowLayout(0, 410, 290));

        add(form);

    }

    protected void paintComponent(Graphics g) {
        // Paints the Gradient
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Color color1 = new Color(221,36,118);
        // Color color2 = new Color(255,81,47);

        Color color1 = new Color(91, 134, 229);
        Color color2 = new Color(54, 209, 220);

        // Color color1 = new Color(82,84,172);
        // Color color2 = new Color(229,150,137);

        GradientPaint gp = new GradientPaint(0, 0, color2, width, 100, color1);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

    }
}