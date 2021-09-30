package com.disgitechorg.inventory.helper;

import java.util.ArrayList;
import java.util.List;

public class ProgArgs {

    private static final String configYml = "cucumber-" + (System.getProperty("profile")) == null ? "local" : System.getProperty("profile");
    private static final CucumberProperties properties = (CucumberProperties) YmlPropertyLoaders.loadYaml(CucumberProperties.class,configYml);

    public static List<String> getProgArgs(String thread, int port){
        List<String> progArgsList = new ArrayList<>();
        progArgsList.add("-Dlogging.config=" +properties.getApplication());
        return progArgsList;

    }
}
