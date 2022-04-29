
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import Classes.*;
import GroupChat.ChatPanel;
import Help.HelpPanel;
import Menu.Menu;
import Overview.OverviewPanel;
import Settings.SettingsPanel;
import Tasks.*;

/**
 * Program Description 
 * @author Maher Athar Ilyas
 * @version 24.04.2021
*/ 
public class test
{
    public static void main(String[] args) throws SQLException
    {
        
        
        // Constants

        //  JFrame frame = new JFrame(); 
          
        //   frame.add(new SettingsPanel(DB.getUser(8)), BorderLayout.CENTER);
        //   frame.add(new Menu(DB.getUser(8)), BorderLayout.WEST);

        User u = new User("OldUser", "habinet", "olduser@bilkent.edu.tr", "STRICT", 1, 800, 30, 3);
    
        

        //   frame.setSize(1280, 800);
        //   frame.setTitle("Login Page");
        //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //   frame.setVisible(true);     

        //DB.getAllGroupsofUser(1);

        //DB.memberRemover(memberID, groupId);
         

         //Group g = new Group("name", DB.getUser(1),null, null);
        //System.out.println(DB.us);
         

        // new User("Tasks", "t", "t", "STRICT", 34, 2, 4, 6);




        
    }

  


    

}