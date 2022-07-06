package uk.co.lunalux.tests;
import uk.co.lunalux.libos.*;
public class Main
{
    public static void main(String args[])
    {
        // file io test
        FileIO io = new FileIO();
        io.openFile(FileIO.LOS_FILE_BIT_CREATE | FileIO.LOS_FILE_BIT_WRITE | FileIO.LOS_FILE_BIT_READ,"test.txt");
        if(io.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not open file Error: " + io.getCurrentResult());
        io.writeFile("this is a test");
        if(io.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not write file");
        String text = io.readFile();
        if(io.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not read file");
        if(!text.equals("this is a test"))
            throw new RuntimeException("could not read file correctly");
        io.closeFile();
        if(io.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not close file correctly");  
        // networking io test
        // udp test
        NetIO netio = new NetIO();
        netio.createSocket(NetIO.LOS_SOCKET_UDP,"127.0.0.1",54000);
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not open udp socket Error: " + netio.getCurrentResult());
        netio.writeSocket("this is a test");
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not write to udp socket");
        netio.closeSocket();
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not close udp socket");
        // TCP test
        netio.createSocket(NetIO.LOS_SOCKET_TCP,"127.0.0.1",54000);
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not open tcp socket Error: " + netio.getCurrentResult());
        netio.writeSocket("this is a test");
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not write to tcp socket");
        String data = netio.readSocket(16);
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not read to tcp socket");
        if(!data.equals("this is a test"))
            throw new RuntimeException("could not read socket correctly");
        netio.closeSocket();
        if(netio.getCurrentResult() != Defines.losResult.LOS_SUCCESS)
            throw new RuntimeException("could not close tcp socket");  
    }
}