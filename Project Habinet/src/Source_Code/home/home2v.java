package home;

import Classes.User;
import Menu.Menu;
import Overview.OverviewPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author AmirrezaKhoshbakht
 */
public class home2v extends javax.swing.JPanel {

        User user;

        /**
         * Creates new form home2v
         */
        public home2v(User user) {
                this.user = user;
                initComponents();
        }

        private void initComponents() {

                headerPanel = new javax.swing.JPanel();
                profileLabel = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                task1 = new javax.swing.JCheckBox();
                task2 = new javax.swing.JCheckBox();
                task3 = new javax.swing.JCheckBox();
                task1groups = new javax.swing.JLabel();
                task2groups = new javax.swing.JLabel();
                task3groups = new javax.swing.JLabel();
                task3DueDate = new javax.swing.JLabel();
                task2DueDate = new javax.swing.JLabel();
                task1DueDate = new javax.swing.JLabel();
                editTask1 = new javax.swing.JButton();
                editTask2 = new javax.swing.JButton();
                editTask3 = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jPanel3 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();

                profileLabel.setFont(new java.awt.Font("Times New Roman", 3, 24)); 
                profileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                profileLabel.setText("Home");

                javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
                headerPanel.setLayout(headerPanelLayout);
                headerPanelLayout.setHorizontalGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup().addGap(182, 182, 182)
                                                .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 613,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                headerPanelLayout.setVerticalGroup(
                                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(headerPanelLayout.createSequentialGroup()
                                                                .addComponent(profileLabel)
                                                                .addGap(0, 17, Short.MAX_VALUE)));

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setText("Upcoming Tasks");

                task1.setBackground(new java.awt.Color(255, 255, 0));
                task1.setText("No Task");
                if (user.taskList.size() != 0) {
                        task1.setText(user.taskList.get(0).getTitle() + ", xp: " + user.taskList.get(0).xpReward);
                }
                task1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                task1ActionPerformed(evt);
                        }
                });

                task2.setBackground(new java.awt.Color(255, 102, 51));
                task2.setText("No Task");
                if (user.taskList.size() > 1) {
                        task2.setText(user.taskList.get(1).getTitle() + ", xp: " + user.taskList.get(1).xpReward);
                }
                task2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                task2ActionPerformed(evt);
                        }
                });

                task3.setBackground(new java.awt.Color(255, 102, 51));
                task3.setText("No Task");
                if (user.taskList.size() > 2) {
                        task3.setText(user.taskList.get(2).getTitle() + ", xp: " + user.taskList.get(2).xpReward);
                }
                task3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                task3ActionPerformed(evt);
                        }
                });

                task1groups.setText("No Data");
                if (user.taskList.size() != 0) {
                        task1groups.setText(user.taskList.get(0).getCategory());
                }

                task2groups.setText("No Data");
                if (user.taskList.size() > 1) {
                        task2groups.setText(user.taskList.get(1).getCategory());
                }

                task3groups.setText("No Data");
                if (user.taskList.size() > 2) {
                        task3groups.setText(user.taskList.get(2).getCategory());
                }

                task3DueDate.setText("No Data");
                if (user.taskList.size() > 2) {
                        task3DueDate.setText(user.taskList.get(2).getDate().toString() + ", "
                                        + user.taskList.get(2).getTime().toString());
                }

                task2DueDate.setText("No Data");
                if (user.taskList.size() > 1) {
                        task2DueDate.setText(user.taskList.get(1).getDate().toString() + ", "
                                        + user.taskList.get(1).getTime().toString());
                }

                task1DueDate.setText("No Data");
                if (user.taskList.size() != 0) {
                        task1DueDate.setText(user.taskList.get(0).getDate().toString() + ", "
                                        + user.taskList.get(0).getTime().toString());
                }

                editTask1.setText("Edit");
                editTask1.setBorder(null);

                editTask2.setText("Edit");
                editTask2.setBorder(null);

                editTask3.setText("Edit");
                editTask3.setBorder(null);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(task2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                184,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(task1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                176,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(task3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                178,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(308, 308, 308)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(task2groups,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                82,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(task1groups,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                101,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(task3groups,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                76,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(43, 43, 43)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(task3DueDate,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                119,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(12, 12, 12))
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(task2DueDate,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGap(5, 5, 5))
                                                                                                                .addComponent(task1DueDate,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                131,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(120, 120, 120)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(editTask1)
                                                                                                .addComponent(editTask2)
                                                                                                .addComponent(editTask3))))
                                                .addGap(38, 38, 38)));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(task1).addComponent(task1DueDate)
                                                                .addComponent(task1groups).addComponent(editTask1))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(task2groups)
                                                                                .addComponent(task2DueDate)
                                                                                .addComponent(editTask2))
                                                                .addComponent(task2))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(task3)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(task3groups)
                                                                                .addComponent(task3DueDate)
                                                                                .addComponent(editTask3)))
                                                .addContainerGap(69, Short.MAX_VALUE)));

                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setText("Last 30 Days Performance");

                jButton1.setBackground(new java.awt.Color(51, 255, 0));
                jButton1.setText("More Details >");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1).addGap(31, 31, 31)));
                jPanel2Layout.setVerticalGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12)
                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel2).addComponent(jButton1))
                                                .addContainerGap(180, Short.MAX_VALUE)));

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setText("Recent Updates");

                jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jLabel4.setText("You've just finished an important Task!");

                jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jLabel5.setText("You left a group!");

                jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jLabel6.setText("You Ranked Up!");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3)
                                                .addGap(32, 32, 32).addComponent(jLabel4).addGap(36, 36, 36)
                                                .addComponent(jLabel5).addGap(32, 32, 32).addComponent(jLabel6)
                                                .addContainerGap(59, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                                

                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                gotoOverview();
                        }
                });

                generateGraph();
        }
        public void generateGraph(){

                DefaultCategoryDataset dcd = new  DefaultCategoryDataset();
        
                LocalDate today = LocalDate.now();
        
                String key;
                String categoryAxisLabel;
                int daysCount;
                int ran;
        
                    categoryAxisLabel = "Score / xp";
                    key = "XP" ;
                    ran = 120;                
        
                    daysCount = 20;                
       
        
                String[] days = new String[daysCount];
        
                for (int i = 0; i < days.length; i++) {
        
                    today = today.minusDays(1);
                    days[i] = today.toString();
                    dcd.setValue((int) (Math.random() * ran), key , days[i]);
                }
        
                JFreeChart jChart = ChartFactory.createBarChart( "All Categories", "Days" , categoryAxisLabel, dcd, PlotOrientation.VERTICAL, true, true, false);
        
                CategoryPlot plot = jChart.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.BLACK);
        
                ChartPanel chartfrm = new ChartPanel(jChart, true);
        
                chartfrm.setVisible(true);
                chartfrm.setSize(918, 218); 
     
        
                jPanel2.add(chartfrm);
        
                jPanel2.repaint();
            } 

        private void task1ActionPerformed(java.awt.event.ActionEvent evt) {
                if (user.taskList.size() != 0) {
                        user.completeTask(user.taskList.get(0));
                        this.removeAll();
                        initComponents();
                        repaint();
                        revalidate();
                        JOptionPane.showMessageDialog(null, "Task Completed!!");
                }
        }

        private void task2ActionPerformed(java.awt.event.ActionEvent evt) {
                if (user.taskList.size() > 1) {
                        user.completeTask(user.taskList.get(1));
                        this.removeAll();
                        initComponents();
                        repaint();
                        revalidate();
                        JOptionPane.showMessageDialog(null, "Task Completed!!");
                }
        }

        private void task3ActionPerformed(java.awt.event.ActionEvent evt) {

                if (user.taskList.size() > 2) {
                        user.completeTask(user.taskList.get(2));
                        this.removeAll();
                        initComponents();
                        repaint();
                        revalidate();
                        JOptionPane.showMessageDialog(null, "Task Completed!!");
                }

        }

        private void gotoOverview() {

                JPanel otherPanel = new OverviewPanel(user);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

                Container contain = frame.getContentPane();
                contain.removeAll();
                contain.add(new Menu(user), BorderLayout.WEST);
                contain.add(otherPanel, BorderLayout.CENTER);
                contain.revalidate();
                contain.setVisible(true);

        }

        private javax.swing.JButton editTask1;
        private javax.swing.JButton editTask2;
        private javax.swing.JButton editTask3;
        private javax.swing.JPanel headerPanel;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JLabel profileLabel;
        private javax.swing.JCheckBox task1;
        private javax.swing.JLabel task1DueDate;
        private javax.swing.JLabel task1groups;
        private javax.swing.JCheckBox task2;
        private javax.swing.JLabel task2DueDate;
        private javax.swing.JLabel task2groups;
        private javax.swing.JCheckBox task3;
        private javax.swing.JLabel task3DueDate;
        private javax.swing.JLabel task3groups;
}
