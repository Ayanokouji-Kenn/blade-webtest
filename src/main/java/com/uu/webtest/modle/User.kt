package com.uu.webtest.modle

import com.blade.jdbc.annotation.Table
import com.blade.jdbc.core.ActiveRecord

@Table("t_user")
data class User(var name:String="",var age:Int = 0):ActiveRecord()