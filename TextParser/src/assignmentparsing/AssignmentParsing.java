package assignmentparsing;

import java.util.ArrayList;

public class AssignmentParsing {

    public static void main(String[] args) {
        String text = "John.Davidson/05051988/Belgrade Michael.Barton/01011968/Krakov Ivan.Perkinson/23051986/Moscow";

        //printPersons(text);//conversiune explicita
        printPersonsGeneric(text);//tipuri de date generice
    }

   /* public static void printPersons(String text) {
        ArrayList allPerson = Person.parsText(text);

        for (Object p : allPerson) {
            Person person = (Person) p;

            System.out.println(person);
        }
    }*/
    
    public static void printPersonsGeneric(String text) {
        ArrayList<Person> allPerson = Person.parsTextGeneric(text);

        for (Person person : allPerson) {
            System.out.println(person);
        }

    }
}
