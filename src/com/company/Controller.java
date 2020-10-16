package com.company;

import java.sql.*;

public class Controller {
    Connection conn;

    Controller(Connection conn) {
        this.conn = conn;
    }

    void addingInventory(String nameInventory, String typeInventory) {
        PreparedStatement addingInventoryStatement = null;
        try {
            addingInventoryStatement = conn.prepareStatement("INSERT INTO inventory(inventory_name, inventory_type) VALUES (?, ?)");
            addingInventoryStatement.setString(1, nameInventory);
            addingInventoryStatement.setString(2, typeInventory);
            addingInventoryStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingInventory(String oldNameInventory, String oldTypeInventory, String newNameInventory, String newTypeInventory) {
        PreparedStatement updatingInventoryStatement = null;
        try {
            updatingInventoryStatement = conn.prepareStatement("UPDATE inventory SET inventory_name = ? , inventory_type = ? WHERE inventory_name = ? && inventory_type = ?");
            updatingInventoryStatement.setString(1, newNameInventory);
            updatingInventoryStatement.setString(2, newTypeInventory);
            updatingInventoryStatement.setString(3, oldNameInventory);
            updatingInventoryStatement.setString(4, oldTypeInventory);
            updatingInventoryStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingInventory(String nameInventory, String typeInventory) {
        PreparedStatement deletingInventoryStatement = null;
        try {
            deletingInventoryStatement = conn.prepareStatement("DELETE FROM inventory WHERE inventory_name = ? && inventory_type = ?");
            deletingInventoryStatement.setString(1, nameInventory);
            deletingInventoryStatement.setString(2, typeInventory);
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
                String nameInventory = resultSet.getString("inventory_name");
                String typeInventory = resultSet.getString("inventory_type");
                System.out.printf(nameInventory + " " + typeInventory + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void addingStorage(int storageNumber, String storageName, int storagePhone) {
        PreparedStatement addingStorageStatement = null;
        try {
            addingStorageStatement = conn.prepareStatement("INSERT INTO storage(storage_number, storage_name, storage_phone) VALUES (?,?,?)");
            addingStorageStatement.setInt(1, storageNumber);
            addingStorageStatement.setString(2, storageName);
            addingStorageStatement.setInt(3, storagePhone);
            addingStorageStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingStorage(int oldStorageNumber, String oldStorageName, int oldStoragePhone, int newStorageNumber, String newStorageName, int newStoragePhone) {
        PreparedStatement updatingStorageStatement = null;
        try {
            updatingStorageStatement = conn.prepareStatement("UPDATE storage SET storage_number = ?, storage_name = ?, storage_phone = ? WHERE storage_number = ? AND storage_name = ? AND storage_phone = ?");
            updatingStorageStatement.setInt(1, newStorageNumber);
            updatingStorageStatement.setString(2, newStorageName);
            updatingStorageStatement.setInt(3, newStoragePhone);
            updatingStorageStatement.setInt(4, oldStorageNumber);
            updatingStorageStatement.setString(5, oldStorageName);
            updatingStorageStatement.setInt(6, oldStoragePhone);
            updatingStorageStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingStorage(int storageNumber, String storageName, int storagePhone) {
        PreparedStatement deletingStorageStatement = null;
        try {
            deletingStorageStatement = conn.prepareStatement("DELETE FROM storage WHERE storage_number = ? AND storage_name = ? AND storage_phone = ?");
            deletingStorageStatement.setInt(1, storageNumber);
            deletingStorageStatement.setString(2, storageName);
            deletingStorageStatement.setInt(3, storagePhone);
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
                int storageNumber = resultSet.getInt("storage_number");
                String storageName = resultSet.getString("storage_name");
                int storagePhone = resultSet.getInt("storage_phone");
                System.out.printf(storageNumber + " " + storageName + " " + storagePhone + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingAddition(int storageNumber, Date additionDate, String inventoryName, int inventoryAmount, String additionFio, String additionPost) {
        PreparedStatement addingAdditionStatement = null;
        try {
            addingAdditionStatement = conn.prepareStatement("INSERT INTO addition( storage_number, addition_date, inventory_name, inventory_amount, addition_fio, addition_post) VALUES (?,?,?,?,?,?)");
            addingAdditionStatement.setInt(1, storageNumber);
            addingAdditionStatement.setDate(2, additionDate);
            addingAdditionStatement.setString(3, inventoryName);
            addingAdditionStatement.setInt(4, inventoryAmount);
            addingAdditionStatement.setString(5, additionFio);
            addingAdditionStatement.setString(6, additionPost);
            addingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingAddition(int newStorageNumber, Date newAdditionDate, String newInventoryName, int newInventoryAmount, String newAdditionFio, String newAdditionPost,
                          int oldStorageNumber, Date oldAdditionDate, String oldInventoryName, int oldInventoryAmount, String oldAdditionFio, String oldAdditionPost) {
        PreparedStatement updatingAdditionStatement = null;
        try {
            updatingAdditionStatement = conn.prepareStatement("UPDATE addition SET addition_date = ?, inventory_name = ?, inventory_amount = ?, addition_fio = ?, addition_post = ?  WHERE storage_number = ? AND addition_date = ? AND inventory_name = ? AND inventory_amount = ? AND addition_fio = ? AND addition_post = ? ");
            updatingAdditionStatement.setInt(1, newStorageNumber);
            updatingAdditionStatement.setDate(2, newAdditionDate);
            updatingAdditionStatement.setString(3, newInventoryName);
            updatingAdditionStatement.setInt(4, newInventoryAmount);
            updatingAdditionStatement.setString(5, newAdditionFio);
            updatingAdditionStatement.setString(6, newAdditionPost);
            updatingAdditionStatement.setInt(7, oldStorageNumber);
            updatingAdditionStatement.setDate(8, oldAdditionDate);
            updatingAdditionStatement.setString(9, oldInventoryName);
            updatingAdditionStatement.setInt(10, oldInventoryAmount);
            updatingAdditionStatement.setString(11, oldAdditionFio);
            updatingAdditionStatement.setString(12, oldAdditionPost);
            updatingAdditionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingAddition(int storageNumber, Date additionDate, String inventoryName, int inventoryAmount, String additionFio, String additionPost) {
        PreparedStatement deletingAdditionStatement = null;
        try {
            deletingAdditionStatement = conn.prepareStatement("DELETE FROM addition WHERE storage_number=? AND addition_date = ? AND inventory_name = ? AND inventory_amount = ? AND addition_fio = ? AND addition_post =?");
            deletingAdditionStatement.setInt(1, storageNumber);
            deletingAdditionStatement.setDate(2, additionDate);
            deletingAdditionStatement.setString(3, inventoryName);
            deletingAdditionStatement.setInt(4, inventoryAmount);
            deletingAdditionStatement.setString(5, additionFio);
            deletingAdditionStatement.setString(6, additionPost);
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
                int storageNumber = resultSet.getInt("storage_number");
                Date additionDate = resultSet.getDate("addition_date");
                String inventoryName = resultSet.getString("inventory_name");
                int inventoryAmount = resultSet.getInt("inventory_amount");
                String additionFio = resultSet.getString("addition_fio");
                String additionPost = resultSet.getString("addition_post");
                System.out.printf(storageNumber + " " + additionDate + " " + inventoryName + " " + inventoryAmount + " " + additionFio + " " + additionPost + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingConsumption(int storageNumber, Date consumptionDate, String inventoryName, int inventoryAmount, String consumptionFio, String consumptionPost) {
        PreparedStatement addingConsumptionStatement = null;
        try {
            addingConsumptionStatement = conn.prepareStatement("INSERT INTO consumption(storage_number, consumption_date, inventory_name, inventory_amount, consumption_fio, consumption_post) VALUES (?,?,?,?,?,?)");
            addingConsumptionStatement.setInt(1, storageNumber);
            addingConsumptionStatement.setDate(2, consumptionDate);
            addingConsumptionStatement.setString(3, inventoryName);
            addingConsumptionStatement.setInt(4, inventoryAmount);
            addingConsumptionStatement.setString(5, consumptionFio);
            addingConsumptionStatement.setString(6, consumptionPost);
            addingConsumptionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingConsumption(int newStorageNumber, Date newConsumptionDate, String newInventoryName, int newInventoryAmount, String newConsumptionFio, String newConsumptionPost,
                             int oldStorageNumber, Date oldConsumptionDate, String oldInventoryName, int oldInventoryAmount, String oldConsumptionFio, String oldConsumptionPost) {
        PreparedStatement updatingConsumptionStatement = null;
        try {
            updatingConsumptionStatement = conn.prepareStatement("UPDATE consumption SET consumption_date = ?, inventory_name = ?, inventory_amount = ?, consumption_fio = ?, consumption_post = ?  WHERE consumption_date = ? AND inventory_name = ? AND inventory_amount = ? AND consumption_fio = ? AND consumption_post = ? ");
            updatingConsumptionStatement.setInt(1, newStorageNumber);
            updatingConsumptionStatement.setDate(2, newConsumptionDate);
            updatingConsumptionStatement.setString(3, newInventoryName);
            updatingConsumptionStatement.setInt(4, newInventoryAmount);
            updatingConsumptionStatement.setString(5, newConsumptionFio);
            updatingConsumptionStatement.setString(6, newConsumptionPost);
            updatingConsumptionStatement.setInt(7, oldStorageNumber);
            updatingConsumptionStatement.setDate(8, oldConsumptionDate);
            updatingConsumptionStatement.setString(9, oldInventoryName);
            updatingConsumptionStatement.setInt(10, oldInventoryAmount);
            updatingConsumptionStatement.setString(11, oldConsumptionFio);
            updatingConsumptionStatement.setString(12, oldConsumptionPost);
            updatingConsumptionStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingConsumption(int storageNumber, Date consumptionDate, String inventoryName, int inventoryAmount, String consumptionFio, String consumptionPost) {
        PreparedStatement deletingConsumptionStatement = null;
        try {
            deletingConsumptionStatement = conn.prepareStatement("DELETE FROM consumption WHERE storage_number = ? AND consumption_date = ? AND inventory_name = ? AND inventory_amount = ? AND consumption_fio = ? AND consumption_post =?");
            deletingConsumptionStatement.setInt(1, storageNumber);
            deletingConsumptionStatement.setDate(2, consumptionDate);
            deletingConsumptionStatement.setString(3, inventoryName);
            deletingConsumptionStatement.setInt(4, inventoryAmount);
            deletingConsumptionStatement.setString(5, consumptionFio);
            deletingConsumptionStatement.setString(6, consumptionPost);
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
                int storageNumber = resultSet.getInt("storage_number");
                Date consumptionDate = resultSet.getDate("consumption_date");
                String inventoryName = resultSet.getString("inventory_name");
                int inventoryAmount = resultSet.getInt("inventory_amount");
                String consumptionFio = resultSet.getString("consumption_fio");
                String consumptionPost = resultSet.getString("consumption_post");
                System.out.printf(storageNumber + " " + consumptionDate + " " + inventoryName + " " + inventoryAmount + " " + consumptionFio + " " + consumptionPost + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findInventoryByType(String inventoryType, int storageNumber, Date currentDate) {
        PreparedStatement findingInventoryStatement = null;
        try {
            findingInventoryStatement = conn.prepareStatement("SELECT name_inventory, addition_amount, consumption_amount FROM  WHERE addition_date <= ? AND consumption_data <= ? AND inventory_type = ? AND storage_number = ?");
            findingInventoryStatement.setString(1, inventoryType);
            findingInventoryStatement.setInt(2, storageNumber);
            findingInventoryStatement.setDate(3, currentDate);

            ResultSet resultSet = findingInventoryStatement.executeQuery();
            int inventoryAmount = 0;

            while (resultSet.next()) {
                String inventoryName = resultSet.getString("name_inventory");
                inventoryAmount += resultSet.getInt("addition_amount");
                inventoryAmount -= resultSet.getInt("consumption_amount");
                System.out.println(inventoryName + " " + inventoryAmount);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findingAdditionAndConsumption(String inventoryName) {
        PreparedStatement findingAdditionAndConsumptionStatement = null;
        try {
            findingAdditionAndConsumptionStatement = conn.prepareStatement("SELECT storage_number, inventory_name, addition_date, addition_amount, consumption_date, consumption_amount FROM WHERE inventory_name=?");
            findingAdditionAndConsumptionStatement.setString(1, inventoryName);

            ResultSet resultSet = findingAdditionAndConsumptionStatement.executeQuery();
            while (resultSet.next()) {
                int storageNumber = resultSet.getInt("storage_number");
                Date additionDate = resultSet.getDate("addition_date");
                int additionAmount = resultSet.getInt("addition_amount");
                Date consumptionDate = resultSet.getDate("consumption_date");
                int consumptionAmount = resultSet.getInt("consumption_amount");
                System.out.println(storageNumber + " " + additionDate + " " + additionAmount + " " + consumptionDate + " " + consumptionAmount + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    void findingStorageByDate(Date storageDate) {
        PreparedStatement findingStorageByDateStatement = null;
        try {
            findingStorageByDateStatement = conn.prepareStatement(
                    "SELECT DISTINCT * FROM storage WHERE storage_number" +
                            " IN (SELECT storage_number FROM addition JOIN consumption on" +
                            " consumption.storage_number = addition.storage_number WHERE addition_date = ?" +
                            " OR consumption_date = ?)");
            findingStorageByDateStatement.setDate(1, storageDate);
            findingStorageByDateStatement.setDate(2, storageDate);

            ResultSet resultSet = findingStorageByDateStatement.executeQuery();
            while (resultSet.next()) {
                int storageNumber = resultSet.getInt("storage_number");
                String storageName = resultSet.getString("storage_name");
                int storagePhone = resultSet.getInt("storage_phone");
                System.out.println(storageNumber + " " + storageName + " " + storagePhone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}