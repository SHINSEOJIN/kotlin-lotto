package lotto

import lotto.input.inputBonus
import lotto.input.inputLotto
import lotto.input.inputMoney
import lotto.lottoMachine.generateLotto
import lotto.output.outputLotto
import lotto.output.checkSuccess
import lotto.output.printSuccess
import lotto.output.printCalculate

fun main() {
    // 1. 금액 입력 받기
    val countLotto = inputMoney()

    // 2. 금액에 따라 로또 발행 (1장 = 1000원)
    repeat(countLotto) {
        generateLotto()  // userTickets에 자동 저장됨
    }

    // 3. 발행된 로또 내역 출력
    outputLotto()

    // 4. 당첨 번호 입력받기
    val winNumbers = inputLotto()
    val winBonus = inputBonus(winNumbers)

    // 5. 당첨 결과 분석
    val resultMap = checkSuccess(winNumbers.toSet(), winBonus)

    // 6. 결과 출력
    printSuccess(resultMap)
    printCalculate(resultMap)
}
