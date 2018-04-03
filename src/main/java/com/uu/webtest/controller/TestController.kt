package com.uu.webtest.controller

import com.blade.ioc.annotation.Inject
import com.blade.jdbc.Base
import com.blade.mvc.annotation.*
import com.uu.webtest.StrConst
import com.uu.webtest.modle.BaseDTO
import com.uu.webtest.modle.ResponseKit
import com.uu.webtest.modle.User
import com.uu.webtest.processor.DbProcessor

@Path
class TestController {

    @GetRoute("user/:id")
    @JSON
    fun getUser(@PathParam id: Long?): BaseDTO<*> {
        if(id!=null){
            val user = User().find<User>(id)
            if(user!=null)
            return ResponseKit.ok(user)
        }
        return ResponseKit.fail(StrConst.NO_DATA)
    }

    @GetRoute("user")
    @JSON
    fun getUserList() {
        val allUser = User().findAll<User>()
        println(allUser)
    }

    @PostRoute("regist")
    @JSON
    fun regist(@Param name: String?, @Param age: Int?):BaseDTO<*> {
        if (name.isNullOrBlank() || age == null) {
            return ResponseKit.fail(StrConst.DATA_NULL)
        }
        Base.atomic { User(name!!,age).save<User>() }
        return ResponseKit.ok()
    }

    @PutRoute("update")
    @JSON
    fun update(@BodyParam user: User) :BaseDTO<Void>{
        println(user)
        return BaseDTO()
    }

    @PostRoute("testpost")
    @JSON
    fun testPost(@Param arg1:Int?,@Param arg2:String?) :BaseDTO<*>{
        println("arg1=$arg1 arg2=$arg2")
        return  ResponseKit.ok()
    }

}
