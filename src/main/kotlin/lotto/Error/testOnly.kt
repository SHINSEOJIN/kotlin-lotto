package lotto.Error

fun checkTestFail(): Boolean {
    println("[ERROR] 테스트 입력 실패")
    return false
}

fun isTestEnvironment(): Boolean {
    return Thread.currentThread().stackTrace.any {
        it.className.contains("org.junit") || it.className.contains("ApplicationTest")
    }
}
