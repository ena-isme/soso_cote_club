import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val locations = br.readLine().split(" ").map { it.toInt() }

    val queue: ArrayDeque<Int> = ArrayDeque((1..n).toList())
    var count = 0

    for (location in locations) {
        val index: Int = queue.indexOf(location)
        if (index <= queue.size / 2) {
            repeat(index) {
                queue.addLast(queue.removeFirst())
                count++
            }
        } else {
            repeat(queue.size - index) {
                queue.addFirst(queue.removeLast())
                count++
            }
        }
        queue.removeFirst()
    }

    println(count)
}
