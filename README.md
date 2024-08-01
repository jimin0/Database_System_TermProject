# Database System Term Project: Facebook Clone DB

<p align="center">
  <img src="https://github.com/user-attachments/assets/8eed3101-c2eb-48a0-b5d3-b217f1148208" alt="demo1gif" width="400" />
</p>


## 📌 프로젝트 개요

이 프로젝트는 3학년 2학기 `데이터베이스 및 실습` 수업의 텀프로젝트로, Facebook의 주요 기능과 DB를 모방한 소셜 미디어 플랫폼을 구현했습니다. 
주로 소셜 미디어 기능과 데이터베이스 시스템 구축을 목적으로 했습니다.


## 🌟 주요 기능

- **사용자 관리:** 회원가입, 로그인, 로그아웃, 비밀번호 변경
- **프로필 관리:** 사용자 프로필 조회 및 수정
-  **게시물:** 작성, 조회, 수정, 삭제
- **상호작용:** 게시물 좋아요, 댓글 작성
-  **팔로우 시스템:** 다른 사용자 팔로우/언팔로우

## 💻 기술 스택

- **프론트엔드:** Java Swing (GUI)
- **백엔드:** Java
- **데이터베이스:** MySQL

## 🗂 프로젝트 구조

```
Database_System_TermProject/
├── Facebook1/
│   └── src/
│       ├── gui/
│       │   ├── 메인 GUI 컴포넌트들
│       │   ├── center/
│       │   ├── left/
│       │   ├── manageUser/
│       │   └── posting/
│       └── module-info.java
├── README.md
├── facebook_sample_data.sql
└── facebook_schema.sql
```

## 🚀 설치 및 실행

1. 저장소 클론:
   ```
   git clone https://github.com/jimin0/Database_System_TermProject.git
   ```
2. MySQL 데이터베이스 설정:
   - `facebook_schema.sql` 실행 (데이터베이스 구조 생성)
   - `facebook_sample_data.sql` 실행 (샘플 데이터 삽입)
3. Java 개발 환경(Eclipse, IntelliJ IDEA 등)에서 프로젝트 열기
4. `DatabaseHelper.java`에서 데이터베이스 연결 설정 확인 및 수정
5. `MainPage.java` 실행하여 애플리케이션 시작

## 📁 주요 클래스 설명

- `MainPage.java`: 메인 페이지
- `Login.java`: 로그인 처리
- `SignUpForm.java`: 사용자 등록
- `PostEditor.java`: 게시물 작성/수정
- `FollowUser.java`: 팔로우 기능
- `LikePost.java`: 좋아요 기능

## 📊 데이터베이스 스키마
<p align="center">
  <img width="500" alt="er_diagram" src="https://github.com/user-attachments/assets/10dfc9ca-062d-4620-9398-0dc920fd9f18">
</p>


## 📹 데모 영상
프로젝트의 전체 기능을 보여주는 데모 영상은 [여기](https://youtu.be/7aHfA7vGxV8?si=VW5MMHHQ0q-9LNfR)에서 확인할 수 있습니다.




