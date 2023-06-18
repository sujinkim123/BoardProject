package com.example.demo.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.example.demo", sqlSessionFactoryRef = "SqlSessionFactory")
public class DBConfig {

    @Value("${spring.datasource.mapper-locations}")
    String mPath;

//    // mybatis 설정 파일을 따로 작성해서 임포트할 예정 - snake_case -> camelCase 를 위함
//    @Value("${mybatis.config-location}")
//    String mybatisConfigPath;


    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public javax.sql.DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "SqlSessionFactory")
    public org.apache.ibatis.session.SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") javax.sql.DataSource DataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(DataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mPath));
//        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(mybatisConfigPath));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "SessionTemplate")
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("SqlSessionFactory") org.apache.ibatis.session.SqlSessionFactory firstSqlSessionFactory) {
        return new SqlSessionTemplate(firstSqlSessionFactory);
    }
}
