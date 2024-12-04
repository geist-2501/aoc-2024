package dev.bxsys.aoc.day03

import dev.bxsys.aoc.common.Resources
import kotlin.test.Test
import kotlin.test.assertEquals


class Day03Test {
    @Test
    fun part1_testInput() {
        val input = Resources.readLines("day03/test.txt")
        val result = Day03(input).part1()

        assertEquals(161, result)
    }

    @Test
    fun part1_realInput() {
        val input = Resources.readLines("day03/input.txt")
        val result = Day03(input).part1()

        println(result)
    }

    @Test
    fun part2_testInput() {
        val input = Resources.readLines("day03/test2.txt")
        val result = Day03(input).part2()

        assertEquals(48, result)
    }

    @Test
    fun part2_realInput() {
        val input = Resources.readLines("day03/input.txt")
        val result = Day03(input).part2()

        println(result)
    }
}
