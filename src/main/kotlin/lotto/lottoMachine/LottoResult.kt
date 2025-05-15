package lotto.lottoMachine

import lotto.input.inputBonus
import lotto.input.inputLotto

data class LottoResult(val numbers : List<Int>, val bonus : Int)

val userTickets = mutableListOf<LottoResult>()

fun generateLotto(): LottoResult {

    val userNumbers = inputLotto()
    val bonusNumber = inputBonus(userNumbers)

    val ticket = LottoResult(userNumbers, bonusNumber)
    userTickets.add(ticket)

    return ticket
}