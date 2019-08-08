package com.lw.lr.webTours.python;

public class WebTours {
    public static void main(String[] args) {
        String fileName = "F:/XX/XX/login.py";
        exec(fileName);
    }

    /**
     * 执行python脚本
     *
     * @param fileName python文件
     */
    public static void exec(String fileName) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("cmd /c python " + fileName);
            new ProcessClearStream(process.getInputStream(), "INFO").start();
            new ProcessClearStream(process.getErrorStream(), "ERROR").start();
            int status = process.waitFor();
            System.out.println("Process exitValue: " + status);
        } catch (Exception e) {
            System.out.println("执行" + fileName + "出现错误，" + e.toString());
        } finally {
            if (process == null) {
                process.destroy();
            }
            process = null;
        }

    }
}
