package net.mariasoft.administrations.utils;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public class OsUtils {
    private static OSType cachedOsType;
    private static String cachedHomeDir;

    private static final Map<String, OSType> osTypeMap = Map.of(
            "linux", OSType.LINUX,
            "windows", OSType.WINDOWS,
            "mac os", OSType.MAC,
            "macos", OSType.MAC,
            "darwin", OSType.MAC,
            "solaris", OSType.SCOLARIS,
            "sunos", OSType.SCOLARIS
    );

    public static OSType getOsType() {
        if (cachedOsType == null) {
            String osName = Optional.ofNullable(System.getProperty("os.name")).orElse("").toLowerCase();

            cachedOsType = osTypeMap.entrySet().stream()
                    .filter(e -> osName.contains(e.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(OSType.OTHERS);
        }
        return cachedOsType;
    }

    public static String getOsHomeDir() {
        if (cachedHomeDir == null) {
            String homeDir = System.getProperty("user.home");
            cachedHomeDir = homeDir + File.separator + MsConstants.DEFAULT_DOC_SERVEUR_NAME + File.separator;
        }

        return cachedHomeDir;
    }

    public static String getOsPath(String p) {
        return p.replaceAll("\\\\", "/").replaceAll("(?<=.)/?$", "/");
    }

    public static String getTempDir() {
        return getOsHomeDir() + MsConstants.DIR_TEMP;
    }
}
