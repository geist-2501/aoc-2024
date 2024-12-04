package dev.bxsys.aoc.common

class Resources {
    companion object {
        fun readLines(file: String): List<String> {
            return read(file).split("\n")
        }

        fun read(file: String): String {
            val absFilePath = if (file.startsWith("/")) file else "/$file"
            val fileContent =
                Resources::class.java.getResource(absFilePath)?.readText() ?: throw Exception("File not found")

            return fileContent.trim()
        }
    }
}
