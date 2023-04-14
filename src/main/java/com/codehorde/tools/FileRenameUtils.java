package com.codehorde.tools;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class FileRenameUtils {

    public static void main(String[] args) {
        String folder = "/Users/baomf/Downloads/金融百科";
        File file = new File(folder);
        File[] list = file.listFiles();
        if (file.exists() && file.isDirectory()) {
            for (int i = 0; i < list.length; i++) {
                File curFile = list[i];
                String newName = newName(curFile.getName());
                //curFile.renameTo(new File(folder + "/" + newName));
                System.out.println(newName);
            }
        }
    }

    /*private static String newName(String curName) {
        String retName = curName*//*.replaceAll("【期货从业人员资格考试】 - 期货基础知识 - [\\d]+ - 【期货基础知识】", "").trim()*//*;
        final int index = 12;
        String head = StringUtils.substring(retName, 0, index);
        String tail = StringUtils.substring(retName, index);
        head = head
                .replace("第一章", "01")
                .replace("第二章", "02")
                .replace("第三章", "03")
                .replace("第四章", "04")
                .replace("第五章", "05")
                .replace("第六章", "06")
                .replace("第七章", "07")
                .replace("第八章", "08")
                .replace("第九章", "09")
                .replace("第十章", "10")
        ;
        head = head
                .replace(" 第一节", "-1")
                .replace(" 第二节", "-2")
                .replace(" 第三节", "-3")
                .replace(" 第四节", "-4")
                .replace(" 第五节", "-5")
                .replace(" 第六节", "-6")
                .replace(" 第七节", "-7")
                .replace(" 第八节", "-8")
                .replace(" 第九节", "-9")
        ;
        return head + tail;
    }*/

    private static String newName(String curName) {
        String retName = curName.replaceAll("金融百科 - [\\d]+ - 【金融百科】", "").trim();
        final int index = 4;
        String head = StringUtils.substring(retName, 0, index);
        String tail = StringUtils.substring(retName, index);
        int i = head.indexOf('.');
        if (i == 1) {
            head = "00" + head;
        } else if (i == 2) {
            head = "0" + head;
        }
        return head + tail;
    }
}