package profile;

import javax.swing.*;
import Classes.User;

/**
 *
 * @author AmirrezaKhoshbakht
 */
public class profile extends javax.swing.JPanel {
        // TEST DELETE FROM FINAL CODE
        User user;

        /**
         * Creates new form profile
         */
        public profile(User user) {
                this.user = user;
                initComponents();
        }

        private void initComponents() {

                headerPanel = new javax.swing.JPanel();
                goBackButton = new javax.swing.JButton();
                profileLabel = new javax.swing.JLabel();
                infoPanel = new javax.swing.JPanel();
                picture = new javax.swing.JButton();
                editProf = new javax.swing.JButton();
                share = new javax.swing.JButton();
                userLabel = new javax.swing.JLabel();
                username = new javax.swing.JTextField();
                mailLabel = new javax.swing.JLabel();
                email = new javax.swing.JTextField();
                streakLabel = new javax.swing.JLabel();
                freezeLabel = new javax.swing.JLabel();
                jProgressBar1 = new javax.swing.JProgressBar();
                streak = new javax.swing.JLabel();
                freeze = new javax.swing.JLabel();
                AchievePanel = new javax.swing.JPanel();
                achieveLabel = new javax.swing.JLabel();
                badges = new javax.swing.JLabel();
                groupsPanel = new javax.swing.JPanel();
                groupsLabel = new javax.swing.JLabel();
                groupA = new javax.swing.JLabel();
                groupB = new javax.swing.JLabel();
                groupC = new javax.swing.JLabel();

                goBackButton.setText("< Home");
                goBackButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                profileLabel.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
                profileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                profileLabel.setText("Profile");

                javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
                headerPanel.setLayout(headerPanelLayout);
                headerPanelLayout.setHorizontalGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(173, 173, 173)
                                                .addComponent(profileLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(295, 295, 295)));
                headerPanelLayout.setVerticalGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup().addGroup(headerPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(goBackButton).addComponent(profileLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 17, Short.MAX_VALUE)));

                infoPanel.setBackground(new java.awt.Color(204, 198, 198));

                picture.setPreferredSize(new java.awt.Dimension(97, 97));
                picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rank_1.png")));
                picture.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                pictureActionPerformed(evt);
                        }
                });

                editProf.setText("Edit Profile");
                editProf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                editProf.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                editProfActionPerformed(evt);
                        }
                });

                share.setText("Share");
                share.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                userLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
                userLabel.setText("Username");

                username.setEditable(false);
                username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                username.setText(user.getUsername());
                username.setBorder(null);
                username.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                usernameActionPerformed(evt);
                        }
                });
                username.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                usernameKeyPressed(evt);
                        }
                });

                mailLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
                mailLabel.setText("Email");

                email.setEditable(false);
                email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                email.setText(user.getEmail());
                email.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                emailActionPerformed(evt);
                        }
                });
                email.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                emailKeyPressed(evt);
                        }
                });

                streakLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
                streakLabel.setText("Daily Streak and StreakFreeze Count");

                freezeLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
                freezeLabel.setText("User Expereince");

                jProgressBar1.setBackground(new java.awt.Color(0, 0, 0));
                jProgressBar1.setForeground(new java.awt.Color(173, 93, 253));
                jProgressBar1.setValue(20);
                if(user.xp>100){
                        jProgressBar1.setValue(user.xp/10);
                }

                jProgressBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                streak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                streak.setText("Streak x" + user.getStreak() + ", " + "Streak Freeze x" + user.getStreakFreeze());
                streak.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

                freeze.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                freeze.setText(user.xp + " XP");

                javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
                infoPanel.setLayout(infoPanelLayout);
                infoPanelLayout.setHorizontalGroup(infoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(picture, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(infoPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(infoPanelLayout.createSequentialGroup()
                                                                                .addGroup(infoPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(userLabel,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGap(67, 67, 67))
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(streakLabel,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGap(23, 23, 23))
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(username)
                                                                                                                .addGap(20, 20, 20))
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(streak,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                293,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGap(35, 35, 35)))
                                                                                .addGap(47, 47, 47)
                                                                                .addGroup(infoPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(freezeLabel,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addContainerGap(
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(infoPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(infoPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(infoPanelLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(share,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(mailLabel,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(editProf,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addGap(5, 5, 5))
                                                                                                                                .addGroup(infoPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(email)
                                                                                                                                                .addGap(110, 110,
                                                                                                                                                                110)))
                                                                                                                .addGap(41, 41, 41))
                                                                                                .addGroup(infoPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(freeze,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                289,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGap(191, 191,
                                                                                                                                191))))
                                                                .addGroup(infoPanelLayout.createSequentialGroup()
                                                                                .addComponent(jProgressBar1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                746,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))));
                infoPanelLayout.setVerticalGroup(infoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoPanelLayout.createSequentialGroup().addGroup(infoPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(infoPanelLayout.createSequentialGroup()
                                                                .addComponent(picture,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(infoPanelLayout.createSequentialGroup()
                                                                .addGroup(infoPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(editProf,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(share,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(3, 3, 3)
                                                                .addGroup(infoPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(userLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(mailLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(infoPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(username)
                                                                                .addComponent(email))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(infoPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(streakLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                46, Short.MAX_VALUE)
                                                                                .addComponent(freezeLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(infoPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(streak)
                                                                                .addComponent(freeze))
                                                                .addGap(73, 73, 73).addComponent(jProgressBar1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                45,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap()));

                AchievePanel.setBackground(new java.awt.Color(204, 204, 204));

                achieveLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                achieveLabel.setText("Achievements: ");

                badges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/badges.png")));

                javax.swing.GroupLayout AchievePanelLayout = new javax.swing.GroupLayout(AchievePanel);
                AchievePanel.setLayout(AchievePanelLayout);
                AchievePanelLayout.setHorizontalGroup(AchievePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(AchievePanelLayout.createSequentialGroup().addComponent(achieveLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(AchievePanelLayout.createSequentialGroup().addGap(43, 43, 43)
                                                .addComponent(badges)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                AchievePanelLayout.setVerticalGroup(
                                AchievePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(AchievePanelLayout.createSequentialGroup()
                                                                .addComponent(achieveLabel).addGap(39, 39, 39)
                                                                .addComponent(badges).addGap(0, 137, Short.MAX_VALUE)));

                groupsPanel.setBackground(new java.awt.Color(205, 201, 201));
                groupsPanel.setPreferredSize(new java.awt.Dimension(1080, 174));

                groupsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                groupsLabel.setText("Groups: ");

                groupA.setBackground(new java.awt.Color(63, 63, 63));
                groupA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                groupA.setForeground(new java.awt.Color(102, 102, 102));
                groupA.setText("No Group");
                if (user.groups.size() != 0) {
                        groupA.setText(user.groups.get(0).getGroupName());
                }
                groupA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                groupB.setBackground(new java.awt.Color(65, 65, 65));
                groupB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                groupB.setForeground(new java.awt.Color(102, 102, 102));
                groupB.setText("No Group");
                if (user.groups.size() > 1) {
                        groupA.setText(user.groups.get(1).getGroupName());
                }
                groupB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                groupC.setBackground(new java.awt.Color(63, 63, 63));
                groupC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                groupC.setForeground(new java.awt.Color(102, 102, 102));
                groupC.setText("No Group");
                if (user.groups.size() > 2) {
                        groupA.setText(user.groups.get(2).getGroupName());
                }
                groupC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                javax.swing.GroupLayout groupsPanelLayout = new javax.swing.GroupLayout(groupsPanel);
                groupsPanel.setLayout(groupsPanelLayout);
                groupsPanelLayout.setHorizontalGroup(groupsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(groupsPanelLayout.createSequentialGroup().addComponent(groupsLabel)
                                                .addGap(95, 95, 95)
                                                .addComponent(groupA, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(164, 164, 164)
                                                .addComponent(groupB, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(164, 164, 164)
                                                .addComponent(groupC, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                groupsPanelLayout.setVerticalGroup(groupsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(groupsPanelLayout.createSequentialGroup().addGroup(groupsPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(groupsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(groupsPanelLayout.createSequentialGroup().addContainerGap()
                                                                .addGroup(groupsPanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(groupB,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                95, Short.MAX_VALUE)
                                                                                .addComponent(groupA,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(groupC,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))))
                                                .addContainerGap(159, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AchievePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AchievePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(groupsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 265,
                                                                Short.MAX_VALUE)));
        }

        private void pictureActionPerformed(java.awt.event.ActionEvent evt) {
        }

        private void usernameActionPerformed(java.awt.event.ActionEvent evt) {
        }

        private void emailActionPerformed(java.awt.event.ActionEvent evt) {
        }

        private void editProfActionPerformed(java.awt.event.ActionEvent evt) {

                email.setEditable(true);
                username.setEditable(true);

        }

        private void usernameKeyPressed(java.awt.event.KeyEvent evt) {

                if (evt.getKeyCode() == evt.VK_ENTER) {
                        username.setEditable(false);
                        JOptionPane.showMessageDialog(null, "Username Changed!");
                        user.setUsername(username.getText());

                }
        }

        private void emailKeyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == evt.VK_ENTER) {

                        email.setEditable(false);
                        user.setEmail(email.getText());
                        JOptionPane.showMessageDialog(null, "Email Changed!");

                }
        }

        private javax.swing.JPanel AchievePanel;
        private javax.swing.JLabel achieveLabel;
        private javax.swing.JLabel badges;
        private javax.swing.JButton editProf;
        private javax.swing.JTextField email;
        private javax.swing.JLabel freeze;
        private javax.swing.JLabel freezeLabel;
        private javax.swing.JButton goBackButton;
        private javax.swing.JLabel groupA;
        private javax.swing.JLabel groupB;
        private javax.swing.JLabel groupC;
        private javax.swing.JLabel groupsLabel;
        private javax.swing.JPanel groupsPanel;
        private javax.swing.JPanel headerPanel;
        private javax.swing.JPanel infoPanel;
        private javax.swing.JProgressBar jProgressBar1;
        private javax.swing.JLabel mailLabel;
        private javax.swing.JButton picture;
        private javax.swing.JLabel profileLabel;
        private javax.swing.JButton share;
        private javax.swing.JLabel streak;
        private javax.swing.JLabel streakLabel;
        private javax.swing.JLabel userLabel;
        private javax.swing.JTextField username;
}