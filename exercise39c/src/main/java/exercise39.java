import java.util.*;

public class exercise39
{
    public static class Person
    {
        private String firstName;
        private String lastName;
        private String position;
        private String sepDate;

        public Person(String f, String l, String p, String d)
        {
            firstName = f;
            lastName = l;
            position = p;
            sepDate = d;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public String getPosition()
        {
            return position;
        }

        public String getSepDate()
        {
            return sepDate;
        }

        public static Comparator<Person> LastNameComparator = new Comparator<Person>()
        {
            public int compare(Person p1, Person p2)
            {
                return p1.getLastName().compareTo(p2.getLastName());
            }
        };
    }

    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person("John", "Johnson", "Manager", "2016-12-31"));
        people.add(new Person("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        people.add(new Person("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        people.add(new Person("Jake", "Jacobson", "Programmer", ""));
        people.add(new Person("Jacquelyn", "Jackson", "DBA", ""));
        people.add(new Person("Sally", "Webber", "Web Developer", "2015-12-18"));

        Collections.sort(people, Person.LastNameComparator);

        int maxName = 0;
        int maxPos = 0;

        for (int i = 0; i < people.size(); i++)
        {
            String temp = people.get(i).getFirstName() + " " + people.get(i).getLastName();
            if (temp.length() > maxName)
            {
                maxName = temp.length();
            }

            temp = people.get(i).getPosition();
            if (temp.length() > maxPos)
            {
                maxPos = temp.length();
            }
        }

        for (int i = 0; i < people.size(); i++)
        {
            String temp = people.get(i).getFirstName() + " " + people.get(i).getLastName();
            System.out.print(temp);
            for (int j = temp.length(); j <= maxName; j++)
            {
                System.out.print(" ");
            }
            System.out.print("\t" + people.get(i).getPosition());
            for (int j = people.get(i).getPosition().length(); j <= maxPos; j++)
            {
                System.out.print(" ");
            }
            System.out.print("\t" + people.get(i).getSepDate() + "\n");
        }
    }
}
