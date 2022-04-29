package Groups;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import Classes.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author WIN 10
 */
public class GroupCreate extends JPanel {
    final String GROUP_NAME_TEXT = "enter the name of your group";
    final String USER_SEARCH_TEXT = "enter the name of your friend and press enter ";
    final String CATEGORY_NAME_TEXT = "enter your category and then press enter";

    User currentUser;
    DefaultListModel<String> userModel;
    DefaultListModel<String> catModel;

    ArrayList<String> cats;

    ArrayList<Member> members;

    JPanel previousPanel;
    /**
     * Creates new form groupCreate
     */
    public GroupCreate( User currentUser, JPanel previousPanel) {
        this.currentUser = currentUser;
        this.previousPanel = previousPanel;

        userModel = new DefaultListModel<>();
        catModel = new DefaultListModel<>();

        members = new ArrayList<Member>();
        cats = new ArrayList<String>();

        initComponents();
    }


    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jPanel1 = new JPanel();
        textGroupName = new JFormattedTextField();
        labAddedCat = new JLabel();
        scrollAddedCat = new JScrollPane();
        listAddedCat = new JList<>(catModel);
        butRemoveCat = new JButton();
        scrollAddedFriends = new JScrollPane();
        listAddedUsers = new JList<>(userModel);
        labAddedFriends = new JLabel();
        jSeparator1 = new JSeparator();
        textUserSearch = new JFormattedTextField();
        butRemoveUser = new JButton();
        butCreateGroup = new JButton();
        textCatAdd = new JFormattedTextField();
        butPrevPage = new JButton();
        butAddCat = new JButton();
        butAddUser = new JButton();


        setBackground(new Color(153, 255, 51));
        setAutoscrolls(true);
        setOpaque(false);
        setPreferredSize(new Dimension(1000, 800));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        jScrollPane1.setForeground(new Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setPreferredSize(new Dimension(1000, 800));
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new Dimension(1000, 1600));
        jPanel1.setLayout(new AbsoluteLayout());

        textGroupName.setForeground(new Color(204, 204, 204));
        textGroupName.setText(GROUP_NAME_TEXT);
        textGroupName.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        textGroupName.setPreferredSize(new Dimension(390, 60));
        MainFrame.textBoxEffect (textGroupName, GROUP_NAME_TEXT);

        textGroupName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textGroupNameActionPerformed(evt);
            }
        });
        jPanel1.add(textGroupName, new AbsoluteConstraints(260, 120, 390, 60));

        labAddedCat.setLabelFor(listAddedUsers);
        labAddedCat.setText(" Added categories");
        labAddedCat.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        labAddedCat.setPreferredSize(new Dimension(100, 50));
        jPanel1.add(labAddedCat, new AbsoluteConstraints(630, 260, 120, 50));

        listAddedCat.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        listAddedCat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listAddedCat.setVisibleRowCount(5);
        scrollAddedCat.setViewportView(listAddedCat);

        jPanel1.add(scrollAddedCat, new AbsoluteConstraints(630, 310, 220, 260));

        butRemoveCat.setBackground(new Color(255, 0, 51));
        butRemoveCat.setText("remove");
        butRemoveCat.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        butRemoveCat.setBorderPainted(false);
        butRemoveCat.setPreferredSize(new Dimension(90, 30));
        butRemoveCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butRemovecatActionPerformed(evt);
            }
        });
        jPanel1.add(butRemoveCat, new AbsoluteConstraints(760, 570, 90, 30));

        listAddedUsers.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        listAddedUsers.setVisibleRowCount(5);
        scrollAddedFriends.setViewportView(listAddedUsers);

        jPanel1.add(scrollAddedFriends, new AbsoluteConstraints(650, 970, 220, 260));

        labAddedFriends.setLabelFor(listAddedUsers);
        labAddedFriends.setText("   Added friends");
        labAddedFriends.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanel1.add(labAddedFriends, new AbsoluteConstraints(650, 920, 100, 50));
        jPanel1.add(jSeparator1, new AbsoluteConstraints(10, 730, 990, 10));

        textUserSearch.setForeground(new Color(204, 204, 204));
        textUserSearch.setText("Enter the name of your friend and then hit enter");
        textUserSearch.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        textUserSearch.setPreferredSize(new Dimension(400, 60));
        MainFrame.textBoxEffect (textUserSearch, USER_SEARCH_TEXT);

        jPanel1.add(textUserSearch, new AbsoluteConstraints(70, 970, 400, 60));

        butRemoveUser.setBackground(new Color(255, 0, 51));
        butRemoveUser.setText("remove");
        butRemoveUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butRemoveUserActionPerformed(evt);
            }
        });
        jPanel1.add(butRemoveUser, new AbsoluteConstraints(780, 1230, 90, 30));

        butCreateGroup.setBackground(new Color(51, 255, 0));
        butCreateGroup.setText("Create Group");
        butCreateGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butCreateGroupActionPerformed(evt);
            }
        });
        jPanel1.add(butCreateGroup, new AbsoluteConstraints(180, 1310, 280, 90));


        textCatAdd.setText (CATEGORY_NAME_TEXT);
        textCatAdd.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        textCatAdd.setForeground (new Color(204,204,204));
        textCatAdd.setPreferredSize(new Dimension(400, 60));
        MainFrame.textBoxEffect (textCatAdd, CATEGORY_NAME_TEXT);

        jPanel1.add(textCatAdd, new AbsoluteConstraints(40, 340, 400, 60));


        butPrevPage.setBackground(new Color(51, 102, 255));
        butPrevPage.setText("Previous page");
        butPrevPage.setPreferredSize(new Dimension(130, 40));
        butPrevPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butPrevPageActionPerformed(evt);
            }
        });
        jPanel1.add(butPrevPage, new AbsoluteConstraints(30, 20, 130, 40));

        butAddCat.setBackground(new Color(51, 255, 51));
        butAddCat.setText("add category+");
        butAddCat.setPreferredSize(new Dimension(140, 50));
        butAddCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butAddCatActionPerformed(evt);
            }
        });
        jPanel1.add(butAddCat, new AbsoluteConstraints(440, 345, 140, 50));


        butAddUser.setBackground(new Color(51, 255, 51));
        butAddUser.setText("Add friend+");
        butAddUser.setPreferredSize(new Dimension(140, 50));
        butAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butAddUserActionPerformed(evt);
            }
        });
        jPanel1.add(butAddUser, new AbsoluteConstraints(470, 975, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        labTitle = new JLabel();

        labTitle.setFont(new Font("Tahoma", 0, 32)); // NOI18N

        labTitle.setText("Create group");
        Font font = labTitle.getFont();
        Map attributes = font.getAttributes();
        attributes.put (TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labTitle.setFont (font.deriveFont(attributes));

        jPanel1.add(labTitle, new AbsoluteConstraints (400, 20, 200, 50));

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void textGroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textGroupNameActionPerformed


    private void butCreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCreateGroupActionPerformed
        // TODO add your handling code here:
        if (textGroupName.getText().equals (GROUP_NAME_TEXT) || textGroupName.getText().equals ("") ) {
            JOptionPane.showMessageDialog(null, "group name can not be empty", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if (catModel.isEmpty()){
            JOptionPane.showMessageDialog(null, "you need to add at least 1 category", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if (userModel.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "you need to add at least 1 friend", "error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int option = JOptionPane.showInternalConfirmDialog (null,
                    "Create the group?", "are you sure?",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION)
            {
                Group group;
                group = new Group (textGroupName.getText (), currentUser, members, cats);
                MainFrame.panelChanger (this, new GroupsPanel (
                        new User (currentUser.getUsername(), currentUser.getPassword()), new JPanel()));
            }
            else
            {

            }
        }
    }


    private void butRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ListSelectionModel selmodel = listAddedUsers.getSelectionModel();
        int index = selmodel.getMinSelectionIndex();
        if (index >= 0)
        {
            userModel.remove (index);
            members.remove (index);
        }
    }//GEN-LAST:event_butRemoveUserActionPerformed

    private void butRemovecatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRemovecatActionPerformed
        // TODO add your handling code here:
        ListSelectionModel selmodel = listAddedCat.getSelectionModel();
        int index = selmodel.getMinSelectionIndex();
        if (index >= 0)
        {
            catModel.remove (index);
            cats.remove (index);
        }
    }//GEN-LAST:event_butRemovecatActionPerformed


    private void butPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPrevPageActionPerformed
        // TODO add your handling code here:
        MainFrame.panelChanger (this, new GroupsPanel (currentUser, new JPanel ()));
    }//GEN-LAST:event_butPrevPageActionPerformed

    private void butAddCatActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (textCatAdd.getText().equals (CATEGORY_NAME_TEXT) || textCatAdd.getText().equals ("")){
            JOptionPane.showMessageDialog(null, "enter a proper category", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!cats.contains (textCatAdd.getText()))
        {
            catModel.addElement (textCatAdd.getText());
            cats.add (textCatAdd.getText().toLowerCase(Locale.ROOT));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "you can't add a duplicate category", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void butAddUserActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (textUserSearch.getText().equals (USER_SEARCH_TEXT) || textUserSearch.getText ().equals (""))
        {
            JOptionPane.showMessageDialog (null, "please enter a user's id", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Integer.valueOf (textUserSearch.getText()) == currentUser.getProfileID())
        {
            JOptionPane.showMessageDialog (null, "you can't add yourself", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Integer.valueOf (textUserSearch.getText()) >= DB.userIdGenerator())
        {
            JOptionPane.showMessageDialog (null, "the user does not exist", "error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            User temp = DB.getUser (Integer.valueOf (textUserSearch.getText()));
            if (!userModel.contains (temp.toString()))
            {
                members.add (new Member (temp, 0));
                userModel.addElement (temp.toString ());
            }
            else
            {
                JOptionPane.showMessageDialog (null, "the user is already added", "error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAddCat;
    private javax.swing.JButton butAddUser;
    private JButton butCreateGroup;
    private JButton butPrevPage;
    private JButton butRemoveUser;
    private JButton butRemoveCat;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JLabel labAddedCat;
    private JLabel labAddedFriends;
    private JList<String> listAddedCat;
    private JList<String> listAddedUsers;
    private JScrollPane scrollAddedCat;
    private JScrollPane scrollAddedFriends;
    private JFormattedTextField textCatAdd;
    private JFormattedTextField textGroupName;
    private JFormattedTextField textUserSearch;
    private JLabel labTitle;
    // End of variables declaration//GEN-END:variables
}
