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
                while (true) {
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
                            switch (inventory_answer) {
                                case "1": {
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите тип инвенторя");
                                    String inventoryType = scanner.nextLine();
                                    controller.addingInventory(inventoryName, inventoryType);
                                    break;
                                }
                                case "2": {
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите тип инвенторя");
                                    String inventoryType = scanner.nextLine();
                                    System.out.println("Введите новое имя инвенторя");
                                    String newInventoryName = scanner.nextLine();
                                    System.out.println("Введите новое тип инвенторя");
                                    String newInventoryType = scanner.nextLine();
                                    controller.updatingInventory(inventoryName, inventoryType, newInventoryName, newInventoryType);
                                    break;
                                }
                                case "3": {
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите тип инвенторя");
                                    String inventoryType = scanner.nextLine();
                                    controller.deletingInventory(inventoryName, inventoryType);
                                    break;
                                }
                            }
                            break;
                        }
                        case "2": {
                            System.out.println("Выберите действие:");
                            System.out.println("1.Добавление информации о складах.");
                            System.out.println("2.Редактирование информации о складах.");
                            System.out.println("3.Удаление информаации о складах.");
                            String storageAnswer = scanner.nextLine();
                            switch (storageAnswer) {
                                case "1": {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите имя склада");
                                    String storageName = scanner.nextLine();
                                    System.out.println("Введите телефон склада");
                                    String storagePhone = scanner.nextLine();
                                    controller.addingStorage(Integer.parseInt(storageNumber), storageName, Integer.parseInt(storagePhone));
                                    break;
                                }
                                case "2": {
                                    System.out.println("Введите номер инвенторя");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String storageName = scanner.nextLine();
                                    System.out.println("Введите телефон склада");
                                    String storagePhone = scanner.nextLine();
                                    System.out.println("Введите новый номер склада");
                                    String newStorageName = scanner.nextLine();
                                    System.out.println("Введите новое имя склада");
                                    String newStorageType = scanner.nextLine();
                                    System.out.println("Введите новый телефон склада");
                                    String newStoragePhone = scanner.nextLine();
                                    controller.updatingStorage(Integer.parseInt(storageNumber), storageName, Integer.parseInt(storagePhone), Integer.parseInt(newStorageName), newStorageType, Integer.parseInt(newStoragePhone));
                                    break;
                                }
                                case "3": {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите имя склада");
                                    String storageName = scanner.nextLine();
                                    System.out.println("Введите телефон склада");
                                    String storagePhone = scanner.nextLine();
                                    controller.deletingStorage(Integer.parseInt(storageNumber), storageName, Integer.parseInt(storagePhone));
                                    break;
                                }
                            }
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
                            String additionConsumptionAnswer = scanner.nextLine();
                            switch (additionConsumptionAnswer) {
                                case "1": {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите дату прихода");
                                    String additionDate = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventoryAmount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String additionFio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String additionPost = scanner.nextLine();
                                    controller.addingAddition(Integer.parseInt(storageNumber), Date.valueOf(additionDate), inventoryName, Integer.parseInt(inventoryAmount), additionFio, additionPost);
                                    break;
                                }
                                case "2": {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите дату прихода");
                                    String additionDate = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventoryAmount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String additionFio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String additionPost = scanner.nextLine();
                                    System.out.println("Введите новый номер склада");
                                    String newStorageNumber = scanner.nextLine();
                                    System.out.println("Введите новую дату прихода");
                                    String newAdditionDate = scanner.nextLine();
                                    System.out.println("Введите новое имя инвенторя");
                                    String newInventoryName = scanner.nextLine();
                                    System.out.println("Введите новое количество инвенторя");
                                    String newInventoryAmount = scanner.nextLine();
                                    System.out.println("Введите новое ФИО сотрудника");
                                    String newAdditionFio = scanner.nextLine();
                                    System.out.println("Введите новую должность сотрудника");
                                    String newAdditionPost = scanner.nextLine();
                                    controller.updatingAddition(Integer.parseInt(newStorageNumber), Date.valueOf(newAdditionDate), newInventoryName, Integer.parseInt(newInventoryAmount), newAdditionFio, newAdditionPost,
                                            Integer.parseInt(storageNumber), Date.valueOf(additionDate), inventoryName, Integer.parseInt(inventoryAmount), additionFio, additionPost);
                                    break;
                                }
                                case "3": {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите дату прихода");
                                    String additionDate = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventoryAmount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String additionFio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String additionPost = scanner.nextLine();
                                    controller.deletingAddition(Integer.parseInt(storageNumber),Date.valueOf(additionDate), inventoryName,Integer.parseInt(inventoryAmount), additionFio, additionPost);
                                    break;
                                }
                                case "4" : {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите дату расхода");
                                    String consumptionDate = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventoryAmount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String consumptionFio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String consumptionPost = scanner.nextLine();
                                    controller.addingConsumption(Integer.parseInt(storageNumber), Date.valueOf(consumptionDate), inventoryName, Integer.parseInt(inventoryAmount), consumptionFio, consumptionPost);
                                    break;
                                }
                                case "5" : {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите дату расхода");
                                    String additionDate = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventoryAmount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String additionFio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String additionPost = scanner.nextLine();
                                    System.out.println("Введите новый номер склада");
                                    String newStorageNumber = scanner.nextLine();
                                    System.out.println("Введите новую дату расхода");
                                    String newAdditionDate = scanner.nextLine();
                                    System.out.println("Введите новое имя инвенторя");
                                    String newInventoryName = scanner.nextLine();
                                    System.out.println("Введите новое количество инвенторя");
                                    String newInventoryAmount = scanner.nextLine();
                                    System.out.println("Введите новое ФИО сотрудника");
                                    String newAdditionFio = scanner.nextLine();
                                    System.out.println("Введите новую должность сотрудника");
                                    String newAdditionPost = scanner.nextLine();
                                    controller.updatingConsumption(Integer.parseInt(newStorageNumber), Date.valueOf(newAdditionDate), newInventoryName, Integer.parseInt(newInventoryAmount), newAdditionFio, newAdditionPost,
                                            Integer.parseInt(storageNumber), Date.valueOf(additionDate), inventoryName, Integer.parseInt(inventoryAmount), additionFio, additionPost);
                                    break;
                                }
                                case "6" : {
                                    System.out.println("Введите номер склада");
                                    String storageNumber = scanner.nextLine();
                                    System.out.println("Введите дату расхода");
                                    String consumptionDate = scanner.nextLine();
                                    System.out.println("Введите имя инвенторя");
                                    String inventoryName = scanner.nextLine();
                                    System.out.println("Введите количество инвенторя");
                                    String inventoryAmount = scanner.nextLine();
                                    System.out.println("Введите ФИО сотрудника");
                                    String consumptionFio = scanner.nextLine();
                                    System.out.println("Введите должность сотрудника");
                                    String consumptionPost = scanner.nextLine();
                                    controller.deletingConsumption(Integer.parseInt(storageNumber), Date.valueOf(consumptionDate), inventoryName, Integer.parseInt(inventoryAmount), consumptionFio, consumptionPost);
                                    break;
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
