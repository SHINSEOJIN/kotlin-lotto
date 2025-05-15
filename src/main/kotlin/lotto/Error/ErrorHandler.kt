package lotto.Error

fun checkThousant(input: String, list: List<Int>) {
    println("[ERROR] 1000원 단위로 입력해주세요.")
}

fun checkLottoError(errorType: String, lottoList: List<Int>) {
    when (errorType) {
        "size" -> println("[ERROR] 로또 번호는 6개여야 합니다.")
        "duplicate" -> println("[ERROR] 중복 없는 숫자만 입력해야 합니다.")
        "range" -> println("[ERROR] 숫자는 1~45 사이여야 합니다.")
    }
}

fun checkBonusError(bonus: Int?, win: List<Int>): Boolean {
    return when {
        bonus == null || bonus !in 1..45 -> {
            println("[ERROR] 숫자 하나만 입력해주세요.")
            false
        }
        win.contains(bonus) -> {
            println("[ERROR] 기존 로또 번호와 중복된 숫자는 입력할 수 없습니다. 다시 입력해주세요.")
            false
        }
        else -> true
    }
}

fun checkInputNull(): Boolean {
    println("[ERROR] 입력이 없습니다.")
    return false
}
