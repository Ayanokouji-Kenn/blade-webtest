package com.uu.webtest.processor

import com.blade.Blade
import com.blade.event.BeanProcessor
import com.blade.ioc.annotation.Bean
import com.blade.ioc.annotation.Order
import io.github.biezhi.anima.Anima

@Order(1)
@Bean
class DbProcessor:BeanProcessor {
    override fun processor(blade: Blade?) {
        Anima.open("jdbc:mysql://127.0.0.1:3306/webtest", "root", "123456")
    }
}