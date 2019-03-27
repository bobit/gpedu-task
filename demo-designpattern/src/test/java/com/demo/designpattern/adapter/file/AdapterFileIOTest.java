package com.demo.designpattern.adapter.file;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * AdapterFileIOTest
 *
 * @Author: zhangb
 * @Date: 2019-03-16 13:05
 */
public class AdapterFileIOTest {
    public static void main(String args[]) {
        FileIO fileIO = new FileProperties();
        try {
            fileIO.readFromFile("F:\\RepoSpaces\\public\\github\\gpedu-task\\demo-designpattern\\src\\test\\resources\\file.txt");
            fileIO.setValue("year", "2020");
            fileIO.writeToFile("F:\\RepoSpaces\\public\\github\\gpedu-task\\demo-designpattern\\src\\test\\resources\\newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}