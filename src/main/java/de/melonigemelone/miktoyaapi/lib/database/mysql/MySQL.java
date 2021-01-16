package de.melonigemelone.miktoyaapi.lib.database.mysql;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {

    //Connection Values
    private String host;
    private String port;
    private String database;
    private String userName;
    private String password;

    private Connection connection;

    //Connect with DataBase
    public MySQL(String host, String port, String database, String userName, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.userName = userName;
        this.password = password;

        try{
            connect();
        } catch (SQLException e) {
            System.out.println("Could not connect to Database ex: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Could not connect to Database - Mysql not found! ex: " + e.getMessage());
        }
    }

    //Check if the connection is active
    public boolean isConnected() {
        if (connection != null)
            try {
                return !connection.isClosed();
            } catch (Exception e) {
                System.out.println(ChatColor.RED + "SQL Connection:");
                System.out.println(ChatColor.RED + "Error: " + e.getMessage());
            }
        return false;
    }

    //Connect with the DataBase
    public void connect() throws ClassNotFoundException, SQLException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            if(this.password == null || this.password.isEmpty() || this.password.equals("nopw")){
                //System.out.println("Starting without Mysql Password!");
                connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true&useUnicode=yes", this.userName, null);
            }
            else{
                connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true&useUnicode=yes", this.userName, this.password);
            }
        }
    }

    //Connect if the Connection is not active
    public void connectIfConnectionNotActive() {
        try {
            if(connection.isClosed()){
                connect();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Creates Table if not exists
    public void createTableIfNotExists(String table, String columns) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS `" + table + "` (" + columns + ") ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    //Resets a Table
    public void resetTable(String table) {
        runAsync(() -> {
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + table);
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    //Adds Data to a table
    public void insertData(String table, String columns, String values) {
        runAsync(() -> {
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")");
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    //Adds Data to a table
    public void insertDataAndGetGeneratedKey(String table, String columns, String values, Callback<Integer> callback) {
        runAsync(() -> {
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")");
                preparedStatement.executeUpdate();

                int autoIncKeyFromFunc = -1;
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT LAST_INSERT_ID()");

                if (rs.next()) {
                    autoIncKeyFromFunc = rs.getInt(1);
                }

                callback.taskDone(autoIncKeyFromFunc);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }



    //Deletes Data From a table
    public void deleteDataFromTable(String table, String where) {
        runAsync(() -> {
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + table + " WHERE " + where);
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    //Check if the Data exist in the table
    public void existsData(String table, String where, Callback<Boolean> callback) {
        runAsync(() -> {
            boolean result = false;
            try {
                connectIfConnectionNotActive();
                PreparedStatement st = connection.prepareStatement("SELECT * FROM " +  table + " WHERE " + where);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    result =  rs != null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            callback.taskDone(result);
        });
    }

    //Check if the Data exist in the table
    public boolean existsDataSync(String table, String where) {

        try {
            connectIfConnectionNotActive();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM " +  table + " WHERE " + where);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs != null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    //Update Data in the table
    public void update(String table, String update, String where) {
        runAsync(() -> {
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + table + " SET " + update + " WHERE " + where);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    //Update Data in the table
    public void update(String table, String update) {
        runAsync(() -> {
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + table + " SET " + update);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    //Get Data From the table
    public void get(String table, String where, String selected, Callback<Object> callback) {
        runAsync(() -> {
            Object o = null;
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + where);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    o = resultSet.getObject(selected);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            callback.taskDone(o);
        });

    }

    //Get a List of Columns from a tabel
    public void get(String table, String where, String[] selected, Callback<List<Object>> callback) {
        runAsync(() -> {
            List<Object> objects = new ArrayList<>();

            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + where);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    for (String s : selected) {
                        objects.add(resultSet.getObject(s));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            callback.taskDone(objects);

        });
    }

    //Get a List of Columns from a tabel
    public List<Object> getSync(String table, String where, String[] selected) {
        List<Object> objects = new ArrayList<>();

        try {
            connectIfConnectionNotActive();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + where);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                for (String s : selected) {
                    objects.add(resultSet.getObject(s));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;


    }

    //Get all from one Column
    public void getDataInColumn(String table, String column, Callback<List<Object>> callback) {
        runAsync(() -> {
            List<Object> objects = new ArrayList<>();
            try {
                connectIfConnectionNotActive();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT " + column + " FROM " + table);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    objects.add(resultSet.getObject(column));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            callback.taskDone(objects);
        });
    }


    private void runAsync(final Runnable runnable){
        BukkitRunnable r = new BukkitRunnable() {
            public void run() {
                runnable.run();
            }
        };
        r.runTaskAsynchronously(MiktoyaAPI.getInstance());
    }

}
