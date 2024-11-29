package dev.bxsys.aoc.day00

class Day00(private val input: List<String>) {
    fun part1(): Int {
        return input
            .map { it.trim().length }
            .reduce {acc: Int, i: Int -> acc + i }
    }
}
