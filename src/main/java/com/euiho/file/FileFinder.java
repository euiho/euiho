package com.euiho.file;

import java.io.File;

/**
 * 지정된 경로 내 파일명으로 파일의 위치를 찾는 프로그램
 */
public class FileFinder {

    public static void main(String[] args) {
        FileFinder finder = new FileFinder();

        finder.run("/", "euiho.txt");
    }

    public void run(String rootDirPath, String fileName) {

        File rootDir = new File(rootDirPath);

        if (rootDir.isDirectory()) {
            this.find(rootDir, fileName);
            return;
        }

    }

    private void find(File dir, String fileName) {

        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                this.find(file, fileName);
                continue;
            }
            if (file.getName().equals(fileName)) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
