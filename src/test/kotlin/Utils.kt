import java.io.File

fun readFileAsStrings(filePath: String): List<String> = File(filePath).readLines()