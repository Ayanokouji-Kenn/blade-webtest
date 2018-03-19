package com.uu.webtest;

import com.blade.Blade;
import com.blade.kit.JsonKit;

public class Application {
    public static void main(String[] args) {
        Blade.me().listen(9000).start(Application.class,args);
    }
}
