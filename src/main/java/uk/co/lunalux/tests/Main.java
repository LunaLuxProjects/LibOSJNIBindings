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
        // networking io test
    }
}