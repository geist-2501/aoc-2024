package dev.bxsys.aoc

import dev.bxsys.aoc.common.Resources
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    @Test
    fun part1_testInput() {
        val input = Resources.readLines("day02/test.txt")
        val result = Day02(input).part1()

        assertEquals(2, result)
    }

    @Test
    fun part1_realInput() {
        val input = Resources.readLines("day02/input.txt")
        val result = Day02(input).part1()

        println(result)
    }

    @Test
    fun part2_testInput() {
        val input = Resources.readLines("day02/test.txt")
        val result = Day02(input).part2()

        assertEquals(4, result)
    }

    @Test
    fun part2_realInput() {
        val input = Resources.readLines("day02/input.txt")
        val result = Day02(input).part2()

        println(result)
    }
}
