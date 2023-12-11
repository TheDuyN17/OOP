import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Person pts = new Person("Nguyễn Thế Duy", "25/12/2004", "Male", "PTS");
        Person p1 = new Person("P1", "21/01/2000", "Female", null);
        Person p2 = new Person("P2", "01/01/2002", "Male", "s1");
        pts.addChild(p1);
        pts.addChild(p2);

        Person ps1 = new Person("PS1", "02/08/2001", "Female", null);
        Person ps2 = new Person("PS2", "19/05/1999", "Male", "v1");
        p2.addChild(ps1);
        p2.addChild(ps2);

        List<Person> personNotWedding = new ArrayList<>();
        List<Person> listFamilyHasTwoChildren = new ArrayList<>();
        List<Person> listPersonOfTheLastGeneration = new ArrayList<>();

        addToListIfNotMarried(pts, personNotWedding);
        addToListIfHasTwoChildren(pts, listFamilyHasTwoChildren);
        addToListIfLatestGeneration(pts, listPersonOfTheLastGeneration);

        System.out.println("People not married: ");
        for (Person person : personNotWedding) {
            System.out.println(person);
        }

        System.out.println("Families with two children: ");
        for (Person person : listFamilyHasTwoChildren) {
            System.out.println(person);
        }

        System.out.println("People of the latest generation: ");
        for (Person person : listPersonOfTheLastGeneration) {
            System.out.println(person);
        }
    }

    private static void addToListIfNotMarried(Person person, List<Person> list) {
        if (!person.isMarried()) {
            list.add(person);
        }
        for (Person child : person.getChildren()) {
            addToListIfNotMarried(child, list);
        }
    }

    private static void addToListIfHasTwoChildren(Person person, List<Person> list) {
        if (person.hasTwoChildren()) {
            list.add(person);
        }
        for (Person child : person.getChildren()) {
            addToListIfHasTwoChildren(child, list);
        }
    }

    private static void addToListIfLatestGeneration(Person person, List<Person> list) {
        if (person.isLatestGeneration()) {
            list.add(person);
        }
        for (Person child : person.getChildren()) {
            addToListIfLatestGeneration(child, list);
        }
    }
}
