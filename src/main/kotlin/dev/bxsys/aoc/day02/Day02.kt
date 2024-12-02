package dev.bxsys.aoc.day02

import kotlin.math.abs

class Day02(private val input: List<String>) {
    fun part1(): Int {
        val reports = parseReports()
        return reports.fold(0) { acc, report -> acc + (if (isReportSafe(report)) 1 else 0) }
    }

    fun parseReports(): List<Array<Int>> {
        val reports = mutableListOf<Array<Int>>()
        input.forEach { row ->
            val report = row.split(" ").map { it.trim().toInt() }.toTypedArray()
            reports.add(report)
        }

        return reports
    }

    fun isReportSafe(report: Array<Int>): Boolean {
        var lastDiff = report[1] - report[0]
        if (lastDiff == 0 ) {
            return false
        }

        for (index in 1..<report.size) {
            val diff = report[index] - report[index - 1]
            if (abs(diff) !in 1..3) {
                return false
            }

            if ((lastDiff > 0) != (diff > 0)) {
                return false
            }

            lastDiff = diff
        }

        return true
    }
}
