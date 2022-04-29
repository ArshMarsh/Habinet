package Settings;

import javax.swing.*;

import Classes.DB;
import Classes.User;

import java.awt.*;

/**
 * Settings Panel
 * @author Maher Athar Ilyas
 */
public class SettingsPanel extends JPanel {

    private JToggleButton BackButton;
    private JRadioButton Carefree;
    private JLabel ChangLabel;
    private JButton DisableNotificationButton;
    private JLabel EmailLabel;
    private JButton EnableNotificationButton;
    private JRadioButton Medium;
    private JLabel ModeLabel;
    private JLabel NotificationLabel;
    private JLabel PasswordLabel;
    private JLabel SettingsTitle;
    private JRadioButton Strict;
    private JButton emailButton;
    private JButton passwordButton;
    private User user;
    private ButtonGroup ModeButtons;

    /**
     * Creates new form SettingsPanel
     */
    public SettingsPanel(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {

        ModeButtons = new ButtonGroup();
        SettingsTitle = new JLabel();
        BackButton = new JToggleButton();
        NotificationLabel = new JLabel();
        ChangLabel = new JLabel();
        PasswordLabel = new JLabel();
        EmailLabel = new JLabel();
        ModeLabel = new JLabel();
        EnableNotificationButton = new JButton();
        DisableNotificationButton = new JButton();
        Strict = new JRadioButton();
        Medium = new JRadioButton();
        Carefree = new JRadioButton();
        passwordButton = new JButton();
        emailButton = new JButton();

        setBackground(Color.WHITE);
        Strict.setBackground(Color.WHITE);
        Medium.setBackground(Color.WHITE);
        Carefree.setBackground(Color.WHITE);

        setPreferredSize(new Dimension(962, 800));

        SettingsTitle.setFont(new Font("Segoe UI Semibold", 0, 36)); // NOI18N
        SettingsTitle.setText("Settings");

        BackButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        BackButton.setText("<--  Home");

        ModeButtons.add(Strict);
        ModeButtons.add(Medium);
        ModeButtons.add(Carefree);

        NotificationLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NotificationLabel.setText("Notifications");

        ChangLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ChangLabel.setText("Change");

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PasswordLabel.setText("Change Password");

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EmailLabel.setText("Change Email");

        ModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ModeLabel.setText("App Mode");

        EnableNotificationButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EnableNotificationButton.setText("Enable");
        EnableNotificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user.changeNotif(true);
            }
        });

        DisableNotificationButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DisableNotificationButton.setText("Disable");
        EnableNotificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user.changeNotif(false);
            }
        });

        Strict.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Strict.setText("Strict");
        Strict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeChange(evt);
            }
        });

        Medium.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Medium.setText("Medium");
        Medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeChange(evt);
            }
        });

        Carefree.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Carefree.setText("Carefree");
        Carefree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeChange(evt);
            }
        });

        passwordButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordButton.setText("Send Password Reset Link");

        emailButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailButton.setText("Send Email Reset Link");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(BackButton)
                                        .addGap(213, 213, 213).addComponent(SettingsTitle, GroupLayout.PREFERRED_SIZE,
                                                156, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup().addGap(237, 237, 237)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(NotificationLabel)
                                                .addGroup(layout
                                                        .createSequentialGroup().addGroup(layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(PasswordLabel).addComponent(EmailLabel)
                                                                .addGroup(layout
                                                                        .createParallelGroup(
                                                                                GroupLayout.Alignment.CENTER)
                                                                        .addComponent(ChangLabel)
                                                                        .addComponent(ModeLabel)))
                                                        .addGap(65, 65, 65)
                                                        .addGroup(layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(Carefree).addComponent(Medium)
                                                                .addComponent(Strict).addComponent(emailButton)
                                                                .addComponent(passwordButton)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(EnableNotificationButton)
                                                                        .addGap(33, 33, 33)
                                                                        .addComponent(DisableNotificationButton)))))))
                        .addContainerGap(274, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(SettingsTitle)
                        .addComponent(BackButton))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(NotificationLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(EnableNotificationButton).addComponent(DisableNotificationButton)))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addComponent(ChangLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(ModeLabel))
                        .addGroup(layout.createSequentialGroup().addComponent(Strict).addGap(16, 16, 16)
                                .addComponent(Medium).addGap(18, 18, 18).addComponent(Carefree)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(passwordButton)
                        .addComponent(PasswordLabel))
                .addGap(63, 63, 63).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(EmailLabel).addComponent(emailButton))
                .addContainerGap(192, Short.MAX_VALUE)));

        // BackButton.setVisible(false);
        BackButton.setBackground(Color.WHITE);
        BackButton.setForeground(Color.WHITE);
        BackButton.setBorderPainted(false);
    }

    /**
     * Changes mode of User
     */
    private void modeChange(java.awt.event.ActionEvent evt) {

        if (Strict.isSelected()) {
            DB.changeValue("STRICT", user.getProfileID(), "mode");
           
        } else if (Medium.isSelected()) {
            DB.changeValue("MEDIUM", user.getProfileID(), "mode");
           
        } else {
            DB.changeValue("CAREFREE", user.getProfileID(), "mode");
            
        }
    }

}
