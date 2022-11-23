package com.my;

import data.*;
import service.DataGroupService;
import service.DataService;
import service.StudentsGroupService;
import util.ReaderFromTxt;
import util.WriterToTxt;

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
        groupList.add(new Teacher("Математика","Александр", "11.05.1974"));
        groupList.add(new Student("012","Иван", "20.06.1984"));
        groupList.add(new Student("013","Павел", "28.01.1985"));
        groupList.add(new Student("014","Ирина", "05.08.1984"));
        groupList.add(new Student("015","Сергей", "04.09.1983"));
        groupList.add(new Student("016","Анна", "17.12.1984"));
        StudentsGroup bestGroup = new StudentsGroup(groupList);

        for(User s: bestGroup.getMembers()) {
            logger.info(s.toString());
        }

        DataGroupService dataService = new StudentsGroupService();
        dataService.create(bestGroup);

        logger.info("Данные записаны!");
        logger.info("Читаем данные в другой объект!");

        StudentsGroup anotherGroup = dataService.read("group.txt");///!!!!!!!!!!!!!!!!!!!!!!!!!!! TYT!!!!

        //DataGroupService anotherDataService = (DataGroupService) dataService.read("gpoup.txt");

        for(User s: anotherGroup.getMembers()) {
            logger.info(s.toString());
        }


        //        WriterToTxt.write(teacher);
//        logger.info(ReaderFromTxt.read("user.txt").toString());
//        DataService dataService = new StudentService();
//        dataService.create(student);
//        dataService.create(teacher);
    }
}
