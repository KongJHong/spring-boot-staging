package com.hong.repository.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Description     : mybatis plus代码生成器
 */
public class MybatisCodeGenerator {


	private static final String LOCATION = System.getProperty("user.dir") + "/hong-repository/src/main/java";
	private static final String PACKAGE = "com.hong.repository";
	private static final String AUTHOR = "KongJHong";

	private static final String URL = "jdbc:mysql:///grad?useUnicode=true&useSSL=false&characterEncoding=utf8";
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	// 数据库对应表名
	private static final String[] targetTable = {"user"};

	public static void main(String[] args) {

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(LOCATION);
		gc.setFileOverride(false);
		gc.setAuthor(AUTHOR);
		gc.setOpen(false);
		gc.setMapperName("%sDao");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDriverName(DRIVER);
		dsc.setUrl(URL);
		dsc.setUsername(USERNAME);
		dsc.setPassword(PASSWORD);
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		// 不需要模块
//		pc.setModuleName("com.hong.repository.bean")
		// 设置包名
		pc.setParent("");
		pc.setMapper(PACKAGE+".dao");
		pc.setEntity(PACKAGE+".entity");
		mpg.setPackageInfo(pc);

		// 自定义配置
//		InjectionConfig cfg = new InjectionConfig() {
//			@Override
//			public void initMap() {
//				 // to do nothing
//			}
//		};
//
//		// 自定义输出配置
//		List<FileOutConfig> focList = new ArrayList<>();
//		// 自定义配置会被优先输出
//		focList.add(new FileOutConfig() {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return
//						LOCATION + "/src/main/resources/mapper/"
//						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//			}
//		});
//		cfg.setFileOutConfigList(focList);
//		mpg.setCfg(cfg);

		 // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        //控制 不生成 controller
        templateConfig.setController("");
        templateConfig.setService("");
        templateConfig.setServiceImpl("");
        templateConfig.setXml("");

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自定义继承的Entity类全称，带包名 舍弃 不需要
        strategy.setSuperEntityClass("com.hong.repository.entity.BaseEntity");
        strategy.setEntityLombokModel(true);

        //不需要 controller 舍弃
//        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        //要添加的表
        strategy.setInclude(targetTable);
        strategy.setControllerMappingHyphenStyle(true);
        //表名前缀 这样生成的bean里面 就没有前缀了
//        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

	}
}
