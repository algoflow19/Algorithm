/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;
import java.io.File;
/** 
 *
 * @author KK
 */
public class ListFile {
    
    public static void main(String[] args) {
        printFiles("G:\\NetB\\DrJava", "");
    }
    
    public static void printFiles(String folderName,String prefix){
        File root=new File(folderName);
        System.out.print(prefix+folderName);
        if(root.isFile()) {
            System.out.println();
            return;
        }
        System.out.println("\\");
        String[] files=root.list();
        prefix+="   ";
        for(String f : files){
            if(!f.equals(folderName))
            printFiles(folderName+"\\"+f, prefix);
        }
        return;
    }
    
}
