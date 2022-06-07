package TViMS

import java.lang.Math.pow

fun c(k: Int, n: Int): Int {
    var c = 1
    for (i in k + 1..n)
        c *= i
    for (i in 2..(n - k))
        c /= i
    return c
}

fun getG(n: Int, p: Double): RandomVariable {
    val list = emptyList<Value>().toMutableList()
    val q = 1 - p
    for (k in 0 until n)
        list.add(Value(k, p * pow(q, k.toDouble())))
    list.add(Value(n, pow(q, n.toDouble())))
    return RandomVariable(list)
}


fun getB(n: Int, p: Double): RandomVariable {
    val list = emptyList<Value>().toMutableList()
    val q = 1 - p
    for (k in 0..n)
        list.add(Value(k, c(k, n) * pow(p, k.toDouble()) * pow(q, (n - k).toDouble())))
    return RandomVariable(list)
}

data class Value(val x: Int, val p: Double) {
    override fun toString(): String {
        return "(x=$x, p=$p)"
    }
}

class RandomVariable(val ksi: List<Value>) {
    var Ex: Double
    var Ex_2: Double
    var Dx: Double

    init {
        var sum = 0.0
        Ex = 0.0
        Ex_2 = 0.0

        ksi.forEach {
            sum += it.p
            Ex += it.p * it.x
            Ex_2 += it.p * it.x * it.x
        }
        val exp = 0.00001
        if (sum - 1.0 > exp)
            throw IllegalArgumentException("Sum of p should be 1")
        //println(sum)

        Dx = Ex_2 - Ex * Ex
    }

    fun p(range: IntRange): Double {
        var p = 0.0

        ksi.forEach {
            if (it.x in range)
                p += it.p
        }
        return p
    }

    override fun toString(): String {
        return "RandomVariable(ksi=$ksi\n" +
                "Ex=$Ex\n" +
                "Ex_2=$Ex_2\n" +
                "Dx=$Dx)"
    }
}

fun main() {
    val list = mutableListOf(
        Value(0, 15.0 / 10000),
        Value(1, 55 * 5.0 / 10000),
        Value(2, 337 * 5.0 / 10000),
        Value(3, 5 * 3 * 283.0 / 10000),
        Value(4, 3 * 4 * 63 * 5.0 / 10000)
    )

    val variable = RandomVariable(list)
    //val variable = getG(5, 0.3)

    print(variable)
    print(variable.p(3..4))
}