package org.itstep;

import org.itstep.service.FileManagerservice;

public class AppRunner {

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = System.getProperty("file.separator");

    public static void main(String[] args) {
        String filePath = MAIN_DIR+SEPARATOR+"files"+SEPARATOR+"Cat.jpg";
        String fileCopyPath = MAIN_DIR+SEPARATOR+"files"+SEPARATOR+"Cat_copy.jpg";

        FileManagerservice.copyFile(filePath,fileCopyPath);

    }
}
