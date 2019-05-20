package com.king.clone;

public class ExecuteClone {
    
    public static void main(String[] args) {
        Inner orginIn = new Inner("king", 123);
        Outer originOut = new Outer(orginIn);
        
        Outer currentOut = originOut.myclone();
        Inner currentIn = new Inner("pancy", 456);
        currentOut.setInner(currentIn);
        
        System.out.println(originOut);
        System.out.println(currentOut);
    }
    
}
