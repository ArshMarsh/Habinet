package Tasks;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Classes.*;

public class ImageUploadPanel extends JPanel {
    private javax.swing.JLabel TaskImageUploadTitle;
    private javax.swing.JLabel imageField;
    private javax.swing.JButton imageUploadButton;
    private javax.swing.JButton previousPageButton;
    String fileName = null;
    byte[] photo = null;
    private javax.swing.JButton submitButton;
    int userID = 420;
    int taskSerialNumber = 4;
    File f;
    FileInputStream fileInputStream;

    public ImageUploadPanel(User user, int taskSerialNumberin) {
        this.userID = user.getProfileID();
        this.taskSerialNumber = taskSerialNumberin;
        initComponents();
    }

    public ImageUploadPanel() {
        initComponents();
    }

    private void imageUploadButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // File f = DB.getTaskVerificationImageLocation(420, 3);
        // ImageIcon image = DB.getTaskVerificationImageLocation(420, 3);
        // imageField.setIcon(image);

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();

        fileName = f.getAbsolutePath();
        try {
            imageField.setIcon(new ImageIcon(f.toString()));
            fileInputStream = new FileInputStream(f);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DB.changeTaskVerificationImageLocation(userID, taskSerialNumber, f, fileInputStream);
        imageField.setIcon(null);
        JOptionPane.showMessageDialog(null, "Image Submitted for Review");
    }

    private void initComponents() {

        previousPageButton = new javax.swing.JButton();
        TaskImageUploadTitle = new javax.swing.JLabel();
        imageUploadButton = new javax.swing.JButton();
        imageField = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(962, 800));
        setPreferredSize(new java.awt.Dimension(962, 800));

        previousPageButton.setText("<-- Go Back");

        TaskImageUploadTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        TaskImageUploadTitle.setText("Task Image Upload");

        imageUploadButton.setText("Upload Image");
        imageUploadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageUploadButtonMouseClicked(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(87, 87, 87)
                                        .addComponent(previousPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118).addComponent(TaskImageUploadTitle,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 325,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup().addGap(70, 70, 70).addComponent(imageField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 838,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(54, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(imageUploadButton, javax.swing.GroupLayout.DEFAULT_SIZE, 155,
                                                Short.MAX_VALUE))
                                .addGap(367, 367, 367)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(previousPageButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addComponent(TaskImageUploadTitle,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 427,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(imageUploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18).addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)));

    }

}