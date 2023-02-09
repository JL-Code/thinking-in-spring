package org.spring.learn.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * <p>创建时间: 2023/2/9 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
public class TransactionDemo {

    public static void main(String[] args) {
        JdbcTemplate template = JdbcForH2Singleton.getInstance();

//        template.execute("insert into def_person  values (1,'jiangy',1,1);");
        List<Map<String, Object>> maps = template.queryForList("select * from def_person;");

        System.out.println(maps);
    }
}
