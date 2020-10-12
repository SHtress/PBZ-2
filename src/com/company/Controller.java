package com.company;

import java.sql.*;

public class Controller {
    Connection conn;

    Controller(Connection conn){
        this.conn=conn;
    }

    void addingInventory(String name_inventory, String type_inventory) {
        PreparedStatement addingInventoryStatement = null;
        try {
            addingInventoryStatement = conn.prepareStatement("INSERT INTO inventory(name_inventory, type_inventory) VALUES (?, ?)");
            addingInventoryStatement.setString(1, name_inventory);
            addingInventoryStatement.setString(2, type_inventory);
            addingInventoryStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingInventory(String old_name_inventory, String old_type_inventory, String new_name_inventory, String new_type_inventory) {
        PreparedStatement updatingInventoryStatement = null;
        try {
            updatingInventoryStatement = conn.prepareStatement("UPDATE inventory SET name_inventory = ? , type_inventory = ? WHERE name_inventory = ? && type_inventory = ?");
            updatingInventoryStatement.setString(1, new_name_inventory);
            updatingInventoryStatement.setString(2, new_type_inventory);
            updatingInventoryStatement.setString(3, old_name_inventory);
            updatingInventoryStatement.setString(4, old_type_inventory);
            updatingInventoryStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingInventory(String name_inventory, String type_inventory) {
        PreparedStatement deletingInventoryStatement = null;
        try {
            deletingInventoryStatement = conn.prepareStatement("DELETE FROM inventory WHERE name_inventory = ? && type_inventory = ?");
            deletingInventoryStatement.setString(1, name_inventory);
            deletingInventoryStatement.setString(2, type_inventory);
            deletingInventoryStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void showingInventory() {
        PreparedStatement showingInventory = null;
        try {
            showingInventory = conn.prepareStatement("SELECT * FROM inventory");
            ResultSet resultSet = showingInventory.executeQuery();
            while (resultSet.next()) {
                String name_inventory = resultSet.getString("name_inventory");
                String type_inventory = resultSet.getString("type_inventory");
                System.out.printf(name_inventory + " " + type_inventory + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void addingStorage(int storage_number, String storage_name, int storage_phone) {
        PreparedStatement addingStorageStatement = null;
        try {
            addingStorageStatement = conn.prepareStatement("INSERT INTO storage(storage_number, storage_name, storage_phone) VALUES (?,?,?)");
            addingStorageStatement.setInt(1, storage_number);
            addingStorageStatement.setString(2, storage_name);
            addingStorageStatement.setInt(3, storage_phone);
            addingStorageStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingStorage(int old_storage_number, String old_storage_name, int old_storage_phone ,int new_storage_number, String new_storage_name, int new_storage_phone) {
        PreparedStatement updatingStorageStatement = null;
        try {
            updatingStorageStatement = conn.prepareStatement("UPDATE storage SET storage_number = ?, storage_name = ?, storage_phone = ? WHERE storage_number = ? AND storage_name = ? AND storage_phone = ?");
            updatingStorageStatement.setInt(1, new_storage_number);
            updatingStorageStatement.setString(2, new_storage_name);
            updatingStorageStatement.setInt(3, new_storage_phone);
            updatingStorageStatement.setInt(4, old_storage_number);
            updatingStorageStatement.setString(5, old_storage_name);
            updatingStorageStatement.setInt(6, old_storage_phone);
            updatingStorageStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

   void deletingStorage(int storage_number, String storage_name, int storage_phone) {
       PreparedStatement deletingStorageStatement = null;
       try {
           deletingStorageStatement = conn.prepareStatement("DELETE FROM storage WHERE storage_number = ? AND storage_name = ? AND storage_phone = ?");
           deletingStorageStatement.setInt(1, storage_number);
           deletingStorageStatement.setString(2, storage_name);
           deletingStorageStatement.setInt(3, storage_phone);
           deletingStorageStatement.executeUpdate();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }

    void showingStorage() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM storage");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int storage_number = resultSet.getInt("storage_number");
            String storage_name = resultSet.getString("storage_name");
            int storage_phone = resultSet.getInt("storage_phone");
            System.out.printf(storage_number + " " + storage_name + " " + storage_phone + "\n");
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingAddition(Date addition_date, String inventory_name, int inventory_amount, String addition_fio, String addition_post) {
        PreparedStatement addingAdditionStatement = null;
        try {
            addingAdditionStatement = conn.prepareStatement("INSERT INTO addition(addition_date, inventory_name, inventory_amount, addition_fio, addition_post) VALUES (?,?,?,?,?)");
            addingAdditionStatement.setDate(1, addition_date);
            addingAdditionStatement.setString(2, inventory_name);
            addingAdditionStatement.setInt(3, inventory_amount);
            addingAdditionStatement.setString(4, addition_fio);
            addingAdditionStatement.setString(5, addition_post);
            addingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingAddition(Date new_addition_date, String new_inventory_name, int new_inventory_amount ,String new_addition_fio, String new_addition_post,
                          Date old_addition_date, String old_inventory_name, int old_inventory_amount ,String old_addition_fio, String old_addition_post) {
        PreparedStatement updatingAdditionStatement = null;
        try {
            updatingAdditionStatement = conn.prepareStatement("UPDATE storage SET addition_date = ?, inventory_name = ?, inventory_amount = ?, addition_fio = ?, addition_post = ?  WHERE addition_date = ? AND inventory_name = ? AND inventory_amount = ? AND addition_fio = ? AND addition_post = ? ");
            updatingAdditionStatement.setDate(1, new_addition_date);
            updatingAdditionStatement.setString(2, new_inventory_name);
            updatingAdditionStatement.setInt(3, new_inventory_amount);
            updatingAdditionStatement.setString(4, new_addition_fio);
            updatingAdditionStatement.setString(5, new_addition_post);
            updatingAdditionStatement.setDate(6, old_addition_date);
            updatingAdditionStatement.setString(7, old_inventory_name);
            updatingAdditionStatement.setInt(8, old_inventory_amount);
            updatingAdditionStatement.setString(9, old_addition_fio);
            updatingAdditionStatement.setString(10, old_addition_post);
            updatingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingAddition(Date addition_date, String inventory_name, int inventory_amount, String addition_fio, String addition_post) {
        PreparedStatement deletingAdditionStatement = null;
        try {
            deletingAdditionStatement = conn.prepareStatement("DELETE FROM storage WHERE addition_date = ? AND inventory_name = ? AND inventory_amount = ? AND addition_fio = ? AND addition_post =?");
            deletingAdditionStatement.setDate(1, addition_date);
            deletingAdditionStatement.setString(2, inventory_name);
            deletingAdditionStatement.setInt(3, inventory_amount);
            deletingAdditionStatement.setString(4, addition_fio);
            deletingAdditionStatement.setString(5, addition_post);
            deletingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void showingAddition() {
        PreparedStatement showingAdditionStatement = null;
        try {
            showingAdditionStatement = conn.prepareStatement("SELECT * FROM addition");

            ResultSet resultSet = showingAdditionStatement.executeQuery();
            while (resultSet.next()) {
                Date addition_date = resultSet.getDate("addition_date");
                String inventory_name = resultSet.getString("inventory_name");
                int inventory_amount = resultSet.getInt("inventory_amount");
                String addition_fio = resultSet.getString("addition_fio");
                String addition_post = resultSet.getString("addition_post");
                System.out.printf(addition_date + " " + inventory_name + " " + inventory_amount + " " + addition_fio + " " + addition_post + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}