import java.util.ArrayList;

public class SocialNetwork extends Person {
    public ArrayList<Person> personArray;

    public SocialNetwork(ArrayList<Person> personArray) {
        this.personArray = personArray;
    }

    public void register(Person person) {
        personArray.add(person);
    }

    public Person login(String name) {
        Person person = new Person();
        for (Person value : personArray) {
            if (value.getName().equals(name)) {
                person.setName(value.getName());
                person.setMessage(value.getMessage());
            }
        }
        return person;
    }

    public void friend(Person person, String name) {
        for (Person value : personArray) {
            if (value.getName().equals(name)) {
                person.getFriend().add(value);
            }
        }
    }

    public void send(Person person, String message) {
        for (int i = 0; i <=person.getFriend().size(); i++) {
            for (Person value : personArray)
                if (person.getFriend().get(i).equals(value)) {
                    String sep = " ";
                    message = person.getName() + sep + message;
                    value.setMessage(message);
                }
        }
    }

    public String read(Person person)
    {
        return person.getMessage();
    }
}
