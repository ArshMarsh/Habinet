/**
 * A simple Java class!
*/

package ForgotPassword;

import javax.swing.*;

import GroupChat.RoundPanel;
import Login.HintTextField;
import Login.LoginFrame;

/**
 *
 * @author Maher Athar Ilyas
 */
public class ForgotPassForm extends RoundPanel {

    private JTextField EmailField;
    private JLabel EmailLabel;
    private JButton ForgotButton;
    private JLabel Title;
    private JLabel UserNameLabel;

    /**
     * Creates new form ForgotPassForm
     */
    public ForgotPassForm() {
        initComponents();
    }

    private void initComponents() {

        Title = new JLabel();
        UserNameLabel = new JLabel();
        EmailLabel = new JLabel();
        EmailField = new HintTextField("Email / Username");
        ForgotButton = new JButton();

        setPreferredSize(new java.awt.Dimension(460, 200));

        Title.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        Title.setText("Forgot Password");

        UserNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        UserNameLabel.setText("Enter Username / ");

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        EmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        EmailLabel.setText("Email");

        EmailField.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        EmailField.setHorizontalAlignment(JTextField.CENTER);

        ForgotButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ForgotButton.setText("Send Password Reset Link");
        ForgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(Title).addGap(132,
                                132, 132))
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(ForgotButton, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addGap(33, 33, 33).addComponent(EmailLabel)
                                                .addGap(42, 42, 42))
                                .addComponent(UserNameLabel))
                        .addGap(28, 28, 28)
                        .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap().addComponent(Title)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addComponent(EmailField,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup().addGap(41, 41, 41).addComponent(UserNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(EmailLabel)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ForgotButton).addContainerGap()));
    }

    private void ForgotButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();

        new LoginFrame();

        JOptionPane.showMessageDialog(null, "To be Implemented");
    }

}
