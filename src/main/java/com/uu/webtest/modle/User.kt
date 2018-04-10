package com.uu.webtest.modle

import io.github.biezhi.anima.Model
import io.github.biezhi.anima.annotation.Table

@Table(name = "user" ,pk = "id")
data class User(var id:Int? = null, var name:String="",var age:Int = 0):Model()