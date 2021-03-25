package com.samapps.kotlincourse.models

data class UserModel(var firstName: String? = "Anna", var lastName: String? = "Volk"){
    override fun toString(): String {
        return super.toString()

        val list = mutableListOf<String>()
        list.add(" ")
        "UserModel{firstname=$firstName,lastName=$lastName"
    }

}