package com.uu.webtest.controller

import com.blade.mvc.annotation.*
import com.uu.webtest.modle.BaseDTO
import com.uu.webtest.modle.User

@Path
class TestController {
    @GetRoute("user/:id")
    @JSON
    fun getUser(@PathParam id: Long?): BaseDTO<*> {
        return BaseDTO(data = User("lily",13))
    }

    @PostRoute("regist")
    @JSON
    fun regist(@Param name: String, @Param age: Int?):BaseDTO<*> {
        println("name:" + name)
        println("age:" + age!!)
        return BaseDTO<Void>()
    }

    @PutRoute("update")
    @JSON
    fun update(@BodyParam user: User) :BaseDTO<Void>{
        println(user)
        return BaseDTO()
    }

}
