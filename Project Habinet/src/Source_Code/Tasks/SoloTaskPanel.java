package Tasks;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class SoloTaskPanel extends JPanel {
    String taskTitleInput;
    LocalDate startDateInput;
    LocalDate dueDateInput;
    String categoryInput;
    LocalTime startTimeInput;
    LocalTime dueTimeInput;
    String priorityInput;
    int userID;
    private javax.swing.JButton addTaskButton;
    private javax.swing.JLabel addTaskTitle;
    private javax.swing.JLabel category;
    private javax.swing.JComboBox<String> chooseACateogryDropDrown;
    private javax.swing.JLabel dueDate;
    private com.toedter.calendar.JDateChooser dueDateChooser;
    private javax.swing.JComboBox<String> dueTimeChooser;
    private javax.swing.JLabel dueTimeText;
    private javax.swing.JComboBox<String> priorityComboBox;
    private javax.swing.JLabel priority;
    private javax.swing.JLabel startDate;
    private javax.swing.JButton previousPageButton;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JComboBox<String> startTimeChooser;
    private javax.swing.JLabel startTimeText;
    private javax.swing.JLabel taskGroupPointDescription;
    private javax.swing.JLabel taskGroupPointDescription1;
    private javax.swing.JTextArea taskGroupPointList;
    private javax.swing.JScrollPane taskGroupPointListScrollPane;
    private javax.swing.JLabel taskTitle;
    private javax.swing.JTextField taskTitleTextField;
    private javax.swing.JLabel xpRewardNumber;

    public SoloTaskPanel(User user) {
        this.userID = user.getProfileID();
        initComponents();
    }

    public SoloTaskPanel() {

        initComponents();
    }

    private void resetAllFields() {
        chooseACateogryDropDrown.setSelectedIndex(0);
        priorityComboBox.setSelectedIndex(0);
        startTimeChooser.setSelectedIndex(0);
        dueTimeChooser.setSelectedIndex(0);
        taskTitleTextField.setText("");
        this.repaint();
    }

    private static boolean atLeastOneInThePast(LocalDate from, LocalDate until) {
        LocalDate today = LocalDate.now();
        return today.isAfter(from) || today.isAfter(until);
    }

    private void chooseACateogryDropDrownItemStateChanged(java.awt.event.ItemEvent evt) {
        categoryInput = chooseACateogryDropDrown.getSelectedItem().toString();

        // TODO add your handling code here:
    }

    private void startTimeChooserItemStateChanged(java.awt.event.ItemEvent evt) {

        startTimeInput = LocalTime.parse(startTimeChooser.getSelectedItem().toString());

        // TODO add your handling code here:
    }

    private void dueTimeChooserItemStateChanged(java.awt.event.ItemEvent evt) {

        dueTimeInput = LocalTime.parse(dueTimeChooser.getSelectedItem().toString());

        // TODO add your handling code here:
    }

    private void priorityComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        priorityInput = priorityComboBox.getSelectedItem().toString();
        if (priorityComboBox.getSelectedIndex() == 0) {
            xpRewardNumber.setText("0");
            this.repaint();
        }

        if (priorityComboBox.getSelectedIndex() == 1) {
            xpRewardNumber.setText("30");
            this.repaint();
        }
        if (priorityComboBox.getSelectedIndex() == 2) {
            xpRewardNumber.setText("20");
            this.repaint();
        }
        if (priorityComboBox.getSelectedIndex() == 3) {
            xpRewardNumber.setText("10");
            this.repaint();
        }

        // TODO add your handling code here:
    }

    private void taskTitleTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        taskTitleInput = taskTitleTextField.getText();

        // TODO add your handling code here:
    }

    private void startDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {
        startDateInput = LocalDate.parse(((JTextField) startDateChooser.getDateEditor().getUiComponent()).getText());

        // TODO add your handling code here:
    }

    private void dueDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {
        dueDateInput = LocalDate.parse(((JTextField) dueDateChooser.getDateEditor().getUiComponent()).getText());

        // TODO add your handling code here:
    }

    private void addTaskButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (atLeastOneInThePast(startDateInput, dueDateInput) || taskTitleTextField.getText().equals("")
                || priorityComboBox.getSelectedIndex() == 0 || chooseACateogryDropDrown.getSelectedIndex() == 0
                || startTimeChooser.getSelectedIndex() == 0 || dueTimeChooser.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(null, "Please choose a valid input");
        } else {
                
                taskTitleInput = taskTitleTextField.getText();
            JOptionPane.showMessageDialog(null, "Task Added");
            DB.addToTaskTable(userID, taskTitleInput, priorityInput, startDateInput, dueDateInput, startTimeInput,
                    dueTimeInput, false, categoryInput, null, null, Integer.parseInt(xpRewardNumber.getText()));
            resetAllFields();
        }

        System.out.println("ADD TASK BUTTON CLICKED");
        // TODO add your handling code here:
    }

    private void previousPageButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    public void initComponents() {

        addTaskTitle = new javax.swing.JLabel();
        startDate = new javax.swing.JLabel();
        addTaskButton = new javax.swing.JButton();
        taskTitle = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        dueDate = new javax.swing.JLabel();
        dueDateChooser = new com.toedter.calendar.JDateChooser();
        priority = new javax.swing.JLabel();
        priorityComboBox = new javax.swing.JComboBox<>();
        category = new javax.swing.JLabel();
        taskGroupPointDescription1 = new javax.swing.JLabel();
        taskTitleTextField = new javax.swing.JTextField();
        startTimeText = new javax.swing.JLabel();
        chooseACateogryDropDrown = new javax.swing.JComboBox<>();
        startTimeChooser = new javax.swing.JComboBox<>();
        taskGroupPointDescription = new javax.swing.JLabel();
        dueTimeText = new javax.swing.JLabel();
        taskGroupPointListScrollPane = new javax.swing.JScrollPane();
        taskGroupPointList = new javax.swing.JTextArea();
        dueTimeChooser = new javax.swing.JComboBox<>();
        xpRewardNumber = new javax.swing.JLabel();
        previousPageButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(962, 800));

        this.setPreferredSize(new java.awt.Dimension(962, 800));

        addTaskTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        addTaskTitle.setText("Add Tasks");
        addTaskTitle.setOpaque(true);

        startDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startDate.setText("Start Date");

        addTaskButton.setBackground(new java.awt.Color(102, 255, 102));
        addTaskButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addTaskButton.setText("Add Task");
        addTaskButton.setBorderPainted(false);
        addTaskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTaskButtonMouseClicked(evt);
            }
        });

        taskTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        taskTitle.setText("Task Title");

        startDateChooser.setDateFormatString("yyyy-MM-dd");
        startDateChooser.setDate(Date.valueOf(LocalDate.now()));
        startDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startDateChooserPropertyChange(evt);
            }
        });

        dueDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dueDate.setText("Due Date");

        dueDateChooser.setDateFormatString("yyyy-MM-dd");
        dueDateChooser.setDate(Date.valueOf(LocalDate.now()));
        dueDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dueDateChooserPropertyChange(evt);
            }
        });

        priority.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priority.setText("Priority");

        priorityComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a priority", "High", "Medium", "Low" }));
        priorityComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                priorityComboBoxItemStateChanged(evt);
            }
        });

        category.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        category.setText("Category");

        taskGroupPointDescription1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taskGroupPointDescription1.setText("Task will give points in the following groups:");

        taskTitleTextField.setToolTipText("Task Title");
        taskTitleTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taskTitleTextFieldKeyTyped(evt);
            }
        });

        startTimeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startTimeText.setText("Start Time");

        chooseACateogryDropDrown.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Choose a category", "Maths", "Science", "English", "Physics" }));
        chooseACateogryDropDrown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chooseACateogryDropDrownItemStateChanged(evt);
            }
        });

        startTimeChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a time", "00:00:00",
                "00:30:00", "01:00:00", "01:30:00", "02:00:00", "02:30:00", "03:00:00", "03:30:00", "04:00:00",
                "04:30:00", "05:00:00", "05:30:00", "06:00:00", "06:30:00", "07:00:00", "07:30:00", "08:00:00",
                "08:30:00", "09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00",
                "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00",
                "16:30:00", "17:00:00", "17:30:00", "18:00:00", "18:30:00", "19:00:00", "19:30:00", "20:00:00",
                "20:30:00", "21:00:00", "21:30:00", "22:00:00", "22:30:00", "23:00:00", "23:30:00" }));
        startTimeChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                startTimeChooserItemStateChanged(evt);
            }
        });

        taskGroupPointDescription.setText("XP with this priority rewarded");

        dueTimeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dueTimeText.setText("Due Time");

        taskGroupPointList.setEditable(false);
        taskGroupPointList.setColumns(20);
        taskGroupPointList.setRows(5);
        taskGroupPointListScrollPane.setViewportView(taskGroupPointList);

        dueTimeChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a time", "00:00:00",
                "00:30:00", "01:00:00", "01:30:00", "02:00:00", "02:30:00", "03:00:00", "03:30:00", "04:00:00",
                "04:30:00", "05:00:00", "05:30:00", "06:00:00", "06:30:00", "07:00:00", "07:30:00", "08:00:00",
                "08:30:00", "09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00",
                "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00",
                "16:30:00", "17:00:00", "17:30:00", "18:00:00", "18:30:00", "19:00:00", "19:30:00", "20:00:00",
                "20:30:00", "21:00:00", "21:30:00", "22:00:00", "22:30:00", "23:00:00", "23:30:00" }));
        dueTimeChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dueTimeChooserItemStateChanged(evt);
            }
        });

        xpRewardNumber.setText("0");
        previousPageButton.setText("<-- Home");
        previousPageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousPageButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29)
                        .addComponent(previousPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196).addComponent(addTaskTitle).addGap(76, 76, 76))
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(137, 137, 137).addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(taskGroupPointDescription1)
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(taskGroupPointListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                .createSequentialGroup()
                                                .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(137, 137, 137))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                .createSequentialGroup()
                                                .addComponent(xpRewardNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(taskGroupPointDescription).addGap(35, 35, 35))))))
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(141, 141, 141).addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dueDate).addComponent(taskTitle))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dueDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 251,
                                                Short.MAX_VALUE)
                                        .addComponent(taskTitleTextField)))
                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(startDate).addGap(41, 41, 41)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(105, 105, 105)
                        .addGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(category).addComponent(startTimeText)
                                                        .addComponent(dueTimeText).addComponent(priority))
                                                .addGap(42, 42, 42)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(startTimeChooser, 0, 115, Short.MAX_VALUE)
                                                        .addComponent(dueTimeChooser, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(125, 125, 125)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(chooseACateogryDropDrown,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(priorityComboBox,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(73, 73, 73)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addTaskTitle).addComponent(previousPageButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chooseACateogryDropDrown, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(taskTitle)
                                        .addComponent(taskTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(category)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startTimeText).addComponent(startTimeChooser,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(startDate).addComponent(startDateChooser,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(23, 23, 23)
                                        .addComponent(dueDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(taskGroupPointDescription1).addComponent(priority)
                                                .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1)
                                                        .addComponent(dueDate))
                                                .addComponent(dueTimeChooser, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dueTimeText))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(taskGroupPointDescription).addComponent(xpRewardNumber))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(taskGroupPointListScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 175,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(266, Short.MAX_VALUE)));

    }

}