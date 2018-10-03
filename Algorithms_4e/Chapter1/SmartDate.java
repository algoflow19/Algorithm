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
import edu.princeton.cs.algs4.Date;

public class SmartDate {
    int day;
    int mouth;
    int year;
    public enum weeks{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
    };
    Date date;
    public SmartDate(String str){
        String[] argList=str.split("/");
        try {
            mouth=Integer.parseInt(argList[0]);
            day=Integer.parseInt(argList[1]);
            year=Integer.parseInt(argList[2]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal input format");
        }
        
        if(!(day>0&&year>0&&mouth>0))
            throw new RuntimeException("Illgeal input: date can't be negetive!");
        if(mouth>12) throw new RuntimeException("Illgeal input: mouth must less than 13");
        if(day>31) throw new RuntimeException("Illegal input:day must less than 32");
        switch(mouth){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12: break;
            case 2: if(year%4==0){
                if(day>29) throw new RuntimeException("Illegal input:day must less than 30 in fours-year");
            }
            else
                if(day>28) throw new RuntimeException("Illegal input:day must less than 29 in non-fours-year");
            break;
            default:
                if(day>30) throw new RuntimeException("Illegal input:day out of range!");
        }
    }
    public String toString(){
        return date.toString();
    }
    public int year(){
        return year;
    }
    public int mouth(){
        return mouth;
    }
    public int day(){
        return day;
    }
    public boolean equal(Object other){
        return date.equals(other);   
    }
    public int dayOfWeek(){
        return (5+daysFrom2000_1_1ToThisYear_1_1())%7;
    }
    
    int daysFromYearBeginToToday(){
        int sum=0;
        int changeYears=year-2000;
        if(changeYears>=1){
            ++sum;
        sum+=(changeYears-1)/4;
        }
        return changeYears*365+sum;
    }
    
    int daysFrom2000_1_1ToThisYear_1_1(){
        int sum=0;
        int mouth=this.mouth;
        if(mouth>1) sum+=31;
        if(mouth>2){
            if(year%4==0) sum+=29;
            else sum+=28;
        }
        if(mouth>3) sum+=31;
        if(mouth>4) sum+=30;
        if(mouth>5) sum+=31;
        if(mouth>6) sum+=30;
        if(mouth>7) sum+=31;
        if(mouth>8) sum+=31;
        if(mouth>9) sum+=30;
        if(mouth>10) sum+=31;
        if(mouth>11) sum+=30;
        sum+=day-1;
        return sum+daysFromYearBeginToToday();
    }
    
    public static void main(String[] args) {
        SmartDate smartDate=new SmartDate("4/20/2018");
        System.out.println(smartDate.dayOfWeek());
    }
    
}
