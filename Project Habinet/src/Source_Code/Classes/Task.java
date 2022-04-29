package Classes;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

/**
 * Task class for tasks implimentation and all related functions
 * 
 * @author Muhammad Ali Waris
 * @version
 */

// Another class should automatically make the Task Table when user registers
// Apparently in the main class, there should be a method comparing the local
// date and time with the due date and time for all the tasks
public class Task implements Notification {

    String title;
    int taskCount;
    String priority;
    LocalDate startDate;
    User taskOwner;
    int taskOwnerUserID;
    LocalDate dueDate;
    LocalTime startTime;
    LocalTime dueTime;
    Boolean status;
    String category;
    Boolean needsVerification;
    Boolean isVerified;
    public int xpReward;
    LocalDate dateRightNow = LocalDate.now();
    LocalTime timeRightNow = LocalTime.now();
    int upVote;
    int downVote;
    String imageLocation;
    ImageIcon imageVerify;
    String taskDescription;
    public int serialNum;

    public Task() {

    }

    public Task(User user, String title, String priority, LocalDate startDate, LocalTime startTime, LocalDate dueDate,
            LocalTime dueTime, String category) {
        this.setTitle(title);
        this.taskOwner = user;
        this.setPriority(priority);
        this.setCategory(category);
        this.setStartDate(startDate);
        this.setDueDate(dueDate);
        this.setStartTime(startTime);
        this.setDueTime(dueTime);

    }

    public Task(int serialNum, int userId, String title, String priority, LocalDate startDate, LocalDate dueDate,
            LocalTime startTime, LocalTime dueTime, Boolean status, String category, Boolean needsVerification,
            Boolean isVerified, int xpReward, int upVote, int downVote, String verificationImageLocation,
            String taskDescription) {
        this.serialNum = serialNum;
        this.setTitle(title);
        this.taskOwnerUserID = userId;
        this.setPriority(priority);
        this.setCategory(category);
        this.setStartDate(startDate);
        this.setDueDate(dueDate);
        this.setStartTime(startTime);
        this.setDueTime(dueTime);
        this.status = status;
        this.category = category;
        this.needsVerification = needsVerification;
        this.isVerified = isVerified;
        this.xpReward = xpReward;
        this.upVote = upVote;
        this.downVote = downVote;
        this.imageLocation = verificationImageLocation;
        this.taskDescription = taskDescription;

    }

    public Task(Boolean isNewTask, User user, String title, String priority, LocalDate startDate, LocalTime startTime,
            LocalDate dueDate, LocalTime dueTime, String category) {
        this.setTitle(title);
        this.taskOwner = user;
        this.setPriority(priority);
        this.setCategory(category);
        this.setStartDate(startDate);
        this.setDueDate(dueDate);
        this.setStartTime(startTime);
        this.setDueTime(dueTime);
        this.taskCount++;
        if (DB.checkIfTaskTableExistsForUser(user.getProfileID()) == false) {
            createTaskTableDB(user.getProfileID());
        }
        DB.addToTaskTable(user.getProfileID(), title, priority, startDate, dueDate, startTime, dueTime, false, category,
                null, null, 0);

    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(int taskID, String newTitle) {
        DB.changeTaskTitle(taskOwner.getProfileID(), taskID, newTitle);
        this.title = newTitle;
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalTime getTime() {
        return dueTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDueTime(LocalTime dueTime) {
        this.dueTime = dueTime;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean newStatus) {
        this.status = newStatus;
    }

    public void setStatus(int taskID, Boolean newStatus) {
        DB.changeTaskCurrentStatus(taskOwner.getProfileID(), taskID, newStatus);
        this.status = newStatus;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public void setCategory(int taskID, String newCategory) {
        DB.changeTaskCategory(taskOwner.getProfileID(), taskID, newCategory);
        this.category = newCategory;
    }

    public String getCategory(int taskID) {
        return DB.getTaskCategory(taskOwner.getProfileID(), taskID);
    }

    public String getCategory() {
        return this.category;
    }

    public void setPriority(String newPriority) {
        this.priority = newPriority;
    }

    public void setPriority(int taskID, String newPriority) {
        DB.changeTaskPriority(taskOwner.getProfileID(), taskID, newPriority);
        this.priority = newPriority;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getPriority(int taskID) {
        return DB.getTaskPriority(taskOwner.getProfileID(), taskID);
    }

    public void notifyUser() {
        String color;
        if (this.getPriority().equals("urgent")) {
            color = "red";
        } else {
            color = "white";
        }
        DB.addNotification(taskOwner.getProfileID(), "New Task Added title: " + title, color, "pageOnClick");

    }

    public void notifyUser(User userToBeNotified) {
        int userID = userToBeNotified.getProfileID();
        String color;
        if (this.getPriority().equals("urgent")) {
            color = "red";
        } else {
            color = "white";
        }
        DB.addNotification(userID, "New Task Added title: " + title, color, "pageOnClick");

    }

    public void createTaskTableDB(int userID) {
        DB.createTaskTable(userID); // This line is for a class that registers a new user
    }

    // Should be in the user class tho
    public void groupCheck(ArrayList<Group> groupName) {
        // get array of all the groups the user is in
        for (int i = 0; i < groupName.size(); i++) {
            User currentUserInstance = taskOwner;
            User topScorer = groupName.get(i).getTopScorer();

            for (int x = 0; x < groupName.get(i).getCategories().size(); x++) {
                ArrayList<String> categories = groupName.get(i).getCategories();

                if (this.category == categories.get(x)) {
                    if (currentUserInstance == topScorer) {
                        this.needsVerification = true;
                        this.isVerified = false;
                    }
                }
            }

        }

    }

}