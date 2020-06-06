package com.mt.common.configrutaion;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * @author:李小龙
 * @createTime: 2020-01-06 19:38
 * @description: 框架配置
 * @modifyTime:
 * @modifyDescription:
 */
@Configuration
public class PlatformConfiguration {



    @Value("${mysql.filename}")
    private String defaultMysqlFile;


    @Bean
    public Properties properties() {
        String path = "/home/mt/resource";
        final Properties props = new Properties();
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(path + "/" + defaultMysqlFile + ".properties");
            props.load(inStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null){
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }

    @Bean
    public DataSource dataSource(Properties properties) {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(properties.getProperty("mt.write.url"));
        ds.setUsername(properties.getProperty("mt.write.username"));
        ds.setPassword(properties.getProperty("mt.write.password"));
        ds.setMaxActive(Integer.valueOf(properties.getProperty("maxActive")));
        ds.setInitialSize(Integer.valueOf(properties.getProperty("initialSize")));
        ds.setMaxWait(Integer.valueOf(properties.getProperty("maxWait")));
        ds.setMinIdle(Integer.valueOf(properties.getProperty("minIdle")));
        ds.setTimeBetweenEvictionRunsMillis(Integer.valueOf(properties.getProperty("timeBetweenEvictionRunsMillis")));
        ds.setMinEvictableIdleTimeMillis(Integer.valueOf(properties.getProperty("minEvictableIdleTimeMillis")));
        ds.setValidationQuery((properties.getProperty("validationQuery")));
        ds.setTestWhileIdle(Boolean.valueOf(properties.getProperty("testWhileIdle")));
        ds.setTestOnBorrow(Boolean.valueOf(properties.getProperty("testOnBorrow")));
        ds.setTestOnReturn(Boolean.valueOf(properties.getProperty("testOnReturn")));
        ds.setPoolPreparedStatements(Boolean.valueOf(properties.getProperty("poolPreparedStatements")));
        ds.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(properties.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        return ds;
    }
    @Bean
    public DataSourceTransactionManager transactionManager(Properties properties){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource(properties));
        return dataSourceTransactionManager;
    }






    @Bean
    public JdbcTemplate getJdbcTemplate(Properties properties) {
        return new JdbcTemplate(dataSource(properties));
    }




}
