package dev.bxsys.aoc.day02

import kotlin.math.abs

class Day02(private val input: List<String>) {
    fun part1(): Int {
        val reports = parseReports()
        return reports.fold(0) { acc, report -> acc + (if (isReportSafe(report)) 1 else 0) }
    }

    fun part2(): Int {
        val reports = parseReports()
        return reports.fold(0) { acc, report -> acc + (if (isReportSafe(report) || bruteForce(report)) 1 else 0) }
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
            if (!isDiffSafe(diff, lastDiff)) {
                return false
            }

            lastDiff = diff
        }

        return true
    }

    fun bruteForce(report: Array<Int>): Boolean {
        return report.indices.any {
            isReportSafe(report.filterIndexed { index, _ -> index != it }.toTypedArray())
        }
    }


    fun isDiffSafe(thisDiff: Int, lastDiff: Int): Boolean {
        if (abs(thisDiff) !in 1..3) {
            return false
        }

        if ((thisDiff > 0) != (lastDiff > 0)) {
            return false
        }

        return true
    }
}
