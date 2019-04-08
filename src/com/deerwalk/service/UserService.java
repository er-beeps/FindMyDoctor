package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.Role;
import com.deerwalk.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public boolean insertUser(User user) {
        boolean isInserted = false;
        int c = 0;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String query = "Select count(*) as cnt from user where username=? OR email=? OR phone=?";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUname());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                c = rs1.getInt("cnt");
                if (c > 0) {
                    System.out.println("Please enter unique username, e-mail and phone");
                } else {
                    String sql = "insert into user(fname,lname,username,role,password,email,phone) values(?,?,?,?,?,?,?)";
                    PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getFname());
                    ps.setString(2, user.getLname());
                    ps.setString(3, user.getUname());
                    ps.setString(4, getUserRole().getAuthority());
                    ps.setString(5, user.getPassword());
                    ps.setString(6, user.getEmail());
                    ps.setString(7, user.getPhone());

                    int affectedRows = ps.executeUpdate();
                    if (affectedRows > 0) {
                        isInserted = true;
                        ResultSet rs = ps.getGeneratedKeys();
                        while (rs.next()) {
                            int id = rs.getInt(1);

                            User recentUser = new UserService().findById(id);

                            if (recentUser != null) {
                                Role userRole = new UserService().getUserRole();
                                new UserService().insertUserRole(recentUser.getId(), userRole.getId());
                            }
                        }


                    } else {
                        isInserted = false;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isInserted;

    }


    private void insertUserRole(int uid, int rid) {
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "insert into user_role(user_id,role_id) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.setInt(2, rid);

            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private Role getUserRole() {

        Role role = null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from role where authority=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "user");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                role = new Role();
                role.setId(rs.getInt("id"));
                role.setAuthority(rs.getString("authority"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return role;
    }

    private User findById(int id) {
        User user = null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from user where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                user = new User();
                user.setId(id);
                user.setUname(rs.getString("username"));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;

    }

    public Role getUserRoleById(int id) {
        Role role = null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from user_role as ur inner join role r on ur.role_id = r.id where ur.user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                role = new Role();
                role.setAuthority(rs.getString("authority"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return role;
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        ;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setUname(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));

                userList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    public void deleteUserById(String id) {
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "Delete from user where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public User findUserByEmail(String toEmail) {
        User user = null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select username from user where email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, toEmail);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setUname(rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public User getUserByUserName(String userName) {
        User user=null;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from user where username=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setUname(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return user;
    }
}

