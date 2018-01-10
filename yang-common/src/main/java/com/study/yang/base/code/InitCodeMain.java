package com.study.yang.base.code;

import com.google.common.collect.Maps;
import com.study.yang.base.code.config.Config;
import com.study.yang.base.code.db.DBInfo;
import com.study.yang.base.code.db.TableInfo;
import com.study.yang.base.code.util.TemplateUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class InitCodeMain {
    public static void main(String [] args) throws Exception {
        Config conf = new Config();
        DBInfo dbInfo = DBInfo.getInstance(conf);
        genCodeForMvc(conf, dbInfo);
    }

    private static void genCodeForMvc(Config conf, DBInfo dbInfo) throws Exception {

        Map<String, Object> model = Maps.newHashMap();
        model.put("conf", conf);

        log.info("\n--------------------------------------------------------------Generate Dao Module Start--------------------------------------------------------------");
        genDaoModule(conf.getDaoModuleName(), model, conf.getBackendTemplatePath() + File.separator + "dao", conf.getBackendTargetPath() + File.separator + "" + conf.getDaoModuleName(), dbInfo, conf.getBasePackage().replace(".", File.separator + ""));
        log.info("\n--------------------------------------------------------------Generate Dao Module End  --------------------------------------------------------------");

        log.info("\n--------------------------------------------------------------Generate Service Module Start--------------------------------------------------------------");
        genApiModule(conf.getApiModuleName(), model, conf.getBackendTemplatePath() + File.separator + "api", conf.getBackendTargetPath() + File.separator + "" + conf.getApiModuleName(), dbInfo, conf.getBasePackage().replace(".", File.separator + ""));
        log.info("\n--------------------------------------------------------------Generate Service Module End  --------------------------------------------------------------");
//
//        log.info("\n--------------------------------------------------------------Generate Service-impl Module Start--------------------------------------------------------------");
//        genServiceModule(conf.getServiceModuleName(), model, conf.getBackendTemplatePath() + File.separator + "service", conf.getBackendTargetPath() + File.separator + "" + conf.getServiceModuleName(), dbInfo, conf.getBasePackage().replace(".", File.separator + ""));
//        log.info("\n--------------------------------------------------------------Generate Service-impl Module End  --------------------------------------------------------------");
//
//        log.info("\n--------------------------------------------------------------Generate web Module Start--------------------------------------------------------------");
//        genWebModule(conf.getWebModuleName(), model, conf.getBackendTemplatePath() + File.separator + "web", conf.getBackendTargetPath() + File.separator + "" + conf.getWebModuleName(), dbInfo, conf.getBasePackage().replace(".", File.separator + ""));
//        log.info("\n--------------------------------------------------------------Generate web Module End  --------------------------------------------------------------");

    }


    private static void genWebModule(String webModuleName, Map<String, Object> model, String templatePath, String targetPath, DBInfo dbInfo, String basePackage) throws IOException {
        for (TableInfo table : dbInfo.getTables()) {
            model.put("table", table);

            // Controller
            String controllerTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "controller";
            String controllerTargetName = table.getClassName() + "Controller.java";

            log.info("1. Generate " + webModuleName + " Module : " + controllerTargetPath + File.separator + controllerTargetName);
            TemplateUtils.executeFreemarker(templatePath, "Controller.ftl", "UTF-8", model, controllerTargetPath, controllerTargetName);
            log.info("==> success");
        }
    }

    private static void genDaoModule(String daoModuleName, Map<String, Object> model, String templatePath, String targetPath, DBInfo dbInfo, String basePackage) throws IOException {
        for (TableInfo table : dbInfo.getTables()) {
            model.put("table", table);

            // Entity
            String modelTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "entity";
            String modelTargetName = table.getClassName() + "Entity.java";

            log.info("1. Generate " + daoModuleName + " Module : " + modelTargetPath + File.separator + modelTargetName);
            TemplateUtils.executeFreemarker(templatePath, "Entity.ftl", "UTF-8", model, modelTargetPath, modelTargetName);
            log.info("==> success");

//            // DAO
//            String daoTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "dao";
//            String daoTargetName =  "I"+table.getClassName() + "DAO.java";
//
//            log.info("2. Generate " + daoModuleName + " Module : " + modelTargetPath + File.separator + modelTargetName);
//            TemplateUtils.executeFreemarker(templatePath, "DAO.ftl", "UTF-8", model, daoTargetPath, daoTargetName);
//            log.info("==> success");

            // Mapper
            String mapperTargetPath = targetPath + File.separator + "src" +File.separator+ "main" +File.separator+ "resources" +File.separator+ "sqlMapper";
            String mapperTargetName = table.getClassName() + "Mapper.xml";

            log.info("3. Generate " + daoModuleName + " Module : " + mapperTargetPath + File.separator + mapperTargetName);
            TemplateUtils.executeFreemarker(templatePath, "Mapper.ftl", "UTF-8", model, mapperTargetPath, mapperTargetName);
            log.info("==> success");
        }
    }

    private static void genApiModule(String apiModuleName, Map<String, Object> model, String templatePath, String targetPath, DBInfo dbInfo, String basePackage) throws IOException {
        for (TableInfo table : dbInfo.getTables()) {
            model.put("table", table);
            // DTO
            String dtoTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "dto";
            String dtoTargetName = table.getClassName() + "DTO.java";

            log.info("1. Generate " + apiModuleName + " Module : " + dtoTargetPath + File.separator + dtoTargetName);
            TemplateUtils.executeFreemarker(templatePath, "Dto.ftl", "UTF-8", model, dtoTargetPath, dtoTargetName);
            log.info("==> success");

            // Service
//            String serviceTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "service";
//            String serviceTargetName = "I"+table.getClassName() + "Service.java";
//
//            log.info("2. Generate " + apiModuleName + " Module : " + serviceTargetPath + File.separator + serviceTargetName);
//            TemplateUtils.executeFreemarker(templatePath, "Service.ftl", "UTF-8", model, serviceTargetPath, serviceTargetName);
//            log.info("==> success");

        }
    }

    private static void genServiceModule(String serviceModuleName, Map<String, Object> model, String templatePath, String targetPath, DBInfo dbInfo, String basePackage) throws IOException {
        for (TableInfo table : dbInfo.getTables()) {
            model.put("table", table);

            // Manager
            String managerTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "manager";
            String managerTargetName = "I"+table.getClassName() + "Manager.java";

            log.info("1. Generate " + serviceModuleName + " Module : " + managerTargetPath + File.separator + managerTargetName);
            TemplateUtils.executeFreemarker(templatePath, "Manager.ftl", "UTF-8", model, managerTargetPath, managerTargetName);
            log.info("==> success");

            // Manager Impl
            String managerImplTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "manager/impl";
            String managerImplTargetName = table.getClassName() + "ManagerImpl.java";

            log.info("2. Generate " + serviceModuleName + " Module : " + managerImplTargetPath + File.separator + managerImplTargetName);
            TemplateUtils.executeFreemarker(templatePath, "ManagerImpl.ftl", "UTF-8", model, managerImplTargetPath, managerImplTargetName);
            log.info("==> success");

            // Service Impl
            String serviceImplTargetPath = targetPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + basePackage + File.separator + table.getLowerCamelName() + File.separator + "service/impl";
            String serviceImplTargetName = table.getClassName() + "ServiceImpl.java";

            log.info("3. Generate " + serviceModuleName + " Module : " + serviceImplTargetPath + File.separator + serviceImplTargetName);
            TemplateUtils.executeFreemarker(templatePath, "ServiceImpl.ftl", "UTF-8", model, serviceImplTargetPath, serviceImplTargetName);
            log.info("==> success");
        }
    }
}
