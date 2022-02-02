package com.codeinglogs.util

fun getId(vararg id  : String) : String{
    var s = "id"
    id.forEach {
        s += "_$it"
    }
    return s
}