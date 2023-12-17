import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Task1 {
    static class Person {
        private String name;
        private int age;
        private String city;

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

        public static void main(String[] args) {
            List<Person> people = new ArrayList<>();
            people.add(new Person("Alice", 25, "New York"));
            people.add(new Person("Bob", 30, "Los Angeles"));
            people.add(new Person("Charlie", 20, "New York"));
            people.add(new Person("David", 35, "Chicago"));

            people.sort(Comparator.comparingInt(Person::getAge));

            String cityToFilter = "New York";
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getCity().equals(cityToFilter))
                    .collect(Collectors.toList());

            System.out.println("Sorted list by age:");
            people.forEach(System.out::println);

            System.out.println("\nFiltered list by city '" + cityToFilter + "':");
            filteredPeople.forEach(System.out::println);
    }
}
