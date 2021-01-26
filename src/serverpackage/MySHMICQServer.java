package serverpackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySHMICQServer {
    public static final int PORT = 4488;
    public static void main(String[] args) throws IOException
    {
        ServerSocket s  = new ServerSocket(PORT);
        try {
            Socket socket = s.accept();
            try
            {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()
                                )
                        )
                , true);
                while (true)
                {
                    String str = in.readLine();
                    if(str.equals("BYE")) break;
                    out.println(str);
                }
            } finally { socket.close(); }
        } finally{s.close();}
    }
}
