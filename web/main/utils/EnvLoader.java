package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    private static Dotenv dotenv;

    public static void loadEnv(String env) {
        dotenv = Dotenv.configure()
                .filename(".env." + env.toLowerCase())
                .ignoreIfMissing()
                .load();
    }

    public static String get(String key) {
        return dotenv.get(key);
    }
}
