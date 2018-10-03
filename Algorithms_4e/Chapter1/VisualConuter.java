/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

/**
 *
 * @author KK
 */
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdIn;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VisualConuter {
    
    Draw canvase;
    long operatorTimeUpBound;
    long value;
    double RetOffset;
    long maxHeight;
    
    public VisualConuter(int n,long max){
        RetOffset=0.2;
        maxHeight=max;
        operatorTimeUpBound=n;
        canvase=new Draw("VisualCounter with upBoard "+max);
        canvase.setYscale(-max,max);
        canvase.setXscale(0,1);
        canvase.setPenRadius(0.001);
        canvase.setPenColor(Draw.GRAY);
        canvase.line(0, 0, 1, 0);
    }
    public long get(){
        return value;
    }
    
    public void add(){
        if(operatorTimeUpBound<0)
            throw new RuntimeException(" Too many operator!");
        if(value==maxHeight)
            throw new RuntimeException(" Add Out of Range!!!");
        drawAdd();
        ++value;
        --operatorTimeUpBound;
    }
    
    public void sub(){
        if(operatorTimeUpBound<0)
            throw new RuntimeException(" Too many operator!");
        if(value==-maxHeight)
            throw new RuntimeException(" Sub Out of Range!!!");
        drawSub();
        --value;
        --operatorTimeUpBound;
    }
    
    void drawAdd(){
        
        if(value>=0){
            canvase.setPenColor(Draw.BLACK);
            canvase.filledRectangle(0.5, value+0.5, 0.45, 0.5*(1-RetOffset));
        }
        else{
            canvase.setPenColor(Draw.WHITE);
            canvase.filledRectangle(0.5, value+0.5, 0.5, 0.5);
        }
            
    }
    
    void drawSub(){
        if(value<=0){
            canvase.setPenColor(Draw.BLACK);
            canvase.filledRectangle(0.5, value-0.5, 0.45, 0.5*(1-RetOffset));
        }
        else{
            canvase.setPenColor(Draw.WHITE);
            canvase.filledRectangle(0.5, value-0.5, 0.5, 0.5);
        }
    }
    // private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        VisualConuter vc=new VisualConuter(100, 20);
        System.out.println("--------------------------------------------\n"
                + "type + or - to test this class");
        //scanner.useDelimiter(WHITESPACE_PATTERN);
        while(true){
            
            String command = scanner.nextLine();
            System.out.println(command);
            if(command.charAt(0)=='+'){
            vc.add();
            }
            else if(command.charAt(0)=='-'){
                vc.sub();
            }
            else if(command.charAt(0)=='q')
                System.exit(0);
            else{
                System.err.println("Unknow operator! use '+' or '-' insted." + command);
            }
        }
    }
}
