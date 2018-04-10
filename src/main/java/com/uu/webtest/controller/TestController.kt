package com.uu.webtest.controller

import com.blade.Blade
import com.blade.mvc.annotation.*
import com.blade.mvc.ui.RestResponse
import com.uu.webtest.StrConst
import com.uu.webtest.modle.BaseDTO
import com.uu.webtest.modle.ResponseKit
import com.uu.webtest.modle.User
import io.github.biezhi.anima.Anima
import io.github.biezhi.anima.Anima.select

@Path
class TestController {

    @GetRoute("user/:id")
    @JSON
    fun getUser(@PathParam id: Long?): BaseDTO<*> {
        return if (id != null) {
            val user = Anima.select().from(User::class.java).byId(id)
            if (user != null) ResponseKit.ok(user)
            else ResponseKit.fail(StrConst.NO_DATA)
        } else ResponseKit.fail("id不可为空")
    }

    @GetRoute("user")
    @JSON
    fun getUserList(@Param page: Int?, @Param size: Int?, @Param minAge: Int?, @Param maxAge: Int?): BaseDTO<*> {

        if (minAge != null && maxAge != null) {
            val result = Anima.select().from(User::class.java).between("age", minAge, maxAge).page(page ?: 1, size ?: 10)
            return ResponseKit.ok(result)
        } else {
            val result = select().from(User::class.java).page(page ?: 1, size ?: 10)
            return ResponseKit.ok(result)
        }

    }

    @PostRoute("user")
    @JSON
    fun regist(@Param name: String?, @Param age: Int?): BaseDTO<*> {
        if (name.isNullOrBlank() || age == null) {
            return ResponseKit.fail(StrConst.DATA_NULL)
        } else {
            User(null, name!!, age).save()
        }
        return ResponseKit.ok()
    }

    @PutRoute("user")
    @JSON
    fun update(@BodyParam user: User): BaseDTO<*> {
        if (user.id == null) return ResponseKit.fail("id不可为空")
        else {
            user.update()
            return ResponseKit.ok()
        }
    }


}
