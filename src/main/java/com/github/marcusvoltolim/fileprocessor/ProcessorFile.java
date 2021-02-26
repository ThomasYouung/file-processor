package com.github.marcusvoltolim.fileprocessor;

import java.io.*;
import java.util.List;

public final class ProcessorFile {

    private ProcessorFile() {
    }

    public static File decompress(final InputStream inputStream, boolean ignoreFolder) throws IOException {
        return ProcessorFactory.getInstance().getDecompress(ignoreFolder).decompress(inputStream);
    }

    /*public static File compress(final List<File> files, final String mediaType) throws IOException {
        return ProcessorFactory.getInstance().getCompress(mediaType).compress(files);
    }*/

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File file = null;
        try{
            String sourceFile = "";

            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\作者提供的案例\\go-janeiro-2017.rar";//成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\作者提供的案例\\go-janeiro-2018.7z";//成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\作者提供的案例\\go-janeiro-2018-RAR5.rar";//成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\作者提供的案例\\go-janeiro-2019.zip";//失败

            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\我的案例.7z";// 成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\我的案例rar5.rar";// 成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\我的案例.zip";// 成功，第二个pdf会失败
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\GO.zip";// 成功，第二个pdf会失败

            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\EXCEL\\EXCEL.zip";//excel测试之zip，成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\EXCEL\\EXCEL.7z";//excel测试之7z，成功
            sourceFile = "D:\\网盘\\（Git同步）文档和代码\\rar解压问题\\我的案例\\EXCEL\\EXCEL.rar";//excel测试之rar5，成功



            fis = new FileInputStream(new File(sourceFile));
            ProcessorFile.decompress(fis, false);

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

