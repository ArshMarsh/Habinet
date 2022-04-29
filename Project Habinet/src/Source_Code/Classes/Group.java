package Classes;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * a class representing a group of members(users) and related functions
 * 
 * @author Arshia Bakhshayesh
 * @version 12/04/2021
 */
public class Group {
    // properties

    // group related
    private String name;
    private int groupId;
    private Member admin;
    private ArrayList<String> categories;
    private ImageIcon groupImage;

    // member related
    private ArrayList<Member> members;
    private Member topScorer;
    private LeaderBoard leaderBoard;
    private GroupChat groupchat;

    // constructors

    /**
     * for making a new group and adding it to the database
     * 
     * @param name
     * @param admin
     * @param categories an arraylist of string categories of the group
     */
    public Group(String name, User admin, ArrayList<Member> members, ArrayList<String> categories) {
        groupId = DB.groupIdGenerator();
        this.name = name;
        // this.admin = new Member (groupId, admin);
        this.categories = categories;
        this.members = members;
        this.admin = new Member(groupId, admin, 0);
        this.members.add(this.admin);

        leaderBoard = new LeaderBoard(members, groupId, name);
        groupchat = new GroupChat (groupId);
        topScorer = null;

        DB.groupInit(DB.groupIdGenerator(), name, admin.getProfileID(), null);
        for (String category : this.categories) {
            if (category != null)
                DB.categoryAdder(groupId, category);
        }
        for (Member member : this.members) {
            if (member != null)
            {
                DB.memberAdder (groupId, member.getProfileId());
                DB.addGroupID (member.getProfileId(), groupId);
            }
        }
    }

    /**
     * for constructing a group object by completely specifying the details
     * 
     * @param groupId
     * @throws Exception when a groupId is out of the index of the existing groups
     */
    public Group(int groupId, String name, User admin, ArrayList<Member> members, ArrayList<String> categories)
            throws Exception {
        if (groupId >= DB.groupIdGenerator()) {
            throw new Exception("this group does not already exist");
        } else {
            this.groupId = groupId;
            this.name = name;
            this.categories = categories;
            this.admin = new Member(groupId, admin, DB.memberScore(groupId, admin.getProfileID()));
            this.members = members;
            leaderBoard = new LeaderBoard(members, groupId, name);
            topScorer = null;
            groupchat = new GroupChat("groupchat" + groupId);
        }

    }

    /**
     * constructs an existing group from the database
     * 
     * @param groupId
     * @throws SQLException
     */
    public Group(int groupId) throws SQLException {
        Group temp;

        temp = DB.getGroup(groupId);
        // not tested
        this.name = temp.getGroupName();
        this.categories = temp.getCategories();
        this.admin = new Member(groupId, temp.getAdmin(), DB.memberScore(groupId, temp.getAdmin().getProfileId()));
        this.members = temp.getMembers();
        leaderBoard = new LeaderBoard(groupId, name);
        topScorer = leaderBoard.getTopScorer();
        groupchat = new GroupChat("groupchat" + groupId);
    }

    // methods
    public int getGroupID() {
        return groupId;
    }

    public String getGroupName() {
        return name;
    }

    public Member getTopScorer() {
        return leaderBoard.getTopScorer();
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public GroupChat getGroupChat() {
        return groupchat;
    }

    public Member getAdmin() {
        return admin;
    }

    public void addUser(User user) {
        Member newMember;

        newMember = new Member(groupId, user, 0);
        members.add(newMember);
        leaderBoard.addMember(newMember);
        user.addGroup(this);

        DB.memberAdder(groupId, newMember.getProfileId());
    }

    public void removeUser(User user) {
        members.removeIf(Member -> user.getProfileID() == user.getProfileID());
        leaderBoard.removeMember(user);

        user.leaveGroup(this);
        DB.memberRemover(user.getProfileID(), groupId);
    }

    // changed user input to member input
    public boolean isAdmin(Member member) {
        return member.getProfileId() == admin.getProfileId();
    }

    // GUI
    public void setGroupImage(ImageIcon image) {
        groupImage = image;
        // toDo db method
    }

    public void addCategory(String category) {
        DB.categoryAdder(groupId, category);
        categories.add(category);
    }

    public void removeCategory(String category) {
        DB.categoryRemover(groupId, category);
        categories.remove(category);
    }

    public void resetScores() {
        leaderBoard.resetScore();
        for (Member member : members) {
            member.resetScores();
        }
    }

    public void memberScoreInc(User user, int score) {
        Member wantedMember;
        wantedMember = null;

        for (Member member : members) {
            if (member.getProfileID() == user.getProfileID()) {
                wantedMember = member;
            }
        }
        wantedMember.incScore(score);
    }

    @Override
    public String toString()
    {
        return "id: " + groupId + "     name: " + name;
    }
}
