package com.samapps.kotlincourse.data

import com.samapps.kotlincourse.models.UserModel
import java.util.*

class Repository private constructor() {
    private var users: MutableList<UserModel?>? = null

    init {
        users = mutableListOf()
    }


    fun getUsers(): MutableList<UserModel?>? {
        return users
    }

    fun getFormattedUserNames(): MutableList<String?>? {
        val userNames: MutableList<String?> = ArrayList(users!!.size!!)
        for (user in users!!) {
            val name = if (user!!.lastName != null) {
                if (user.firstName != null) {
                    user.firstName + " " + user.lastName
                } else {
                    user.lastName
                }
            } else if (user.firstName != null) {
                user.firstName
            } else {
                "Unknown"
            }
            userNames.add(name)
        }
        return userNames
    }

    companion object {
        private var INSTANCE: Repository? = null
        fun getInstance(): Repository? {
            if (INSTANCE == null) {
                INSTANCE = Repository()
            }
            return INSTANCE
        }
    }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = UserModel("Anton", "")
        val user2 = UserModel("Anna", null)
        val user3 = UserModel("Mark", "Twain")
        users = mutableListOf()
        users?.add(user1)
        users?.add(user2)
        users?.add(user3)
    }
}