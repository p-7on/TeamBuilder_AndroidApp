package at.fhooe.me.android.pro1;

import android.nfc.Tag;
import android.util.Log;

import java.sql.*;

import javax.xml.transform.Result;

//JAVA_Class

class DBConnection {
    private Connection connection = null;
    private final static String TAG = "DBConnection";
    private static DBConnection instance = null;

    private DBConnection() {
        start();
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    private void start() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://192.168.215.3:3306/fussball_app?user=root");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //Log.e(TAG, e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                return rs;
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return null;
    }

    public void executeUpdate(String sql) {
        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    public void insertNewUser(String vollstaendiger_name, String benutzername, String passwort, int Rolle_id, int Verein_id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO User(vollstaendiger_name, benutzername, passwort, Rolle_id, Verein_id) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, vollstaendiger_name);
            preparedStatement.setString(2, benutzername);
            preparedStatement.setString(3, passwort);
            preparedStatement.setInt(4, Rolle_id);
            preparedStatement.setInt(5, Verein_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
            DBConnection.instance = null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}