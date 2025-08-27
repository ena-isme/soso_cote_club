import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val test: Int = br.readLine().toInt()

    repeat(test) {
        val volunteers: Int = br.readLine().toInt()
        val testResult: MutableList<List<Int>> = mutableListOf()

        repeat(volunteers) {
            val input: List<Int> = br.readLine().split(" ").map { it.toInt() }
            testResult.add(input)
        }
        
        testResult.sortBy { it[0] }

        var count: Int = 1
        var bestInterview: Int = testResult[0][1]

        for (i in 1..<testResult.size) {
            val currentInterview: Int = testResult[i][1]

            if (currentInterview < bestInterview) {
                count++
                bestInterview = currentInterview
            }
        }

        println(count)
    }
}
