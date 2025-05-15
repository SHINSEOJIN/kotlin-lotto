package lotto.Error

//Error 출력은 "[ERROR]"로 시작해야 합니다.

//UserInput.inputMoney의 오류 여부 검증
fun checkThousant(inputMoney: String, moneyList: List<Int>) {
    if (!inputMoney.matches(Regex("^\\d+$"))) {
        println("[ERROR] 숫자만 입력해주세요.")
    } else if (moneyList.size != 1) {
        println("[ERROR] 정확한 금액을 입력해주세요.")
    } else if (moneyList[0] % 1000 != 0) {
        println("[ERROR] 1000원 단위로 입력해주세요.")
    }
}

//Userinput.inputLotto의 오류 여부 검증
fun checkLottoError(inputlotto: String, lottoList: List<Int>) {
    if (!inputlotto.contains(Regex(","))) {
        println("[ERROR] 구분자는 \",\"입니다. 다시 입력해주세요.")
    } else if (lottoList.size != 6) {
        println("[ERROR] 로또는 1 ~ 45로 이루어진 6개의 숫자로 입력해야합니다. 다시 입력해주세요.")
    } else if (lottoList.toSet().size != 6) {
        println("[ERROR] 로또는 중복없이 6개의 숫자로 입력해야합니다. 다시 입력해주세요.")
    } else if (lottoList.all { it !in 1..45 }) {
        println("[ERROR] 숫자의 범위는 1 ~ 45까지 입니다. 다시 입력해주세요.")
    }
}

//Userinput.inputBonus의 오류 여부 검증
fun checkBonusError(userBonus: Int?, lottoList: List<Int>) {
    if (userBonus == null) {
        println("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.")
    } else if (userBonus in lottoList) {
        println("[ERROR] 기존 로또 번호와 중복된 숫자는 입력할 수 없습니다. 다시 입력해주세요.")
    } else if (userBonus !in 1..45) {
        println("[ERROR] 숫자는 1 ~ 45까지의 범위에서 입력할 수 있습니다. 다시 입력해주세요.")
    }
}