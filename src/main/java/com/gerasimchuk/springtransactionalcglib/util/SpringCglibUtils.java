package com.gerasimchuk.springtransactionalcglib.util;

import org.springframework.cglib.core.ReflectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

public class SpringCglibUtils {
    public static void initGeneratedClassHandler(String targetPath) {
        File dir = new File(targetPath);
        dir.mkdirs();
        ReflectUtils.setGeneratedClassHandler((String className, byte[] classContent) -> {
            try (FileOutputStream out = new FileOutputStream(new File(dir, className + ".class"))) {
                out.write(classContent);
            } catch (IOException e) {
                throw new UncheckedIOException("Error while storing " + className, e);
            }
        });
    }
}
