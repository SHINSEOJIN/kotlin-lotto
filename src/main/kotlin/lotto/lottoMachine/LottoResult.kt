package lotto.lottoMachine

data class LottoResult(val numbers : List<Int>, val bonus : Int)

val userTickets = mutableListOf<LottoResult>()

fun generateLotto(): LottoResult {

    val numbers = randomlotto()
    val bonus = randomBonus(numbers.toSet())

    val ticket = LottoResult(numbers, bonus)
    userTickets.add(ticket)

    return ticket
}