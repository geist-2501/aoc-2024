package dev.bxsys.aoc

import dev.bxsys.aoc.common.Resources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class Day05Test {

    @Test
    fun isCorrectlyOrdered() {
        val input = Resources.readLines("day05/test-input.txt")
        val bag = Day05.parseBag(input)
        val data = Day05.parseInput(input)

        val result = Day05(bag, data).isCorrectlyOrdered(data[0])

        assertTrue(result)
    }

    @Test
    fun part1_testInput() {
        val input = Resources.readLines("day05/test-input.txt")
        val bag = Day05.parseBag(input)
        val data = Day05.parseInput(input)

        val result = Day05(bag, data).part1()

        assertEquals(143, result)
    }

    @Test
    fun part1_realInput() {
        val input = Resources.readLines("day05/real-input.txt")
        val bag = Day05.parseBag(input)
        val data = Day05.parseInput(input)

        val result = Day05(bag, data).part1()

        println(result)
    }

    @Test
    fun part2_testInput() {
        val input = Resources.readLines("day05/test-input.txt")
        val bag = Day05.parseBag(input)
        val data = Day05.parseInput(input)

        val result = Day05(bag, data).part2()

        assertEquals(123, result)
    }

    @Test
    fun part2_realInput() {
        val input = Resources.readLines("day05/real-input.txt")
        val bag = Day05.parseBag(input)
        val data = Day05.parseInput(input)

        val result = Day05(bag, data).part2()

        println(result)
    }
}
