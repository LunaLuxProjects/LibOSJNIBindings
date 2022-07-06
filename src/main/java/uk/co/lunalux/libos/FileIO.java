package uk.co.lunalux.libos;

public class FileIO extends Defines
{
    private int file_id = Integer.MAX_VALUE;
    private native int n_openFile(int fileBits, String path);
    private native String n_readFile(int file_id);
    private native void n_writeFile(int file_id,String data);
    private native void n_closeFile(int file_id);
    private native int n_getCurrentResult(int file_id);

    public static final int LOS_FILE_BIT_READ	= 0x001;
    public static final int LOS_FILE_BIT_WRITE	= 0x002;
    public static final int LOS_FILE_BIT_BINARY	= 0x004;
    public static final int LOS_FILE_BIT_CREATE	= 0x008;
    public static final int LOS_FILE_BIT_DELETE_AFTER_CLOSE = 0x016;
    public static final int LOS_FILE_BIT_FLIP_ENDIEN = 0x032;

    public native void setAssetPath(String path);
    public losResult getCurrentResult() {return losResult.valueOf(n_getCurrentResult(file_id));}
    public void openFile(int fileBits, String path) {file_id = n_openFile(fileBits, path);}
    public String readFile(){return n_readFile(file_id);}
    public void writeFile(String data) {n_writeFile(file_id,data);}
    public void closeFile(){n_closeFile(file_id);}
}