package org.example.medicalsystem;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/medical_db?useUnicode=true&characterEncoding=utf-8&" +
                    "useSSL=false&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "huchunliang66X";

        FastAutoGenerator.create(url, username, password)
                // 全局配置：作者名、输出目录
                .globalConfig(builder -> {
                    builder.author("h77h1")
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")
                            .disableOpenDir(); // 生成后不自动打开文件夹
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("org.example.medicalsystem")
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller");
                })
                // 策略配置：要生成哪些表
                .strategyConfig(builder -> {
                    builder.addInclude("department", "doctor", "patient", "registration", "prescription", "medicine")
                            .entityBuilder().enableLombok() // 开启 Lombok
                            .controllerBuilder().enableRestStyle(); // 开启 @RestController
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}