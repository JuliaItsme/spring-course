package ru.goryacheva.other;

/**
 * Пример класса, реализующего паттерн Singleton (англ. Одиночка)
 * Можно будет использовать только один объект класса Singleton
 */

public class Singleton {
    // В этой статической(!) переменной будет храниться единственный объект класса Singleton
    private static Singleton instance;

    // Скажем, что у нашего единственного объекта должно быть поле value
    private final String value;

    // Метод getter для поля value
    public String getValue() {
        return value;
    }

    // ВАЖНО: Конструктор должен быть приватным
    // Мы не хотим, чтобы пользователь мог создавать новые объекты класса Singleton
    private Singleton(String value) {
        this.value = value;
    }

    // Вот этот статический метод будет вызывать пользователь, чтобы получить объект класса Singleton
    public static Singleton getInstance(String value) {
        // если ранее не был создан единственный объект
        if (instance == null) {
            // код здесь выполняется только в момент первого вызова метода getInstance()

            // создаем объект один раз
            instance = new Singleton(value);
        }

        // все остальные вызовы метода getInstance() пользователю возвращается тот же самый объект
        return instance;
    }
}

// Тестируем
class SingletonTest {
    public static void main(String[] args) {
        Singleton first = Singleton.getInstance("Hello!");
        Singleton second = Singleton.getInstance("Goodbye!");

        // true
        System.out.println(first == second);

        // Hello!
        System.out.println(first.getValue());

        // Hello!
        System.out.println(second.getValue());
    }
}



