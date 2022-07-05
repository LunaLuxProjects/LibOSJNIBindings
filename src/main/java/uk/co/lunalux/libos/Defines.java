package uk.co.lunalux.libos;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class Defines
{
    public class losSize
    {
        int width;
        int height;
    }
    public enum losResult
    {
        LOS_SUCCESS(0),
        LOS_ERROR_HANDLE_IN_USE(1),
        LOS_ERROR_COULD_NOT_GET_CORRECT_DATA(2),
        LOS_ERROR_COULD_NOT_INIT(3),
        LOS_ERROR_COULD_NOT_DESTORY(4),
        LOS_ERROR_INVALID_FLAGS(5),
        LOS_ERROR_HANDLE_LOSSED(6),
        LOS_ERROR_FEATURE_NOT_IMPLEMENTED(7),
        // API CUSTOMS
        // NETWORK
        LOS_NET_IO_DOMAIN_NOT_FOUND(8),
        LOS_NET_IO_CONNECTION_REFUSED(9),
        LOS_NET_IO_CONNECTION_CLOSED_SERVER_END(10),
        // WINDOW
        LOS_WINDOW_CLOSE(11),
        //ThreadGuard
        LOS_ERROR_TRIED_TO_ACCESS_THREAD_RESOURCES_ON_OTHER_THREAD(12);

        private int value;
        private static final Map<Integer,losResult> map = new HashMap<>();

        private losResult(int value) {
            this.value = value;
        }

        static {
            for (losResult pageType : losResult.values()) {
                map.put(pageType.value, pageType);
            }
        }

        public static losResult valueOf(int pageType) {
            return (losResult) map.get(pageType);
        }

        public int getValue() {
            return value;
        }
    }
    private static Boolean loaded = false;
    private static class LibResult
    {
        public String path = "";
        public boolean found = false;
        public LibResult() {}
    }
    private static LibResult findFile(String name, File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    LibResult result;
                    if((result = findFile(name,fil)).found)
                        return result;
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    LibResult result = new LibResult();
                    var temp_path = fil.getParent().toString() + "/" + name;
                    result.path = temp_path;
                    result.found = true;
                    return result;
                }
            }
        return new LibResult();
    }

    static
    {
        String name = "libos";
        if(!loaded)
        {
            loaded = true;
            var os = System.getProperty("os.name");
            Path execution_path = Path.of(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(".")).getPath());
            if(os.contains("win"))
                name += ".dll";
            else if(os.contains("mac"))
                name += ".dynlib";
            else if(os.contains("Linux") || os.contains("unix"))
                name = "lib" + name + ".so";
            else throw new RuntimeException("unsupported os:" + os);
            LibResult result = new LibResult();
            for(int i = 0; i < 5; i++) {
                if((result = findFile(name,new File(execution_path.toString()))).found)
                    break;
                execution_path = execution_path.getParent();
            }
            if(!result.found) throw new RuntimeException(name + " - not found to load");
            try
            {
                System.load(result.path);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }
}
