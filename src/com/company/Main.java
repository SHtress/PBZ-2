package com.company;

import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/laba2?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Controller controller = new Controller(conn);
                //controller.AddingInventory("Грабли","Инструмент");
                //controller.UpdatingInventory("Инструмент", "Инструмент", "Лопата", "Инструмент");
                controller.DeletingInventory("","Спецодежда");
                controller.ShowingInventory();
                //----------- Adding storage --------------------------------------//
//                int id_storage = 36;
//                String name_storage = "Красный";
//                int phone_storage = 890;
//                PreparedStatement addingStorageStatement = conn.prepareStatement("INSERT INTO storage(id_storage, name_storage, phone_storage) VALUES (?,?,?)");
//                addingStorageStatement.setInt(1, id_storage);
//                addingStorageStatement.setString(2, name_storage);
//                addingStorageStatement.setInt(3, phone_storage);
//                addingStorageStatement.executeUpdate();

                //----------- Updating storage --------------------------------------//
//                int id_storage = 36;
//                String name_storage = "Красный";
//                int phone_storage = 890;
//                PreparedStatement updatingStorageStatement = conn.prepareStatement("UPDATE storage SET id_storage = ? WHERE id_storage = ?");
//                updatingStorageStatement.setInt(1, id_storage);
//                updatingStorageStatement.setString(2, name_storage);
//                updatingStorageStatement.setInt(3, phone_storage);
//                updatingStorageStatement.executeUpdate();

                //----------- Deleting storage --------------------------------------//
//                int id_storage = 36;
//                String name_storage = "Красный";
//                int phone_storage = 890;
//                PreparedStatement updatingStorageStatement = conn.prepareStatement("DELETE FROM storage WHERE id_storage = ?");
//                updatingStorageStatement.setInt(1, id_storage);
//                updatingStorageStatement.setString(2, name_storage);
//                updatingStorageStatement.setInt(3, phone_storage);
//                updatingStorageStatement.executeUpdate();

                //------------Showing storage table---------------------------------------//
//                PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM storage");
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    int id_storage = resultSet.getInt("id_storage");
//                    String name_storage = resultSet.getString("name_storage");
//                    int phone_storage = resultSet.getInt("phone_storage");
//                    System.out.printf(id_storage + " " + name_storage + " " + phone_storage + "\n");
//                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
