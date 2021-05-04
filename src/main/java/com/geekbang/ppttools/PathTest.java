package com.geekbang.ppttools;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathTest {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();

        System.out.println(path.toString());
    }
}
