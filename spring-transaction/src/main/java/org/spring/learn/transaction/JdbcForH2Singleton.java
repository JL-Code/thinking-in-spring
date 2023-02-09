package org.spring.learn.transaction;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * <p>创建时间: 2023/2/9 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
public class JdbcForH2Singleton {

    private JdbcForH2Singleton() {
    }

    public static JdbcTemplate getInstance() {
        return SingletonHolder.template;
    }

    private static class SingletonHolder {
        // 创建一个 H2 DB DataSource
        static JdbcDataSource h2ds = new JdbcDataSource();

        static {
            h2ds.setUrl("jdbc:h2:~/h2/test");
            h2ds.setUser("sa");
            h2ds.setPassword("123456");
        }

        // 创建一个 JDBCTemplate 实例
        /**
         * 可能出现的问题：
         * Failed to obtain JDBC Connection; nested exception is
         * org.h2.jdbc.JdbcSQLNonTransientConnectionException: Database may be already in use: null.
         * Possible solutions: close all other connection(s); use the server mode [90020-200]
         */
        static JdbcTemplate template = new JdbcTemplate(h2ds);
    }
}
