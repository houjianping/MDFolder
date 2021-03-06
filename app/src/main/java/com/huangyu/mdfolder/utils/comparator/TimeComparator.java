package com.huangyu.mdfolder.utils.comparator;

import com.huangyu.mdfolder.bean.FileItem;

import java.util.Comparator;

/**
 * Created by huangyu on 2017-5-24.
 */
public class TimeComparator implements Comparator<FileItem> {

    public int compare(FileItem file1, FileItem file2) {
        long diff = Long.valueOf(file1.getDate()) - Long.valueOf(file2.getDate());
        if (diff < 0) {
            return -1;
        } else if (diff > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
