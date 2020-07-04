package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

/**
 * Mybatis plus code generator
 * just use it to generate java code
 * @author Larry_lee
 *
 */
public class MybatisPlusCodeGenerator {

	static String packName = "com.demo";
	static String author = "Larry_lee";
	static String[] tables = new String[] { "n_user" };

	public static void main(String[] args) {
		// code generator
		AutoGenerator mpg = new AutoGenerator();

		// global configuration
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor(author);
		gc.setOpen(false);
		mpg.setGlobalConfig(gc);

		// datasource configuration
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/news?useUnicode=true&useSSL=false&characterEncoding=utf8");
		// dsc.setSchemaName("public");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("123456");
		mpg.setDataSource(dsc);

		// package configuration
		PackageConfig pc = new PackageConfig();
		pc.setModuleName("user");
		pc.setParent(packName);
		mpg.setPackageInfo(pc);

		// injection config
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// use beetl to generate code
		String templatePath = "/templates/mapper.xml.btl";

		// out put path
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// costomer out put name
				return projectPath + "/src/main/resources/mapper/" // + pc.getModuleName() + "/"
						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// code template configuration
		TemplateConfig templateConfig = new TemplateConfig();

		templateConfig.setEntity("templates/entity.java");
		// templateConfig.setService();
		// templateConfig.setController();

		templateConfig.setXml(null);
		mpg.setTemplate(templateConfig);

		// strategy
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setSuperEntityColumns("id");
		strategy.setInclude(tables);
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new BeetlTemplateEngine());
		mpg.execute();
	}

}