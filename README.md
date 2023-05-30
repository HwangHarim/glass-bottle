# glass-bottle

> mbti 기만 편지쓰기

# 요구사항

> 아래의 요구사항을 구현한다.

### Branch 규칙

- main : 실제 서버 배포
- staging : 개발용 브랜치
- feature... 여기는 각자 알아서.. fix, refac 등등 알아서 브랜치 정하기

### 사용자 도매인 - 황하림

- ID(이메일)로 인증 후 로그인(V2)
- 사용자는 로그인을 할 수 있다.
- 사용자는 회원가입을 할 수 있다.
- 사용자는 로그아웃을 할 수 있다.
- 사용자는 회원 정보를 조회할 수 있다.
- 사용자는 회원 정보를 수정할 수 있다.

### mbti - 김동건

- user는 mbti를 갖고 있다.
- mbti를 파악할 수 있다.

### noti - 손장미

- 특정 mbti를 가진 사람들에게 mbti 편지를 보낼 수 있다.
- 편지, 답장 조회 가능
- 편지의 답장 기간이 있다.
- mbti 설정 후 해당 mbti user 전체로 발송 할 수 있다.
- mbti 설정 없이 전체 user 한테 발송 할 수 있다.
- 선택한 답장을 url로 공유 할 수 있다.(단일 공유)

### Slack - 황인준

- mbti 편지 발송 히스토리 기록에 대해 전일 정보를 제공한다.
- mbti 문제 풀이를 진행한 기록에 대해 매일 오전 8시마다 전일 정보를 제공한다.
- 사용자 회원가입 정보에 대해 전일 정보를 제공한다.

### admin - 황인준
- admin이 공통 문제를 작성 할 수 있다.
- 공통 문제의 USER 답변을 MBTI 별로 확인 할 수 있다. 

### DevOps - 손장미
- Github Action CI/CD
- docker
- EC2, RDS
