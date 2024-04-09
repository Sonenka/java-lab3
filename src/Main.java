import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        person.inputData();

        person.print();
    }
}