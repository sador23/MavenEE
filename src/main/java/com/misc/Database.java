package com.misc;

import java.sql.*;

public class Database {
    Connection c;
    Statement stmt;

    public Database() throws SQLException {
        Connection();
    }

    public void Connection() throws SQLException {
        //SQL INST PART
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql:sador", "sador",
                    "loldnv32");
            stmt = c.createStatement();
            String sql = "CREATE TABLE  IF NOT EXISTS WebUser " +
                    "(ID SERIAL PRIMARY KEY," +
                    " NAME           TEXT    NOT NULL, " +
                    " PASSWORD            TEXT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void Insert_Table(String name, String password) throws SQLException {
        String SQL = "INSERT INTO WebUser VALUES (DEFAULT ,?, ?)";
        PreparedStatement value_replacer = c.prepareStatement(SQL);
        value_replacer.setString(2, password);
        value_replacer.setString(1, name);
        value_replacer.executeUpdate();
        value_replacer.close();
        //closeconn();
    }

    public boolean get_users(String name, String password) throws SQLException {
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM WebUser WHERE NAME = ? ");
        stmt.setString(1, name);
        ResultSet results = stmt.executeQuery();
        if (!results.next()) {
            return false;
        }

        return results.getString("name").equalsIgnoreCase(name) && results.getString("password").equalsIgnoreCase(password);

    }


    public void closeconn() throws SQLException {
        c.close();
        stmt.close();
    }

}
