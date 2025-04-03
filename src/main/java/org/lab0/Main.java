package org.lab0;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Лабораторная работа 1
        System.out.println("\nЛабораторная работа 1");
        Point point = new Point(5, 3);
        System.out.println("\nТочка: " + point);
        point.parallelMove(2, 4);
        System.out.println("Точка после параллельного переноса на (2, 4): " + point);

        Segment segment = new Segment(new Point(1, 1), new Point(5, -3));
        System.out.println("Длина отрезка " + segment + ": " + segment.getLength());

        Triangle triangle = new Triangle(new Point(0, 4), new Point(-2, 1), new Point(9, 11));
        System.out.println("Площадь треугольника " + triangle + ": " + triangle.getArea());

        //Лабораторная работа 2
        System.out.println("\nЛабораторная работа 2");
        System.out.println("\nТочка до движения: " + point);
        point.move(4, -2);
        System.out.println("Точка после движения на (4, -2): " + point);
        point.scale(0.5);
        System.out.println("Точка после масштабирования на 0.5: " + point);

        System.out.println("\nОтрезок до движения: " + segment);
        segment.move(1, 6);
        System.out.println("Отрезок после движения на (1, 6): " + segment);
        segment.scale(3);
        System.out.println("Отрезок после масштабирования на 3: " + segment);

        System.out.println("\nТреугольник до движения: " + triangle);
        triangle.move(-10, 5);
        System.out.println("Треугольник после движения на (-10, 5): " + triangle);
        triangle.scale(2);
        System.out.println("Треугольник после мастабирования на 2: " + triangle);

        //Сравнение точек
        Point[] points = {
                new Point(3, 4),
                new Point(1, 1),
                new Point(5, 12),
                new Point(0, 0)
        };
        Arrays.sort(points);
        System.out.println("\nОтсортированные точки: ");
        for(Point p : points) {
            System.out.println(p + " с расстоянием до начала координат: " + p.getDistance());
        }

        //Сравнение отрезков
        Segment[] segments = {
                new Segment(new Point(0, 0), new Point(3, 4)),
                new Segment(new Point(1, 1), new Point(4, 5)),
                new Segment(new Point(0, 0), new Point(6, 8)),
                new Segment(new Point(0, 0), new Point(1, 1))
        };
        Arrays.sort(segments);
        System.out.println("\nОтсортированные отрезки: ");
        for(Segment s : segments){
            System.out.println(s + " с длинной: " + s.getLength());
        }

        //Сравнение треугольников
        Triangle[] triangles = {
                new Triangle(new Point(0, 0), new Point(4, 0), new Point(0, 3)),
                new Triangle(new Point(1, 1), new Point(5, 1), new Point(3, 4)),
                new Triangle(new Point(0, 0), new Point(6, 0), new Point(0, 5)),
                new Triangle(new Point(0, 0), new Point(2, 0), new Point(0, 1))
        };
        Arrays.sort(triangles);
        System.out.println("\nОтсортированные треугольники:");
        for (Triangle t : triangles) {
            System.out.println(t + " с площадью: " + t.getArea());
        }

        //Отлавливание ошибок
        try {
            // Попытка масштабирования с некорректным коэффициентом
            point.scale(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка при масштабировании: " + e.getMessage());
        }

        try {
            // Попытка создать отрезок с одинаковыми точками
            Segment segment2 = new Segment(new Point(1, 1), new Point(1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании отрезка: " + e.getMessage());
        }

        try {
            // Попытка создать треугольник с точками, лежащими на одной прямой
            Triangle triangle2 = new Triangle(
                    new Point(0, 0),
                    new Point(1, 1),
                    new Point(2, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании треугольника: " + e.getMessage());
        }
    }
}