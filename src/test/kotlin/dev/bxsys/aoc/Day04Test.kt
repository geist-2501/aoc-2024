package dev.bxsys.aoc

import dev.bxsys.aoc.common.Resources
import dev.bxsys.aoc.day04.Day04
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
    @Test
    fun part1_testInput() {
        val input = Resources.readLines("day04/test-input.txt")
        val result = Day04(input).part1()

        assertEquals(18, result)
    }

    @Test
    fun part1_realInput() {
        val input = Resources.readLines("day04/real-input.txt")
        val result = Day04(input).part1()

        println(result)
    }

    @Test
    fun part2_testInput() {
        val input = Resources.readLines("day04/test-input.txt")
        val result = Day04(input).part2()

        assertEquals(9, result)
    }

    @Test
    fun part2_realInput() {
        val input = Resources.readLines("day04/real-input.txt")
        val result = Day04(input).part2()

        println(result)
    }
}
