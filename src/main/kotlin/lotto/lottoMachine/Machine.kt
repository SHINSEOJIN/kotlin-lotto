package lotto.lottoMachine

import kotlin.random.Random

//로또번호 자동생성(보너스번호 포함)
fun lottoMachine(): Pair <Set<Int>, Int> {
    val winnumbers = mutableListOf<Int>()

    while (winnumbers.size < 6) {
        var number = Random.nextInt(1, 46) //1~45까지
        if (!winnumbers.contains(number)) {
            winnumbers.add(number)
        }
    }
    var winbonus: Int
    do {
        winbonus = Random.nextInt(1, 46) //1~45까지
    } while (winnumbers.contains(winbonus))
    return Pair(winnumbers.toSet(), winbonus)
}