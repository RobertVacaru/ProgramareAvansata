import java.util.ArrayList;

public class Person {
    private String name;
    private String message;
    private ArrayList<Person> friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        String sep = "\n";
        this.message = this.message + sep + message;
    }

    public ArrayList<Person> getFriend() {
        return friend;
    }

    public void setFriend(ArrayList<Person> friend) {
        this.friend = friend;
    }
}
