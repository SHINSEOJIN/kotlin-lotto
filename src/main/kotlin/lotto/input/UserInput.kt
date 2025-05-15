package lotto.input

import lotto.Error.*
import lotto.lottoMachine.randomlotto

fun inputMoney(): Int {
    var attempt = 0
    while (true) {
        println("구입금액을 입력해 주세요.")
        val inputMoney = readLine()
        if (inputMoney == null) {
            if (!checkInputNull()) return -1
            continue
        }

        val moneyList = inputMoney.trim().split(Regex("\\s+")).mapNotNull { it.toIntOrNull() }
        if (moneyList.size == 1 && moneyList[0] % 1000 == 0) return moneyList[0] / 1000

        checkThousant(inputMoney, moneyList)

        attempt++
        if (attempt > 1 && isTestEnvironment()) {
            if (!checkTestFail()) return -1
        }
    }
}

fun inputLotto(): List<Int> {
    var attempt = 0
    while (true) {
        println("당첨 번호를 입력해 주세요.")
        val input = readLine()
        if (input == null) {
            if (!checkInputNull()) return emptyList()
            continue
        }

        val lottoList = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        try {
            return randomlotto(lottoList)
        } catch (e: IllegalArgumentException) {
            checkLottoError(e.message ?: "unknown", lottoList)
        }

        attempt++
        if (attempt > 1 && isTestEnvironment()) {
            if (!checkTestFail()) return emptyList()
        }
    }
}

fun inputBonus(win: List<Int>): Int {
    var attempt = 0
    while (true) {
        println("보너스 번호를 입력해 주세요.")
        val input = readLine()
        if (input == null) {
            if (!checkInputNull()) return -1
            continue
        }

        val bonus = input.toIntOrNull()
        if (checkBonusError(bonus, win)) return bonus!!

        attempt++
        if (attempt > 1 && isTestEnvironment()) {
            if (!checkTestFail()) return -1
        }
    }
}
