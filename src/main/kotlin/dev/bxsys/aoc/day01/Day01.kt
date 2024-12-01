package dev.bxsys.aoc.day01

import kotlin.math.abs

class Day01(private val input: List<String>) {
    fun part1(): Int {
        val (listA, listB) = parseLists()
        listA.sort()
        listB.sort()

        val result = listA.zip(listB).fold(0) { acc, pair -> acc + abs(pair.first - pair.second) }

        return result
    }

    fun part2(): Int {
        val (arrA, arrB) = parseLists()
        val occurrenceBag = getOccurrenceBag(arrB)

        val result = arrA.fold(0) { acc, value -> acc + (value * (occurrenceBag[value] ?: 0)) }

        return result
    }

    fun parseLists(): Pair<Array<Int>, Array<Int>> {
        val a = Array(input.size) { 0 }
        val b = Array(input.size) { 0 }
        input.forEachIndexed { index, it ->
            val parts = it.split("   ")
            a[index] = parts[0].trim().toInt()
            b[index] = parts[1].trim().toInt()
        }

        return Pair(a, b)
    }

    fun getOccurrenceBag(arr: Array<Int>): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()
        arr.forEach {
            map.merge(it, 1) { acc, inc -> acc + inc }
        }

        return map
    }
}