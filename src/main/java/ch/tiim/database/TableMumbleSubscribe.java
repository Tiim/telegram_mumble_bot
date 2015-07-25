package ch.tiim.database;

import Murmur.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TableMumbleSubscribe {

    private final DatabaseManager db;

    private final PreparedStatement subscribeStmt;
    private final PreparedStatement getSubscriberStmt;

    public TableMumbleSubscribe(DatabaseManager db) throws SQLException {
        this.db = db;
        mkTable();
        subscribeStmt = db.getStatement("INSERT INTO mumble_subscription VALUES (?,?);");
        getSubscriberStmt = db.getStatement("SELECT telegram_id, mumble_name FROM mumble_subscription;");
    }

    public void mkTable() throws SQLException {
        Statement mkTable = db.getStatement();
        mkTable.executeUpdate("CREATE TABLE IF NOT EXISTS mumble_subscription (" +
                "telegram_id," +
                "mumble_name TEXT," +
                "FOREIGN KEY (telegram_id) REFERENCES user (telegram_id) ON DELETE CASCADE," +
                "UNIQUE (telegram_id, mumble_name)" +
                ");");
        mkTable.close();
        Statement mkTmpTable = db.getStatement();
        mkTable.executeUpdate("CREATE TEMP TABLE IF NOT EXISTS online_list (" +
                "mumble_name TEXT" +
                ");");
        mkTmpTable.close();
    }

    public void subscribeUser(int telegramId, String mumbleName) throws SQLException {
        subscribeStmt.setInt(1, telegramId);
        subscribeStmt.setString(2, mumbleName);
        subscribeStmt.executeUpdate();
    }

    public Map<String, List<Integer>> getSubscribedUsers() throws SQLException {
        ResultSet set = getSubscriberStmt.executeQuery();
        HashMap<String, List<Integer>> hash = new HashMap<>();
        while (set.next()) {
            String name = set.getString("mumble_name");
            int id = set.getInt("telegram_id");
            if (hash.containsKey(name)) {
                hash.get(name).add(id);
            } else {
                hash.put(name, new ArrayList<>(Arrays.asList(new Integer[]{id})));
            }
        }
        return hash;
    }

}
