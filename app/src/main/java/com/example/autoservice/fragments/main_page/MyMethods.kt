package com.example.autoservice.fragments.main_page

import com.example.autoservice.R
import kotlin.math.abs

object MyMethods {

    fun getRandomGradient(): Int {
        val list = ArrayList<Int>()
        list.add(R.drawable.ic_gradient1)
        list.add(R.drawable.ic_gradient2)
        list.add(R.drawable.ic_gradient3)
        list.add(R.drawable.ic_gradient4)
        val index = (Math.random() * 3).toInt()
        return list[index]
    }

    fun distance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        val k = (abs(x1 - x2) + abs(y1 - y2)) * 110.574
        var str = k.toString()
        var index = -1
        for (c in str) {
            index++
            if (c == '.') break
        }
        str = if (str.elementAt(index + 1) == '0') str.substring(0, index)
        else str.substring(0, index + 1)
        return str.toDouble()
    }
}