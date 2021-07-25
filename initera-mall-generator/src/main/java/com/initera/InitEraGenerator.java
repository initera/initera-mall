package com.initera;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;

/**
 * @author youngmate
 * @date 2021/7/23 22:32
 */
public class InitEraGenerator {
    public static void main(String[] args) {
        // 构建一个代码生成对象
        AutoGenerator mpg = new AutoGenerator();

        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();

        String separator = File.separator;
        gc.setOutputDir("E:\\MCA\\initera-mall\\initera-mall-server\\initera-mall-ums\\src\\main\\java");
        gc.setAuthor("youngmate");
        //打开目录
        gc.setOpen(false);
        //是否覆盖
        gc.setFileOverride(true);
        //去Service的I前缀。
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(false);

        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://39.96.209.201:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("ARTfox123@");
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);

        // 包设置
        PackageConfig pc = new PackageConfig();

        pc.setParent("com.initera");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setController("controller");

        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名
        strategy.setInclude("ums_member");
        // 下划线转他驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 列 下划线转脱发
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //lombok 开启
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("deleted");

        // 自动填充
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModify = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModify);

        strategy.setTableFillList(tableFills);

        //乐观锁
        strategy.setVersionFieldName("version");

        // restController
        strategy.setRestControllerStyle(true);
        // localhost:xxx/hello_2
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
