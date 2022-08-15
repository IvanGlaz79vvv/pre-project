/**
 * Практическая задача
 * В этом задании мы познакомимся с такими технологиями, как:
 * <p>
 * Maven  - https://maven.apache.org/
 * JDBC - https://o7planning.org/ru/10167/java-jdbc-tutorial
 * <p>
 * <p>
 * Для выполнения задания необходимо:
 * <p>
 * Клонировать/скачать заготовку по ссылке
 * Установить на компьютер MySqlServer и Workbench. Создать подключение и схему через Workbench. Протестировать возможность соединения с базой через идею с помощью встроенной утилиты, как показано на рисунке:
 * mysql
 * <p>
 * <p>
 * <p>
 * Описание задачи:
 * <p>
 * Необходимо ознакомиться с заготовкой и доработать приложение, которое взаимодействует с базой оперируя пользователем ( класс User ) и проверить свои методы заранее написанными JUnit тестами. По итогу все тесты должны быть пройдены. Разрешается посмотреть реализацию тестов.
 * <p>
 * Для запуска теста необходимо найти класс в папке test ( показано в предыдущей лекции ) и при нажатии на него правой кнопкой мыши запустить, выбрав Run "Имя класса"
 * <p>
 * Класс UserHibernateDaoImpl в рамках этой задачи не затрагивается (остаётся пустой)
 * <p>
 * User представляет из себя сущность с полями:
 * <p>
 * Long id
 * String name
 * String lastName
 * Byte age
 * Архитектура приложения создана с опорой на паттерн проектирования MVC ( частично, у нас не WEB приложение)
 * <p>
 * Ознакомиться с паттерном можно здесь
 * <p>
 * <p>
 * <p>
 * Требования к классам приложения:
 * <p>
 * Классы dao/service должны реализовывать соответствующие интерфейсы
 * Класс dao должен иметь конструктор пустой/по умолчанию
 * Все поля должны быть private
 * service переиспользует методы dao
 * Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
 * Класс Util должен содержать логику настройки соединения с базой данных
 * <p>
 * <p>
 * Необходимые операции:
 * <p>
 * Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
 * Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
 * Очистка содержания таблицы
 * Добавление User в таблицу
 * Удаление User из таблицы ( по id )
 * Получение всех User(ов) из таблицы
 * <p>
 * <p>
 * Алгоритм работы приложения:
 * <p>
 * В методе main класса Main должны происходить следующие операции:
 * <p>
 * Создание таблицы User(ов)
 * Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
 * Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
 * Очистка таблицы User(ов)
 * Удаление таблицы
 */
package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.*;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoJDBCImpl();


    public void createUsersTable() {
        userDao.createUsersTable();
        System.out.println("Таблица создана");

    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Таблица Удалена");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {

    }
}
