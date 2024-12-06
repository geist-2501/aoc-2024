package dev.bxsys.aoc.common

class Matrix<T>(val data: Array<Array<T>>) {

    public val widthRange: IntRange
        get() = data[0].indices

    public val heightRange: IntRange
        get() = data.indices


    operator fun get(x: Int, y: Int): T {
        return data[x][y]
    }

    operator fun get(point: Vector): T {
        return data[point.y][point.x]
    }

    operator fun set(x: Int, y: Int, value: T) {
        data[x][y] = value
    }

    override fun toString(): String {
        var s = ""
        for (i in data.indices) {
            for (j in data[0].indices) {
                s += "${data[j][i]} "
            }
            s += "\n"
        }

        return s
    }

    fun forEachCoord(func: (Vector) -> Unit) {
        for (x in widthRange) {
            for (y in heightRange) {
                func(Vector(x, y))
            }
        }
    }

    fun applyMatcher(data: Array<T>, point: Vector, direction: (Int) -> Vector): Boolean {
        for (index in data.indices) {
            val thisPoint = point + direction(index)
            if (!inBounds(thisPoint)) {
                return false
            }

            val thisValue = this[thisPoint] ?: Exception()
            if (thisValue != data[index]) {
                return false
            }
        }

        return true
    }

    fun inBounds(point: Vector): Boolean {
        return !(point.x < 0 || point.x >= data[0].size || point.y < 0 || point.y >= data.size)
    }

    companion object {
        fun fromInput(data: List<String>): Matrix<Char> {
            return Matrix(data.map {
                // This is dumb
                it.toList().toTypedArray()
            }.toTypedArray())
        }
    }
}
