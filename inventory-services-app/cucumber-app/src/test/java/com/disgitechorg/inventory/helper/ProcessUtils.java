package com.disgitechorg.inventory.helper;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class ProcessUtils {

    public static void addShutDownHook(Process process){
        Runtime.getRuntime().addShutdownHook(new Thread(process::destroy));
    }

//    public static void addShutDownHook(MsgBkr msgBkr){
//        Runtime.getRuntime().addShutdownHook(new Thread(msgBkr::destroy));
//    }




    public static String getLocalJar(String jarBasePath) throws Exception {
        File directory = new File(jarBasePath);

        if(!directory.exists() || directory.listFiles().length==0){
            throw new Exception();
        }
        String[] extentions = new String[]{"jar"};
        List<File> jarfiles = (List<File>) FileUtils.listFiles(directory,extentions,false);

        if(jarfiles.size()>1){
            throw new Exception();
        }
        return  jarfiles.get(0).getName();
    }
}
