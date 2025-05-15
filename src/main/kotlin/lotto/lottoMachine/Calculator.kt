package lotto.lottoMachine

//수익률 계산
fun calculateProfit(rankCountMap: Map<Rank, Int>): Double {
    val totalSpent = userTickets.size * 1000
    var totalEarned = 0

    for ((rank, count) in rankCountMap) {
        totalEarned += count * rank.prize
    }

    return if (totalSpent == 0) 0.0 else (totalEarned.toDouble() / totalSpent) * 100
}

//로또번호 당첨여부 확인
fun numberIsMatched(userNumbers : List<Int>, winNumber: Set<Int>): Int {
    return userNumbers.count {it in winNumber}
}

//보너스번호 당첨여부 확인
fun bonusIsMatched(userBonus : Int, winBonus : Int): Boolean {
    return userBonus.equals(winBonus)
}
