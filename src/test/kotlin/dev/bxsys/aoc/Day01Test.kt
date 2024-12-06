package dev.bxsys.aoc

import dev.bxsys.aoc.common.Resources
import kotlin.test.Test
import kotlin.test.assertEquals


class Day01Test {
    @Test
    fun part1_smallInput() {
        val input = Resources.readLines("day01/small-input.txt")
        val result = Day01(input).part1()
        assertEquals(11, result)
    }

    @Test
    fun part1_input() {
        val input = Resources.readLines("day01/input.txt")
        val result = Day01(input).part1()

        println(result)
    }

    @Test
    fun part2_smallInput() {
        val input = Resources.readLines("day01/small-input.txt")
        val result = Day01(input).part2()
        assertEquals(31, result)
    }

    @Test
    fun part2_input() {
        val input = Resources.readLines("day01/input.txt")
        val result = Day01(input).part2()

        println(result)
    }
}
