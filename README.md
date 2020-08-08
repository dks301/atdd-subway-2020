<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-%3E%3D%205.5.0-blue">
  <img alt="node" src="https://img.shields.io/badge/node-%3E%3D%209.3.0-blue">
  <img alt="license" src="https://img.shields.io/github/license/woowacourse/atdd-subway-2020">
</p>

<br>

# 레벨2 최종 미션 - 지하철 노선도 애플리케이션

# 구현할 기능 목록
## 백엔드
- [x] 경로 조회 응답 결과에 요금 정보 추가
- [ ] 요금 계산 기능
    - 거리별 요금
        - [x] 10km 이하이면 기본운임(1250원)을 부과한다.
        - [x] 10km 초과 ~ 50km 이하이면 5km마다 100원을 부과한다.
        - [x] 50km 초과 시 8km마다 100원을 부과한다.
    - 노선 별 추가 요금
        - [x] 추가 요금이 있는 노선을 이용하면 기존 요금에 추가한다.
        - [x] **예외** 추가 요금이 있는 여러 노선 중 가장 추가 요금이 큰 노선 요금만 추가한다.
    - 연령 별 할인 정책
        - [ ] 로그인 한 사용자의 경우 연령 별 요금으로 계산한다.
            - [ ] 13세 이상 19세 미만의 청소년인 경우 350원을 공제한 금액의 20%를 할인한다.
            - [ ] 6세 이상 13세 미만의 어린이인 경우 350원을 공제한 금액의 50%를 할인한다. 
        - [ ] **예외** 로그인하지 않은 사용자의 경우 할인을 받지 못한다.

- [ ] 가장 빠른 도착 경로 타입을 추가한다.
- [ ] 가장 빠른 도착 경로 계산 기능을 추가한다.
- [ ] **예외** 노선의 첫차/막차 시간은 24:00을 넘지 못한다.
- [ ] **예외** 첫차시간은 막차 시간보다 항상 이르다.
- [ ] **예외** 막차가 끊길 경우 다음날 첫차 기준으로 계산한다.
- [ ] **예외** 이동 시간과 승하차, 환승 시간은 고려하지 않는다.

## 프론트엔드
- [x] 백엔드 요금 조회 api를 프론트엔드에서 사용할 수 있게 연동한다.
- [x] 템플릿 리터럴을 이용해 현재 시간을 사용자가 보기 편한 형식으로 문자열 렌더링한다.
- [ ] validator를 구현해, form의 유효성을 검사한다.
    - path form의 유효성을 검사한다.
        - [x] **예외** 빈 값인지 확인한다.
        - [x] **예외** id가 자연수인지 확인한다.
    - departureTime form의 유효성을 검사한다.
        - [x] **예외** 빈 값인지 검사한다.
        - [x] **예외** dayTime이 '오전' or '오후'인지 확인한다.
        - [x] **예외** hour이 숫자 타입, 1~12 사이의 정수인지 확인한다.
        - [x] **예외** minute이 숫자 타입, 0~60 사이의 정수인지 확인한다. 
- [ ] 길찾기를 위해 사용자가 입력한 값을 이용해 검색결과를 불러오는 핸들러를 구현한다.

## 🎯 요구사항
- [프론트엔드 미션](https://github.com/woowacourse/atdd-subway-2020/blob/master/frontend-mission.md)
- [백엔드 미션](https://github.com/woowacourse/atdd-subway-2020/blob/master/backend-mission.md)

## 🤔 미션 제출 방법
- 진행 방식은 오프라인 코딩 테스트와 동일하다.
- 저장소를 Fork하여 자신의 저장소에서 미션 구현을 완료하고, Pull Request를 통해 미션을 제출한다.
- Pull Request를 보낸 후 woowa_course@woowahan.com로 메일을 발송한다.

## 😌 레벨2 최종 미션을 임하는 자세
레벨2 과정을 스스로의 힘으로 구현했다는 것을 증명하는데 집중해라
- [ ] 기능 목록을 잘 작성한다.  
- [ ] 자신이 구현한 기능에 대해 인수 테스트를 작성한다.
- [ ] 자신이 구현한 코드에 대해 단위 테스트를 작성한다.
- [ ] TDD 사이클 이력을 볼 수 있도록 커밋 로그를 잘 작성한다.
- [ ] 사용자 친화적인 예외처리를 고민한다.
- [ ] 읽기 좋은 코드를 만든다.

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew bootRun
```
<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/atdd-subway-2020/blob/master/LICENSE.md) licensed.
