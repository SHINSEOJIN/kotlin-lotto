# Lotto 발매기 설계 (Kotlin 콘솔)

## 프로젝트 개요

- 사용자에게 금액을 입력받아 로또를 자동 발행
- 1~45까지 중복 없이 6개 번호 + 보너스 번호 생성
- 당첨 번호와 사용자 번호를 비교해 등수 판별
- 당첨 결과 및 수익률 계산하여 출력
- 잘못된 입력은 예외 처리로 안내

---

## 전체 구성

| 역할 | 클래스 이름 | 주요 함수 / 설명 |
|------|--------------|-------------------|
| 메인 실행 | `Main.kt` | 전체 흐름 제어 |
| 사용자 입력 | `UserInput.kt` | `inputMoney()`, `inputLotto()`, `inputBonus()` |
| 결과 출력 | `OutputManager.kt` | `outputLotto()`, `printResult()`, `printProfit()`, `isSuccess()` |
| 로또 추첨 | `Machine.kt` | `lottoMachine()`, `isMatch()` |
| 수익 계산 | `Calculator.kt` | `calculateProfit()` |
| 등수 판별 | `Rank.kt` (enum class) | `FIRST`, `SECOND`, ..., `else = null` |
| 번호 저장 | `LottoResult.kt` (data class) | `val numbers: Set<Int>`, `val bonus: Int` |
| 예외 처리 | `ErrorHandler.kt` | 입력 오류/범위 초과 등 안내 |

---

## 🔄 동작 흐름

1. `UserInput`에서 금액, 사용자 번호, 보너스 번호 입력받기
2. `Machine` 클래스에서 로또 번호 6개 + 보너스 번호 자동 생성
3. `isMatch()`로 입력 번호와 당첨 번호 비교
4. `Rank` enum으로 등수 분류
5. `OutputManager`에서 결과 출력 및 수익률 계산 표시
6. 잘못된 입력 시 `ErrorHandler`에서 안내 메시지 제공

---

## 💾 향후 확장 아이디어

- SQLite를 활용한 구매 기록 저장
- 당첨 통계 기능 추가

---

