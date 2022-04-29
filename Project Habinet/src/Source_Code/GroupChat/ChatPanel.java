package GroupChat;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import Classes.*;

/**
 *
 * @author Maher Athar Ilyas
 */
public class ChatPanel extends JPanel {

    // private Group group;
    private User user;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel uploadLabel;
    private JLabel sendLabel;
    private JPanel jPanel1;
    private JPanel messagePanel;
    private JScrollPane jScrollPane1;
    private JTextField messageField;
    private JTextArea chatArea;
    private int groupID;

    /**
     * Creates new form GroupChat
     */
    public ChatPanel(Group group, User user) {
        groupID = group.getGroupID();
        this.user = user;
        initComponents();

    }

    /**
     * s for display test only
     * 
     * @param group
     * @param user
     */
    public ChatPanel(int groupID, User user) {
        this.groupID = groupID;
        this.user = user;
        initComponents();

    }

    private void initComponents() {

        chatArea = new JTextArea();
        jPanel1 = new JPanel();
        messagePanel = new RoundPanel();
        sendLabel = new JLabel();
        messageField = new ChatTextField("Type your message here") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        uploadLabel = new JLabel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane(chatArea);

        chatArea.setEditable(false);

        chatArea.setFont(new java.awt.Font("Segoe UI", 0, 14));

        messagePanel.setBackground(Color.WHITE);

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(918, 800));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(918, 150));

        messagePanel.setBackground(java.awt.Color.lightGray);
        messagePanel.setPreferredSize(new java.awt.Dimension(737, 69));

        sendLabel.setIcon(new ImageIcon(getClass().getResource("/Images/send.png")));

        messageField.setBackground(java.awt.Color.lightGray);
        messageField.setPreferredSize(new java.awt.Dimension(148, 22));

        GroupLayout messagePanelLayout = new GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        messagePanelLayout.createSequentialGroup().addGap(33, 33, 33)
                                .addComponent(messageField, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                                .addGap(18, 18, 18).addComponent(sendLabel).addGap(21, 21, 21)));
        messagePanelLayout.setVerticalGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(messagePanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(messagePanelLayout.createSequentialGroup().addComponent(sendLabel).addGap(0,
                                        0, Short.MAX_VALUE))
                                .addComponent(messageField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));

        uploadLabel.setIcon(new ImageIcon(getClass().getResource("/Images/upload.png")));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(78, 78, 78)
                        .addComponent(messagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27).addComponent(uploadLabel)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(28, 28, 28).addGroup(jPanel1Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(messagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(uploadLabel)))
                        .addContainerGap(53, Short.MAX_VALUE)));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Group Chat");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("<--  Groups");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(jButton1)
                                        .addGap(249, 249, 249).addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup().addGap(61, 61, 61).addComponent(jScrollPane1,
                                        GroupLayout.PREFERRED_SIZE, 845, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(80, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel1)
                                .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

        chatArea.append("  \n ");

        chatArea.append(DB.getMessages(groupID));

        sendLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                if (!messageField.getText().equals("Type your message here")) {

                    Message newMessage = new Message(user, messageField.getText(), null);

                    DB.addMessagetoDB(newMessage, groupID);

                    String n = " \n *" + (user.getUsername()).toUpperCase() + "* : ";
                    n += messageField.getText();
                    n += " \n";

                    chatArea.append(n);

                    messageField.setText("");

                    update();
                }
            }
        });

    }

    public void update() {
        repaint();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        frame.getContentPane().revalidate();
        frame.getContentPane().setVisible(true);
    }
}
