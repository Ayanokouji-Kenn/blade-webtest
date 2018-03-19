package com.uu.webtest.modle

data class BaseDTO<T> (
    var code:Int=0,
    var msg:String?=null,
    var data:T?=null)