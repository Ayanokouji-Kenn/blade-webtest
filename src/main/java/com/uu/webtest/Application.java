package com.uu.webtest;

import com.blade.Blade;
public class Application {
    public static void main(String[] args) {
        Blade.me().listen(9000).start(Application.class,args);
    }
}
