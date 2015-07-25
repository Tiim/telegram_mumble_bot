package ch.tiim.database;

import ch.tiim.telegram.TGUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TableUser {

    private final DatabaseManager db;

    private final PreparedStatement isUserRegisteredStmt;
    private final PreparedStatement insertUserStmt;
    private final PreparedStatement registerUserStmt;
    private final PreparedStatement getNameStmt;
    private final PreparedStatement getUnregisteredStmt;

    public TableUser(DatabaseManager db) throws SQLException {
        this.db = db;
        mkTable();
        isUserRegisteredStmt = db.getStatement("SELECT registered FROM user WHERE telegram_id=?;");
        insertUserStmt = db.getStatement("INSERT OR IGNORE INTO user VALUES (?,?,?,?,?);");
        registerUserStmt = db.getStatement("UPDATE user SET registered = ? WHERE telegram_id=?;");
        getNameStmt = db.getStatement("SELECT name FROM user WHERE telegram_id=?;");
        getUnregisteredStmt = db.getStatement("SELECT * FROM user WHERE registered=0;");
    }

    public void mkTable() throws SQLException {
        Statement stmt = db.getStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +
                "telegram_id INT PRIMARY KEY," +
                "name TEXT," +
                "user_name TEXT," +
                "is_group_chat BOOLEAN," +
                "registered BOOLEAN" +
                ");");
        stmt.close();
    }

    public boolean isUserRegistered(int telegramId) throws SQLException {
        isUserRegisteredStmt.setInt(1, telegramId);
        ResultSet res = isUserRegisteredStmt.executeQuery();
        return res.next() && res.getBoolean("registered");
    }

    public void addNewUser(TGUser user) throws SQLException {
        insertUserStmt.setInt(1, user.getId());
        insertUserStmt.setString(2, user.getFirstName());
        insertUserStmt.setString(3, user.getUserName());
        insertUserStmt.setBoolean(4, user.isGroupChat());
        insertUserStmt.setBoolean(5, false);
        insertUserStmt.execute();
    }

    public boolean registerUser(int telegramId, boolean reg) throws SQLException {
        registerUserStmt.setBoolean(1, reg);
        registerUserStmt.setInt(2, telegramId);
        return registerUserStmt.executeUpdate() != 0;
    }

    public String getName(int telegramId) throws SQLException {
        getNameStmt.setInt(1, telegramId);
        ResultSet res = getNameStmt.executeQuery();
        res.next();
        return res.getString("name");
    }

    public TGUser[] getUnregisteredUsers() throws SQLException {
        ResultSet set = getUnregisteredStmt.executeQuery();
        List<TGUser> list = new LinkedList<>();
        while (set.next()) {
            int id = set.getInt("telegram_id");
            String name = set.getString("name");
            String userName = set.getString("user_name");
            boolean isGroupChat = set.getBoolean("is_group_chat");
            TGUser usr;
            if (isGroupChat) {
                usr = new TGUser(id, name);
            } else {
                usr = new TGUser(id, name, null, userName);
            }
            list.add(usr);
        }
        return list.toArray(new TGUser[list.size()]);
    }
}
