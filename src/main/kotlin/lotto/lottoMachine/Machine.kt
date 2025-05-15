package lotto.lottoMachine

import kotlin.random.Random

//로또번호 자동생성

fun randomlotto(input: List<Int>? = null): List<Int> {
    val numbers = input ?: generateRandomNumbers()

    if (numbers.size != 6) throw IllegalArgumentException("size")
    if (numbers.toSet().size != 6) throw IllegalArgumentException("duplicate")
    if (numbers.any { it !in 1..45 }) throw IllegalArgumentException("range")

    return numbers.sorted()
}

private fun generateRandomNumbers(): List<Int> {
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 6) {
        numbers.add(Random.nextInt(1, 46))
    }
    return numbers.toList()
}

fun randomBonus(numbers: Set<Int>): Int {
    var bonus: Int
    do {
        bonus = Random.nextInt(1, 46) //1~45까지
    } while (bonus in numbers)
    return bonus
}