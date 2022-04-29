package Classes;

import javax.swing.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * TODO DB.changeMode(int userID, String newMode)
 */
public class DB {

    private static final String NOTIFICATION = "Notification";

    // Connection info
    private static final String USERNAME = "ather"; //Change according to current host
    private static final String PASSWORD = "ilyas"; //Change according to current host
    private static final String GROUP_DATABASE_NAME = "group";
    private static final String CONN = "jdbc:mysql://localhost/" + GROUP_DATABASE_NAME;

    /**
     * gets a connection to the database
     *
     * @return a connection to the database
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }

    /**
     * adding a new user to the database
     *
     * @param id
     * @param username
     * @param pass
     * @param email
     * @param level
     * @param xp
     * @param streak
     * @param streakFreezeCount
     * @param mode
     */
    public static void add(int id, String username, String pass, String email, int level, int xp, int streak,
            int streakFreezeCount, String mode) {
        String sql = "INSERT INTO `username` (`id`, `user`, `pass`, `mail`, `level`, `xp`, `mode`, `streak`, `streakcount`) VALUES (?, ?, ?, ?,?,?,?,?,?)";
        try (Connection conn = DBconnection.getConnection("users");
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            stmt.setString(2, username);
            stmt.setString(3, pass);
            stmt.setString(4, email);
            stmt.setInt(5, level);
            stmt.setInt(6, xp);
            stmt.setString(7, mode);
            stmt.setInt(8, streak);
            stmt.setInt(9, streakFreezeCount);
            stmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * change Any String value from users database
     *
     * @param id    profileID of user
     * @param value the value requesting
     * @return result
     */
    public static void changeValue(String newValue, int id, String value) {
        String sql = "UPDATE `username` SET `" + value + "` = (?) WHERE id = (?)";
        try (Connection conn = DBconnection.getConnection("users");
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, newValue);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * get Any integer value from users database
     *
     * @param id    profileID of user
     * @param value the value requesting
     * @return result
     */
    public static void changeIntValue(int newValue, int id, String value) {
        String sql = "UPDATE `username` SET `" + value + "` = (?) WHERE id = (?)";
        try (Connection conn = DBconnection.getConnection("users");
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, newValue);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * get Any String value from users database
     *
     * @param id    profileID of user
     * @param value the value requesting
     * @return result
     */
    public static String getValue(int id, String value) {

        try (Connection conn = DBconnection.getConnection("users");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM username");) {
            rs.absolute(id);
            return rs.getString(value);
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Getting the id of an existing user when the user is trying to sign in
     *
     * @param user     username
     * @param password password
     * @return profileID
     */
    public static int getID(String user, String password) {

        try (Connection conn = DBconnection.getConnection("users");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM username");) {
            while (rs.next()) {
                if (rs.getString("user").equals(user)) {
                    if (rs.getString("pass").equals(password)) {
                        return rs.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    /**
     * create user based on userID
     *
     * @param id profileID
     * @return user retrieved from database
     */
    public static User getUser(int id) {
        try (Connection conn = DBconnection.getConnection("users");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM username");) {
            rs.absolute(id);
            User user = new User(rs.getString("user"), rs.getString("pass"), rs.getString("mail"), rs.getString("mode"),
                    rs.getInt("level"), rs.getInt("xp"), rs.getInt("streak"), rs.getInt("streakcount"), false);
            user.myID = id;
            return user;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    /**
     * Creates a new Notification Table for NewUser table name = NotificationX (X =
     * UserID) 0
     * 
     * @param userId
     */
    public static void createNotificationTable(int userId) {

        String sql = "CREATE TABLE " + NOTIFICATION + userId + " ( ";
        sql += "serialNum INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,";
        sql += "notifiString VARCHAR(1000), ";
        sql += "color VARCHAR(100), ";
        sql += "pageOnClick VARCHAR(100) ";
        sql += ")";

        try (Connection con = DBconnection.getConnection("users"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
            ;
        }
    }

    /**
     * Adds Notification to the User's Notification Table
     *
     * @param userId       to get correct User's Notifications
     * @param notifiString the Notification String
     * @param color        Color of the Notification (RED / YELLOW / GREEN)
     * @param pageOnClick  Page where user should be taken when Notification is
     *                     clicked (Home / Groups / NULL)
     */
    public static void addNotification(int userId, String notifiString, String color, String pageOnClick) {

        String sql;

        sql = "INSERT INTO " + NOTIFICATION + userId + " (notifiString, color, pageOnClick) ";
        sql += ("VALUES ('" + notifiString + "', '" + color + "', '" + pageOnClick + "' )");

        try (Connection con = DBconnection.getConnection("group"); PreparedStatement stat = con.prepareStatement(sql);

        ) {

            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
            ;
        }

    }
    // ===========================================================================================================

    /**
     * Creates a new Task Table for NewUser table name = TaskX (X = UserID)
     * 
     * @param userId to identify the User and his/her tasks 0
     */
    public static void createTaskTable(int userId) {

        String sql = "CREATE TABLE Tasks" + userId + " ( ";
        sql += "serialNum INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,";
        sql += "title VARCHAR(1000), ";
        sql += "priority VARCHAR(1000), ";
        sql += "startDate VARCHAR(1000), ";
        sql += "dueDate VARCHAR(1000), ";
        sql += "startTime VARCHAR(1000), ";
        sql += "dueTime VARCHAR(1000), ";
        sql += "status VARCHAR(1000), "; // completed or not
        sql += "category VARCHAR(1000), ";
        sql += "needsVerification VARCHAR(1000), ";
        sql += "isVerified VARCHAR(1000), ";
        sql += "xpReward INT(6),";
        sql += "upVote INT(3),";
        sql += "downVote INT(3),";
        sql += "verificationImageLocation MEDIUMBLOB,";
        sql += "taskDescription VARCHAR(2000) ";
        sql += ")";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Adds Notification to the User's Notification Table
     *
     * @param userId            to get User's ID
     * @param title             the title of the task
     * @param priority          the priority of the task
     * @param startDateLD       (LD - LocalDate) the starting date of the task -
     *                          Must be changed to string before calling SQL
     *                          statement
     * @param dueDateLD         (LD - LocalDate) the end date of the task - Must be
     *                          changed to string before calling SQL statement
     * @param startTimeLT       (LT - LocalTime) the start time of the task - Must
     *                          be changed to string before calling SQL statement
     * @param dueTimeLT         (LT - LocalTime) the end time of the task - Must be
     *                          changed to string before calling SQL statement
     * @param status            the status of task (comleted, not completed, missed)
     * @param category          the category of the task (maths, physics etc.)
     * @param needsVerification does the task need verification (false, true)
     * @param isVerified        is the task verified (true,false)
     * @param xpReward          the xp reward amound to be given after completing
     *                          the task 0
     */

    public static void addToTaskTable(int userId, String title, String priority, LocalDate startDateLD,
            LocalDate dueDateLD, LocalTime startTimeLT, LocalTime dueTimeLT, Boolean status, String category,
            Boolean needsVerification, Boolean isVerified, int xpReward) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String startDate = startDateLD.toString();
        String dueDate = dueDateLD.toString();
        String startTime = formatter.format(startTimeLT);
        String dueTime = formatter.format(dueTimeLT);

        String sql = "insert into Tasks" + userId;
        sql += "( title, priority, startDate, dueDate, startTime, dueTime, status, category, needsVerification, isVerified, xpReward)";
        sql += "values ('" + title + "','" + priority + "','" + startDate + "','" + dueDate + "','" + startTime + "','"
                + dueTime + "','" + status + "','" + category + "','" + needsVerification + "','" + isVerified + "','"
                + xpReward + "')";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    /**
     * Get the biggest serial num to increment when a new task is added so a record
     * of each task is stored and can be accessed
     *
     * @param userId        to get the User's ID
     * @param resultOfQuery the max value of the column "serialNum" returned 0
     */

    public static int getMaxSerialNum(int userId) {
        int maxSerialNum = 0;
        String sql = "SELECT MAX(serialNum)";
        sql += "FROM Tasks" + userId;

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet resultOfQuery = stat.executeQuery(sql);
            if (resultOfQuery.next()) {
                maxSerialNum = resultOfQuery.getInt(1);
                return maxSerialNum;
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return maxSerialNum;

    }

    /**
     * Check if a given Task Table with a given UserID exists
     *
     * @param userId        to get the User's ID
     * @param resultOfQuery the value returned if a Table Exists 0
     */

    public static Boolean checkIfTaskTableExistsForUser(int userId) {

        String sql = "--";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet resultOfQuery = dbm.getTables(null, null, "Tasks" + userId, null);
            if (resultOfQuery.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    /**
     * Remove task from table given a User ID and the Task Serial Number
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task to be removed 0
     */

    public static void removeTaskFromTable(int userId, int taskSerialNumber) {

        String sql = "DELETE FROM Tasks" + userId;
        sql += " WHERE serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    /**
     * Get Task Title
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedTitle      the task title returned from the database 0
     */

    public static String getTaskTitle(int userId, int taskSerialNumber) {
        String parsedTitle = "";
        String sql = "select title from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedTitle = rs.getString("title");

                return parsedTitle;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedTitle;

        }

        return parsedTitle;

    }

    /**
     * Change task Title
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task d
     * @param newPriority      the new status of the task to be changed 0
     */

    public static void changeTaskTitle(int userId, int taskSerialNumber, String newTitle) {

        String sql = "update Tasks" + userId;
        sql += " set title = '" + newTitle + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Priority
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedPriority   the task priority returned from the database 0
     */

    public static String getTaskPriority(int userId, int taskSerialNumber) {
        String parsedPriority = "";
        String sql = "select priority from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedPriority = rs.getString("priority");
                return parsedPriority;

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return parsedPriority;

    }

    /**
     * Change task priority
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task d
     * @param newPriority      the new status of the task to be changed 0
     */

    public static void changeTaskPriority(int userId, int taskSerialNumber, String newPriority) {

        String sql = "update Tasks" + userId;
        sql += " set priority = '" + newPriority + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Start Date
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedStartDate  the task start date returned from the database
     * @return LocalDate 0
     */

    public static LocalDate getTaskStartDate(int userId, int taskSerialNumber) {
        LocalDate parsedStartDate = null;
        String sql = "select startDate from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedStartDate = LocalDate.parse(rs.getString("startDate"));
                System.out.println(parsedStartDate);
                return parsedStartDate;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedStartDate;

        }

        return parsedStartDate;

    }

    /**
     * Get Task Due Date
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedDueDate    the task start due returned from the database
     * @return LocalDate 0
     */

    public static LocalDate getTaskDueDate(int userId, int taskSerialNumber) {
        LocalDate parsedDueDate = null;
        String sql = "select dueDate from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedDueDate = LocalDate.parse(rs.getString("dueDate"));
                System.out.println(parsedDueDate);
                return parsedDueDate;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedDueDate;

        }

        return parsedDueDate;

    }

    /**
     * Get Task Start Time
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedStartTime  the task start time returned from the database
     * @return LocalTime 0
     */

    public static LocalTime getTaskStartTime(int userId, int taskSerialNumber) {
        LocalTime parsedStartTime = null;
        String sql = "select startTime from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedStartTime = LocalTime.parse(rs.getString("startTime"));
                System.out.println(parsedStartTime);
                return parsedStartTime;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedStartTime;

        }

        return parsedStartTime;

    }

    /**
     * Get Task Due Time
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedDueTime    the task due time returned from the database
     * @return LocalTime 0
     */

    public static LocalTime getTaskDueTime(int userId, int taskSerialNumber) {
        LocalTime parsedDueTime = null;
        String sql = "select dueTime from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedDueTime = LocalTime.parse(rs.getString("dueTime"));
                System.out.println(parsedDueTime);
                return parsedDueTime;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedDueTime;

        }

        return parsedDueTime;

    }

    /**
     * Get Task Current Status
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedStatus     the task current status returned from the database
     *                         (Comleted or Not Completed)
     * @return Boolean 0
     */

    public static Boolean getTaskCurrentStatus(int userId, int taskSerialNumber) {
        Boolean parsedStatus = null;
        String sql = "select status from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedStatus = Boolean.parseBoolean(rs.getString("status"));
                System.out.println(parsedStatus);
                return parsedStatus;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedStatus;

        }

        return parsedStatus;

    }

    /**
     * Change task current Status
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task d
     * @param newStatus        the new status of the task to be changed 0
     */

    public static void changeTaskCurrentStatus(int userId, int taskSerialNumber, Boolean newStatus) {

        String sql = "update Tasks" + userId;
        sql += " set status = '" + newStatus + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Category
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedCategory   the task category returned from the database
     *                         (maths/eng etc.)
     * @return String 0
     */

    public static String getTaskCategory(int userId, int taskSerialNumber) {
        String parsedCategory = null;
        String sql = "select category from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedCategory = rs.getString("category");

                return parsedCategory;

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return parsedCategory;

    }

    /**
     * Change Task Category
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param newCategory      the new category of the task to be changed 0
     */

    public static void changeTaskCategory(int userId, int taskSerialNumber, String newCategory) {

        String sql = "update Tasks" + userId;
        sql += " set category = '" + newCategory + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Needs Verifiacation Property
     *
     * @param userId                  to get the User's ID
     * @param taskSerialNumber        the serial number of the task
     * @param parsedNeedsVerification the value of the question that "Does that task
     *                                need verification? Is the task from a top
     *                                scorer?"
     * @return Boolean 0
     */

    public static Boolean getTaskNeedsVerification(int userId, int taskSerialNumber) {
        Boolean parsedNeedsVerification = null;
        String sql = "select needsVerification from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedNeedsVerification = Boolean.parseBoolean(rs.getString("needsVerification"));

                return parsedNeedsVerification;

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return parsedNeedsVerification;

    }

    /**
     * Change Task Needs Verification Status
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param newCategory      the new category of the task to be changed 0
     */

    public static void changeTaskNeedsVerificationStatus(int userId, int taskSerialNumber,
            Boolean newNeedsVerificationStatus) {

        String sql = "update Tasks" + userId;
        sql += " set needsVerification = '" + newNeedsVerificationStatus + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Is Verified Status
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param parsedIsVerified the value returned after "So that task is from a top
     *                         scorer.. has it been verified?"
     * @return Boolean 0
     */

    public static Boolean getTaskIsVerified(int userId, int taskSerialNumber) {
        Boolean parsedIsVerified = null;
        String sql = "select isVerified from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedIsVerified = Boolean.parseBoolean(rs.getString("isVerified"));

                return parsedIsVerified;

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return parsedIsVerified;

    }

    /**
     * Change Task Is Verified Status
     *
     * @param userId              to get the User's ID
     * @param taskSerialNumber    the serial number of the task
     * @param newIsVerifiedStatus the new 'Is Verified' status of the task to be
     *                            changed 0
     */

    public static void changeTaskIsVerifiedStatus(int userId, int taskSerialNumber, Boolean newIsVerifiedStatus) {

        String sql = "update Tasks" + userId;
        sql += " set isVerified = '" + newIsVerifiedStatus + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Xp Reward value
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task to be removed
     * @param parsedXpReward   the xp reward returned from the databse
     * @return int 0
     */

    public static int getTaskXpReward(int userId, int taskSerialNumber) {
        int parsedXpReward = 0;
        String sql = "select xpReward from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedXpReward = rs.getInt("xpReward");

                return parsedXpReward;

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return parsedXpReward;

    }

    /**
     * Change Task's XP Reward
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task
     * @param newXpReward      the new XP Reward for the task 0
     */

    public static void changeTaskXpReward(int userId, int taskSerialNumber, int newXpReward) {

        String sql = "update Tasks" + userId;
        sql += " set xpReward = '" + newXpReward + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Change the Upvotes for a task
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task to be removed
     * @param newUpVotes       the new upVotes to be added to the Datebase
     * @return void 0
     */

    public static void changeTaskUpVotes(int userId, int taskSerialNumber, int newUpVotes) {

        String sql = "update Tasks" + userId;
        sql += " set upVote = '" + newUpVotes + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * set upVotes for a Task
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task to be removed
     * @param parsedUpVotes    the upVotes returned from a verifiable task
     * @return void 0
     */

    public static int getTaskUpVotes(int userId, int taskSerialNumber) {
        int parsedUpVotes = 0;
        String sql = "select upVote from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedUpVotes = rs.getInt("upVote");

                return parsedUpVotes;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedUpVotes;

        }

        return parsedUpVotes;

    }

    /**
     * Change the Down Votes for a task
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task to be removed
     * @param newDownVotes     the new Down Votes to be added to the Datebase
     * @return void 0
     */

    public static void changeTaskDownVotes(int userId, int taskSerialNumber, int newDownVotes) {

        String sql = "update Tasks" + userId;
        sql += " set downVote = '" + newDownVotes + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Down Votes
     *
     * @param userId           to get the User's ID
     * @param taskSerialNumber the serial number of the task to be removed
     * @param parsedDownVotes  the downVotes returned from a verifiable task
     * @return int 0
     */

    public static int getTaskDownVotes(int userId, int taskSerialNumber) {
        int parsedDownVotes = 0;
        String sql = "select downVote from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedDownVotes = rs.getInt("downVote");

                return parsedDownVotes;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return parsedDownVotes;

        }

        return parsedDownVotes;

    }

    /**
     * Get Task Verification Image
     *
     * @param userId                          to get the User's ID
     * @param taskSerialNumber                the serial number of the task to be
     *                                        removed
     * @param parsedVerificationImageLocation the stored image location of the
     *                                        uploaded verification image from the
     *                                        top scorer if he chooses to do so
     * @return String INCOMPLETE
     * @throws IOException
     */

    public static void getTaskVerificationImageLocation(int userId, int taskSerialNumber) {
        BufferedImage bi = null;
        byte[] imageBytes;
        ImageIcon imageIcon = null;

        String sql = "SELECT * FROM Tasks" + userId + " WHERE SavePic IS NOT NULL";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {

        } catch (SQLException e) {
            System.err.println(e);

        }
        System.out.println("NULL");

    }

    /**
     * Change Task's Verification Image saved in the DB
     *
     * @param userId                       to get the User's ID
     * @param taskSerialNumber             the serial number of the task
     * @param newVerificationImageLocation the new Verification Image Location for
     *                                     the Task
     * @param file                         the image file itself
     * @param fis                          the file input stream 0
     */

    public static void changeTaskVerificationImageLocation(int userId, int taskSerialNumber, File file,
            FileInputStream fis) {

        String sql = "UPDATE tasks" + userId + " SET verificationImageLocation=? Where serialNum=?";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.setBinaryStream(1, fis, (int) file.length());
            stat.setInt(2, taskSerialNumber);

            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get Task Verification Description
     *
     * @param userId                        to get the User's ID
     * @param taskSerialNumber              the serial number of the task to be
     *                                      removed
     * @param parsedVerificationDescription the stored image location of the
     *                                      uploaded Task Description from the top
     *                                      scorer if he chooses to do so
     * @return String 0
     */

    public static String getTaskVerificationDescription(int userId, int taskSerialNumber) {
        String parsedVerificationDescription = "";
        String sql = "select taskDescription from Tasks" + userId;
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                parsedVerificationDescription = rs.getString("taskDescription");

                return parsedVerificationDescription;

            }

        } catch (SQLException e) {
            System.err.println(e);

        }

        return parsedVerificationDescription;

    }

    /**
     * Change Task's Verification Description
     *
     * @param userId                    to get the User's ID
     * @param taskSerialNumber          the serial number of the task
     * @param newVerifcationDescription the new Verification Description for the
     *                                  Task 0
     */

    public static void changeTaskVerificationDescription(int userId, int taskSerialNumber,
            String newVerifcationDescription) {

        String sql = "update Tasks" + userId;
        sql += " set taskDescription = '" + newVerifcationDescription + "'";
        sql += " where serialNum = '" + taskSerialNumber + "'";

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);

        }

    }

    /**
     * Get A List of all Tasks and their details - these return their corresponding
     * data types (eg - Title String , xpReward int etc) and not Task Object
     * themselves..
     *
     * @param userId       to get the User's ID
     * @param parsedParams these are all those params which are taken from the
     *                     database and converted to their respective data types
     * @param list         the list of a single task that is returned after each
     *                     while loop
     * 
     *                     ----* The order of each stored task is : serialNum,
     *                     title, priority, startDate, dueDate, startTime, dueTime,
     *                     status, category, needsVerification, isVerified,
     *                     xpReward, upVote, downVote, verificationImageLocation,
     *                     taskDescription *----
     * 
     *                     respectively. So the data can be accessed in this format
     *                     with serialNum at index = 0 and taskDescription at index
     *                     = 15
     * @param listOfLists  the lists of all the tasks combined together as one The
     *                     Data from the listOfLists can be accessed from the first
     *                     task in the database at index = 0 and the last task at
     *                     index = n, where n can be anything
     * @return ArayList of ArrayList of all Tasks 0
     */

    public static ArrayList<Task> getAllUserTasks(int userId) {
        ArrayList<Task> listOfTasks = new ArrayList<>();
        String sql = "select serialNum, title, priority, startDate, dueDate, startTime, dueTime, status, category, needsVerification, isVerified, xpReward, upVote, downVote, verificationImageLocation, taskDescription from Tasks"
                + userId;

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                if (!Boolean.parseBoolean(rs.getString("status"))) {
                    int taskOwnerId = userId;
                    int parsedSerialNum = rs.getInt("serialNum");
                    String parsedTitle = rs.getString("title");
                    String parsedPriority = rs.getString("priority");
                    LocalDate parsedStartDate = LocalDate.parse(rs.getString("startDate"));
                    LocalDate parsedDueDate = LocalDate.parse(rs.getString("dueDate"));
                    LocalTime parsedStartTime = LocalTime.parse(rs.getString("startTime"));
                    LocalTime parsedDueTime = LocalTime.parse(rs.getString("dueTime"));
                    Boolean parsedStatus = Boolean.parseBoolean(rs.getString("status"));
                    String parsedCategory = rs.getString("category");
                    Boolean parsedNeedsVerification = Boolean.parseBoolean(rs.getString("needsVerification"));
                    Boolean parsedIsVerified = Boolean.parseBoolean(rs.getString("isVerified"));
                    int parsedXpReward = rs.getInt("xpReward");
                    int parsedUpVote = rs.getInt("upVote");
                    int parsedDownVote = rs.getInt("downVote");
                    String parsedVerificationImageLocation = rs.getString("verificationImageLocation");
                    String parsedDescription = rs.getString("taskDescription");
                    Task tempTask = new Task(parsedSerialNum, taskOwnerId, parsedTitle, parsedPriority, parsedStartDate,
                            parsedDueDate, parsedStartTime, parsedDueTime, parsedStatus, parsedCategory,
                            parsedNeedsVerification, parsedIsVerified, parsedXpReward, parsedUpVote, parsedDownVote,
                            parsedVerificationImageLocation, parsedDescription);
                    listOfTasks.add(tempTask);

                }
            }
            return listOfTasks;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return listOfTasks;
    }
    // ===========================================================================================================

    /**
     * @return the next id after the last generated id in the database
     */
    public static int groupIdGenerator() {
        String sqlLister = "SELECT * FROM groups";

        try (Connection con = getConnection();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sqlLister)) {
            rs.last();
            return rs.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * initializes the group in the database
     * 
     * @param groupId
     * @param groupName
     * @param adminId
     * @param image     the image part is not functional 0
     */
    public static void groupInit(int groupId, String groupName, int adminId, ImageIcon image) {
        String membersTable;
        String categoriesTable;

        membersTable = "`" + membersTableName(groupId) + "`";
        categoriesTable = "`" + categoriesTableName(groupId) + "`";
        if (groupId != -1) {
            // adds the group
            String sqlGroupAdder = "INSERT INTO `groups` ( `id`, `name`, `admin_id`,`date_joined`, `image`) "
                    + "VALUES ( " + groupId + ",\'" + groupName + "\'," + adminId + ", CURRENT_TIMESTAMP, Null)";

            // creates the members table
            String sqlMemberMaker = "CREATE TABLE " + "`" + GROUP_DATABASE_NAME + "`." + membersTable
                    + " ( `id` INT NOT NULL , `score` INT NOT NULL ) ENGINE = InnoDB;";

            // creates the categories table
            String sqlCategoriesMaker = "CREATE TABLE " + "`" + GROUP_DATABASE_NAME + "`." + categoriesTable
                    + " ( `category` TEXT NOT NULL ) ENGINE = InnoDB;";

            try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(sqlGroupAdder)) {
                // toDo setting image as blob
                // pst.setBlob (1, (Blob) image);
                pst.execute();
                pst.executeUpdate(sqlMemberMaker);
                pst.executeUpdate("ALTER TABLE `" + membersTableName(groupId) + "` ADD PRIMARY KEY(`id`)");
                pst.executeUpdate(sqlCategoriesMaker);
                pst.executeUpdate(
                        "ALTER TABLE `" + categoriesTableName(groupId) + "` ADD PRIMARY KEY(`category`(500))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * transforms a database group object to a group object
     * 
     * @param groupId
     * @return a group object
     * @throws SQLException
     */
    public static Group getGroup (int groupId)
    {
        String sqlGroupRetrieve = "SELECT * FROM groups WHERE id =" + groupId;
        String sqlMemberRetrieve = "SELECT * FROM " + membersTableName (groupId);
        String sqlCategoryRetrive = "SELECT * FROM " + categoriesTableName (groupId);

        int id;
        String name;
        int adminId;
        ArrayList<Member> members;
        ArrayList<String> categories;
        ResultSet rs;

        rs = null;
        members = new ArrayList<Member> ();
        categories = new ArrayList<String> ();
        try (Connection con = getConnection ();
             Statement st = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))
        {

            rs = st.executeQuery (sqlGroupRetrieve);
            rs.next ();
            id = rs.getInt (1);
            name = rs.getString (2);
            adminId = rs.getInt (3);

            rs = st.executeQuery (sqlMemberRetrieve);
            while (rs.next ())
            {
                members.add (new Member (groupId, rs.getInt (1), rs.getInt (2)));
            }

            rs = st.executeQuery (sqlCategoryRetrive);
            while (rs.next ())
            {
                categories.add (rs.getString (1));
            }

            return new Group (id, name, getUser (adminId), members, categories);
            //toDo
//            groupDetail.set (3, rs.getBlob (5));
        } catch (SQLException e)
        {
            e.printStackTrace ();
            return null;
        } catch (Exception e)
        {
            e.printStackTrace ();
            return null;
        } finally
        {
            
        }
    }

    /**
     * removes the group from the database
     * 
     * @param groupId
     */
    public static void groupRemover(int groupId) {
        String sqlGroupRemover = "DELETE FROM groups WHERE id =" + groupId;
        String sqlGroupMemberTableRemover = "DROP TABLE " + membersTableName(groupId);
        String sqlGroupCatRemover = "DROP TABLE " + categoriesTableName(groupId);

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(sqlGroupRemover)) {
            pst.execute();
            pst.executeUpdate(sqlGroupMemberTableRemover);
            pst.executeUpdate(sqlGroupCatRemover);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param groupId
     * @return the corresponding member table name to a certain group
     */
    public static String membersTableName(int groupId) {
        return groupId + "_members";
    }

    public static void memberAdder(int groupId, int memberID) {
        String sqlMemberAdder = "INSERT INTO " + membersTableName(groupId) + " (id, score) VALUES ( ?, ?)";

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(sqlMemberAdder)) {
            pst.setInt(1, memberID);
            pst.setInt(2, 0);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // toDO getMember
    public static int memberScore(int groupId, int memberId) {
        String sqlDataRetrieve = "SELECT * FROM " + membersTableName(groupId) + " WHERE id =" + memberId;

        try (Connection con = getConnection();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sqlDataRetrieve)) {
            rs.next();
            return rs.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * sets the score of a member in tha db
     * 
     * @param groupId
     * @param score
     */
    public static void memberScoreSetter(int groupId, int memberId, int score) {
        String sqlMemberScoreSetter = "UPDATE " + membersTableName(groupId) + " SET score = " + score + " WHERE "
                + membersTableName(groupId) + ".`id` = " + memberId;
        // "UPDATE `1_members` SET `score` = '56' WHERE `1_members`.`id` = 1"

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sqlMemberScoreSetter)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param memberID the user id of the member that should be removed
     * @param groupId
     */
    public static void memberRemover(int memberID, int groupId) {
        String sqlGroupMemberRemover = "DELETE FROM " + membersTableName(groupId) + " WHERE id =" + memberID;

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(sqlGroupMemberRemover)) {
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param groupId
     * @return the corresponding category table name to a certain group
     */
    public static String categoriesTableName(int groupId) {
        return groupId + "_categories";
    }

    /**
     * adds a category to that group's table name
     * 
     * @param groupId
     * @param category a string of the name of the category
     */
    public static void categoryAdder(int groupId, String category) {
        String sqlCatAdder = "INSERT INTO " + categoriesTableName(groupId) + " (category) VALUES (?)";

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(sqlCatAdder)) {
            pst.setString(1, category);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * removes a category from the related group
     * 
     * @param groupId
     * @param category the string form of the category name
     */
    public static void categoryRemover(int groupId, String category) {
        String sqlGroupMemberRemover = "DELETE FROM " + categoriesTableName(groupId) + " WHERE category = '" + category
                + "'";

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(sqlGroupMemberRemover)) {
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==============================================================
    /**
     * Creating the users table 0
     */
    public static void createUsersTable() {
        String sql = "CREATE TABLE username" + " ( ";
        sql += "id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,";
        sql += "user VARCHAR(1000), ";
        sql += "pass VARCHAR(1000), ";
        sql += "mail VARCHAR(1000), ";
        sql += "level INT(6), ";
        sql += "xp INT(6), ";
        sql += "mode VARCHAR(1000), ";
        sql += "streak INT(6), ";
        sql += "streakcount INT(6) ";
        sql += ")";

        try (Connection con = DBconnection.getConnection("users"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
            ;
        }
    }

    /**
     * add the group to the user's group table
     * 
     * @param userID
     * @param groupID
     */
    public static void addGroupID(int userID, int groupID) {

        String sql = "INSERT INTO `groups" + userID + "` VALUES (?)";

        try (Connection conn = DBconnection.getConnection("users");
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, groupID);
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            ;
        }
    }

    /**
     * Create a groups table for each user 0
     * 
     * @param userID
     */
    public static void createGroupTable(int userID) {
        String sql = "CREATE TABLE groups" + userID + " ( ";
        sql += "id INT(6)";
        sql += ")";

        try (Connection con = DBconnection.getConnection("users"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
            ;
        }
    }

    public static int userIdGenerator() {
        try (Connection conn = DBconnection.getConnection("users");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM username");) {
            rs.last();
            if (rs.getRow() == 0) {
                return 1;
            }
            return rs.getInt("id") + 1;
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return 0;
    }

    public static void removeGroup(int id, int userID) {
        String sql = "DELETE FROM groups" + userID;
        sql += " WHERE id = '" + id + "'";
        try (Connection con = DBconnection.getConnection("users");
                PreparedStatement stat = con.prepareStatement(sql);) {
            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public static ArrayList<Task> getAllUserCompletedTasks(int userId) {
        ArrayList<Task> listOfTasks = new ArrayList<>();
        String sql = "select serialNum, title, priority, startDate, dueDate, startTime, dueTime, status, category, needsVerification, isVerified, xpReward, upVote, downVote, verificationImageLocation, taskDescription from Tasks"
                + userId;

        try (Connection con = DBconnection.getConnection("Tasks"); PreparedStatement stat = con.prepareStatement(sql);

        ) {
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                if (Boolean.parseBoolean(rs.getString("status"))) {
                    int taskOwnerId = userId;
                    int parsedSerialNum = rs.getInt("serialNum");
                    String parsedTitle = rs.getString("title");
                    String parsedPriority = rs.getString("priority");
                    LocalDate parsedStartDate = LocalDate.parse(rs.getString("startDate"));
                    LocalDate parsedDueDate = LocalDate.parse(rs.getString("dueDate"));
                    LocalTime parsedStartTime = LocalTime.parse(rs.getString("startTime"));
                    LocalTime parsedDueTime = LocalTime.parse(rs.getString("dueTime"));
                    Boolean parsedStatus = Boolean.parseBoolean(rs.getString("status"));
                    String parsedCategory = rs.getString("category");
                    Boolean parsedNeedsVerification = Boolean.parseBoolean(rs.getString("needsVerification"));
                    Boolean parsedIsVerified = Boolean.parseBoolean(rs.getString("isVerified"));
                    int parsedXpReward = rs.getInt("xpReward");
                    int parsedUpVote = rs.getInt("upVote");
                    int parsedDownVote = rs.getInt("downVote");
                    String parsedVerificationImageLocation = rs.getString("verificationImageLocation");
                    String parsedDescription = rs.getString("taskDescription");
                    Task tempTask = new Task(parsedSerialNum, taskOwnerId, parsedTitle, parsedPriority, parsedStartDate,
                            parsedDueDate, parsedStartTime, parsedDueTime, parsedStatus, parsedCategory,
                            parsedNeedsVerification, parsedIsVerified, parsedXpReward, parsedUpVote, parsedDownVote,
                            parsedVerificationImageLocation, parsedDescription);
                    listOfTasks.add(tempTask);

                }
            }
            return listOfTasks;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return listOfTasks;
    }

    public static ArrayList<Group> getAllGroupsofUser(int id) {
        ArrayList<Group> result = new ArrayList<>();
        try (Connection conn2 = DBconnection.getConnection("users");
                Statement stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM groups" + id);) {
            while (rs2.next()) {
                result.add(getGroup(rs2.getInt("id")));
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return result;
    }

    /**
     * Get Messages as a String
     * 
     * @param groupId
     * @return
     */
    public static String getMessages(int groupId) {

        String tableName = "groupchat" + groupId;

        String out = "";

        try (Connection con = DBconnection.getConnection("group");
                Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stat.executeQuery("SELECT * FROM " + tableName);) {
            while (rs.next()) {

                User user = DB.getUser(Integer.parseInt(rs.getString("Username")));
                // Group group = DB.getGroup(groupId);
                // temp = new Message(user, rs.getString("Message"), group , rs.getDate("Date"),
                // rs.getTime("Time"), null); //ImageIcon = null for now

                out += " \n *" + (user.getUsername()).toUpperCase() + "* : ";
                out += rs.getString("Message");
                out += " \n";

            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return out;
    }

    public static void addMessagetoDB(Message message, int groupID) {

        int userID = message.getSender().getProfileID();
        String sql;

        String tableName = "groupchat" + groupID;

        sql = "INSERT INTO " + tableName + " (UserName, Message, Date, Time) ";
        sql += ("VALUES ('" + userID + "', '" + message.getText() + "', '" + message.getSendDate() + "', '"
                + message.getSendTime() + "' )");

        try (Connection con = DBconnection.getConnection("group"); PreparedStatement stat = con.prepareStatement(sql);

        ) {

            stat.execute();

        } catch (SQLException e) {
            System.err.println(e);
            ;
        }

    }

    public static void groupNameSetter (int groupId, String groupName)
    {
        String sqlNameChanger = "UPDATE `groups` SET `name` = '" + groupName + "' WHERE `groups`.`id` = " + groupId;


        try (Connection con = getConnection ();
             PreparedStatement ps = con.prepareStatement (sqlNameChanger))
        {
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace ();
        }
    }

}