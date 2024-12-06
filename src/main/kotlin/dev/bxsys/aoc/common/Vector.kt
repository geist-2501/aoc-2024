package dev.bxsys.aoc.common

data class Vector(val x: Int, val y: Int) {
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }

    operator fun minus(other: Vector): Vector {
        return Vector(x - other.x, y - other.y)
    }

    operator fun times(scalar: Int): Vector {
        return Vector(x * scalar, y * scalar)
    }

    companion object {
        val north = Vector(0, 1)
        val northEast = Vector(1, 1)
        val east = Vector(1, 0)
        val southEast = Vector(1, -1)
        val south = Vector(0, -1)
        val southWest = Vector(-1, -1)
        val west = Vector(-1, 0)
        val northWest = Vector(-1, 1)
        val cardinalDirections = listOf(
            north,
            northEast,
            east,
            southEast,
            south,
            southWest,
            west,
            northWest
        )
        val diagonals = listOf(
            northEast, southEast, northWest, southWest
        )
    }
}
