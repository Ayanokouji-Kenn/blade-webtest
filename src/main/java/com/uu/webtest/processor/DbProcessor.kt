package com.uu.webtest.processor

import com.blade.Blade
import com.blade.event.BeanProcessor
import com.blade.ioc.annotation.Bean
import com.blade.ioc.annotation.Order
import com.blade.jdbc.Base
import java.sql.Connection
import java.sql.DriverManager

@Order(1)
@Bean
class DbProcessor:BeanProcessor {
    override fun processor(blade: Blade?) {
        Base.open("jdbc:mysql://127.0.0.1:3306/app", "root", "123456")
        println("链接数据库")
    }
}