package lotto.lottoMachine

enum class Rank (val matchCount : Int, val hasBonus : Boolean, val prize : Int) {
    FIRST(6,false,2000000000), //20억원
    SECOND(5,true,30000000), //3천만원
    THIRD(5,false,1500000), //150만원
    FOURTH(4,false,50000), //5만원
    FIFTH(3,false,5000) //5천원
}

fun getRank(matchCount: Int, hasBonus: Boolean) : Rank? {
    return when{
        matchCount == 6 -> Rank.FIRST
        matchCount == 5 && hasBonus -> Rank.SECOND
        matchCount == 5 -> Rank.THIRD
        matchCount == 4 -> Rank.FOURTH
        matchCount == 3 -> Rank.FIFTH
        else -> null
    }
}