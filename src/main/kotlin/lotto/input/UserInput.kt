package lotto.input

import lotto.Error.checkBonusError
import lotto.Error.checkThousant
import lotto.Error.checkLottoError

//금액 입력
fun inputMoney(): Int {
    while (true) {
        println("구매할 금액을 입력하세요. (ex - 5000)")
        val inputMoney = readLine() ?: continue
        val moneyList = inputMoney.trim()
            .split(Regex("\\s+"))
            .mapNotNull { it.toIntOrNull() }

        if (moneyList.size == 1 && moneyList[0] % 1000 == 0) {
            return moneyList[0]
        }
        checkThousant(inputMoney, moneyList)
    }
}

//사용자 로또번호입력
fun inputLotto(): List<Int> {
    while (true) {
        println("로또 번호 6개를 입력하세요. (1~45사이, 중복불가, \",\"로 구분)")
        val inputLotto = readLine() ?: continue
        val lottoList = inputLotto.trim()
            .split(",")
            .mapNotNull { it.toIntOrNull() }
        //조건 : 개수(6개), 범위(1~45), 중복불가
        if (lottoList.size == 6 &&
            lottoList.toSet().size == 6 &&
            lottoList.all { it in 1..45 }
        ) {
            return lottoList
        }
        checkLottoError(inputLotto, lottoList)
    }

}

//보너스 번호 입력
fun inputBonus(lottoList: List<Int>): Int {
    while (true) {
        println("보너스 번호 1개를 입력해주세요. (1~45사이, 앞전 입력한 숫자와 중복불가)")
        val inputBonus = readLine() ?: continue
        val userBonus = inputBonus.trim().toIntOrNull()
        //null X, 입력한 로또번호와 중복X, 범위(1~45)
        if (userBonus != null &&
            userBonus !in lottoList &&
            userBonus in 1..45
        ) {
            return userBonus
        }
        checkBonusError(userBonus, lottoList)
    }
}