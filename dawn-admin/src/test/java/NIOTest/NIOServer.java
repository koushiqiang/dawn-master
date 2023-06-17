package NIOTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

/**
 * Package: NIOTest Description: Date:  2020/5/26 11:18 Author: kousq Modified By:
 */

public class NIOServer extends Thread {


    public void run() {
        try (Selector selector = Selector.open();//1.创建一个selector,作为调度员的角色
                ServerSocketChannel serverSocket = ServerSocketChannel
                        .open();) {// 2.创建ServerSocketChannel并向selector注册
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);//PS: 明确配置非阻塞模式,因为阻塞模式下,注册操作是不允许的
            // 2.1 注册到Selector，并说明关注点 为新的连接请求
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();//3. selector阻塞在select操作,阻塞等待就绪的Channel,当有Channel发生接入请求 就会被唤醒
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    // 生产系统中一般会额外进行就绪状态检查
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
        try (SocketChannel client = server.accept();) {
            client.write(
                    Charset.defaultCharset().encode("Hello world!"));
        }
    }
    // 省略了与前面类似的main


    @Test
    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.start();

        //这个括号在JDK1.7之前是没有的，是1.7的新特性。
        //括号里的内容支持包括流以及任何可关闭的资源，数据流会在 try 执行完毕后自动被关闭，而不用我们手动关闭了
//        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(client.getInputStream()));
//            bufferedReader.lines().forEach(s -> System.out.println(s));
//        }
    }
}