package com.demo.designpattern.adapter.file;

import java.io.IOException;

/**
 * FileIO接口
 *
 * @Author: zhangb
 * @Date: 2019-03-16 13:02
 */
public interface FileIO {
    public void readFromFile(String filename) throws IOException;

    public void writeToFile(String filename) throws IOException;

    public void setValue(String key, String value);

    public String getValue(String key);
}
