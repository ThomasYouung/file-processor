package com.github.marcusvoltolim.fileprocessor;

import java.io.*;
import java.util.List;

public final class ProcessorFile {

    private ProcessorFile() {
    }

    public static File decompress(final InputStream inputStream) throws IOException {
        return ProcessorFactory.getInstance().getDecompress().decompress(inputStream);
    }

    public static File compress(final List<File> files, final String mediaType) throws IOException {
        return ProcessorFactory.getInstance().getCompress(mediaType).compress(files);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File file = null;
        try{
            String sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\rar解压问题思路.rar";
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\go-janeiro-2018-RAR5.rar";
            fis = new FileInputStream(new File(sourceFile));
            ProcessorFile.decompress(fis);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

