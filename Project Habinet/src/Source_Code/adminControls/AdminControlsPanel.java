package adminControls;
import Classes.Member;
import Classes.*;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminControlsPanel extends JPanel {
    
        // Variables declaration - do not modify                     
        private javax.swing.JButton addCategoryButton;
        private javax.swing.JButton addMember;
        private javax.swing.JTextField addMemberField;
        private javax.swing.JComboBox<String> addNewCategoryDropDown;
        private javax.swing.JLabel addNewCategoryLabel;
        private javax.swing.JLabel addedCategoriesLabel;
        private javax.swing.JLabel adminControlsTitle;
        private javax.swing.JButton changeGroupNameButton;
        private javax.swing.JTextField changeGroupNameField;
        private javax.swing.JLabel changeGroupNameLabel;
        private javax.swing.JButton goBackButton;
        private javax.swing.JTextArea groupCategoriesArea;
        private javax.swing.JLabel groupIDLabel;
        private javax.swing.JLabel groupIdValue;
        private javax.swing.JButton removememberButton;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTextArea membersListArea;
        private javax.swing.JComboBox<String> membersListDropDown;
        private javax.swing.JLabel membersListLabel;
        private javax.swing.JButton removeCategoryButton;
        private javax.swing.JComboBox<String> removeCategoryDropDown;
        private javax.swing.JLabel removeCategoryLabel;
        Group currentGroup;
        String currentGroupName;
        int groupID;
        int memberID;
        String newGroupName;
        String newChoosenCategory;
        String removalChoosenCategory;
        String membersListRemoveChoosen;
        ArrayList<String> groupCategories;
        ArrayList<Member> currentGroupMembers;




    public AdminControlsPanel(Group group) throws SQLException {
        this.currentGroup = group;
        groupID = group.getGroupID();
        currentGroupName = group.getGroupName();
        groupCategories = DB.getGroup(groupID).getCategories();
        initComponents();
    }



    private void initComponents() {
       

        goBackButton = new javax.swing.JButton();
        adminControlsTitle = new javax.swing.JLabel();
        groupIDLabel = new javax.swing.JLabel();
        groupIdValue = new javax.swing.JLabel();
        addMemberField = new javax.swing.JTextField();
        addMember = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupCategoriesArea = new javax.swing.JTextArea();
        addedCategoriesLabel = new javax.swing.JLabel();
        addNewCategoryLabel = new javax.swing.JLabel();
        addNewCategoryDropDown = new javax.swing.JComboBox<>();
        removeCategoryLabel = new javax.swing.JLabel();
        removeCategoryDropDown = new javax.swing.JComboBox<>();
        changeGroupNameLabel = new javax.swing.JLabel();
        changeGroupNameField = new javax.swing.JTextField();
        membersListLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersListArea = new javax.swing.JTextArea();
        addCategoryButton = new javax.swing.JButton();
        removeCategoryButton = new javax.swing.JButton();
        changeGroupNameButton = new javax.swing.JButton();
        membersListDropDown = new javax.swing.JComboBox<>();
        removememberButton = new javax.swing.JButton();



        

        goBackButton.setText("<-- Go Back");

        goBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBackButtonMouseClicked(evt);
            }
        });

        adminControlsTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        adminControlsTitle.setText("Admin Controls");

        groupIDLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        groupIDLabel.setText("Group ID");

        groupIdValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        groupIdValue.setText("0");
        groupIdValue.setText(Integer.toString(groupID));

        addMemberField.setText("Member ID");
        addMemberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addMemberFieldKeyTyped(evt);
            }
        });
        
        addMember.setText("Add Member");
        addMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMemberMouseClicked(evt);
            }
        });

        groupCategoriesArea.setColumns(20);
        groupCategoriesArea.setRows(5);
        jScrollPane1.setViewportView(groupCategoriesArea);

        addedCategoriesLabel.setText("Added Categories:");

        addNewCategoryLabel.setText("Add New Category");

        addNewCategoryDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maths", "Science", "English", "Sports", "Football", "Cricket", "Basketball", "Physics", "Astronomy", "Planes", "Mechatronics", "Urdu" }));
        addNewCategoryDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCategoryDropDownActionPerformed(evt);
            }
        });

        removeCategoryLabel.setText("Remove Category");

        removeCategoryDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        removeCategoryDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCategoryDropDownActionPerformed(evt);
            }
        });

        for (int i = 0 ; i < groupCategories.size(); i++) {
            groupCategoriesArea.append(groupCategories.get(i) + "\n");
            removeCategoryDropDown.addItem(groupCategories.get(i));
        }


        changeGroupNameLabel.setText("Change Group Name:");

        changeGroupNameField.setText("New Name");
        changeGroupNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                changeGroupNameFieldKeyTyped(evt);
            }
        });

        membersListLabel.setText("Members List:");

        membersListArea.setColumns(20);
        membersListArea.setRows(5);
        jScrollPane2.setViewportView(membersListArea);

        addCategoryButton.setText("Add");
        addCategoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    addCategoryButtonMouseClicked(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        removeCategoryButton.setText("Remove");
        removeCategoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    removeCategoryButtonMouseClicked(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        changeGroupNameButton.setText("Change");
        changeGroupNameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeGroupNameButtonMouseClicked(evt);
            }
        });

        membersListDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User 1", "User 2", "User 3", "User 4" }));
        membersListDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersListDropDownActionPerformed(evt);
            }
        });

        removememberButton.setText("Remove");
        removememberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removememberButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addMemberField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(addMember, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(253, 253, 253)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(membersListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(removememberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(membersListDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addedCategoriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addNewCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(removeCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addNewCategoryDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(removeCategoryDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(addCategoryButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(removeCategoryButton)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(changeGroupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(changeGroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(changeGroupNameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupIdValue, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adminControlsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminControlsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(goBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupIdValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMemberField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(membersListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addMember, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addedCategoriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addNewCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changeGroupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(membersListDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removememberButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addNewCategoryDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(addCategoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeCategoryDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeCategoryButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeGroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(changeGroupNameButton)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void addMemberMouseClicked(java.awt.event.MouseEvent evt) {       
        DB.memberAdder(groupID, memberID);                                
        groupCategoriesArea.append("Member Added");        // TODO add your handling code here:
        }                                      
    
        private void addCategoryButtonMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {  
            newChoosenCategory = addNewCategoryDropDown.getSelectedItem().toString();
                DB.categoryAdder(groupID ,newChoosenCategory);
                groupCategoriesArea.setText("");
                removeCategoryDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
                groupCategories = DB.getGroup(groupID).getCategories();
                for (int i = 0 ; i < groupCategories.size(); i++) {
                    groupCategoriesArea.append(groupCategories.get(i) + "\n");
                    removeCategoryDropDown.addItem(groupCategories.get(i));
                }
            JOptionPane.showMessageDialog(null, "ADD CATEGORY");                                             
            // TODO add your handling code here:
        }                                              
                                              
    
        private void changeGroupNameButtonMouseClicked(java.awt.event.MouseEvent evt) {   
            DB.groupNameSetter(groupID, changeGroupNameField.getText());
            currentGroupName = currentGroup.getGroupName();
            JOptionPane.showMessageDialog(null, "CHNAGE G NAME");                                             
                                
            // TODO add your handling code here:
        }                                                  
    
        private void removememberButtonMouseClicked(java.awt.event.MouseEvent evt) {   
            JOptionPane.showMessageDialog(null, "REMVE MEMBER");                                             
    
            // TODO add your handling code here:
        }                                     
    
        private void goBackButtonMouseClicked(java.awt.event.MouseEvent evt) {   
            JOptionPane.showMessageDialog(null, "GO BACK");                                             
                                       
            // TODO add your handling code here:
        }                                         
    
        private void addMemberFieldKeyTyped(java.awt.event.KeyEvent evt) {     
            memberID = Integer.parseInt(addMemberField.getText());
            System.out.println(addMemberField.getText());                                        
                                   
            // TODO add your handling code here:
        }                                       
    
        private void changeGroupNameFieldKeyTyped(java.awt.event.KeyEvent evt) {   
            newGroupName = changeGroupNameField.getText(); 
            System.out.println(newGroupName);
            System.out.println(currentGroupName);
                                                       
            // TODO add your handling code here:
        }                                             
                                          

        private void addNewCategoryDropDownActionPerformed(java.awt.event.ActionEvent evt) {  
            newChoosenCategory = addNewCategoryDropDown.getSelectedItem().toString();
            System.out.println(newChoosenCategory);                                                       
            
        }       

        private void removeCategoryButtonMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {  
            removalChoosenCategory = removeCategoryDropDown.getSelectedItem().toString();
            DB.categoryRemover(4, removalChoosenCategory.trim());
            removeCategoryDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
            groupCategoriesArea.setText("");
            groupCategories = DB.getGroup(groupID).getCategories();
            for (int i = 0 ; i < groupCategories.size(); i++) {
                groupCategoriesArea.append(groupCategories.get(i) + "\n");
                removeCategoryDropDown.addItem(groupCategories.get(i));
            }
            
            JOptionPane.showMessageDialog(null, "REMOVE CATEGORY");                                             
                                              
            // TODO add your handling code here:
        }   

        private void removeCategoryDropDownActionPerformed(java.awt.event.ActionEvent evt) {                                                       
            removalChoosenCategory = removeCategoryDropDown.getSelectedItem().toString();
            System.out.println(removalChoosenCategory);     
        }                                                      
    
        private void membersListDropDownActionPerformed(java.awt.event.ActionEvent evt) {  
            membersListRemoveChoosen = membersListDropDown.getSelectedItem().toString();
            System.out.println(membersListRemoveChoosen);                                              
            // TODO add your handling code here:
        }  



}