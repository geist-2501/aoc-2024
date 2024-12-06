package dev.bxsys.aoc

import java.lang.Exception

class Day05(private val bag: Map<Int, List<Int>>, private val input: List<List<Int>>) {
    fun part1(): Int {
        val correctlyOrdered = input.filter {
            isCorrectlyOrdered(it)
        }

        return correctlyOrdered.sumOf { it[it.size / 2] }
    }

    fun part2(): Int {
        val incorrectlyOrdered = input.filter { !isCorrectlyOrdered(it) }
        val reordered = incorrectlyOrdered.map { reorder(it) }
        return reordered.sumOf { it[it.size / 2] }
    }

    fun isCorrectlyOrdered(row: List<Int>): Boolean {
        val narrowBag = getNarrowBag(row)
        for (index in row.indices) {
            val value = row[index]
            val requiredValues = narrowBag[value] ?: listOf()
            if (requiredValues.size != row.size - index - 1) {
                return false
            }

            for (inner in index + 1..<row.size) {
                val innerValue = row[inner]
                if (!requiredValues.contains(innerValue)) {
                    return false
                }
            }
        }

        return true
    }

    fun reorder(row: List<Int>): List<Int> {
        val narrowBag = getNarrowBag(row)
        val destinationIndexes = narrowBag.mapValues { row.size - 1 - it.value.size }
        val newRow = Array(row.size) { 0 }
        for (index in row.indices) {
            val value = row[index]
            val targetIndex = destinationIndexes.getValue(value)
            newRow[targetIndex] = value
        }

        newRow.forEachIndexed { index, it ->
            if (destinationIndexes[it] != index ) {
                throw Exception()
            }
        }

        return newRow.toList()
    }

    fun getNarrowBag(row: List<Int>): Map<Int, List<Int>> {
        val sum = row.indices.sumOf { it }
        val valuesInRow = row.toSet()
        val narrowBag = bag
            .filter { valuesInRow.contains(it.key) }
            .mapValues { it.value.filter { value -> valuesInRow.contains(value) } }
        if (sum != narrowBag.values.sumOf { it.size }) {
            throw Exception()
        }
        return narrowBag
    }

    companion object {
        fun parseBag(input: List<String>): Map<Int, List<Int>> {
            val linesForBag = input.takeWhile { it != "" }
            return linesForBag.map {
                val parts = it.split("|")
                Pair(parts[0].toInt(), parts[1].toInt())
            }
                .groupBy({ it.first }) { it.second }
                .toMap()
        }

        fun parseInput(input: List<String>): List<List<Int>> {
            val linesForInput = input.dropWhile { it != "" }.drop(1)
            return linesForInput.map { line -> line.split(",").map { it.toInt() } }
        }
    }
}
