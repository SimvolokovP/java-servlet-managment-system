package dao;

import model.Child;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChildDao {
    private Connection connection;

    public ChildDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addChild(Child child) {
        boolean f = false;

        try {
            String sqlQuery = "insert into children(name, age, gender, `group`) values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, child.getName());
            ps.setInt(2, child.getAge());
            ps.setString(3, child.getGender());
            ps.setString(4, child.getGroup());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean updateChild(Child child) {
        boolean f = false;

        try {
            String sqlQuery = "update children set name=?, age=?, gender=?, `group`=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, child.getName());
            ps.setInt(2, child.getAge());
            ps.setString(3, child.getGender());
            ps.setString(4, child.getGroup());
            ps.setInt(5, child.getId());
            System.out.println(child);
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Child> getChildren() {
        List<Child> list = new ArrayList<>();
        Child child = null;
        try {
            String sqlQuery = "select * from children";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                child = new Child();
                child.setId(rs.getInt("id"));
                child.setName(rs.getString("name"));
                child.setAge(rs.getInt("age"));
                child.setGender(rs.getString("gender"));
                child.setGroup(rs.getString("group"));
                list.add(child);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Child getChildById(int id) {
        Child child = null;
        try {
            String sqlQuery = "select * from children where id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                child = new Child();
                child.setName(rs.getString("name"));
                child.setGender(rs.getString("gender"));
                child.setAge(rs.getInt("age"));
                child.setGroup(rs.getString("group"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return child;
    }

    public boolean deleteChild(int id) {
        boolean f = false;

        try {
            String sqlQuery = "delete from children where id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            int i = ps.executeUpdate();

            if (i==1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
