package dev.bxsys.aoc.common

class Resources {
    companion object {
        fun readLines(file: String): List<String> {
            val absFilePath = if (file.startsWith("/")) file else "/$file"
            val fileContent =
                Resources::class.java.getResource(absFilePath)?.readText() ?: throw Exception("File not found")

            return fileContent.split("\n")
        }
    }
}