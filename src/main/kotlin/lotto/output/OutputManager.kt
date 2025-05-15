package lotto.output

import lotto.lottoMachine.*
import lotto.input.inputMoney


// 로또 데이터 출력
fun outputLotto() {
    println("${userTickets.size}개를 구매했습니다.")
    println("[구입한 로또 목록]")
    userTickets.forEachIndexed { index, ticket ->
        println("${index + 1}번: ${ticket.numbers} + 보너스: ${ticket.bonus}")
    }
}

// 당첨 여부 확인
fun checkSuccess(winNumbers: Set<Int>, winBonus: Int): Map<Rank, Int> {
    val rankCountMap = mutableMapOf<Rank, Int>()

    for (ticket in userTickets) {
        val matchCount = numberIsMatched(ticket.numbers, winNumbers)
        val hasBonus = bonusIsMatched(ticket.bonus, winBonus)
        val rank = getRank(matchCount, hasBonus)

        if (rank != null) {
            rankCountMap[rank] = rankCountMap.getOrDefault(rank, 0) + 1
        }
    }
    return rankCountMap
}

//당첨 결과 출력
fun printSuccess(rankCountMap: Map<Rank, Int>) {
    println("\n당첨 통계")
    println("---------")

    Rank.values().sortedBy { it.ordinal }.forEach { rank ->
        val count = rankCountMap.getOrDefault(rank, 0)
        val description = when (rank) {
            Rank.FIRST -> "6개 일치"
            Rank.SECOND -> "5개 일치, 보너스 볼 일치"
            Rank.THIRD -> "5개 일치"
            Rank.FOURTH -> "4개 일치"
            Rank.FIFTH -> "3개 일치"
        }
        println("$description (${String.format("%,d", rank.prize)}원) - ${count}개")
    }
}

//수익률 출력
fun printCalculate(rankCountMap: Map<Rank, Int>) {
    val profitRate = calculateProfit(rankCountMap)
    println("\n총 수익률은 ${String.format("%.1f", profitRate)}%입니다.")
}
