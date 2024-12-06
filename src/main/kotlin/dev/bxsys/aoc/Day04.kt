package dev.bxsys.aoc

import dev.bxsys.aoc.common.Matrix
import dev.bxsys.aoc.common.Vector

class Day04(private val input: List<String>) {
    val part1text = arrayOf('X', 'M', 'A', 'S')
    val part2text = arrayOf('M', 'A', 'S')

    fun part1(): Int {
        val matrix = Matrix.fromInput(input)
        var matches = 0
        matrix.forEachCoord { coord ->
            if (matrix[coord] != 'X') {
                return@forEachCoord
            }

            matches += Vector.cardinalDirections.count {
                matrix.applyMatcher(part1text, coord) { dist -> it * dist }
            }
        }

        return matches
    }

    fun part2(): Int {
        val matrix = Matrix.fromInput(input)
        var matches = 0
        matrix.forEachCoord { coord ->
            if (matrix[coord] != 'A') {
                return@forEachCoord
            }

            val xMatch = Vector.diagonals.count {
                matrix.applyMatcher(part2text, coord - it) { dist -> it * dist }
            } == 2

            if (xMatch) {
                matches += 1
            }
        }

        return matches
    }
}
