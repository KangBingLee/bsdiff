package com.lkb.bspatch;

/**
 * @author
 * @date 2018/06/08
 */
public class BsPatchUtil {

    private static BsPatchUtil instance = new BsPatchUtil();

    public static BsPatchUtil getInstance(){
        return instance;
    }

    public native int bsPatchFile(String oldFile, String newFile, String patchFile);

    static{
        System.loadLibrary("BsPatchLkb");
    }

}
