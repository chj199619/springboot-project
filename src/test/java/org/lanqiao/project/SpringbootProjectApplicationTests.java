package org.lanqiao.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    public void contextLoads() throws SQLException {
      Connection connection= dataSource.getConnection();
     List<Map<String,Object>> emplist = jdbcTemplate.queryForList("select * from  user ");
        System.out.println(emplist.size());
        System.out.println(connection);

    }

}

