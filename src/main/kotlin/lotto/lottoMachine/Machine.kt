package lotto.lottoMachine

import kotlin.random.Random

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }
}


//로또번호 자동생성(보너스번호 포함)
fun lottoMachine(): Pair <Set<Int>, Int> {
    val numbers = mutableListOf<Int>()

    while (numbers.size < 6) {
        var number = Random.nextInt(1, 46) //1~45까지
        if (!numbers.contains(number)) {
            numbers.add(number)
        }
    }
    var bonus: Int
    do {
        bonus = Random.nextInt(1, 46) //1~45까지
    } while (numbers.contains(bonus))
    return Pair(numbers.toSet(), bonus)
}