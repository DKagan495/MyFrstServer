package clientpackage;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MySHMICQClient {
    public static void main(String[] args) throws IOException
    {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(addr, 4488);
        try
        {
            BufferedReader in  = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(in.readLine());
        } finally{socket.close();}
    }
}
