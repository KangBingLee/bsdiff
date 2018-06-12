package com.lkb.bsdiff;


/**
 * @author likangbing
 * @date 2018/06/07
 */
public class BsDiffUtil {

    private static BsDiffUtil instance = new BsDiffUtil();

    public static BsDiffUtil getInstance(){
        return instance;
    }

    public native int bsDiffFile(String oldFile, String newFile, String patchFile);

    static{
        System.loadLibrary("BsDiffLkb");
    }

}

