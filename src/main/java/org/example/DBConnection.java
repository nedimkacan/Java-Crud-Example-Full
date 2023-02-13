package org.example;

import java.sql.*;

public class DBConnection {
    public static final String DB_URL="jdbc:mysql://localhost/java_ornek";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="";
    public static Connection getConnection(){
        /*
        try {
            Class.forName("patika52/mysql-connector-j-8.0.32.jar!/com/mysql/jdbc/Driver.class");
        } catch (ClassNotFoundException e) {
            System.out.println("Hata driver bulunamadı. " + e.getMessage());
        }
        */
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Mysql bağlantısı başarılı.");
        } catch (SQLException e) {
            System.out.println("Mysql bağlantısı sırasında bir hata meydana geldi");
        }
        return connection;
    }
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement){
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                System.out.println("Statement başarılı bir şekilde kapatıldı.");
            } catch (SQLException e) {
                System.out.println("Statement kapatılırken bir hata oluştu !");
            }
        }
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Mysql bağlantısı başarılı bir şekilde kapatıldı.");
            } catch (SQLException e) {
                System.out.println("Mysql bağlantısı kapatılırken bir hata ile karşılaşıldı !" + e.getMessage());
            }
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
                System.out.println("ResultSet başarılı bir şekilde kapatıldı.");
            } catch (SQLException e) {
                System.out.println("ResultSet kapatılırken bir sorun ile karşılaşıldı ! Hata: " + e.getMessage());
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                System.out.println("Statement başarılı bir şekilde kapatıldı.");
            } catch (SQLException e) {
                System.out.println("Statement kapatılırken bir hata oluştu !" + e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Mysql bağlantısı başarılı bir şekilde kapatıldı.");
            } catch (SQLException e) {
                System.out.println("Mysql bağlantısı kapatılırken bir hata ile karşılaşıldı !" + e.getMessage());
            }
        }
    }
}
