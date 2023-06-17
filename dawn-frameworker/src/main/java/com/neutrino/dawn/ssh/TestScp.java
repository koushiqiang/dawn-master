package com.neutrino.dawn.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileHandle;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Package: com.neutrino.dawn.ssh Description: Date:  2020/5/22 12:59 Author: kousq Modified By:
 */
public class TestScp {


    public static void main(String[] args)
    {
        String hostname = "192.168.137.137";
        String username = "kousq";
        String password = "960425";

        try
        {
            /* Create a connection instance */
            //构造一个连接器，传入一个需要登陆的ip地址，连接服务
            Connection conn = new Connection(hostname);
            conn.connect();

            //用户验证，传入用户名和密码
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);

            if (isAuthenticated == false) {
                throw new IOException("Authentication failed.");
            }

            //创建一个copy文件客户端
            SCPClient scpClient = conn.createSCPClient();
            //从本地复制文件到远程目录
            scpClient.put("D:/test.txt ", 10,"\\./", "0644");
            scpClient.get("/home/kousq/kousq/do_script/multipFileRead/file1");//从远程获取文件

            /**
             * 通过SFTP远程读取文件内容
             * test.txt文件内容为sftp---test
             */
            SFTPv3Client sftpClient = new SFTPv3Client(conn);
            SFTPv3FileHandle sftpHandle = sftpClient.openFileRW("/home/kousq/kousq/do_script/multipFileRead/file1");
            byte[] bs = new byte[11];
            int i = 0;
            long offset = 0;
            while(i!=-1){
                i = sftpClient.read(sftpHandle, offset, bs, 0, bs.length);
                offset += i;
            }
            System.out.println(new String(bs));

            //打开一个会话session，执行linux命令
            Session sess = conn.openSession();
            sess.execCommand("ls");
            System.out.println("Here is some information about the remote host:");

            //接收目标服务器上的控制台返回结果,输出结果。
            InputStream stdout = new StreamGobbler(sess.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            while (true)
            {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

            //得到脚本运行成功与否的标志 ：0－成功 非0－失败
            System.out.println("ExitCode: " + sess.getExitStatus());

            //关闭session和connection
            sess.close();
            conn.close();

        }
        catch (IOException e)
        {
            e.printStackTrace(System.err);
            System.exit(2);
        }
    }

}