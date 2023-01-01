import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {

    private static Logger logger;
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalArgumentException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        logger = LogManager.getRootLogger();

        String[] components = data.split("\\s+");
        if (components.length > 4) {
            logger.log(Level.WARN, "Wrong format account. Correct format: Василий Петров vasily.petrov@gmail.com +79215637722");
            throw new IllegalArgumentException("Wrong format account. Correct format: Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (components.length < 4) {
            logger.log(Level.WARN, "Wrong format account. Correct format: Василий Петров vasily.petrov@gmail.com +79215637722");
            throw new IllegalArgumentException("Wrong format account. Correct format: Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (components.length == 4) {
            if (!checkName(components[0])) {
                logger.log(Level.WARN, "Wrong format name. Correct format: Василий");
                throw new IllegalArgumentException("Wrong format name. Correct format: Василий");
            }
            if (!checkSurname(components[1])) {
                logger.log(Level.WARN, "Wrong format surname. Correct format: Петров");
                throw new IllegalArgumentException("Wrong format surname. Correct format: Петров");
            }
            if (!checkEmail(components[2])) {
                logger.log(Level.WARN, "Wrong format Email. Correct format: vasily.petrov@gmail.com");
                throw new IllegalArgumentException("Wrong format Email. Correct format: vasily.petrov@gmail.com");
            }
            if (!checkPhone(components[3])) {
                logger.log(Level.WARN, "Wrong format phone. Correct format: +79215637722");
                throw new IllegalArgumentException("Wrong format phone. Correct format: +79215637722");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        logger = LogManager.getRootLogger();
        if(storage.remove(name) == null){
            logger.log(Level.WARN, "Запись не найдена");
            System.out.println("Запись не найдена");
        } else {
            storage.remove(name);
            logger.info("Запись удалена");
            System.out.println("Запись удалена");
        }
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    public static boolean checkName(String string) {
        String regexName = "[А-Я][а-я]+";

        Pattern pattern = Pattern.compile(regexName);
        Matcher matcher = pattern.matcher(string);
        boolean matches = matcher.matches();

        return matches;
    }

    public static boolean checkSurname(String string) {
        String regexName = "[А-Я][а-я]+";

        Pattern pattern = Pattern.compile(regexName);
        Matcher matcher = pattern.matcher(string);
        boolean matches = matcher.matches();

        return matches;
    }

    public static boolean checkPhone(String string) {
        String[] components = string.split("\\s+");
        String regexPhone = "[+?][0-9]{11}";

        Pattern pattern = Pattern.compile(regexPhone);
        Matcher matcher = pattern.matcher(string);
        boolean matches = matcher.matches();

        return matches;
    }

    public static boolean checkEmail(String string) {
        String[] components = string.split("\\s+");
        String regexEmail = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";

        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(string);
        boolean matches = matcher.matches();

        return matches;
    }


}