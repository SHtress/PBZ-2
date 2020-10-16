package com.company;

//import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/laba2?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            Scanner scanner = new Scanner(System.in);
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Controller controller = new Controller(conn);
                //controller.addingInventory("Грабли","Инструмент");
                //controller.UpdatingInventory("Инструмент", "Инструмент", "Лопата", "Инструмент");
                //controller.DeletingInventory("","Спецодежда");
               // controller.showingInventory();
                //controller.addingStorage(2,"BASE",653);
                //controller.addingAddition(2, Date.valueOf("2015-05-12"), "Лопата", 5, "Сидоров", "Завхоз");
                //controller.addingConsumption(2, Date.valueOf("2015-07-3"), "Лопата", 2 , "Петров", "Завхоз");
                //controller.showingConsumption();
                while(true) {
                    System.out.println("Выберите действие:");
                    System.out.println("1.Добавление/редактирование/удаление информации о рабочем инвентаре.");
                    System.out.println("2.Добавление/редактирование/удаление информации о складах.");
                    System.out.println("3.Добавление/редактирование/удаление информации о приходе и расходе рабочего инвентаря.");
                    System.out.println("4.Просмотр списка инвентаря заданного типа на заданном складе и его количество на текущую дату.");
                    System.out.println("5.Просмотр списка всех приходов и расходов инвентаря заданного наименования на всех складах");
                    System.out.println("6.Просмотр списка всех складов, отсортированных по названию на текущую дату.");
                    String answer = scanner.nextLine();

                    switch (answer) {
                        case "1": {
                            System.out.println("Выберите действие:");
                            System.out.println("1.Добавление информации о рабочем инвентаре.");
                            System.out.println("2.Редактирование информации о рабочем инвентаре.");
                            System.out.println("3.Удаление информаации о рабочем инвентаре.");
                            String inventory_answer = scanner.nextLine();
                            switch (inventory_answer){
                                case "1": {
                                    System.out.println("Введите имя инвенторя");
                                    String inventory_name = scanner.nextLine();
                                    System.out.println("Введите тип инвенторя");
                                    String inventory_type = scanner.nextLine();
                                    controller.addingInventory(inventory_name, inventory_type);
                                    break;
                                }
                                case "2": {
                                    System.out.println("Введите имя инвенторя");
                                    String inventory_name = scanner.nextLine();
                                    System.out.println("Введите тип инвенторя");
                                    String inventory_type = scanner.nextLine();
                                    System.out.println("Введите новое имя инвенторя");
                                    String new_inventory_name = scanner.nextLine();
                                    System.out.println("Введите новое тип инвенторя");
                                    String new_inventory_type = scanner.nextLine();
                                    controller.updatingInventory(inventory_name,inventory_type,new_inventory_name,new_inventory_type);
                                    break;
                                }
                                case "3": {
                                    System.out.println("Введите имя инвенторя");
                                    String inventory_name = scanner.nextLine();
                                    System.out.println("Введите тип инвенторя");
                                    String inventory_type = scanner.nextLine();
                                    controller.deletingInventory(inventory_name,inventory_type);
                                    break;
                                }}
                            break;
                        }
                        case "2": {
                            System.out.println("Выберите действие:");
                            System.out.println("1.Добавление информации о складах.");
                            System.out.println("2.Редактирование информации о складах.");
                            System.out.println("3.Удаление информаации о складах.");
                            String storage_answer = scanner.nextLine();
                            switch (storage_answer){
                                case "1": {
                                    System.out.println("Введите номер склада");
                                    String storage_number = scanner.nextLine();
                                    System.out.println("Введите имя склада");
                                    String storage_name = scanner.nextLine();
                                    System.out.println("Введите телефон склада");
                                    String storage_phone = scanner.nextLine();
                                    controller.addingStorage(Integer.parseInt(storage_number), storage_name, Integer.parseInt(storage_phone));
                                    break;
                                }
                                case "2": {
                                    System.out.println("Введите номер инвенторя");
                                    String storage_number = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String storage_name = scanner.nextLine();
                                    System.out.println("Введите телефон склада");
                                    String storage_phone = scanner.nextLine();
                                    System.out.println("Введите новый номер склада");
                                    String new_storage_name = scanner.nextLine();
                                    System.out.println("Введите новое имя склада");
                                    String new_storage_type = scanner.nextLine();
                                    System.out.println("Введите новый телефон склада");
                                    String new_storage_phone = scanner.nextLine();
                                    controller.updatingStorage(Integer.parseInt(storage_number),storage_name, Integer.parseInt(storage_phone),Integer.parseInt(new_storage_name),new_storage_type,Integer.parseInt(new_storage_phone));
                                    break;
                                }
                                case "3": {
                                    System.out.println("Введите номер склада");
                                    String storage_number = scanner.nextLine();
                                    System.out.println("Введите имя склада");
                                    String storage_name = scanner.nextLine();
                                    System.out.println("Введите телефон склада");
                                    String storage_phone = scanner.nextLine();
                                    controller.deletingStorage(Integer.parseInt(storage_number), storage_name, Integer.parseInt(storage_phone));
                                    break;
                                }}
                                break;
                                }
                        case "3": {
                            System.out.println("Выберите действие:");
                            System.out.println("1.Добавление информации о приходе рабочего инвентаря.");
                            System.out.println("2.Редактирование информации о приходе инвентаря.");
                            System.out.println("3.Удаление информаации о приходе рабочего инвентаря.");
                            System.out.println("4.Добавление информации о расходе рабочего инвентаря.");
                            System.out.println("5.Редактирование информации о расходе инвентаря.");
                            System.out.println("6.Удаление информаации о расходе рабочего инвентаря.");
                            String addition_consumption_answer = scanner.nextLine();
                            switch (addition_consumption_answer){
                                case "1": {
                                    System.out.println("Введите номер склада");
                                    String storage_number = scanner.nextLine();
                                    System.out.println("Введите дату прихода");
                                    String addition_date = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventory_name = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventory_amount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String addition_fio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String addition_post = scanner.nextLine();
                                    controller.addingAddition(Integer.parseInt(storage_number), Date.valueOf(addition_date), inventory_name, Integer.parseInt(inventory_amount), addition_fio, addition_post);
                                    break;
                                }
                                case "2": {
                                    System.out.println("Введите номер склада");
                                    String storage_number = scanner.nextLine();
                                    System.out.println("Введите дату прихода");
                                    String addition_date = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventory_name = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventory_amount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String addition_fio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String addition_post = scanner.nextLine();
                                    System.out.println("Введите новый номер склада");
                                    String new_storage_number = scanner.nextLine();
                                    System.out.println("Введите новую дату прихода");
                                    String new_addition_date = scanner.nextLine();
                                    System.out.println("Введите новое имя инвенторя");
                                    String new_inventory_name = scanner.nextLine();
                                    System.out.println("Введите новое количество инвенторя");
                                    String new_inventory_amount = scanner.nextLine();
                                    System.out.println("Введите новое ФИО сотрудника");
                                    String new_addition_fio = scanner.nextLine();
                                    System.out.println("Введите новую должность сотрудника");
                                    String new_addition_post = scanner.nextLine();
                                    controller.updatingAddition(Integer.parseInt(new_storage_number), Date.valueOf(new_addition_date), new_inventory_name, Integer.parseInt(new_inventory_amount), new_addition_fio, new_addition_post,
                                                                Integer.parseInt(storage_number), Date.valueOf(addition_date), inventory_name, Integer.parseInt(inventory_amount), addition_fio, addition_post);
                                }
                            }

                        }
                    }
                }


                }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
