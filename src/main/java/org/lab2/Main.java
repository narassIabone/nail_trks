package org.lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();

        humans.add(new Human(25, "Иван", "Иванов", LocalDate.of(1998, 5, 15), 70));
        humans.add(new Human(30, "Мария", "Петрова", LocalDate.of(1993, 8, 22), 60));
        humans.add(new Human(40, "Алексей", "Смирнов", LocalDate.of(1983, 12, 30), 80));
        humans.add(new Human(22, "Михаил", "Кузнецов", LocalDate.of(2001, 2, 10), 75));
        humans.add(new Human(22, "Елена", "Попова", LocalDate.of(2003, 11, 5), 65));
        humans.add(new Human(28, "Дмитрий", "Соколов", LocalDate.of(1995, 7, 8), 85));
        humans.add(new Human(45, "Светлана", "Лебедева", LocalDate.of(1978, 3, 14), 90));
        humans.add(new Human(33, "Андрей", "Григорьев", LocalDate.of(1990, 4, 19), 70));
        humans.add(new Human(52, "Татьяна", "Романова", LocalDate.of(1971, 9, 3), 78));
        humans.add(new Human(27, "Роман", "Васильев", LocalDate.of(1996, 6, 28), 80));

        System.out.println("Изначальный список:");
        printHumansList(humans);

        //Задание 1
        System.out.println("\n\nЗадание 1\nСортировка по имени:");
        humans.stream()
                .sorted(Comparator.comparing(Human::getFirstName))
                .forEach(System.out::println);
        System.out.println("\nСортировка по фамилии:");
        humans.stream()
                .sorted(Comparator.comparing(Human::getLastName))
                .forEach(System.out::println);
        System.out.println("\nФильтрация по дате рождения:");
        humans.stream().filter(human -> human.getBirthDate().isAfter(LocalDate.of(2000, 6, 24)))
                .forEach(System.out::println);
        System.out.println("\nСумма возрастов:");
        int sumOfAges = humans.stream()
                .mapToInt(Human::getAge)
                .sum();
        System.out.println(sumOfAges);

        //Задание 2
        System.out.println("\n\nЗадание 2\nСортировка по дате рождения:");
        humans.stream()
                .sorted(Comparator.comparing(Human::getBirthDate))
                .forEach(System.out::println);
        System.out.println("\nФильтрация по возрасту меньше, чем 50:");
        humans.stream()
                .filter(human -> human.getAge() < 50)
                .forEach(System.out::println);
        System.out.println("\nФильтрация по весу:");
        humans.stream()
                .sorted(Comparator.comparing(Human::getWeight))
                .forEach(System.out::println);
        System.out.println("\nКонкатенация всех имен в одну строку через пробел:");
        String concatenatedNames = humans.stream()
                .map(Human::getFirstName)
                .collect(Collectors.joining(" "));
        System.out.println(concatenatedNames);

        //Задание 15
        System.out.println("\n\nЗадание 15\nУвеличение веса каждого объекта на 3:");
        humans.stream()
                .map(human -> {
                    human.setWeight(human.getWeight() + 3);
                    return human;
                })
                .forEach(System.out::println);
        System.out.println("\nСортировка веса в обратном порядке:");
        humans.stream()
                .sorted(Comparator.comparing(Human::getWeight).reversed())
                .forEach(System.out::println);
        System.out.println("\nФильтрация по дате рождения меньшей, чем 01.01.2000:");
        humans.stream()
                .filter(human -> human.getBirthDate().isBefore(LocalDate.of(2000, 1, 1)))
                .forEach(System.out::println);
        System.out.println("\nСумма всех весов:");
        int sumOfWeights = humans.stream()
                .mapToInt(Human::getWeight)
                .sum();
        System.out.println(sumOfWeights);
    }

    private static void printHumansList(List<Human> humans) {
        for (Human human : humans) {
            System.out.println(human);
        }
    }
}