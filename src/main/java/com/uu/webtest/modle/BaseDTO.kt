package com.uu.webtest.modle

data class BaseDTO<T> (
    var code:Int=0,
    var msg:String?=null,
    var data:T?=null)

object  ResponseKit {
    fun ok(): BaseDTO<*> {
        return BaseDTO<Void>()
    }

    fun fail(msg: String):BaseDTO<*> {
        return BaseDTO<Void>(1,msg)
    }

    fun ok(info: Any):BaseDTO<Any> {
        return BaseDTO(data = info)
    }
}