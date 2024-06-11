package com.ex.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ex.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity	, 	Integer>{
	List<QuestionEntity> findBySubject(String subject);
	List<QuestionEntity> findBySubjectAndContent(String subject, String content);
	List<QuestionEntity> findBySubjectLike(String subject);
}

	// findBySubjectOrContent() 
	// findBySubjectBetween
	// findBySubjectLike
	// findBySubjectIn	- in 연산자
	// findBySubjectOrderByCreateDateAsc - 날짜순으로 정렬
	// findBySubjectOrderByCreateDateDesc - 날짜순으로 

1. **인터페이스 이름과 역할**
    - 인터페이스 이름: `QuestionRepository`
    - 역할: 데이터베이스에서 질문을 저장하고 불러오는데 사용됩니다.

2. **상속**
    ```java
    public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
    ```
    - `extends JpaRepository<QuestionEntity, Integer>`: 이 부분은 `QuestionRepository`가 `JpaRepository`를 상속받는다는 것을 의미합니다.
    - `JpaRepository<QuestionEntity, Integer>`: `JpaRepository`는 질문을 데이터베이스에서 저장하고 불러오는 다양한 기능을 제공합니다.
        - `QuestionEntity`: 이 리포지토리가 질문 엔티티(`QuestionEntity`)를 다룬다는 것을 의미합니다.
        - `Integer`: 질문의 ID 타입이 `Integer`라는 것을 의미합니다.

3. **메서드들**
    ```java
    List<QuestionEntity> findBySubject(String subject);
    List<QuestionEntity> findBySubjectAndContent(String subject, String content);
    List<QuestionEntity> findBySubjectLike(String subject);
    ```
    - 이 부분은 데이터베이스에서 질문을 검색하는 메서드들을 정의합니다.
    
    - `List<QuestionEntity> findBySubject(String subject);`
        - `findBySubject`: 이 메서드는 주어진 제목(`subject`)과 일치하는 질문들을 찾습니다.
        - `String subject`: 검색할 제목입니다.
        - 반환값은 주어진 제목과 일치하는 질문들의 리스트입니다.

    - `List<QuestionEntity> findBySubjectAndContent(String subject, String content);`
        - `findBySubjectAndContent`: 이 메서드는 주어진 제목(`subject`)과 내용(`content`) 모두 일치하는 질문들을 찾습니다.
        - `String subject`: 검색할 제목입니다.
        - `String content`: 검색할 내용입니다.
        - 반환값은 주어진 제목과 내용이 모두 일치하는 질문들의 리스트입니다.

    - `List<QuestionEntity> findBySubjectLike(String subject);`
        - `findBySubjectLike`: 이 메서드는 주어진 제목(`subject`)과 비슷한 질문들을 찾습니다.
        - `String subject`: 검색할 제목입니다. 여기서 `subject`는 일부만 일치해도 됩니다.
        - 반환값은 주어진 제목과 비슷한 질문들의 리스트입니다.

**정리하자면:**
- 이 인터페이스는 데이터베이스에서 질문을 검색하는 데 사용됩니다.
- `JpaRepository`를 상속받아서 질문을 저장하고 불러오는 기본적인 기능을 모두 사용할 수 있습니다.
- 세 가지 검색 메서드를 제공합니다:
  - `findBySubject(String subject)`: 제목과 일치하는 질문들을 찾습니다.
  - `findBySubjectAndContent(String subject, String content)`: 제목과 내용이 모두 일치하는 질문들을 찾습니다.
  - `findBySubjectLike(String subject)`: 제목과 비슷한 질문들을 찾습니다.

이렇게 정의된 인터페이스를 사용하면, 코드 한 줄로 데이터베이스에서 질문을 쉽게 검색할 수 있습니다. 마치 도서관에서 특정 제목이나 내용의 책을 쉽게 찾는 것과 비슷해요.
