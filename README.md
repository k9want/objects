# 6️⃣ 메시지와 인터페이스

협력의 관점에서 객체는 두 가지 종류의 메시지 집합으로 구성된다.

1. 객체가 수신하는 메시지의 집합
2. 외부의 객체에게 전송하는 메시지의 집합

### 메시지(message)

- 협력하는 객체들이 사용할 수 있는 유일한 의사소통 수단.
- 메시지 전송 or 메시지 패싱: 다른 객체에 도움 요청
- 메시지 전송자: 해당 메시지를 전송하는 객체 [client]
- 메시지 수신자: 메시지를 수신하는 객체 [server]

메시지 = 오퍼레이션명(operation name) + 인자(argument)로 구성되어 있다.

ex) 메시지 = isSatisfiedBy(screening)

메시지 전송 = 메시지 수신자 + 메시지

ex) 메시지 전송 = condition.isSatisfiedBy(screening) // condition이 메시지 수신자

### 메서드

- 메시지를 수신했을 때 실제로 실행되는 함수 또는 프로시저
- condition은 DiscountCondition 인터페이스 타입으로 정의되어 있지만, 실체로는 구현체의 isSatisfiedBy 메서드가 실행된다.
- 핵심! 동일한 이름의 변수 condition에게 동일한 메시지를 전송하더라도 객체의 타입에 따라 실행되는 메서드가 달라질 수 있다는 것! (다형성)
- 메시지와 메서드라는 서로 다른 개념을 실행 시점에 연결해야 하기 때문에 컴파일 시점과 실행 시점의 의미가 달라질 수 있다.
- 메시지와 메서드의 구분은 메시지 전송자와 메시지 수신자 간의 결합을 느슨하게 한다.
  - 메시지 전송자는 자신이 어떤 메시지를 전송해야하는지만 알면 된다.
  - 메시지 수신자도 누가 메시지를 전송하는지 알 필요가 없다. 메시지 도착했다는 사실만 알면 된다.
  - 그렇기에 메시지 수신자는 메시지를 처리하기 위해 필요한 메서드를 스스로 결정할 수 있다.
- 중요! 메시지 전송자와 메시지 수신자는 서로에 대한 상세한 정보를 알지 못한 채 오직 메시지를 통해서만 연결된다.

### 퍼블릭 인터페이스

- **객체가 의사소통을 위해 외부에 공개하는 메시지의 집합**
  - 객체는 안과 밖을 뚜렷한 경계를 가지고 구분한다.
  - 그렇기에 외부의 객체는 객체가 공개하는 메시지를 통해서만 객체와 상호작용이 가능하다.
- 오퍼레이션: 퍼블릭 인터페이스에 포함된 메시지
  - 수행 가능한 어떤 행동에 대한 추상화
  - 대부분 단순 메시지와 관련된 시그니처를 가리킨다.
  - ex) isSatisfiedBy가 오퍼레이션에 해당한다.

### 오퍼레이션 vs 메서드

오퍼레이션은 구현이 아닌 추상화

메서드는 오퍼레이션에 대한 구현

ex) SequenceCondition과 PeriodCondition의 두 메서드는 DiscountCondition 인터페이스에 정의된 isSatisfiedBy 오퍼레이션의 여러 가능한 구현 중 하나다.

### 메시지, 오퍼레이션, 메서드 사이의 관계

1. **객체가 다른 객체에게 메시지를 전송**하면,
2. **런타임 시스템**은 **메시지 전송을 오퍼레이션 호출로 해석**하고
3. 메시지를 **수신한 객체의 실제 타입을 기반**으로 **적절한 메서드를 찾아 실행**한다.

퍼블릭 인터페이스와 메시지의 관점에서 보면 메서드 호출보단 **오퍼레이션 호출이 더 적합하다.**

### 시그니처

시그니처 = 오퍼레이션(또는 메서드)의 이름 + 파라미터 목록

- 오퍼레이션: 실행 코드 없이 시그니처만을 정의한 것
- 메서드: 시그니처에 구현을 더한 것
- 오퍼레이션 관점에서 다형성이란 동일한 오퍼레이션 호출에 대해 서로 다른 메서드들이 실행되는 것이라고 정의할 수 있다.

### 인터페이스

- 어떻게 수행하는지가 아니라 무엇을 하는지를 표현하자
- 최소의 오퍼레이션만 포함하게 된다.
- 메시지가 객체를 선택하게 함으로써 클라이언트의 의도를 메시지에 표현할 수 있게 된다.
- 퍼블릭 인터페이스의 품질에 영향을 미치는 원칙과 기법
  - 디미터 법칙
  - 묻지 말고 시켜라
  - 의도를 드러내는 인터페이스
  - 명령-쿼리 분리

### 디미터 법칙

객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하라는 것

캡술화하기 위해 따라야하는 구체적인 지침을 제공한다. (캡슐화를 지키기 위해 접근해야 하는 요소를 제한한다.)

객체의 내부 구조를 묻는 메시지가 아닌 수신자에게 무언가를 시키는 메시지가 더 좋은 메시지라고 말하는 법칙

‘묻지 말고 시켜라’: 훌륭한 인터페이스를 만들기 위해서는 객체가 어떻게 작업을 수행하는지를 노출하지 않아야 하며, 인터페이스는 객체가 얻허게 하는지가 아니라 **무엇을 하는지를 서술**해야한다.

- 낯선 자에게 말하지 말라
- 오직 인접한 이웃하고만 말하라
- 오직 하나의 도트만 사용하라
- 클래스 내부의 메서드가 아래 조건을 만족하는 인스턴스에만 메시지를 전송하도록 프로그래밍 해야한다.
  - this 객체
  - 메서드의 매개변수
  - this의 속성
  - this의 속성인 컬렉션의 요소
  - 메서드 내에서 생성된 지역 객체
- 부끄럼타는 코드(shy code):불필요한 어떤 것도 다른 객체에게 보여주지 않으며, 다른 객체의 구현에 의존하지 않는 코드가 된다.

디미터 법칙을 위반한 코드

```java
screening.getMovie().getDiscountConditions();
```

메시지 전송자가 수신자의 내부 구조에 대해 물어보고 반환하는 요소(getMovie())에 대해 연쇄적으로 메시지를 전송한다. - 기차 충돌(train wreck)

이렇게 되면 메시지 전송자는 메시지 수신자의 내부 정보를 알게 되며, 메시지 수신자의 내부 구현에 강하게 결합된다.

```java
screening.calculateFee(audienceCount); // 디미터 법칙 적용한 코드
```

### 의도를 드러내는 인터페이스

컨트 벡이 말하는 메서드를 명명하는 두 가지 방법

1. 메서드가 적업을 어떻게 수행하는지를 나타내도록 이름을 짓는 방법 (X)

```java
public class PeriodCondition {
	public boolean isSatisfiedByPeriod(Screening screening) {}
}
    
public class SequenceCondition {
  public boolean isSatisfiedBySequence(Screening screening) {}
}
```

해당 스타일이 좋지 않은 이유

- 메서드에 대해 커뮤니케이션이 제대로 되지 않는다.
  - 클라이언트 관점에서 isSatisfiedByPeriod와 isSatisfiedBySequence모두 할인 조건을 판단하는 동일한 적업을 수행하지만, 메서드의 이름이 다르기 때문에 두 메서드의 내부 구현을 정확하게 이해하지 못한다면 두 메서드가 동일한 작업을 수행한다는 사실을 알기가 어렵다.
- 메서드 수준에서 캡슐화를 위반한다.
  - 해당 메서드들은 클라이언트가 협력하는 객체의 종류를 알도록 강요한다.
  - PeriodCondition을 사용하는 코드를 SequenceCondition을 사용하도록 변경하려고 한다면, 단순히 참조하는 객체를 변경하는 것뿐만 아니라 호출하는 메서드를 변경해야한다. 더불어 할인 여부를 판단하는 방법이 바뀌면 메서드의 이름도 바꿔야 한다.
  - 메서드 이름을 변경한다는 것은 메시지를 전송하는 클라이언트의 코드도 같이 변경해야한다는 것이고, 변경에 취약해질 수 밖에 없다.

1. ‘어떻게’가 아닌 ‘무엇’을 하는지를 드러내 이름을 짓는 방법 (O)

어떻게 vs 무엇을

- 어떻게 수행하는지를 드러내는 이름은 메서드의 내부 구현을 설명하는 이름이다.
  - 결국 협력을 설계하기 시작하는 이른 시기부터 클래스의 내부 구현에 관해 고민을 할 수 밖에 없다.
- 무엇을 하는지를 드러내는 이름은 이름을 짓기 전에 객체가 협력 안에서 수행해야하는 책임에 관해 고민을 하고 짓게 된다.
  - 이는 외부의 객체가 메시지를 전송하는 목적을 먼저 생각하게끔 하며, 결국은 협력하는 클라이언트의 의도에 부합하도록 메서드의 이름을 짓게 된다.

‘무엇을’ 하는지를 드러내는 방법으로 변경한 메서드 이름

```java
public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}

public class PeriodCondition implements DiscountCondition {
	public boolean isSatisfiedBy(Screening screening) {}
}
    
public class SequenceCondition implements DiscountCondition  {
  public boolean isSatisfiedBy(Screening screening) {}
}
```

클라이언트의 관점에서 두 메서드는 할인 여부를 판단하기 위한 작업을 수행하기에, 두 메서드의 이름을 isSatisfiedBy로 변경하는 것이 적합하다.

단순히 메서드의 이름이 같다고 해서 동일한 메시지를 처리하지 않기에 DiscountCondtion 인터페이스를 정의하고 이 인터페이스에  isSatisfiedBy 오퍼레이션을 정의하면 클라이언트에선 두 메서드를 동일한 방식으로 사용할 수 있게 된다.

또 다른 예시

```java
public class TicketSeller {
	public void sellTo(Audience audience) {}
}

public class Audience {
	public Long buy(Ticket ticket) {}
}

public class Bag{
	public Long hold(Ticket ticket) {}
}
```

오퍼레이션의 이름은 협력이라는 문맥을 반영해야 한다.

오퍼레이션은 클라이언트가 객체에게 무엇을 원하는지를 표현해야 한다.

---

### 원칙의 함정

1. 디미터 법칙은 하나의 도트(.)를 강제하는 규칙이 아니다.

```java
IntStream.of(1, 11, 21, 33, 9).filter(x -> x > 10).distinct().count();
```

of, filter, distinct 메서드는 모두 IntStream 클래스의 인스턴스를 반환한다. 즉, IntStream의 인스턴스를 또 다른 인스턴스로 변환한다.  이는 디미터 법칙을 위반하지 않는다.

디미터 법칙은 결합도와 관련된 것이고, 이 결합도가 문제가 발생할 때는 **객체의 내부 구조가 외부로 노출되는 경우로 한정된다.**

IntStream을 다른 IntStream으로 변환할 뿐, 객체를 둘러싸고 있는 캡슐은 그대로 유지되기에 이는 디미터 법칙을 위반한 것이 아니다.

**핵심! - 여러 개의 도트를 사용한 코드가 객체의 내부 구조를 노출하는가?**

1. 결합도와 응집도의 충돌

일반적으로 어떤 객체의 상태를 물어본 후 반환된 상태(getter처럼)를 기반으로 결정을 내리고 해당 결정에 따라 객체의 상태를 변경하는 코드는 묻지 말고 시켜라 스타일로 변경해야 한다.

```java
if(audience.getBag().hasInvitation) 
```

위 코드는 위임메서드를 사용하는 방법으로 객체의 내부 구조를 감출 수 있고, 결합도를 낮추면서 객체의 응집도를 높일 수 있다.

하지만 주의할 점은 모든 상황에서 이렇게 위임 메서드를 추가한다면, 객체는 오히려 상관없는 책임까지도 떠안게 되고 응집도가 낮아지게 된다.

클래스는 하나의 변경 원인만을 가져야 하는데, 많은 위임 메서드로 인해 서로 상관없는 책임들이 있는 클래스는 작은 변경에도 쉽게 무너질 수 있다. 그렇기에 디미터 법칙과 묻지 말고 시켜라 원칙을 무작정 따르면 응집도가 낮은 객체로 넘쳐날 것이다.

**묻는 것외에는 방법이 존재하지 않는 경우**

컬렉션에 포함된 객체들을 처리하는 방법은 객체에게 물어보는 것이 유일하다.

객체는 내부 구조를 숨겨야 하므로 디미터 법칙을 따르는 것이 좋지만 자료 구조라면 당연히 내부를 노출해야하므로 디미터 법칙을 적용할 필요가 없다.

따라서 무작정 원칙을 맹신해서 사용하는 것은 좋지 않다. 상황에 따라 적절하나 판단을 해야할 뿐이다. 설계는 결국 경우에 따라 다르다!

---

### 명령-쿼리 분리 원칙

퍼블릭 인터페이스에 오퍼레이션을 정의할 때 참고할 수 있는 지침을 제공한다.

프로시저 vs 함수

프로시저: 부수효과를 발생시킬 수 잇지만 값을 반환할 수 없다.

함수: 값을 반환할 수 있지만 부수효과를 발생시킬 수 없다.

명령 vs 쿼리

명령: 객체의 상태를 수정하는 오퍼레이션

쿼리: 객체와 관련된 정보를 반환하는 오퍼레이션

프로시저 = 명령

쿼리 = 함수

명령-쿼리 분리 원칙의 핵심은

오퍼레이션은 부수효과를 발생시키는 명령이거나 부수효과를 발생시키지 않는 쿼리 중 하나여야만 한다는 것이다.

둘 다 될 수 없다가 핵심이다.

- 객체의 상태를 변경하는 명령은 반환값을 가질 수 없다.
- 객체의 정보를 반환하는 쿼리는 상태를 변경할 수 없다.

즉, 질문이 답변을 수정해서는 안된다.

불변성 = 부수효과가 발생하지 않는다

불변성은 부수효과의 발생을 방지하고 참조 투명성을 만족시킨다.

객체지향 패러다임은 객체의 상태 변경이라는 부수효과를 기반으로 하기 때문에 참조 투명성은 예외에 가깝다. 하지만 명령-쿼리 분리 원칙을 통해 명령과 쿼리를 명백하게 분리하여 제한적이나마 참조 투명성의 혜택을 누릴 수 있게 된다. → 어떤 순서로 몇 번 호출해도 항상 결과는 동일하다.

---

### 결론 - 책임에 초점을 맞춰라

메시지를 먼저 선택하고 그 후에 메시지를 처리할 객체를 선택하자!

디미터법칙, 묻지 말고 시켜라, 의도를 드러내는 인터페이스, 명령-쿼리 분리 원칙 모두 메시지를 먼저 선택하는 방식을 사용하면 적용되는 원칙들이다.

책음 주도 설계 원칙을 따르면 훌륭한 메시지를 얻을 수 있고, 메시지가 객체를 선택하기 때문에 협력에 적합한 메시지를 결정할 확률이 높아진다. 협력에 적합한 메시지를 구하는 것이 협력에 적합한 객체를 구하는 것보다 중요하다.