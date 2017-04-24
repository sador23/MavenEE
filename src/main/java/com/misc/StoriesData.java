package com.misc;

import java.sql.*;
import com.misc.Story;

public class StoriesData {
    Connection c;
    Statement stmt;
    Story story;

    public StoriesData() throws SQLException {
        Connection();
    }

    public void Connection() throws SQLException {
        //SQL INST PART
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql:sador", "sador",
                    "kiscica12");
            stmt = c.createStatement();
            String sql = "CREATE TABLE  IF NOT EXISTS stories " +
                    "(ID SERIAL PRIMARY KEY," +
                    " title           TEXT    NOT NULL, " +
                    " story            TEXT     NOT NULL,"+
                    "criteria          TEXT      NOT NULL,"+
                    "value             INTEGER   NOT NULL,"+
                     "estimation       FLOAT     NOT NULL,"+
                    "status             TEXT     NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void add_story(String title, String story, String criteria, String status, int value, float estimation) throws SQLException {
        String SQL = "INSERT INTO stories VALUES (DEFAULT ,?, ?,?,?,?,?)";
        PreparedStatement value_replacer = c.prepareStatement(SQL);
        value_replacer.setString(2, story);
        value_replacer.setString(1, title);
        value_replacer.setString(3,criteria);
        value_replacer.setString(6,status);
        value_replacer.setInt(4,value);
        value_replacer.setFloat(5,estimation);
        value_replacer.executeUpdate();
        value_replacer.close();
        //closeconn();
    }

    public Story get_story(int id) throws SQLException {
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM stories WHERE id = ? ");
        stmt.setInt(1, id);
        ResultSet results = stmt.executeQuery();
        while (results.next()) {
            story = new Story(results.getInt("id"), results.getString("title"), results.getString("story"), results.getString("criteria"), results.getString("status"), results.getInt("value"), results.getFloat("estimation"));
        }
        return story;
    }

    public void update_story(int id,String title, String story, String criteria, String status, int value, float estimation) throws SQLException {
        PreparedStatement stmt = c.prepareStatement("UPDATE stories SET title=?,story=?,criteria=?,status=?,value=?,estimation=? WHERE id = ? ");
        stmt.setInt(7, id);
        stmt.setString(2,story);
        stmt.setString(1,title);
        stmt.setString(3,criteria);
        stmt.setString(4,status);
        stmt.setInt(5,value);
        stmt.setFloat(6,estimation);
        stmt.executeUpdate();
    }

    public void delete_row(int id) throws SQLException {
        PreparedStatement stmt = c.prepareStatement("DELETE FROM stories WHERE id = ? ");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public Story[] list_story() throws SQLException {
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM stories");
        ResultSet results = stmt.executeQuery();
        PreparedStatement sonka=c.prepareStatement("SELECT COUNT(*) as count FROM stories");
        ResultSet length=sonka.executeQuery();
        int len=0;
        Story [] objs;
        if (length.next()){
            len=length.getInt("count");
        }
        objs=new Story[len];
        int counter=0;
        while(results.next()){
            story=new Story(results.getInt("id"),results.getString("title"),results.getString("story"),results.getString("criteria"),results.getString("status"),results.getInt("value"),results.getFloat("estimation"));
            objs[counter]=story;
            counter++;
        }
        return objs;
    }



    public void closeconn() throws SQLException {
        c.close();
        stmt.close();
    }

}
