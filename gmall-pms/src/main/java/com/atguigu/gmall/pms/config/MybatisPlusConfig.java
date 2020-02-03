package com.atguigu.gmall.pms.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邵枫
 * @date 2019/10/10 16:34
 */
@Configuration
@MapperScan("com.atguigu.gmall.pms.dao")
public class MybatisPlusConfig {

    @Bean  //配置分页插件
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    @Bean //Oracle的序列生成器
    public OracleKeyGenerator oracleKeyGenerator(){
        return new OracleKeyGenerator();
    }

/*    @Bean //注入自定义的拦截器（插件）
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }*/
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();

        List<ISqlParser> list= new ArrayList<>();
        list.add(new BlockAttackSqlParser());//全表更新、删除的阻断器
        sqlExplainInterceptor.setSqlParserList(list);
        return new SqlExplainInterceptor();
    }

}
