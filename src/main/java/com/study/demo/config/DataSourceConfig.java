package com.study.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author ：xurong02
 * @date ：2023/3/7 2:32 下午
 */
@Configuration
@MapperScan(basePackages ="com.study.demo.repository.xurongtest.mapper")
public class DataSourceConfig {


    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUserName;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean("${domainDatasource}")
    public DruidDataSource getDataSource() {

        //todo 修改db配置
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUserName);
        dataSource.setPassword(dataSourcePassword);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
