import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        Ctrl+Alt+L自动排序快捷键
         */
        boolean bool=true;
        while(bool){
            System.out.println("请输入用户名:");
            Scanner sc=new Scanner(System.in);
            String username=sc.next();//阻塞方法

            System.out.println("请输入密码:");
            String password=sc.next();

            //File file=new File("C:\\Users\\G150T\\IdeaProjects\\Shop\\src\\users.xlsx");
            InputStream in=Class.forName("Test").getResourceAsStream("/users.xlsx");

            InputStream inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");

            ReadUserExcel readExcel=new ReadUserExcel();//创建对象
            User users[]=readExcel.readExcel(in);
            for(int i=0;i<users.length;i++){
                if(username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())){
                    bool=false;
                    /*
                    显示商品的信息
                     */
                    ReadProductExcel readProductExcel=new ReadProductExcel();
                    Product products[] = readProductExcel.getAllProduct(inPro);
                    for (Product product:products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());//\t类似tab键空格间隔
                        System.out.print("\t\t" + product.getPrice());
                        System.out.println("\t\t" + product.getDesc());
                    }
                    /*
                    遍历数组
                     */
                    System.out.println("请输入商品ID，把该商品加入购物车");
                    String pId=sc.next();
                    ReadProductExcel readProductExcel1=new ReadProductExcel();
                    inPro=null;
                    inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");
                    readProductExcel1.getProductById(pId,inPro);
                    if(products!=null){
                        System.out.println("找到该商品");
                    }
                    break;
                }else{
                    System.out.println("登陆失败");
                }
            }
        }
    }
}



