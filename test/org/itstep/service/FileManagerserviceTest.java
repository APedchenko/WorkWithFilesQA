package org.itstep.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileManagerserviceTest {


    private static String fromPath;
    private static String toPath;

    @BeforeAll
    static void setPreData() {

        String MAIN_DIR = System.getProperty("user.dir");
        String SEPARATOR = System.getProperty("file.separator");

        fromPath = MAIN_DIR + SEPARATOR + "files" + SEPARATOR + "Cat.jpg";
        ;
        toPath = MAIN_DIR + SEPARATOR + "files" + SEPARATOR + "Cat_test_copy.jpg";

    }

    @Test
    void testGetFileAsByteArray() {
        byte[] bytes = FileManagerservice.getFileAsByteArray(fromPath);
        assertNotNull(bytes);
        assertTrue(bytes.length > 0);
    }

    @Test
    void writeByteArrayToFile() {
        byte[] bytes = FileManagerservice.getFileAsByteArray(fromPath);

        FileManagerservice.writeByteArrayToFile(bytes, toPath);
        byte[] testBytes = FileManagerservice.getFileAsByteArray(toPath);

        assertNotNull(testBytes);
        assertTrue(testBytes.length > 0);

    }


    @AfterAll
    static void removeTestFiles() {
        File file = new File(toPath);
        if (file.isFile()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
