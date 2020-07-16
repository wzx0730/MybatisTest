package com.test.demo_ibatis.config;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.test.demo_ibatis.Dao.UserDao;
import com.test.demo_ibatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;
import java.util.List;

@Configuration
public class MySqlConfig {
        private static final SqlMapClient sqlMap;
        static {
            try {
                String resource = "sqlmap-dev.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error initializing MyAppSqlConfig class. Cause: " + e);
            }
        }
        public static SqlMapClient getSqlMapInstance() {
            return sqlMap;
        }


}
