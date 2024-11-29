package dev.bxsys.aoc.day00

import dev.bxsys.aoc.common.Resources
import kotlin.test.Test
import kotlin.test.assertEquals

class Day00Test {

    private val part1Input = Resources.readLines("day00/input1.txt")
    private val part2Input = Resources.readLines("day00/input2.txt")

    @Test
    fun part1_shouldPass1() {
        val result = Day00(part1Input).part1()
        assertEquals(6, result)
    }

    @Test
    fun part1_shouldPass2() {
        val result = Day00(part2Input).part1()
        assertEquals(23, result)
    }
}