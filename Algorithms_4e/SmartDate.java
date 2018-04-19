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
    public enum weeks{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
    };
    Date date;
    public SmartDate(String str){
        date=new Date(str);
        if(!(date.day()>0&&date.year()>0&&date.month()>0))
            throw new RuntimeException("Illgeal input: date can't be negetive!");
        if(date.month()>12) throw new RuntimeException("Illgeal input: mouth must less than 13");
        if(date.day()>31) throw new RuntimeException("Illegal input:day must less than 32");
        switch(date.month()){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12: break;
            case 2: if(date.year()%4==0){
                if(date.day()>29) throw new RuntimeException("Illegal input:day must less than 30 in fours-year");
            }
            else
                if(date.day()>28) throw new RuntimeException("Illegal input:day must less than 29 in non-fours-year");
            break;
            default:
                if(date.day()>30) throw new RuntimeException("Illegal input:day out of range!");
        }
    }
    public String toString(){
        return date.toString();
    }
    public int year(){
        return date.year();
    }
    public int mouth(){
        return date.month();
    }
    public int day(){
        return date.day();
    }
    public boolean equal(Object other){
        return date.equals(other);   
    }
    public int dayOfWeek(){
        return (5+daysFrom2000_1_1ToThisYear_1_1())%7;
    }
    
    int daysFromYearBeginToToday(){
        int sum=0;
        int changeYears=date.year()-2000;
        if(changeYears>=1){
            ++sum;
        sum+=(changeYears-1)/4;
        }
        return changeYears*365+sum;
    }
    
    int daysFrom2000_1_1ToThisYear_1_1(){
        int sum=0;
        int mouth=date.month();
        if(mouth>1) sum+=31;
        if(mouth>2){
            if(date.year()%4==0) sum+=29;
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
        sum+=date.day()-1;
        return sum+daysFromYearBeginToToday();
    }
    
    public static void main(String[] args) {
        SmartDate smartDate=new SmartDate("4/19/2018");
        System.out.println(smartDate.dayOfWeek());
    }
    
}
