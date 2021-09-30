package com.disgitechorg.inventory.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PropertyReaderUtil {

    public static String translateEnvVar(String property){
        try{
            Matcher match = Pattern.compile("\\$\\{(.*?)\\}").matcher(property);
            if(match.find()){
                String envVar=getEnvVar(match.group(1));
                if(envVar.length()>0){
                    return envVar;
                }
            }
        }catch(NullPointerException e){
            return property;
        }
        return property;
    }

    static String getEnvVar(String lookupVal){
        return System.getenv(lookupVal);
    }

}
