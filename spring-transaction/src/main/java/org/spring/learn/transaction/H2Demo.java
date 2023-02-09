package org.spring.learn.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * H2 实例：
 * <p>创建时间: 2023/2/9 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
public class H2Demo {
    static Connection conn;

    public static Connection getConn() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:h2:~/h2/test", "sa", "123456");
        }
        return conn;
    }

    public static void craeteTable() throws SQLException {
        Connection conn = getConn();
        String createTable = "CREATE TABLE IF NOT EXISTS tutorials_tbl (\n" +
                "    id INT NOT NULL,\n" +
                "    title VARCHAR(50) NOT NULL,\n" +
                "    author VARCHAR(20) NOT NULL,\n" +
                "    submission_date DATE\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE  IF NOT EXISTS def_person\n" +
                "(\n" +
                "    id       INT NOT NULL,\n" +
                "    username VARCHAR(20) NULL,\n" +
                "    age      INT NULL,\n" +
                "    sex      INT NULL\n" +
                ");";
        conn.createStatement().execute(createTable);
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        int command;
        Scanner scanner = new Scanner(System.in);
        System.out.println("创建表：1; 退出：0");
        command = scanner.nextInt();
        switch (command) {
            case 1:
                craeteTable();
            default:
                break;
        }
    }
}
