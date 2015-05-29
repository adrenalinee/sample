#Overview
spring-security로 웹 페이지 인증을 구현하는 샘플 프로젝트입니다.

#적용기능
* java config 방식으로 설정
* 사용자 정의 로그인 화면
* 페이지별 접근 권한 설정
* 권한없음 페이지 지정
* 로그아웃후 이동할 페이지 지정
* 사용자 정의 테이블로 사용자 인증 및 권한 설정

#개발 환경
- java8
- spring-sts
- maven
- spring-boot
  - spring-boot-starter-web
  - spring-boot-starter-security
  - spring-boot-starter-thymeleaf
  - spring-boot-starter-data-jpa
- java configuration


#권한 설정
* USER: 일반 사용자
* ADMIN: 운영자


#웹 페이지 설정
* **/(메인화면)**: 로그인 하지 않은 사용자 포함 모두 접근 가능한 페이지
* **/login(로그인 화면)**: 로그인하려고 하거나 인증이 필요한 페이지에 접근하려고 할때 이동하는 페이지
* **/users(사용자 목록 화면)**: 운영자(ADMIN) 권한의 사용자만 접근 가능
* **/users/me(로그인한 사용자 자신의 상세 페이지)**: 로그인한 사용자는 모두 접근 가능
* **/users/{userId}(특정 사용자의 상세 페이지)**: 로그인한 사용자 모두 접근 가능
* **/accessDenied(접근권한 없음 페이지)**: 로그인했으나 접근권한이 없는 페이지에 접속하려고 할 경우에 이동하는 페이지

직접 실행하셔서 위와 같이 동작하는지 테스트해보시기 바랍니다.


#이슈 사항
현재 이 샘플 프로젝트에서는
운영자 권한이 없어도 다른 사용자의 상세 페이지(/users/{userId})의 주소를 직접 치고 들어가면 접속이 가능합니다.
자신의 상세 페이지 외에는 접속이 불가능 하도록 하려면 어떻게 설정해야 할까요? 
