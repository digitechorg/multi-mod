package com.disgitechorg.inventory.helper;

import lombok.Data;

@Data
public class CucumberProperties {

    private Application application;

    @Data
    public static class Application{
        private Credentials credentials;
        private Connection connection;
    }

    @Data
    public static class Credentials{
        private String username;
        private String password;

        public void setUsername(String username) {
            this.username = PropertyReaderUtil.translateEnvVar(username);
        }

        public void setPassword(String password) {
            this.password = PropertyReaderUtil.translateEnvVar(password);
        }
    }

    @Data
    public static class Connection{
        private String host;
        private Integer port;

    }



}
