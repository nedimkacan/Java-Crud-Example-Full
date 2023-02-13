package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonnelController {
    public ArrayList<PersonnelModel> list(){
        Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        ArrayList<PersonnelModel> personnelModels=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM student");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                PersonnelModel personnelModel=new PersonnelModel(id,name,surname);
                personnelModels.add(personnelModel);
            }
            System.out.println("Kayıtlar başarılı bir şekilde alındı.");
        } catch (SQLException e) {
            System.out.println("Listeleme sırasında bir sorun ile karşılaşıldı ! Hata: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(connection,preparedStatement,resultSet);
        }
        return personnelModels;
    }
    public void insert(PersonnelModel personnelModel){
        Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO student (name,surname) VALUES (?,?)");
            preparedStatement.setString(1,personnelModel.getName());
            preparedStatement.setString(2,personnelModel.getSurname());
            int result=preparedStatement.executeUpdate();
            System.out.println(result + " kayıt eklendi.");
        } catch (SQLException e) {
            System.out.println("Ekleme işlemi sırasında bir sorun ile karşılaşıldı ! Hata: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(connection,preparedStatement);
        }
    }
    public void insertPersonnelList(ArrayList<PersonnelModel> personnelModels){
        Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement("INSERT INTO student (name,surname) VALUES (?,?)");
            for (PersonnelModel personnelModel:personnelModels) {
                preparedStatement.setString(1, personnelModel.getName());
                preparedStatement.setString(2, personnelModel.getSurname());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Personeller başarılı bir şekilde kayıt edildi.");
        } catch (SQLException e) {
            System.out.println("Personel listesi eklenirken bir sorun ile karşılaşıldı. Hata: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(connection,preparedStatement);
        }
    }
    public void update(PersonnelModel personnelModel){
        Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement("UPDATE student SET name=?,surname=? WHERE id=?");
            preparedStatement.setString(1,personnelModel.getName());
            preparedStatement.setString(2,personnelModel.getSurname());
            preparedStatement.setInt(3,personnelModel.getId());
            preparedStatement.executeUpdate();
            System.out.println("Güncelleme işlemi başarılı bir şekilde gerçekleşti.");
        } catch (SQLException e) {
            System.out.println("Güncelleme işlemi sırasında bir sorun ile karşılaşıldı ! Hata: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(connection,preparedStatement);
        }
    }
    public void delete(PersonnelModel personnelModel){
        Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement("DELETE FROM student WHERE id=?");
            preparedStatement.setInt(1,personnelModel.getId());
            preparedStatement.executeUpdate();
            System.out.println("Silme işlemi başarılı bir şekilde gerçekleşti.");
        } catch (SQLException e) {
            System.out.println("Silme işlemi sırasında bir sorun ile karşılaşıldı ! Hata: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(connection,preparedStatement);
        }
    }
    public PersonnelModel searchId(PersonnelModel personnelModel){
        Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        PersonnelModel personnelModel1=null;
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM student WHERE id=?");
            preparedStatement.setInt(1,personnelModel.getId());
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                personnelModel1=new PersonnelModel(id,name,surname);
            }
            System.out.println(personnelModel1.getName() + " isimli kullanıcı bulundu.");
        } catch (SQLException e) {
            System.out.println("Arama işlemi sırasında bir sorun ile karşılaşıldı ! Hata: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(connection,preparedStatement,resultSet);
        }
        return personnelModel1;
    }
}
