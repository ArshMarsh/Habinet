package Help;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import java.awt.*;


/**
 *
 * @author Maher Athar Ilyas
 */
public class HelpPanel extends JPanel {

    private JLabel DesLabel;
    private JButton DocButton;
    private JLabel HelpLabel;
    private JButton PreviousPageButton;

    /**
     * Creates new form HelpPanel
     */
    public HelpPanel() {
        initComponents();
    }

                         
    private void initComponents() {

        HelpLabel = new JLabel();
        PreviousPageButton = new JButton();
        DocButton = new JButton();
        DesLabel = new JLabel();


        setBackground(Color.WHITE);
        setPreferredSize(new java.awt.Dimension(962, 800));

        HelpLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        HelpLabel.setText("Help");

        PreviousPageButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PreviousPageButton.setText("<--   Home");

        DocButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DocButton.setText("Go to Documentation");
        DocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPDF();
            }
        });

        DesLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DesLabel.setText("For more information regarding Habinet click on the button below");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(PreviousPageButton)
                        .addGap(257, 257, 257)
                        .addComponent(HelpLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(DesLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(DocButton)))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(HelpLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(PreviousPageButton)))
                .addGap(211, 211, 211)
                .addComponent(DesLabel)
                .addGap(44, 44, 44)
                .addComponent(DocButton)
                .addContainerGap(394, Short.MAX_VALUE))
        );

        
        PreviousPageButton.setBackground(Color.WHITE);
        PreviousPageButton.setForeground(Color.WHITE);
        PreviousPageButton.setBorderPainted(false);
    }                     


    
    
    public static void openPDF(){
        
        if (Desktop.isDesktopSupported()) {
            try {
                String basePath = new File("").getAbsolutePath();
                System.out.println(basePath);
            
                String path = new File("src/Source_Code/PDF/help.pdf").getAbsolutePath();
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
        
    }
                 
}

