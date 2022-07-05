package uk.co.lunalux.libos;

import java.util.ArrayList;

public class NetIO extends Defines
{
    public static int LOS_SOCKET_UDP = 0x001;
    public static int LOS_SOCKET_TCP = 0x002;
    //this is auto port forward
    public static int LOS_SOCKET_APF = 0x004;
    public static int LOS_SOCKET_SERVER = 0x008;

    public class createSocketInfo
    {
        int socketBits;
        String address;
        int port;
    }

    public class socketResult
    {
        losResult losResult;
        String value;
    }

    public native ArrayList<Integer> losNetworkBytesToSystemBytes(ArrayList<Integer> bytes);
    public native ArrayList<Integer> losSystemBytesToNetworkBytes(ArrayList<Integer> bytes);

    public native losResult losCreateSocket(createSocketInfo info);
    public native socketResult losReadSocket();
    public native losResult losWriteSocket(String data);
    public native losResult losDestroySocket();
}
