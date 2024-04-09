import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Person {
    private String name, surname, patronymic;
    private String sex;
    private LocalDate birthDate;

    public Person() {
        name = "";
        surname = "";
        patronymic = "";
        sex = "None";
        birthDate = LocalDate.of(1,1,1);
    }

    public Person(String surname, String name, String patronymic, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        if (patronymic.endsWith("а")) {
            this.sex = "женский";
        }
        else {
            this.sex = "мужской";
        }
    }

    public void setSex() {
        if (patronymic.endsWith("а")) {
            this.sex = "женский";
        }
        else {
            this.sex = "мужской";
        }
    }

    public String getFullName() {
        return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите фамилию: ");
            this.surname = scanner.nextLine();

            System.out.print("Введите имя: ");
            this.name = scanner.nextLine();

            System.out.print("Введите отчество: ");
            this.patronymic = scanner.nextLine();

            boolean validDate = false;
            while (!validDate) {
                try {
                    System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                    String birthDateStr = scanner.nextLine();
                    this.birthDate = LocalDate.parse(birthDateStr);
                    validDate = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Неверный формат даты. Введите дату рождения в формате ГГГГ-ММ-ДД.");
                }
            }

            setSex();

        } finally {
            scanner.close();
        }
    }

    public void print() {
        System.out.println("Результат:");
        System.out.print(this.getFullName() + ", " + sex + " пол" + ", " + this.getAge());
        if (this.getAge() % 10 == 1 && this.getAge()/10 != 1) {
            System.out.println(" год.");
        }
        else if ((this.getAge()%10 == 2 || this.getAge()%10 == 3 ||  this.getAge()%10 == 4) && this.getAge()/10 != 1) {
            System.out.println(" года.");
        }
        else {
            System.out.println(" лет.");
        }
    }
}
