package Helper;

public class DataUser {
    private String userID;
    private String title;
    private String body;

    public DataUser(String userID, String title, String body) {
        this.userID = userID;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "{\n" +
                "userID: " + userID + "\n" +
                "title: " + title + "\n" +
                "body: " + body + "\n" +
                "}";
    }
}
