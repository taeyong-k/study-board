# study-board 📝

Spring Boot 기반의 학습용 게시판 프로젝트입니다.  
게시글 작성, 조회, 삭제 기능을 중심으로 CRUD 흐름을 구현하며,  
조회수 증가 및 삭제 요청 처리 등의 실전 백엔드 로직을 연습하기 위해 제작했습니다.

---

## 📌 프로젝트 목적

> Spring Boot와 MariaDB를 사용한 간단한 게시판 기능 구현을 통해  
> CRUD 처리, RESTful 요청 처리, 조회수 증가 및 삭제 처리 흐름을 학습하기 위한 프로젝트입니다.

---

## 🔧 기술 스택

### 🛠 개발 환경
- IDE: IntelliJ IDEA
- JDK: Java 17
- 빌드 도구: Maven
- 실행 방식: WAR 배포

### ⚙️ 사용 기술
- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **Backend**:
  - Java, Spring Boot 3.4.4
  - Lombok, Spring Boot DevTools
  - Spring Web
  - Thymeleaf Template Engine
  - JDBC API, Spring Data JDBC, MyBatis Framework
  - **MariaDB Driver** (추가됨)

---

## ✨ 주요 기능

- ✅ 게시글 작성 (닉네임, 비밀번호, 제목, 내용 입력)
- ✅ 게시글 읽기 (조회 시 조회수 증가)
  - 작성자, 작성일시, 제목, 내용, 조회수 표시
- ✅ 게시글 삭제 (입력한 비밀번호로 검증 후 삭제)
  - `DELETE` 방식 요청 처리
  - 응답은 JSON 형태로 `success` / `failure` 구분
  - 실패 시 `alert("알 수 없는 이유로 작성에 실패하였습니다.")`
  - 성공 시 `alert("삭제되었습니다.")` 후 작성 페이지로 이동

---

## 🧠 학습 및 구현 포인트

- HTML 폼 제출 이벤트(`submit`)에서 JavaScript `XMLHttpRequest`를 활용해 `POST` 및 `DELETE` 요청 처리  
- `FormData` 객체를 사용하여 서버에 데이터 전송  
- 닉네임, 비밀번호, 비밀번호 재입력, 제목, 내용에 대한 클라이언트 측 유효성 검사 및 `alert` 경고 처리  
- REST API 응답을 JSON 형식으로 받고, 상태 코드에 따라 성공(`success`) / 실패(`failure`) 로직 분기  
- 게시글 작성 시 성공하면 해당 글 상세 페이지로 자동 이동  
- 게시글 삭제 시 비밀번호 확인 후 삭제 처리 및 사용자 알림  
- MariaDB 스키마 설계 및 쿼리 작성  
- `ArticleEntity` 클래스 생성 및 Lombok 활용 (기본 생성자, 모든 필드 생성자, getter/setter, `equals`, `hashCode` 오버라이드)  
- Spring Boot MVC 기반으로 데이터베이스 연동과 CRUD 기능 구현  

---

## ▶️ 실행 방법

```bash
./mvnw spring-boot:run
