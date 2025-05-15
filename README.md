# Lotto 발매기 (Kotlin 콘솔)

---

## 프로젝트 구조

| 역할           | 파일명                 | 주요 함수 / 설명 |
|----------------|------------------------|------------------|
| 앱 실행        | `Application.kt`       | `main()` – 전체 흐름 실행 |
| 사용자 입력    | `UserInput.kt`         | `inputMoney()`, `inputLotto()`, `inputBonus()` |
| 결과 출력      | `OutputManager.kt`     | `outputLotto()`, `checkSuccess()`, `printSuccess()`, `printCalculate()` |
| 로또 생성      | `Machine.kt`           | `lottoMachine()` – 자동 당첨번호 생성 |
| 결과 판별      | `Calculator.kt`        | `numberIsMatched()`, `bonusIsMatched()` |
| 수익 계산      | `printCalculate()`     | 수익률 계산 및 출력 |
| 등수 정의      | `Rank.kt`              | enum: `FIRST ~ FIFTH`, `getRank()` |
| 구매내역 저장  | `LottoResult.kt`       | data class `LottoResult`, `userTickets` |
| 예외 처리      | `ErrorHandler.kt`      | 입력 오류 시 `[ERROR]` 메시지 출력 |

---

## 실행 흐름 요약

1. `inputMoney()` → 구매 금액 입력
2. `generateLotto()` → 구매 수만큼 번호 자동 입력 받기
3. `outputLotto()` → 구매 내역 출력
4. `lottoMachine()` → 당첨 번호 + 보너스 번호 생성
5. `checkSuccess()` → 등수별 당첨 개수 집계
6. `printSuccess()` → 등수 결과 출력
7. `printCalculate()` → 수익률 계산 및 출력

---

## 예외 처리

- 입력값이 잘못되면 `[ERROR]`로 시작하는 메시지 출력
- 처리 예: 금액 범위 초과, 숫자 아님, 중복 숫자, 잘못된 개수 등

---

## 규칙 반영

- 로또 번호: 1~45 사이, 중복 없이 6개
- 보너스 번호: 1~45, 기존 번호와 중복 불가
- 1장 = 1,000원, 수익률 소수점 1자리까지 출력
- 등수는 `Rank.kt` 기준으로 자동 판별

