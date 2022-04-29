package Groups;

import com.sun.tools.javac.Main;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import Classes.*;
import groupProf.groupProf;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author WIN 10
 */
public class GroupsPanel extends javax.swing.JPanel {

    User currentUser;
    DefaultListModel<String> model = new DefaultListModel<>();
    ArrayList<Group> groupArrayList;
    JPanel previousPanel;
    /**
     * Creates new form GroupsPanel
     */
    public GroupsPanel (User currentUser, JPanel previousPanel) {
        this.currentUser = currentUser;
        this.previousPanel = previousPanel;
        groupArrayList = currentUser.groups;
        for ( Group group : groupArrayList)
        {
            model.addElement (group.toString());
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupsPanel = new JPanel();
        butPrevPage = new JButton();
        butCreateGroup = new JButton();
        butSearchGroup = new JButton();
//        scrollGroupList = new javax.swing.JScrollPane();
//        listGroup = new javax.swing.JList<>();
        labForList = new JLabel();
        butLeave = new JButton();
        butGo = new JButton();


        setPreferredSize(new Dimension(1000, 800));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        groupsPanel.setBackground(new Color(255, 255, 255));
        groupsPanel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        groupsPanel.setPreferredSize(new Dimension(1000, 800));
        groupsPanel.setRequestFocusEnabled(false);
        groupsPanel.setLayout(new AbsoluteLayout());

        butPrevPage.setBackground(new Color(51, 102, 255));
        butPrevPage.setText("Previous page");
        butPrevPage.setPreferredSize(new Dimension(130, 40));
        butPrevPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butPrevPageActionPerformed(evt);
            }
        });
        groupsPanel.add(butPrevPage, new AbsoluteConstraints(30, 20, 130, 40));

        butCreateGroup.setBackground(new Color(0, 255, 51));
        butCreateGroup.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        butCreateGroup.setText("Create a new group");
        butCreateGroup.setBorder(new LineBorder(new Color(0, 255, 51), 1, true));
        butCreateGroup.setMaximumSize(new Dimension(1000, 200));
        butCreateGroup.setPreferredSize(new Dimension(270, 70));

        butCreateGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butcreateGroupActionPerformed(evt);
            }
        });
        groupsPanel.add(butCreateGroup, new AbsoluteConstraints(166, 120, 270, 70));

        butSearchGroup.setBackground(new Color(0, 255, 51));
        butSearchGroup.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        butSearchGroup.setText("search for groups");
        butSearchGroup.setBorder(new LineBorder(new Color(0, 255, 51), 1, true));
        butSearchGroup.setMaximumSize(new Dimension(1000, 200));
        butSearchGroup.setPreferredSize(new Dimension(270, 70));
        butSearchGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butSearchGroupActionPerformed(evt);
            }
        });
        groupsPanel.add(butSearchGroup, new AbsoluteConstraints(520, 120, 270, 70));

        groupListInit();



        labForList.setLabelFor(listGroup);
        labForList.setText("  Current groups");
        labForList.setAlignmentY(0.0F);
        labForList.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        labForList.setPreferredSize(new Dimension(110, 40));
        groupsPanel.add(labForList, new AbsoluteConstraints(210, 300, 110, 40));

        butLeave.setBackground(new Color(255, 0, 0));
        butLeave.setText("leave");
        butLeave.setPreferredSize(new Dimension(100, 40));
        butLeave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butLeaveActionPerformed(evt);
            }
        });
        groupsPanel.add(butLeave, new AbsoluteConstraints(690, 700, 100, 40));

        butGo.setBackground(new Color(0, 255, 51));
        butGo.setText("Go to Group");
        butGo.setPreferredSize(new Dimension(150, 40));
        butGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butGoActionPerformed(evt);
            }
        });
        groupsPanel.add(butGo, new AbsoluteConstraints(210, 700, 150, 40));

        labGroups = new JLabel();

        labGroups.setFont(new Font("Tahoma", 0, 32)); // NOI18N

        labGroups.setText("Groups");
        Font font = labGroups.getFont();
        Map attributes = font.getAttributes();
        attributes.put (TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labGroups.setFont (font.deriveFont(attributes));

        groupsPanel.add(labGroups, new AbsoluteConstraints(430, 20, 110, 50));

        add(groupsPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void groupListInit()
    {
        scrollGroupList = new javax.swing.JScrollPane();
        listGroup = new javax.swing.JList<>(model);

        scrollGroupList.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollGroupList.setPreferredSize(new java.awt.Dimension(580, 360));

        listGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listGroup.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        listGroup.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listGroup.setPreferredSize(new java.awt.Dimension(580, 360));

        scrollGroupList.getVerticalScrollBar().setUnitIncrement (16);
        listGroup.setValueIsAdjusting(true);

        scrollGroupList.setViewportView(listGroup);

        groupsPanel.add(scrollGroupList, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 580, 360));

    }

    private void butcreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butcreateGroupActionPerformed
        // TODO add your handling code here:
        GroupCreate newPanel = new GroupCreate(currentUser, this);
        MainFrame.panelChanger (this, newPanel);

    }//GEN-LAST:event_butcreateGroupActionPerformed

    private void butSearchGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchGroupActionPerformed
        // TODO add your handling code here:
       String input = JOptionPane.showInputDialog (null,"enter the id of your group:");
       try {
           if (input.equals (""))
           {
               JOptionPane.showMessageDialog (null, "the group does not exist", "error", JOptionPane.ERROR_MESSAGE);
           } else
           {
               Group group = DB.getGroup (Integer.valueOf (input));
               if (!model.contains (group.toString()))
               {
                   group.addUser (currentUser);
                   JOptionPane.showMessageDialog (null, "Successfully added to the group!");
                   model.addElement (group.toString ());
               }
               else
               {
                   JOptionPane.showMessageDialog (null, "you are already in the group", "error", JOptionPane.ERROR_MESSAGE);
               }
           }
       } catch ( Exception e)
       {
           JOptionPane.showMessageDialog (null, "the group does not exist", "error", JOptionPane.ERROR_MESSAGE);
       }
    }

    private void butLeaveActionPerformed (ActionEvent evt) {
        ListSelectionModel selmodel = listGroup.getSelectionModel();
        int index = selmodel.getMinSelectionIndex();
        if (index >= 0)
        {
            model.remove (index);
            groupArrayList.get (index).removeUser (currentUser);
        }
    }

    private void butGoActionPerformed (ActionEvent evt) {
        ListSelectionModel selmodel = listGroup.getSelectionModel();
        int index = selmodel.getMinSelectionIndex();
        if (index >= 0)
        {
            MainFrame.panelChanger (this, new groupProf (groupArrayList.get (index), currentUser ));
        }
    }

    private void butPrevPageActionPerformed (ActionEvent evt) {
        MainFrame.panelChanger (this, previousPanel);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butLeave;
    private javax.swing.JButton butPrevPage;
    private javax.swing.JButton butSearchGroup;
    private javax.swing.JButton butCreateGroup;
    private javax.swing.JPanel groupsPanel;
    private javax.swing.JLabel labForList;
    private javax.swing.JList<String> listGroup;
    private javax.swing.JScrollPane scrollGroupList;
    private JLabel labGroups;
    private JButton butGo;
    // End of variables declaration//GEN-END:variables
}
