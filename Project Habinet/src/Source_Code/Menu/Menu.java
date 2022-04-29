package Menu;
import Classes.*;
import GroupChat.ChatPanel;
import Groups.GroupsPanel;
import Help.HelpPanel;
import Overview.OverviewPanel;
import Settings.SettingsPanel;
import Tasks.SoloTaskPanel;
import home.home2v;
import profile.profile;
import upcomingTasks.upcomingTask;

import  javax.swing.*;
import java.awt.*;

/**
 *
 *@author Maher Athar Ilyas
 */
public class Menu extends JPanel {

    private JPanel GroupsButton;
    private JPanel HelpButton;
    private JPanel HomeButton;
    private JPanel ProfileButton;
    private JPanel SettingsButton;
    private JLabel StreakFreezeCount;
    private JPanel TasksButton;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel10;
    private JPanel jPanel5;
    private JPanel jPanel9;
    private JLabel streakCount;
    private JLabel userName;
    private User user;
    
    /**
     * for testing
     * Delete later
     */
    public Menu() {
        initComponents();
        //userComponents();
    }  
    
    public Menu(User user){
        
        this.user = user;
        initComponents();
        userComponents();
    }
    
    public void userComponents(){

       userName.setText(user.getUsername());
       StreakFreezeCount.setText(" x " + user.getStreakFreeze());
       streakCount.setText(" x " + user.getStreak());       
    }

    private void initComponents() {

        jPanel5 = new JPanel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        HomeButton = new JPanel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel6 = new JLabel();
        ProfileButton = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        TasksButton = new JPanel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        GroupsButton = new JPanel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        SettingsButton = new JPanel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        HelpButton = new JPanel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jPanel9 = new JPanel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        streakCount = new JLabel();
        StreakFreezeCount = new JLabel();
        jPanel10 = new JPanel();
        userName = new JLabel();
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();

        jPanel5.setBackground(Color.darkGray);

        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel14.setIcon(new ImageIcon(getClass().getResource("/Images/home.png")));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel16.setForeground(new Color(236, 236, 236));
        jLabel16.setText("Home");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
            .addComponent(jLabel14, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBackground(new Color(31, 29, 29));
        setMaximumSize(new java.awt.Dimension(281, 779));
        setPreferredSize(new java.awt.Dimension(318, 779));

        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Images/home.png"))); 

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel6.setForeground(new Color(236, 236, 236));
        jLabel6.setText("Home");

        GroupLayout HomeButtonLayout = new GroupLayout(HomeButton);
        HomeButton.setLayout(HomeButtonLayout);
        HomeButtonLayout.setHorizontalGroup(
            HomeButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(HomeButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeButtonLayout.setVerticalGroup(
            HomeButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(jLabel2, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HomeButtonLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ProfileButton.setBackground(new Color(31, 29, 29));

        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/Images/profile.png"))); 

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel10.setForeground(new Color(236, 236, 236));
        jLabel10.setText("Profile");

        GroupLayout ProfileButtonLayout = new GroupLayout(ProfileButton);
        ProfileButton.setLayout(ProfileButtonLayout);
        ProfileButtonLayout.setHorizontalGroup(
            ProfileButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ProfileButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfileButtonLayout.setVerticalGroup(
            ProfileButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(jLabel8, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ProfileButtonLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TasksButton.setBackground(new Color(31, 29, 29));

        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/Images/tasks.png"))); 

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel13.setForeground(new Color(236, 236, 236));
        jLabel13.setText("Tasks");

        GroupLayout TasksButtonLayout = new GroupLayout(TasksButton);
        TasksButton.setLayout(TasksButtonLayout);
        TasksButtonLayout.setHorizontalGroup(
            TasksButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TasksButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TasksButtonLayout.setVerticalGroup(
            TasksButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
            .addComponent(jLabel11, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TasksButtonLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        GroupsButton.setBackground(new Color(31, 29, 29));

        jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel17.setIcon(new ImageIcon(getClass().getResource("/Images/Groups.png"))); 

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel19.setForeground(new Color(236, 236, 236));
        jLabel19.setText("Groups");

        GroupLayout GroupsButtonLayout = new GroupLayout(GroupsButton);
        GroupsButton.setLayout(GroupsButtonLayout);
        GroupsButtonLayout.setHorizontalGroup(
            GroupsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupsButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GroupsButtonLayout.setVerticalGroup(
            GroupsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
            .addComponent(jLabel17, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupsButtonLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        SettingsButton.setBackground(new Color(31, 29, 29));

        jLabel20.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel20.setIcon(new ImageIcon(getClass().getResource("/Images/Settings.png"))); 

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel22.setForeground(new Color(236, 236, 236));
        jLabel22.setText("Settings");

        GroupLayout SettingsButtonLayout = new GroupLayout(SettingsButton);
        SettingsButton.setLayout(SettingsButtonLayout);
        SettingsButtonLayout.setHorizontalGroup(
            SettingsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SettingsButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SettingsButtonLayout.setVerticalGroup(
            SettingsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(jLabel20, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SettingsButtonLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        HelpButton.setBackground(new Color(31, 29, 29));

        jLabel23.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel23.setIcon(new ImageIcon(getClass().getResource("/Images/Help.png"))); 

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 22)); 
        jLabel25.setForeground(new Color(236, 236, 236));
        jLabel25.setText("Help");

        GroupLayout HelpButtonLayout = new GroupLayout(HelpButton);
        HelpButton.setLayout(HelpButtonLayout);
        HelpButtonLayout.setHorizontalGroup(
            HelpButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(HelpButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HelpButtonLayout.setVerticalGroup(
            HelpButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(jLabel23, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HelpButtonLayout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new Color(31, 29, 29));

        jLabel26.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel26.setIcon(new ImageIcon(getClass().getResource("/Images/fire.png"))); 

        jLabel27.setIcon(new ImageIcon(getClass().getResource("/Images/ice.png"))); 

        streakCount.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); 
        streakCount.setForeground(new Color(240, 240, 240));
        streakCount.setText("x 3");

        StreakFreezeCount.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); 
        StreakFreezeCount.setForeground(new Color(240, 240, 240));
        StreakFreezeCount.setText("x 2");

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(streakCount)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StreakFreezeCount)
                .addGap(49, 49, 49))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(streakCount)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel27, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel26, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StreakFreezeCount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new Color(31, 29, 29));

        userName.setFont(new java.awt.Font("Segoe UI", 1, 30)); 
        userName.setForeground(new Color(240, 240, 240));
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setText("User Name");

        jLabel31.setIcon(new ImageIcon(getClass().getResource("/Images/Rank_1.png"))); 

        jLabel32.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel32.setIcon(new ImageIcon(getClass().getResource("/Images/rank_bar.png")));

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(userName, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(HomeButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfileButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TasksButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GroupsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HelpButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(HomeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProfileButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TasksButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GroupsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SettingsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(HelpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        HomeButton.setBackground(Color.darkGray);
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoHome();
            }
        });

        TasksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoTasks();
            }
        });

        ProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoProfile();
            }
        });

        GroupsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoGroups();
            }
        });

        SettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoSettings();
            }
        });

        HelpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoHelp();
            }
        });


    }   

    public void gotoHome(){
        HomeButton.setBackground(Color.darkGray);
        TasksButton.setBackground(new Color(31, 29, 29));
        ProfileButton.setBackground(new Color(31, 29, 29));
        GroupsButton.setBackground(new Color(31, 29, 29));
        SettingsButton.setBackground(new Color(31, 29, 29));
        HelpButton.setBackground(new Color(31, 29, 29));

        JPanel otherPanel = new home2v(new User(user.getUsername(), user.getPassword()));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Container contain = frame.getContentPane();                
        contain.removeAll();
        contain.add(this, BorderLayout.WEST);
        contain.add(otherPanel, BorderLayout.CENTER);
        contain.revalidate();
        contain.setVisible(true);
    }

    public void gotoProfile(){
        ProfileButton.setBackground(Color.darkGray);
        TasksButton.setBackground(new Color(31, 29, 29));
        HomeButton.setBackground(new Color(31, 29, 29));
        GroupsButton.setBackground(new Color(31, 29, 29));
        SettingsButton.setBackground(new Color(31, 29, 29));
        HelpButton.setBackground(new Color(31, 29, 29));

        JPanel otherPanel = new profile(new User(user.getUsername(), user.getPassword()));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Container contain = frame.getContentPane();                
        contain.removeAll();
        contain.add(this, BorderLayout.WEST);
        contain.add(otherPanel, BorderLayout.CENTER);
        contain.revalidate();
        contain.setVisible(true);
    }

    public void gotoTasks(){
        TasksButton.setBackground(Color.darkGray);
        HomeButton.setBackground(new Color(31, 29, 29));
        ProfileButton.setBackground(new Color(31, 29, 29));
        GroupsButton.setBackground(new Color(31, 29, 29));
        SettingsButton.setBackground(new Color(31, 29, 29));
        HelpButton.setBackground(new Color(31, 29, 29));

        JPanel otherPanel =  new upcomingTask(new User(user.getUsername(), user.getPassword()));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Container contain = frame.getContentPane();                
        contain.removeAll();
        contain.add(this, BorderLayout.WEST);
        contain.add(otherPanel, BorderLayout.CENTER);
        contain.revalidate();
        contain.setVisible(true);
    }

    public void gotoGroups(){
        GroupsButton.setBackground(Color.darkGray);
        TasksButton.setBackground(new Color(31, 29, 29));
        ProfileButton.setBackground(new Color(31, 29, 29));
        HomeButton.setBackground(new Color(31, 29, 29));
        SettingsButton.setBackground(new Color(31, 29, 29));
        HelpButton.setBackground(new Color(31, 29, 29));

        //JPanel otherPanel = new ChatPanel(1 , user);
        JPanel otherPanel = new GroupsPanel(new User(user.getUsername(), user.getPassword()) , new home2v(user));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Container contain = frame.getContentPane();                
        contain.removeAll();
        contain.add(this, BorderLayout.WEST);
        contain.add(otherPanel, BorderLayout.CENTER);
        contain.revalidate();
        contain.setVisible(true);
    }

    public void gotoSettings(){

        HomeButton.setBackground(new Color(31, 29, 29));
        TasksButton.setBackground(new Color(31, 29, 29));
        ProfileButton.setBackground(new Color(31, 29, 29));
        GroupsButton.setBackground(new Color(31, 29, 29));
        SettingsButton.setBackground(Color.darkGray);
        HelpButton.setBackground(new Color(31, 29, 29));

        JPanel otherPanel = new SettingsPanel(user);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        Container contain = frame.getContentPane();                
        contain.removeAll();
        contain.add(this, BorderLayout.WEST);
        contain.add(otherPanel, BorderLayout.CENTER);
        contain.revalidate();
        contain.setVisible(true);
    }

    public void gotoHelp(){

        HomeButton.setBackground(new Color(31, 29, 29));
        TasksButton.setBackground(new Color(31, 29, 29));
        ProfileButton.setBackground(new Color(31, 29, 29));
        GroupsButton.setBackground(new Color(31, 29, 29));
        HelpButton.setBackground(Color.darkGray);
        SettingsButton.setBackground(new Color(31, 29, 29));

        JPanel otherPanel = new HelpPanel();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        Container contain = frame.getContentPane();                
        contain.removeAll();
        contain.add(this, BorderLayout.WEST);
        contain.add(otherPanel, BorderLayout.CENTER);
        contain.revalidate();
        contain.setVisible(true);
    }   

}
