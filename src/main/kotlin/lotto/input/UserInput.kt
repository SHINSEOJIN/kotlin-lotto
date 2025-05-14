package lotto.input

//금액 입력
fun inputMoney(): Int {
    while (true) {
        println("구매할 금액을 입력하세요. (ex - 5000)")
        val input = readLine() ?: continue
        val moneyList = input.trim()
            .split(Regex("\\s+"))
            .mapNotNull { it.toIntOrNull() }

//        if (moneyList.size == 1) {
//            val money = moneyList[0]
//            if (money % 1000 == 0) {
//                return money
//            }
//        } else {
//            println("정확한 금액을 입력해주세요.")
//        }
    }
}

//사용자 로또번호입력
fun inputLotto(){

}

//보너스 번호 입력
fun inputBonus(){

}