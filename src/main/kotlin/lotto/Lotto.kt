package lotto

import kotlin.random.Random

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }
}

//구매금액 입력받기
fun inputMoney(): Int {
    while (true) {
        println("구매할 금액을 입력하세요. (ex - 5000)")
        val input = readLine() ?: continue
        val moneyList = input.trim()
            .split(Regex("\\s+"))
            .mapNotNull { it.toIntOrNull() }

        if (moneyList.size == 1) {
            val money = moneyList[0]
            if (money % 1000 == 0) {
                return money
            }
        } else {
            println("정확한 금액을 입력해주세요.")
        }
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