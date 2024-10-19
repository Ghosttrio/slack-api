# WithSlack - 슬랙 정보 전송 프로젝트

### 목적
슬랙 봇을 이용하여 메시지를 보낼 때 구성 설정 간단하고 재사용성 있게 하기 위해 제작

### 사용법
 
Dockerfile 사용
```bash
docker pull ghosttrio/with-slack:latest

docker run -d -p 8080:8080 --env SLACK_TOKEN=<토큰입력> --env SLACK_CHANNEL=<채널입력> --name=with-slack ghosttrio/with-slack:latest
```

Docker Compose 사용
```yaml
version: '3.8'
services:
  app:
    image: ghosttrio/with-slack:latest
    ports:
      - "8080:8080"
    environment:
      SLACK_TOKEN: # Slack 토큰을 추가
      SLACK_CHANNEL: # 여기에 Slack 토큰을 추가합니다.
```

```bash
docker compose up
```
### 관련 포스팅
[슬랙으로 Daily Report 만들기]()  
[슬랙봇 만들기]()


### 기능
- 슬랙으로 기본 메시지 보내기
- 슬랙으로 Blocks 메시지 보내기
- 슬랙으로 Scheduler 메시지 보내기 
- 슬랙으로 PDF 메시지 보내기
- 슬랙으로 커스텀 메시지 보내기
- 슬랙으로 메시지 스케줄링해서 보내기
- 슬랙으로 여러 채널에 메시지 보내기
- 기능들을 커스텀 할 수 있게 인터페이스 제공

### 기능 구조도

### API