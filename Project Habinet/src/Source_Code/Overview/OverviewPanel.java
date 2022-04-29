package Overview;

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
import Classes.User;

/**
 *
 * @author Maher Athar Ilyas
 */
public class OverviewPanel extends JPanel {

    private JComboBox<String> Activities;
    private JComboBox<String> TimeRange;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JComboBox<String> yType;
    private User user;
    private String yAxis ;
    private String categories ;
    private String time  ;

    /**
     * Creates new form OverViewPanel
     */
    public OverviewPanel(User user) {
        this.user = user; 
        initComponents();
        
    }
                        
    private void initComponents() {

        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jPanel1 = new JPanel();
        TimeRange = new JComboBox<>();
        Activities = new JComboBox<>();
        yType = new JComboBox<>();
        jButton2 = new JButton();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(918, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("             Overview");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("<-- Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jPanel1.removeAll();
                jPanel1.repaint();
                
                yAxis = (String) yType.getSelectedItem();
                categories = (String) Activities.getSelectedItem();
                time = (String) TimeRange.getSelectedItem();
       
               if (yAxis.equals("-- Choose Graph Type --")){            
                   JOptionPane.showMessageDialog(null, "Choose \"Graph Type\" before generating Graph" );
               }
               else if ( categories.equals("-- Choose Categories --")){
                   JOptionPane.showMessageDialog(null, "Choose \"Categories\" before generating Graph" );
               }
               else if (time.equals("-- Choose Time Range --")){
                   JOptionPane.showMessageDialog(null, "Choose \"Time Range\" before generating Graph" );
               }
               else{
                   generateGraph();
               }

            }
        });

        jPanel1.setBackground(java.awt.Color.lightGray);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        TimeRange.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TimeRange.setModel(new DefaultComboBoxModel<>(new String[] { "-- Choose Time Range --", "Last 7 days", "Last 14 days", "Last 21 days", "Last 30 days", " " }));


        Activities.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Activities.setModel(new DefaultComboBoxModel<>(new String[] { "-- Choose Categories --", "All Categories", "Excercise", "Programming", "Reading" }));
  

        yType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        yType.setModel(new DefaultComboBoxModel<>(new String[] { "-- Choose Graph Type --", "According to Time", "According to Score"}));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Generate Graph");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(TimeRange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Activities, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(yType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TimeRange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Activities, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(yType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );


        jButton1.setVisible(false);
        
     }                            
    
    public void generateGraph(){

        DefaultCategoryDataset dcd = new  DefaultCategoryDataset();

        LocalDate today = LocalDate.now();

        String key;
        String categoryAxisLabel;
        int daysCount;
        int ran;

        if (yAxis.equals("According to Time") ) {
            categoryAxisLabel = "Minutes";
            key = "Minutes";
            ran = 500;
        }
        else{
            categoryAxisLabel = "Score / xp";
            key = "XP" ;
            ran = 120;
        }

        if (time.equals("Last 30 days"))   {
            daysCount = 30;
            
        }
        else if (time.equals("Last 14 days")) {
            daysCount = 14;
        }
        else if (time.equals("Last 21 days"))  {
            daysCount = 21;
        }
        else  {
            daysCount = 7;
        }   

        String[] days = new String[daysCount];

        for (int i = 0; i < days.length; i++) {

            today = today.minusDays(1);
            days[i] = today.toString();
            dcd.setValue((int) (Math.random() * ran), key , days[i]);
        }

        JFreeChart jChart = ChartFactory.createBarChart( categories, "Days" , categoryAxisLabel, dcd, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        // ((BarRenderer)plot.getRenderer()).setBarPainter(new StandardBarPainter());
        // BarRenderer r = (BarRenderer)jChart.getCategoryPlot().getRenderer();
        // r.setSeriesPaint(0, new Color(127,255,0));

        ChartPanel chartfrm = new ChartPanel(jChart, true);

        chartfrm.setVisible(true);
        chartfrm.setSize(804, 476);         

        jPanel1.add(chartfrm);

        jPanel1.repaint();
    }              
}
