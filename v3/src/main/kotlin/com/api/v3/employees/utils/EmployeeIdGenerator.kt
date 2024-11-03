package com.api.v3.employees.utils

import kotlin.random.Random

class EmployeeIdGenerator {

    companion object {
        fun generate(): String {
            val random = Random(System.currentTimeMillis())
            val id = StringBuilder()
            for (i in 1..7) {
                id.append(random.nextInt(10))
            }
            return id.toString()
        }
    }

}