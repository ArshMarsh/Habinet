package Classes;

import javax.swing.ImageIcon;

/**
 * TaskVerifying class for verifying the tasks if the user who completes it is a
 * top scorer
 * 
 * @author Muhammad Ali Waris
 * @version
 */

public class TaskVerifiable extends Task {
    int upVote;
    int downVote;
    String imageLocation;
    ImageIcon imageVerify;
    String taskDescription;
    int userId = super.taskOwner.getProfileID();

    public TaskVerifiable() {
        this.upVote = 0;
        this.downVote = 0;

    }

    public TaskVerifiable(String imageLocation) {
        this.upVote = 0;
        this.downVote = 0;
        this.imageLocation = imageLocation;
    }

    public void incUpVotes(int taskSerialNumber) {
        int currentUpvotes = DB.getTaskUpVotes(userId, taskSerialNumber);
        DB.changeTaskUpVotes(userId, taskSerialNumber, currentUpvotes + 1);
        this.upVote++;
    }

    public int getUpVotes(int taskSerialNumber) {
        return DB.getTaskUpVotes(userId, taskSerialNumber);
    }

    public void incDownVotes(int taskSerialNumber) {
        int currentDownvotes = DB.getTaskDownVotes(userId, taskSerialNumber);
        DB.changeTaskDownVotes(userId, taskSerialNumber, currentDownvotes + 1);
        this.downVote++;
    }

    public int getDownVotes(int taskSerialNumber) {
        return DB.getTaskDownVotes(userId, taskSerialNumber);

    }

    public boolean getStatus(int taskSerialNumber) {
        return DB.getTaskCurrentStatus(userId, taskSerialNumber);
    }

    public void setStatus(int taskSerialNumber, boolean newStatus) {
        DB.changeTaskCurrentStatus(userId, taskSerialNumber, newStatus);
        this.status = newStatus;
    }

    public void setImage(int taskSerialNumber, ImageIcon newImage) {
        this.imageVerify = newImage;
    }

    public void setImageLocation(int taskSerialNumber, String newImageLocation) {
        // DB.changeTaskVerificationImageLocation(userId, taskSerialNumber,
        // newImageLocation);

    }

    public void getImageLocation(int taskSerialNumber) {
        DB.getTaskVerificationImageLocation(userId, taskSerialNumber);

    }

    public void setDescription(int taskSerialNumber, String newVerificationDescription) {
        DB.changeTaskVerificationDescription(userId, taskSerialNumber, newVerificationDescription);
        this.taskDescription = newVerificationDescription;
    }

    public String getDescription(int taskSerialNumber) {
        return DB.getTaskVerificationDescription(userId, taskSerialNumber);
    }

}