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
            addingInventoryStatement = conn.prepareStatement("INSERT INTO inventory(inventory_name, inventory_type) VALUES (?, ?)");
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
            updatingInventoryStatement = conn.prepareStatement("UPDATE inventory SET inventory_name = ? , inventory_type = ? WHERE inventory_name = ? && inventory_type = ?");
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
            deletingInventoryStatement = conn.prepareStatement("DELETE FROM inventory WHERE inventory_name = ? && inventory_type = ?");
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
                String name_inventory = resultSet.getString("inventory_name");
                String type_inventory = resultSet.getString("inventory_type");
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

    void addingAddition(int storage_number, Date addition_date, String inventory_name, int inventory_amount, String addition_fio, String addition_post) {
        PreparedStatement addingAdditionStatement = null;
        try {
            addingAdditionStatement = conn.prepareStatement("INSERT INTO addition( storage_number, addition_date, inventory_name, inventory_amount, addition_fio, addition_post) VALUES (?,?,?,?,?,?)");
            addingAdditionStatement.setInt(1, storage_number);
            addingAdditionStatement.setDate(2, addition_date);
            addingAdditionStatement.setString(3, inventory_name);
            addingAdditionStatement.setInt(4, inventory_amount);
            addingAdditionStatement.setString(5, addition_fio);
            addingAdditionStatement.setString(6, addition_post);
            addingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingAddition(int new_storage_number,Date new_addition_date, String new_inventory_name, int new_inventory_amount ,String new_addition_fio, String new_addition_post,
                          int old_storage_number, Date old_addition_date, String old_inventory_name, int old_inventory_amount ,String old_addition_fio, String old_addition_post) {
        PreparedStatement updatingAdditionStatement = null;
        try {
            updatingAdditionStatement = conn.prepareStatement("UPDATE addition SET addition_date = ?, inventory_name = ?, inventory_amount = ?, addition_fio = ?, addition_post = ?  WHERE storage_number = ? AND addition_date = ? AND inventory_name = ? AND inventory_amount = ? AND addition_fio = ? AND addition_post = ? ");
            updatingAdditionStatement.setInt(1,new_storage_number);
            updatingAdditionStatement.setDate(2, new_addition_date);
            updatingAdditionStatement.setString(3, new_inventory_name);
            updatingAdditionStatement.setInt(4, new_inventory_amount);
            updatingAdditionStatement.setString(5, new_addition_fio);
            updatingAdditionStatement.setString(6, new_addition_post);
            updatingAdditionStatement.setInt(7, old_storage_number);
            updatingAdditionStatement.setDate(8, old_addition_date);
            updatingAdditionStatement.setString(9, old_inventory_name);
            updatingAdditionStatement.setInt(10, old_inventory_amount);
            updatingAdditionStatement.setString(11, old_addition_fio);
            updatingAdditionStatement.setString(12, old_addition_post);
            updatingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingAddition(int storage_number, Date addition_date, String inventory_name, int inventory_amount, String addition_fio, String addition_post) {
        PreparedStatement deletingAdditionStatement = null;
        try {
            deletingAdditionStatement = conn.prepareStatement("DELETE FROM addition WHERE storage_number=? AND addition_date = ? AND inventory_name = ? AND inventory_amount = ? AND addition_fio = ? AND addition_post =?");
            deletingAdditionStatement.setInt(1,storage_number);
            deletingAdditionStatement.setDate(2, addition_date);
            deletingAdditionStatement.setString(3, inventory_name);
            deletingAdditionStatement.setInt(4, inventory_amount);
            deletingAdditionStatement.setString(5, addition_fio);
            deletingAdditionStatement.setString(6, addition_post);
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
                int storage_number = resultSet.getInt("storage_number");
                Date addition_date = resultSet.getDate("addition_date");
                String inventory_name = resultSet.getString("inventory_name");
                int inventory_amount = resultSet.getInt("inventory_amount");
                String addition_fio = resultSet.getString("addition_fio");
                String addition_post = resultSet.getString("addition_post");
                System.out.printf(storage_number + " " +addition_date + " " + inventory_name + " " + inventory_amount + " " + addition_fio + " " + addition_post + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingConsumption(int storage_number, Date consumption_date, String inventory_name, int inventory_amount, String consumption_fio, String consumption_post) {
        PreparedStatement addingConsumptionStatement = null;
        try {
            addingConsumptionStatement = conn.prepareStatement("INSERT INTO consumption(storage_number, consumption_date, inventory_name, inventory_amount, consumption_fio, consumption_post) VALUES (?,?,?,?,?,?)");
            addingConsumptionStatement.setInt(1,storage_number);
            addingConsumptionStatement.setDate(2, consumption_date);
            addingConsumptionStatement.setString(3, inventory_name);
            addingConsumptionStatement.setInt(4, inventory_amount);
            addingConsumptionStatement.setString(5, consumption_fio);
            addingConsumptionStatement.setString(6, consumption_post);
            addingConsumptionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingConsumption(int new_storage_number, Date new_consumption_date, String new_inventory_name, int new_inventory_amount ,String new_consumption_fio, String new_consumption_post,
                             int old_storage_number, Date old_consumption_date, String old_inventory_name, int old_inventory_amount ,String old_consumption_fio, String old_consumption_post) {
        PreparedStatement updatingConsumptionStatement = null;
        try {
            updatingConsumptionStatement = conn.prepareStatement("UPDATE consumption SET consumption_date = ?, inventory_name = ?, inventory_amount = ?, consumption_fio = ?, consumption_post = ?  WHERE consumption_date = ? AND inventory_name = ? AND inventory_amount = ? AND consumption_fio = ? AND consumption_post = ? ");
            updatingConsumptionStatement.setDate(1, new_consumption_date);
            updatingConsumptionStatement.setString(2, new_inventory_name);
            updatingConsumptionStatement.setInt(3, new_inventory_amount);
            updatingConsumptionStatement.setString(4, new_consumption_fio);
            updatingConsumptionStatement.setString(5, new_consumption_post);
            updatingConsumptionStatement.setDate(6, old_consumption_date);
            updatingConsumptionStatement.setString(7, old_inventory_name);
            updatingConsumptionStatement.setInt(8, old_inventory_amount);
            updatingConsumptionStatement.setString(9, old_consumption_fio);
            updatingConsumptionStatement.setString(10, old_consumption_post);
            updatingConsumptionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingConsumption(int storage_number, Date consumption_date, String inventory_name, int inventory_amount, String consumption_fio, String consumption_post) {
        PreparedStatement deletingConsumptionStatement = null;
        try {
            deletingConsumptionStatement = conn.prepareStatement("DELETE FROM consumption WHERE storage_number = ? AND consumption_date = ? AND inventory_name = ? AND inventory_amount = ? AND consumption_fio = ? AND consumption_post =?");
            deletingConsumptionStatement.setInt(1,storage_number);
            deletingConsumptionStatement.setDate(2, consumption_date);
            deletingConsumptionStatement.setString(3, inventory_name);
            deletingConsumptionStatement.setInt(4, inventory_amount);
            deletingConsumptionStatement.setString(5, consumption_fio);
            deletingConsumptionStatement.setString(6, consumption_post);
            deletingConsumptionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void showingConsumption() {
        PreparedStatement showingConsumptionStatement = null;
        try {
            showingConsumptionStatement = conn.prepareStatement("SELECT * FROM consumption");

            ResultSet resultSet = showingConsumptionStatement.executeQuery();
            while (resultSet.next()) {
                int storage_number = resultSet.getInt("storage_number");
                Date consumption_date = resultSet.getDate("consumption_date");
                String inventory_name = resultSet.getString("inventory_name");
                int inventory_amount = resultSet.getInt("inventory_amount");
                String consumption_fio = resultSet.getString("consumption_fio");
                String consumption_post = resultSet.getString("consumption_post");
                System.out.printf(storage_number + " " +consumption_date + " " + inventory_name + " " + inventory_amount + " " + consumption_fio + " " + consumption_post + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findInventoryByType(String inventory_type, int storage_number, Date current_date){
        PreparedStatement findingInventoryStatement = null;
        try {
            findingInventoryStatement = conn.prepareStatement("SELECT name_inventory, addition_amount, consumption_amount FROM  WHERE addition_date <= ? AND consumption_data <= ? AND inventory_type = ? AND storage_number = ?");
            findingInventoryStatement.setString(1,inventory_type);
            findingInventoryStatement.setInt(2,storage_number);
            findingInventoryStatement.setDate(3,current_date);

            ResultSet resultSet = findingInventoryStatement.executeQuery();
            int inventory_amount=0;

            while(resultSet.next()){
                String inventory_name = resultSet.getString("name_inventory");
                inventory_amount += resultSet.getInt("addition_amount");
                inventory_amount -= resultSet.getInt("consumption_amount");
                System.out.println(inventory_name + " " + inventory_amount);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findingAdditionAndConsumption(String inventory_name){
        PreparedStatement findingAdditionAndConsumptionStatement = null;
        try {
            findingAdditionAndConsumptionStatement = conn.prepareStatement("SELECT storage_number, inventory_name, addition_date, addition_amount, consumption_date, consumption_amount FROM WHERE inventory_name=?");
            findingAdditionAndConsumptionStatement.setString(1,inventory_name);

            ResultSet resultSet = findingAdditionAndConsumptionStatement.executeQuery();
            while(resultSet.next()){
                int storage_number = resultSet.getInt("storage_number");
                Date addition_date = resultSet.getDate("addition_date");
                int addition_amount = resultSet.getInt("addition_amount");
                Date consumption_date = resultSet.getDate("consumption_date");
                int consumption_amount = resultSet.getInt("consumption_amount");
                System.out.println(storage_number+ " " + addition_date + " " + addition_amount + " " + consumption_date + " " + consumption_amount + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void findingStorageByDate(Date storage_date){
        PreparedStatement findingStorageByDateStatement = null;
        try {
            findingStorageByDateStatement = conn.prepareStatement(
                    "SELECT DISTINCT * FROM storage WHERE storage_number" +
                        " IN (SELECT storage_number FROM addition JOIN consumption on" +
                        " consumption.storage_number = addition.storage_number WHERE addition_date = ?" +
                        " OR consumption_date = ?)");
            findingStorageByDateStatement.setDate(1,storage_date);
            findingStorageByDateStatement.setDate(2,storage_date);

            ResultSet resultSet = findingStorageByDateStatement.executeQuery();
            while(resultSet.next()){
                int storage_number=resultSet.getInt("storage_number");
                String storage_name = resultSet.getString("storage_name");
                int storage_phone = resultSet.getInt("storage_phone");
                System.out.println(storage_number + " " + storage_name + " " + storage_phone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}