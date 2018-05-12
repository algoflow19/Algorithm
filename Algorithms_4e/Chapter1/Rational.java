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

// 

public class Rational {
    int numerator;
    int denominator;
    public Rational(int numerator,int denominator){
        if(denominator==0) throw new IllegalArgumentException("Denominator can't be zero");
        assert numerator>=denominator:"Denominator should't bigger or equal to numerator";
        this.numerator=numerator;
        this.denominator=denominator;
        transformWordToMostSimple();
    }
    void transformWordToMostSimple(){
        boolean negetiveFlag=false;
        if(denominator*numerator<0) negetiveFlag=true;
        numerator=Math.abs(numerator);
        denominator=Math.abs(denominator);
        int x=denominator;
        int y=numerator;
        int r=x%y;
        while(r!=0){
            x=y;
            y=r;
            r=x%y;
        }
        numerator/=y;
        denominator/=y;
        if(negetiveFlag) numerator=-numerator;
        
    }
    
    public Rational plus(Rational other){
        checkIsRightType(other);
        if(isOverflow(denominator, other.denominator,'*')||isOverflow(numerator*other.denominator,other.numerator*denominator ,'+'))
            throw new RuntimeException("Long type has overflew");
        return new Rational(numerator*other.denominator+other.numerator*denominator,denominator*other.denominator);
    }
    
    public Rational minus(Rational other){
        checkIsRightType(other);
        if(isOverflow(denominator, other.denominator,'*')||isOverflow(numerator*other.denominator,other.numerator*denominator ,'-'))
            throw new RuntimeException("Long type has overflew");
        return new Rational(numerator*other.denominator-other.numerator*denominator,denominator*other.denominator);
    }
    
    public Rational times(Rational other){
        checkIsRightType(other);
        if(isOverflow(numerator, other.numerator, '*')||isOverflow(denominator, other.denominator, '*'))
            throw new RuntimeException("Long type has overflew");
        return new Rational(numerator*other.numerator, denominator*other.denominator);
    }
    
    public Rational divides(Rational other){
        checkIsRightType(other);
        if(isOverflow(numerator, other.denominator, '*')||isOverflow(denominator, other.numerator, '*'))
            throw new RuntimeException("Long type has overflew");
        return new Rational(numerator*other.denominator, denominator*other.numerator);
    }
    
    public boolean equal(Rational other){
        if(this==other) return true;
        checkIsRightType(other);
        if(denominator!=other.denominator) return false;
        if(numerator!=other.numerator) return false;
        return true;
    }
    
    public String toString(){
        return numerator+"/"+denominator;
    }
    void checkIsRightType(Rational other){
        if(other==null) throw new IllegalArgumentException(" The input object is null");
        if(other.getClass()!=this.getClass()) throw new IllegalArgumentException("The input object isn't Rational");
    }
    static boolean isOverflow(long a,long b,char operator){
        
        double MaxMul;
        switch (operator) {
            case '+':
                if(a*b<=0) return false;
                if(a>0&&a+b<0) break;
                if(a<0&&a+b>0) break;
                return false;
            case '-':
                if(a*b>=0) return false;
                if(a>0&&a-b<0) break;
                if(a<0&&a-b>0) break;
                return false;
            case '*':
               MaxMul=Long.MAX_VALUE/a;
               MaxMul=Math.abs(MaxMul);
               b=Math.abs(b);
               if(b>MaxMul) break;
               return false;
            case '/':
                return false;
            default:
                throw new RuntimeException("Invaid opertaor");
        }
        return true;
    }
    
    public static void main(String[] args) {
        Rational r1=new Rational(3, 5);
        System.out.println(r1);
        Rational r2=new Rational(5, 3);
        System.out.println(r1.plus(r2));
        System.out.println(r1.minus(r2));
        System.out.println(r1.times(r2));
        System.out.println(r1.divides(r2));
    }
    
    
}
