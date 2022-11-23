package com.my;

import data.*;
import service.DataGroupService;
import service.StudentsGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
/*  ЗАДАНИЕ НА СЕМИНАР
Реализовать абстрактный класс User и его наследники Student и Teacher.
Родитель имеет в себе общие данные (пример: фио, год рождения и тд),
а наследники собственные параметры (какие, по выбору преподавателя –
Пример: studentId для Student, disciplesTaught для Teacher).

1. Создать package – util. Работу продолжаем в нем
2. Создать классы WriterToTxt и ReaderFromTxt
   имеющие статичные методы для записи/чтения в/из txt файла

1. Создать package – service. Работу продолжаем в нем
2. Создать интерфейс DataService описывающий реализацию
   конкретных сервисов по управлению сущностями (create, read)
3. Создать для сущности Student отдельный Service реализующий
   интерфейс DataService. Create и read операции реализуются путем вызова utils методов
*/

/*   ДОМАШНЕЕ ЗАДАЕНИЕ
Задание 1
1. Создать класс УчебнаяГруппа содержащая в себе поля Преподаватель и список Студентов
2. Создать класс УчебнаяГруппаСервис, в котором реализована логика чтения Студентов и Преподавателя
   из файла TXT, создания класса УчебнаяГруппа и возвращения его
3. Создать метод в Контроллере, в котором агрегируются
4. Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре
 */

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        List<User> groupList = new ArrayList<User>();

        // Не стал выделять в классе отдельно учителя. Решил хранить учителя и студентов
        // в одной коллекции. Студетнов и учителя отличаю по наименованию класса в коллекции
        // Такая у нас группа:
        groupList.add(new Teacher("Математика","Александр", "11.05.1974"));
        groupList.add(new Student("012","Иван", "20.06.1984"));
        groupList.add(new Student("013","Павел", "28.01.1985"));
        groupList.add(new Student("014","Ирина", "05.08.1984"));
        groupList.add(new Student("015","Сергей", "04.09.1983"));
        groupList.add(new Student("016","Анна", "17.12.1984"));

        StudentsGroup bestGroup = new StudentsGroup(groupList);

        for(User s: bestGroup.getMembers()) {  // Красиво выводим в лог
            logger.info(s.toString());
        }

        DataGroupService dataService = new StudentsGroupService();
        dataService.create(bestGroup);  // Сохраняем все в файл

        logger.info("Данные записаны!");
        logger.info("Читаем данные в другой объект!");

        // Для теста читаем из только что соозданного файла все в новый экземпляр класса
        StudentsGroup anotherGroup = dataService.read("group.txt");
        for(User s: anotherGroup.getMembers()) {
            logger.info(s.toString());
        }
        logger.info("Работа завершена.");
    }
}

/* Вывод программы:
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Преподаватель Имя: Александр День рождения: 11.05.1974 Предмет: Математика
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Иван День рождения: 20.06.1984 Идентификатор: 012
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Павел День рождения: 28.01.1985 Идентификатор: 013
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Ирина День рождения: 05.08.1984 Идентификатор: 014
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Сергей День рождения: 04.09.1983 Идентификатор: 015
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Анна День рождения: 17.12.1984 Идентификатор: 016
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Данные записаны!
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Читаем данные в другой объект!
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Преподаватель Имя: Александр День рождения: 11.05.1974 Предмет: Математика
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Иван День рождения: 20.06.1984 Идентификатор: 012
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Павел День рождения: 28.01.1985 Идентификатор: 013
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Ирина День рождения: 05.08.1984 Идентификатор: 014
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Сергей День рождения: 04.09.1983 Идентификатор: 015
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Тип: Студент Имя: Анна День рождения: 17.12.1984 Идентификатор: 016
нояб. 23, 2022 9:21:17 PM com.my.Main main
INFO: Работа завершена.
 */