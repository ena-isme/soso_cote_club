import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[b].add(a)
    }

    var maxCount = 0
    val result = mutableListOf<Int>()

    for (i in 1..n) {
        val visited = BooleanArray(n + 1)
        val count = dfs(i, graph, visited)

        if (count > maxCount) {
            maxCount = count
            result.clear()
            result.add(i)
        } else if (count == maxCount) {
            result.add(i)
        }
    }

    println(result.joinToString(" "))
}

fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): Int {
    visited[node] = true
    var count = 1

    for (next in graph[node]) {
        if (!visited[next]) {
            count += dfs(next, graph, visited)
        }
    }

    return count
}
