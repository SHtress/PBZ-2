package com.company;

//import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.*;
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
                //controller.AddingInventory("Грабли","Инструмент");
                //controller.UpdatingInventory("Инструмент", "Инструмент", "Лопата", "Инструмент");
                //controller.DeletingInventory("","Спецодежда");
                //controller.ShowingInventory();
                //controller.addingStorage(2,"BASE",653);
                while(true){

                    String str=scanner.nextLine();
                }

            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
