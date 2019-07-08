package assignmentparsing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Person {

    private String firstName;
    private String lastName;
    private String placeOfBirth;
    private LocalDate dateOfBirth;

    public Person(String personText) {
        String[] personArray = personText.split("[./]");
        this.placeOfBirth = personArray[3];
        LocalDate dateOfBirth = LocalDate.parse(personArray[2], DateTimeFormatter.ofPattern("ddMMyyyy"));
        this.dateOfBirth = dateOfBirth;
        this.firstName = personArray[0];
        this.lastName = personArray[1];

    }

    @Override
    public String toString() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM yyyy");

        return lastName + ", " + firstName + ", " + dateOfBirth.format(date) + ", " + placeOfBirth;
    }

    public static ArrayList parsText(String arg) {
        String[] argArray = arg.split(" ");
        ArrayList allPerson = new ArrayList();

        for (String personText : argArray) {
            Person person = new Person(personText);
            allPerson.add(person);

        }
        return allPerson;

    }

    public static ArrayList<Person> parsTextGeneric(String arg) {
        String[] argArray = arg.split(" ");
        ArrayList<Person> allPerson = new ArrayList<Person>();
        
        for (String personText : argArray) {
            Person person = new Person(personText);
            allPerson.add(person);
        }
        return allPerson;

    }

}



