package dev.bxsys.aoc.day03


class Day03(private val input: List<String>) {
    private val part1Regex = Regex("""mul\((\d+),(\d+)\)""")
    private val part2Regex = Regex("""mul\((\d+),(\d+)\)|(do\(\))|(don't\(\))""")

    fun part1(): Int {
        return input.flatMap { part1Regex.findAll(it) }.fold(0) { acc, match ->
            val left = match.groups[1]?.value ?: throw Exception()
            val right = match.groups[2]?.value ?: throw Exception()
            acc + left.toInt() * right.toInt()
        }
    }

    fun part2(): Int {
        var enabled = true
        return input.flatMap { part2Regex.findAll(it) }.fold(0) { acc, match ->
            val left = match.groups[1]?.value
            val right = match.groups[2]?.value
            if (left != null && right != null && enabled) {
                return@fold acc + left.toInt() * right.toInt()
            }

            val shouldEnable = match.groups[3]?.value
            val shouldDisable = match.groups[4]?.value
            if (shouldEnable != null) {
                enabled = true
            } else if (shouldDisable != null) {
                enabled = false
            }

            return@fold acc
        }
    }
}
