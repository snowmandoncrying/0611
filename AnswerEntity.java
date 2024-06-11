package com.ex.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="answer")
public class AnswerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "TEXT")
	private String content;
	private LocalDateTime createDate;
	@ManyToOne
	private QuestionEntity question;

}

이 코드는 `AnswerEntity`라는 이름의 클래스를 보여줍니다. 
  이 클래스는 답변을 데이터베이스에 저장할 때 사용되는 객체를 정의합니다.

1. **클래스 이름과 역할**
    - 클래스 이름: `AnswerEntity`
    - 역할: 답변의 정보를 저장하는 객체를 정의합니다.

2. **어노테이션**
    - `@Entity`: 이 클래스가 데이터베이스 테이블과 연결된다는 것을 나타냅니다.
    - `@Builder`: 이 클래스에 빌더 패턴을 적용합니다. 빌더 패턴은 객체를 쉽게 만들 수 있게 도와줍니다.
    - `@Setter`와 `@Getter`: 이 클래스의 모든 필드에 대해 자동으로 세터와 게터 메서드를 생성합니다. 세터는 값을 설정하는 메서드이고, 게터는 값을 가져오는 메서드입니다.
    - `@NoArgsConstructor`: 파라미터가 없는 기본 생성자를 자동으로 생성합니다.
    - `@AllArgsConstructor`: 모든 필드를 파라미터로 받는 생성자를 자동으로 생성합니다.
    - `@Table(name="answer")`: 이 클래스가 데이터베이스의 "answer" 테이블과 연결된다는 것을 나타냅니다.

3. **필드**
    ```java
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createDate;
    @ManyToOne
    private QuestionEntity question;
    ```
    - `private Integer id;`
        - `@Id`: 이 필드가 테이블의 기본 키(Primary Key)라는 것을 나타냅니다.
        - `@GeneratedValue(strategy=GenerationType.IDENTITY)`: 이 필드의 값이 데이터베이스에서 자동으로 생성된다는 것을 나타냅니다.
    - `private String content;`
        - `@Column(columnDefinition = "TEXT")`: 이 필드가 "TEXT" 타입의 열이라는 것을 나타냅니다. 답변의 내용을 저장합니다.
    - `private LocalDateTime createDate;`
        - 답변이 작성된 날짜와 시간을 저장합니다.
    - `private QuestionEntity question;`
        - `@ManyToOne`: 이 필드가 다른 테이블(QuestionEntity)과 다대일 관계를 갖는다는 것을 나타냅니다. 즉, 하나의 질문에 여러 개의 답변이 달릴 수 있다는 의미입니다.
        - 답변이 어느 질문에 달렸는지 저장합니다.

**정리하자면:**
- 이 클래스는 답변의 정보를 저장하는 객체를 정의합니다.
- 답변의 ID, 내용, 작성 날짜, 그리고 어느 질문에 달렸는지를 저장합니다.
- 이 클래스는 데이터베이스의 "answer" 테이블과 연결되어 있습니다.
- `@Entity`와 다른 어노테이션들은 이 클래스를 데이터베이스와 쉽게 연동할 수 있게 도와줍니다.
