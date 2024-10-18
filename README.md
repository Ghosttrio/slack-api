# WithSlack - 슬랙 정보 전송 프로젝트

### 목적
슬랙 봇을 이용하여 메시지를 보낼 때 구성 설정을 간단하게 하기 위해 제작

### 사용법

도커 사용
```bash
docker pull ghosttrio/with-slack:latest

docker run -d -p 8080:8080 --name=with-slack ghosttrio/with-slack:latest
```

인터페이스 커스텀
```bash
git clone https://github.com/Ghosttrio/with-slack.git
```

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