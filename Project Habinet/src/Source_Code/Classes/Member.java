package Classes;

public class Member extends User {
    public int id;
    private int score;
    private int groupId;

    /**
     * new group and member
     * 
     * @param user
     * @param score
     */
    public Member(User user, int score) {
        super();
        groupId = DB.groupIdGenerator();
        this.id = user.getProfileID();
        myID = id;
        this.score = score;
    }

    /**
     * new group and member
     * 
     * @param id
     * @param score
     */
    public Member(int id, int score) {
        super();
        this.id = id;
        myID = id;
        this.score = score;
        groupId = DB.groupIdGenerator();

    }

    /**
     * when getting from db
     * 
     * @param groupId
     * @param id
     * @param score
     */
    public Member(int groupId, int id, int score) {
        this.groupId = groupId;
        this.id = id;
        myID = id;
        this.score = score;
    }

    /**
     * when getting from db
     * 
     * @param groupId
     * @param user
     */
    public Member(int groupId, User user, int score) {
        super();
        this.groupId = groupId;
        this.id = user.getProfileID();
        myID = id;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void incScore(int i) {
        score += i;
        DB.memberScoreSetter (groupId, id, score);
    }

    public int getProfileId() {
        return id;
    }

    public void resetScores() {
        score = 0;
        DB.memberScoreSetter (groupId, id, 0);
    }

    public int getGroupId() {
        return groupId;
    }

}
