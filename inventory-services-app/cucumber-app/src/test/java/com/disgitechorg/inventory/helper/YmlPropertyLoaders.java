package com.disgitechorg.inventory.helper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.io.InputStream;
import java.io.ObjectInput;
import java.util.Map;

public class YmlPropertyLoaders {

    private static final Logger LOGGER = LoggerFactory.getLogger(YmlPropertyLoaders.class);

    public static Object loadYaml(Class pojoPropertiesClass, String yamlPath) {
        Representer representer = new Representer();
        representer.getPropertyUtils().setSkipMissingProperties(true);
        Yaml yaml = new Yaml(new Constructor(pojoPropertiesClass), representer);
        InputStream inputStream = YmlPropertyLoaders.class.getResourceAsStream("/" + yamlPath);
        LOGGER.info("Loading yml file" + yamlPath);
        return yaml.load(inputStream);
    }


    public static Map<String, Object> loadYamlAsMap(String yamlPath){
        Yaml yaml = new Yaml();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(yamlPath);
        LOGGER.info("Loading yaml file :" +yamlPath);
        return yaml.load(inputStream);
    }

    public static String getPropertyFromYamlFile(String basePathKey, Map<String,Object> configMap) throws Exception {
        String [] paths= basePathKey.split("\\.");
        for(String path:paths){
            if(configMap.get(path) instanceof Map) {
                configMap = (Map) configMap.get(path);
            }else{
                return (String)configMap.get(path);
            }
        }
        throw new Exception("Not able to read property value :"+basePathKey);
    }
}
