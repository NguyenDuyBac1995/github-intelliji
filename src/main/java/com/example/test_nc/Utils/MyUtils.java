package com.example.test_nc.Utils;

public class MyUtils {
    public int add(int a, int b) {
        return a + b;
    }

    public int tinhTongSoChan(int n){
        int tongSoChan = 0;
        for(int i = 0; i <= n; i+=2){
            tongSoChan = tongSoChan + i;
        }
        return tongSoChan;
    }
}
