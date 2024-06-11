package com.ex.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="question")
public class QuestionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String subject;
	@Column(length=4000, columnDefinition = "TEXT")
	private String content;
	private LocalDateTime createDate;
	@OneToMany(mappedBy="question", cascade=CascadeType.REMOVE)
	private List<AnswerEntity> answerList;
	
}

1. **클래스 이름과 역할**
    - 클래스 이름: `QuestionEntity`
    - 역할: 질문의 정보를 저장하는 객체를 정의합니다.

2. **어노테이션**
    - `@Entity`: 이 클래스가 데이터베이스 테이블과 연결된다는 것을 나타냅니다.
    - `@Setter`와 `@Getter`: 이 클래스의 모든 필드에 대해 자동으로 세터와 게터 메서드를 생성합니다. 세터는 값을 설정하는 메서드이고, 게터는 값을 가져오는 메서드입니다.
    - `@Builder`: 이 클래스에 빌더 패턴을 적용합니다. 빌더 패턴은 객체를 쉽게 만들 수 있게 도와줍니다.
    - `@NoArgsConstructor`: 파라미터가 없는 기본 생성자를 자동으로 생성합니다.
    - `@AllArgsConstructor`: 모든 필드를 파라미터로 받는 생성자를 자동으로 생성합니다.
    - `@Table(name="question")`: 이 클래스가 데이터베이스의 "question" 테이블과 연결된다는 것을 나타냅니다.

3. **필드**
    ```java
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String subject;
    @Column(length=4000, columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createDate;
    @OneToMany(mappedBy="question", cascade=CascadeType.REMOVE)
    private List<AnswerEntity> answerList;
    ```
    - `private Integer id;`
        - `@Id`: 이 필드가 테이블의 기본 키(Primary Key)라는 것을 나타냅니다.
        - `@GeneratedValue(strategy=GenerationType.IDENTITY)`: 이 필드의 값이 데이터베이스에서 자동으로 생성된다는 것을 나타냅니다.
    - `private String subject;`
        - 질문의 제목을 저장합니다.
    - `@Column(length=4000, columnDefinition = "TEXT") private String content;`
        - `@Column(length=4000, columnDefinition = "TEXT")`: 이 필드가 최대 4000자까지 저장할 수 있는 "TEXT" 타입의 열이라는 것을 나타냅니다.
        - 질문의 내용을 저장합니다.
    - `private LocalDateTime createDate;`
        - 질문이 작성된 날짜와 시간을 저장합니다.
    - `@OneToMany(mappedBy="question", cascade=CascadeType.REMOVE) private List<AnswerEntity> answerList;`
        - `@OneToMany`: 이 필드가 다른 테이블(AnswerEntity)과 일대다 관계를 갖는다는 것을 나타냅니다. 즉, 하나의 질문에 여러 개의 답변이 달릴 수 있다는 의미입니다.
        - `mappedBy="question"`: 이 관계는 `AnswerEntity` 클래스의 `question` 필드에 의해 맵핑됩니다.
        - `cascade=CascadeType.REMOVE`: 질문이 삭제될 때, 연결된 모든 답변들도 함께 삭제됩니다.
        - 답변들의 리스트를 저장합니다.

**정리하자면:**
- 이 클래스는 질문의 정보를 저장하는 객체를 정의합니다.
- 질문의 ID, 제목, 내용, 작성 날짜, 그리고 그 질문에 달린 답변들의 리스트를 저장합니다.
- 이 클래스는 데이터베이스의 "question" 테이블과 연결되어 있습니다.
- `@Entity`와 다른 어노테이션들은 이 클래스를 데이터베이스와 쉽게 연동할 수 있게 도와줍니다.

이렇게 정의된 클래스를 사용하면, 질문 정보를 쉽게 데이터베이스에 저장하거나 불러올 수 있습니다. 마치 도서관에서 책 정보를 관리하는 것과 비슷해요. 여기서는 질문 정보를 관리하는 거죠.













