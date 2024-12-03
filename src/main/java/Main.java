import java.util.Scanner;
public class Main {
    // Класс "Автомобиль"
    static class Car {
        private final String name; // Нельзя изменить
        private final int speed;
        public Car(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
        public String getName() {
            return name;
        }
        public int getSpeed() {
            return speed;
        }
    }
    // Класс "Гонка"
    static class Race {
        private String leaderName = "";
        private int maxDistance = 0;
        public void updateLeader(Car car) {
            int distance = car.getSpeed() * 24; // Расчёт дистанции
            if (distance > maxDistance) {
                maxDistance = distance;
                leaderName = car.getName();
            }
        }
        public String getLeaderName() {
            return leaderName;
        }
    }
    // Основной метод программы
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Экземпляр Scanner для ввода данных
        Race race = new Race(); // Экземпляр гонки для отслеживания лидера
        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.nextLine(); // Считывание строки с пробелами
            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                if (scanner.hasNextInt()) { // Проверка ввода числа
                    speed = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера после nextInt()
                    if (speed > 0 && speed <= 250) { // Проверка диапазона
                        break;
                    } else {
                        System.out.println("Неверная скорость! Попробуйте снова.");
                    }
                } else {
                    System.out.println("Некорректный ввод. Введите целое число.");
                    scanner.nextLine(); // Очистка некорректного ввода
                }
            }
            Car car = new Car(name, speed); // Создаём объект автомобиля
            race.updateLeader(car); // Обновляем лидера гонки
        }
        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close(); // Закрываем Scanner
    }
}