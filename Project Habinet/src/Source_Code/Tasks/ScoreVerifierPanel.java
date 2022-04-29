
package Tasks;

import Classes.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ScoreVerifierPanel extends JPanel {

    private javax.swing.JLabel descriptionArea;
    private javax.swing.JButton downVoteButton;
    private javax.swing.JLabel imageArea;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel topScoreLabelnearUser;
    private javax.swing.JLabel topScorerTitle;
    private javax.swing.JButton upVoteButton;
    private javax.swing.JLabel username;
    int userID;
    String taskDescription;
    int taskSerialNumber;

    public ScoreVerifierPanel() {
        initComponents();
    }

    public ScoreVerifierPanel(int userid, int taskSerialNumberin) {
        this.userID = userid;
        this.taskSerialNumber = taskSerialNumberin;
        this.taskDescription = DB.getTaskVerificationDescription(userID, taskSerialNumber);
        initComponents();
    }

    private void downVoteButtonMouseClicked(java.awt.event.MouseEvent evt) {

        int oldDownVotes = DB.getTaskDownVotes(userID, taskSerialNumber);
        DB.changeTaskDownVotes(userID, taskSerialNumber, oldDownVotes + 1);
        JOptionPane.showMessageDialog(null, "You have DOWN VOTED");
        // TODO add your handling code here:
    }

    private void upVoteButtonMouseClicked(java.awt.event.MouseEvent evt) {

        int oldUpVotes = DB.getTaskUpVotes(userID, taskSerialNumber);
        DB.changeTaskUpVotes(userID, taskSerialNumber, oldUpVotes + 1);
        JOptionPane.showMessageDialog(null, "You have UP VOTED");
        // TODO add your handling code here:
    }

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Going Back");
        // TODO add your handling code here:
    }

    private void initComponents() {

        backButton = new javax.swing.JButton();
        topScorerTitle = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        upVoteButton = new javax.swing.JButton();
        downVoteButton = new javax.swing.JButton();
        imageArea = new javax.swing.JLabel();
        descriptionArea = new javax.swing.JLabel();
        topScoreLabelnearUser = new javax.swing.JLabel();

        this.setPreferredSize(new java.awt.Dimension(962, 800));
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setText("<-- Go Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        this.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, 40));

        topScorerTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        topScorerTitle.setText("Top Scorer Verification");
        this.add(topScorerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 370, 50));

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username.setText("userX");
        this.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 70, 40));

        upVoteButton.setText("UP VOTE");
        upVoteButton.setBackground(new java.awt.Color(153, 255, 153));
        upVoteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        upVoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/upVote.png")));
        upVoteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upVoteButtonMouseClicked(evt);
            }
        });
        this.add(upVoteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 610, 90, 80));

        downVoteButton.setBackground(new java.awt.Color(255, 51, 51));
        downVoteButton.setText("jButton2");
        downVoteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        downVoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/downVote.png")));
        downVoteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downVoteButtonMouseClicked(evt);
            }
        });
        this.add(downVoteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 90, 80));
        username.setText("user:" + userID);
        imageArea.setText("");
        imageArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/upVote.png")));
        imageArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        this.add(imageArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 430, 370));

        descriptionArea.setText(taskDescription);
        descriptionArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        this.add(descriptionArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 430, 370));

        topScoreLabelnearUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        topScoreLabelnearUser.setText("Top Scorer");
        this.add(topScoreLabelnearUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 40));

    }

}
