package NIOTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.Test;

/**
 * Package: NIOTest Description:实现一个服务器应用，只简单要求能够同时服务多个客户端请求 Date:  2020/5/26 0:08 Author: kousq
 * Modified By:
 */

public class DemoServer extends Thread {

    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(0);


//            ServerSocket[] serverSockets = new ServerSocket[3];
//            for (int i = 0; i < 3; i++) {
//                serverSockets[i] = new ServerSocket(i+100);
//                System.out.println(serverSockets);
//            }

            while (true) {
//                for (ServerSocket serverSocket:serverSockets) {
//                    Socket socket = serverSocket.accept();
//                    RequestHandler requestHandler = new RequestHandler(socket);
//                    requestHandler.start();
//                }
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }


    @Test
    public static void main(String[] args) throws IOException {
        DemoServer server = new DemoServer();
        server.start();

        //这个括号在JDK1.7之前是没有的，是1.7的新特性。
        //括号里的内容支持包括流以及任何可关闭的资源，数据流会在 try 执行完毕后自动被关闭，而不用我们手动关闭了
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {

    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
