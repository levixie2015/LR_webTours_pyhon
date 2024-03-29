package com.lw.lr.webTours.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 清除process里的InputStream和ErrorStream 缓存
 */
public class ProcessClearStream extends Thread {
    private InputStream inputStream;
    private String type;

    ProcessClearStream(InputStream inputStream, String type) {
        this.inputStream = inputStream;
        this.type = type;
    }

    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "GB2312");
            BufferedReader br = new BufferedReader(inputStreamReader);
            // 打印信息
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(type + ">" + line);
            }
            // 不打印信息
//           while (br.readLine() != null);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}