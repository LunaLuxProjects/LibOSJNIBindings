package uk.co.lunalux.libos;

import java.util.ArrayList;

public class NetIO extends Defines
{
    private int socket_id = Integer.MAX_VALUE;
    private native int n_createSocket(int socketBits, String address, int port);
    private native String n_readSocket(int socket_id,int buffer_size);
    private native void n_writeSocket(int socket_id,String data);
    private native void n_destroySocket(int socket_id);
    private native int n_getCurrentResult(int socket_id);

    public static int LOS_SOCKET_UDP = 0x001;
    public static int LOS_SOCKET_TCP = 0x002;
    public static int LOS_SOCKET_SERVER = 0x008;
    //this is auto port forward (not implemented yet)
    public static int LOS_SOCKET_APF = 0x004;

    public native int[] losNetworkBytesToSystemBytes(int[] bytes);
    public native int[] losSystemBytesToNetworkBytes(int[] bytes);

    public losResult getCurrentResult() {return losResult.valueOf(n_getCurrentResult(socket_id));}
    public void createSocket(int socketBits, String address, int port) {socket_id = n_createSocket(socketBits, address, port);}
    public String readSocket(int buffer_size){return n_readSocket(socket_id,buffer_size);}
    public void writeSocket(String data) {n_writeSocket(socket_id,data);}
    public void closeSocket(){n_destroySocket(socket_id);}
}
