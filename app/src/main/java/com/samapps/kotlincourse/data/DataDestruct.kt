package com.samapps.kotlincourse.data

class DataDestruct {

    fun combinePairs(pair1: Pair<String, Int>, pair2: Pair<Int, String>): Triple<String, Int, String> =
            Triple(pair1.first, pair1.second + pair2.first, pair2.second)

    private fun timeStrToSeconds(str: String ): Triple<Int, Int, Int> {
        val parts = str.split(":").map { it.toInt() }
        return Triple(parts[0], parts[1], parts[2])
    }

    fun useTimeStrToSeconds() {
        val triple = timeStrToSeconds("11:34:45")
        val hh = triple.first
        val mm = triple.second
        val ss = triple.third
        // или: деструктурирование
        val (hours, minutes, seconds) = timeStrToSeconds("11:34:45")
    }
}