package ch.tiim.database;

import java.sql.*;

public class DatabaseManager {

    private final Connection conn;
    private TableUser tableUser;
    private TableMumbleSubscribe mumbleSubscribe;

    public DatabaseManager(String file) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("org.sqlite.JDBC not found!");
        }
        conn = DriverManager.getConnection("jdbc:sqlite:" + file);
        tableUser = new TableUser(this);
        mumbleSubscribe = new TableMumbleSubscribe(this);
    }

    public PreparedStatement getStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    public TableUser getTableUser() {
        return tableUser;
    }

    public TableMumbleSubscribe getTableMumbleSubscribe() {
        return mumbleSubscribe;
    }
}
