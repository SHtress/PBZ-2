package com.company;

import java.sql.*;

public class Controller {
    Connection conn;

    Controller(Connection conn){
        this.conn=conn;
    }

    void AddingInventory(String name_inventory, String type_inventory) {
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

    void UpdatingInventory(String old_name_inventory, String old_type_inventory, String new_name_inventory, String new_type_inventory) {
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

    void DeletingInventory(String name_inventory, String type_inventory) {
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

    void ShowingInventory() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM inventory");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name_inventory = resultSet.getString("name_inventory");
                String type_inventory = resultSet.getString("type_inventory");
                System.out.printf(name_inventory + " " + type_inventory + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}