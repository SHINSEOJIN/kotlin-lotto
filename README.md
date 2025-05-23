# Kotlin 로또 시뮬레이터

사용자 입력, 예외 처리, 테스트 대응 구조를 분리하여 설계한 로또 번호 시뮬레이터입니다.  

---

## 기능 요약

- 사용자가 구입 금액을 입력하면 1000원 단위로 로또 자동 발행
- 각 로또는 6개의 번호와 1개의 보너스 번호로 구성
- 사용자가 당첨 번호 및 보너스 번호를 입력
- 전체 로또 결과 중 당첨 개수, 수익률 계산 출력

---

## 프로젝트 구조

| 파일명 | 설명 |
|--------|------|
| Application.kt | 메인 함수, 전체 흐름 조립 |
| UserInput.kt | 사용자 입력 처리 전용 |
| ErrorHandler.kt | 사용자 대상 에러 메시지 출력 담당 |
| testOnly.kt | 테스트 실행 환경에서만 동작하는 조건 분리 |
| Machine.kt | 로또 번호, 보너스 번호 생성 로직 |
| LottoResult.kt | 로또 결과 저장 및 리스트 관리 |
| OutputManager.kt | 발행 로또 출력, 당첨 통계, 수익률 계산 |
| Rank.kt | 당첨 순위 정의 및 상금 설정 |

---

## 테스트 대응 전략

- 모든 입력 함수(inputMoney, inputLotto, inputBonus)에 attempt 횟수를 부여
- isTestEnvironment()를 통해 테스트 환경 여부 판단
- 테스트 환경일 경우 2회 이상 잘못된 입력 시 종료 + 에러 메시지 출력
- 일반 사용자 환경에서는 무제한 재입력 가능
