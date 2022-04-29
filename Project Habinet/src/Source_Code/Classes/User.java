package Classes;

import java.util.ArrayList;

/**
 * User class
 * 
 * @author Amirreza KHoshbakht 22001198
 * @version 04.23.2021
 */
public class User {
    private String username, password, email, mode;
    public int level, xp, streak, streakFreezeCount;
    public int myID;
    private ArrayList<String> badges;
    public ArrayList<Group> groups;
    public ArrayList<Task> taskList;
    public ArrayList<Task> completedTasks;
    private boolean notifEnable;

    /**
     * Constructor for new user with saving the user to DB
     * 
     * @param username
     * @param password
     * @param email
     * @param mode
     * @param level
     * @param xp
     * @param streak
     * @param streakFreezeCount
     */
    public User(String username, String password, String email, String mode, int level, int xp, int streak,
            int streakFreezeCount) {
        myID = DB.userIdGenerator();
        this.username = username;
        this.password = password;
        this.email = email;
        this.mode = mode;
        this.level = level;
        this.xp = xp;
        this.streak = streak;
        notifEnable = true;
        this.streakFreezeCount = streakFreezeCount;
        groups = new ArrayList<>();
        taskList = new ArrayList<>();
        completedTasks = new ArrayList<>();
        DB.createGroupTable(myID);
        DB.createTaskTable(myID);
        DB.add(myID, username, password, email, level, xp, streak, streakFreezeCount, mode);
    }

    public User() {

    }

    /**
     * Constructor for creating an existing user with the values from DB
     * 
     * @param username
     * @param password
     * @param email
     * @param mode
     * @param level
     * @param xp
     * @param streak
     * @param streakFreezeCount
     * @param temp
     */
    public User(String username, String password, String email, String mode, int level, int xp, int streak,
            int streakFreezeCount, boolean temp) {
        myID = 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mode = mode;
        this.level = level;
        this.xp = xp;
        this.streak = streak;
        notifEnable = true;
        this.streakFreezeCount = streakFreezeCount;
        groups = new ArrayList<>();
        taskList = new ArrayList<>();
        completedTasks = new ArrayList<>();
    }

    /**
     * Constructor for checking user/pass of an existing user and creating the user
     * from DB
     * 
     * @param user
     * @param pass
     */
    public User(String user, String pass) {
        myID = DB.getID(user, pass);
        User a = DB.getUser(myID);
        username = a.username;
        password = a.password;
        email = a.email;
        mode = a.mode;
        level = a.level;
        xp = a.xp;
        streak = a.streak;
        streakFreezeCount = a.streakFreezeCount;
        badges = a.badges;
        // taskList = a.taskList;
        completedTasks = a.completedTasks;
        groups = a.groups;
        taskList = DB.getAllUserTasks(myID);
        completedTasks = DB.getAllUserCompletedTasks(myID);
        groups = DB.getAllGroupsofUser(myID);
    }
    public void setPassword(String pass) {
        DB.changeValue(pass, myID, "pass");
        password = pass;
    }

    public String getPassword() {
        return DB.getValue(myID, "pass");
    }

    public void setUsername(String user) {
        DB.changeValue(user, myID, "user");
        username = user;
    }

    public String getUsername() {
        return DB.getValue(myID, "user");

    }

    public String getEmail() {
        return DB.getValue(myID, "mail");
    }

    public void setEmail(String mail) {
        DB.changeValue(mail, myID, "mail");
        email = mail;
    }

    public void incStreakFreeze() {
        streakFreezeCount++;
        DB.changeIntValue(streakFreezeCount, myID, "streakcount");
    }

    public void incStreak() {
        streak++;
        DB.changeIntValue(streak, myID, "streak");
    }

    public void addGroup(Group a) {
        groups.add(a);
        DB.addGroupID(myID, a.getGroupID());
    }

    public void addGroup(Group a, boolean temp) {
        groups.add(a);
    }

    public void leaveGroup(Group a) {
        groups.remove(a);
        DB.removeGroup(a.getGroupID(), myID);
    }

    public void addBadge(String badge) {
        badges.add(badge);
    }

    public ArrayList<String> getBadges() {
        // Fix diagram
        return badges;
    }

    public void updateLevel() {
        level++;
        DB.changeIntValue(streak, myID, "level");
    }

    public int getProfileID() {
        // Fix diagram
        return myID;
    }

    public void addTask(Task a) {
        taskList.add(a);

    }

    public void removeTask(Task a) {
        taskList.remove(a);
    }

    public void completeTask(Task a) {
        completedTasks.add(a);
        DB.changeTaskCurrentStatus(myID, a.serialNum, true);
         removeTask(a);
         xp+=a.xpReward;
         DB.changeIntValue(xp, myID, "xp");
    }

    public void changeNotif(boolean preference) {
        notifEnable = preference;
    }

    public int getStreak() {
        return streak;
    }

    public int getStreakFreeze() {
        return streakFreezeCount;
    }

    public void changeMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString()
    {
        return "id: " + myID + " name: " + username;
    }

    public void add(Member admin) {
    }
}