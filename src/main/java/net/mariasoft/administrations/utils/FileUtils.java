package net.mariasoft.administrations.utils;

import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static String getJsonfromFile(String path) throws Exception {
        return Files.readString(Paths.get(new ClassPathResource(path).getURI()));
    }
}
