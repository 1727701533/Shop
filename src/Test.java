import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool=true;
        while(bool){
            System.out.println("请输入用户名:");
            Scanner sc=new Scanner(System.in);
            String username=sc.next();//阻塞方法

            System.out.println("请输入密码:");
            String password=sc.next();

            //File file=new File("C:\\Users\\G150T\\IdeaProjects\\Shop\\src\\users.xlsx");
            InputStream in=Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadExcel readExcel=new ReadExcel();
            User users[]=readExcel.readExcel(in);
            for(int i=0;i<users.length;i++){
                if(username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())){
                    System.out.println("登陆成功");
                    bool=false;
                    break;
                }else{
                    System.out.println("登陆失败");
                }
            }
        }
    }
}
