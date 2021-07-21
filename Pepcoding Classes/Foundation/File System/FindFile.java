import java.io.*;
import java.util.*;
public class FindFile {
    public boolean findFile(String name,File file)
    {
        boolean res = false;
        File[] list = file.listFiles();
        
        if(list.length < 1){
            return false;
        }
        for (File fil : list){
            if (fil.isDirectory()) {
                res = res || findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName())){
                res = true;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) 
    {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file to be searched.. " );
        String name = scan.next();
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        boolean ans = ff.findFile(name,new File(directory));
        System.out.println(ans);
    }
}
