package com.neutrino.dawn.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Package: com.neutrino.dawn.ssh Description: Date:  2020/5/22 12:58 Author: kousq Modified By:
 */
public class Basic
{
    public static void main(String[] args)
    {
        //服务器ip
        String hostname = "192.168.137.137";
        //用户名
        String username = "kousq";
        //密码
        String password = "960425";

        try
        {
            /* Create a connection instance */
            //构造一个连接器，传入一个需要登陆的ip地址，连接服务
            Connection conn = new Connection(hostname);

            /* Now connect */
            conn.connect();

            /* Authenticate.
             * If you get an IOException saying something like
             * "Authentication method password not supported by the server at this stage."
             * then please check the FAQ.
             */
            //用户验证，传入用户名和密码
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);

            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");

            /* Create a session */
            //打开一个会话session，执行linux命令
            Session sess = conn.openSession();


            sess.execCommand("pwd");

            System.out.println("Here is some information about the remote host:");

            /*
             * This basic example does not handle stderr, which is sometimes dangerous
             * (please read the FAQ).
             */
            //接收目标服务器上的控制台返回结果,输出结果。
            InputStream stdout = new StreamGobbler(sess.getStdout());

            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

            while (true)
            {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }

            /* Show exit status, if available (otherwise "null") */
            //得到脚本运行成功与否的标志 ：0－成功 非0－失败
            System.out.println("ExitCode: " + sess.getExitStatus());

            /* Close this session */
            //关闭session和connection
            sess.close();

            /* Close the connection */

            conn.close();

        }
        catch (IOException e)
        {
            e.printStackTrace(System.err);
            System.exit(2);
        }
    }
}