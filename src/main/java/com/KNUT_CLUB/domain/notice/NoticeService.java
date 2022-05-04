package com.KNUT_CLUB.domain.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {

    /* notice */
    public List<Notice> getNoticeList(String field, String query) {

        List<Notice> list = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, NOTICE.*"
                + " FROM NOTICE, (SELECT @ROWNUM := 0)TMP WHERE " + field + " LIKE ? ORDER BY date DESC limit 1, 10;";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/test";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
//            pst.setInt(2, 0 + (page - 1) * 10);

            rs = pst.executeQuery();

            while (rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");

                Notice notice = new Notice(
                        n
                        , num
                        , title
                        , writer
                        , date
                );
                list.add(notice);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (rs != null)
                    rs.close();

                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }

    /* paging */
    public int getNoticeCount(String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM NOTICE";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/test";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next())
                count = rs.getInt("count");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return count;
    }
}
