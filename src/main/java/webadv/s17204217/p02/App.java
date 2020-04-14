package webadv.s17204217.p02;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        File file = new File("userInfo.txt");
        System.out.println("请输入您的用户名及密码:");
        Scanner input = new Scanner(System.in);
        String id = input.next();
        String password = input.next();
        Reader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);

        List<String> ids = new ArrayList<>();
        List<String> pws = new ArrayList<>();
        String s = "";
        int op=1;
        while((s=in.readLine())!=null){
            if(op==1){
                ids.add(s);
                op=2;
            }
            else{
                pws.add(s);
                op=1;
            }
        }
        int len = ids.size();
        boolean flag=false;
        for(int i=0;i<len;++i){
            if(id.equals(ids.get(i))==true&& DigestUtils.sha256Hex(password).equals(pws.get(i))==true){
                flag=true;
                break;
            }
        }
        if(flag==true){
            System.out.println("登陆成功,17204217");
        }
        else{
            System.out.println("登录失败");
        }
    }
}
