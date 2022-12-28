# 프로젝트 생성

spring boot를 사용할건데 [start.spring.io](http://start.spring.io) 사이트를 통해 프로젝트를 생성하면 편하게 프로젝트를 생성할 수 있다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cfdbc24a-a823-42a0-bb7d-b16c0472afc7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114556Z&X-Amz-Expires=86400&X-Amz-Signature=a8055aada802c1bb222044a0150b883aa8aa0fdfb8cf3c577cea34cc1552230e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/475c2825-c8dc-4d29-9d65-e1f0f19dffa3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114616Z&X-Amz-Expires=86400&X-Amz-Signature=21b2416ae0817f3359e5ced7412d970643d23c24b24744afae9f068f8a6dc647&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

프로젝트 구성을 보면 src/main 폴더와 src/test 폴더가 나누어져있다.

- 요즘에는 maven이든 gradle이든 main이랑 test랑 나누어져있다.
- main에는 java폴더와 resources폴더로 나누어져있다.
    - resources폴더는 java파일들을 제외한 설정파일이나 xml파일 또는 html파일 등등이 들어가게 된다.
- test는 테스트 코드들과 관련된 파일들이 들어갈 폴더이다.
    - 요즘에는 테스트 코드가 굉장히 중요하다.

build.gradle

- 예전에는 개발자가 직접 이 파일을 입력했어햐하는데 요즘에는 [start.spring.io](http://start.spring.io) 같은 사이트에서 자동으로 생성해주기 때문에 굉장히 편해졌다.
- 알고있으면 좋지만 자세하게 파고들 필요는 없다.
    - ‘그냥 버전 설정하고 라이브러리를 땡겨오는구나’라고만 생각하면 된다.


```
plugins {
	id 'java'
	id 'org.springframework.boot' version '2.7.7'  -- spring boot 버전
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'  -- java 버전

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
	useJUnitPlatform()
}
```

dependencies에 포함된 라이브러리들은 repositories에 적힌 mavenCentral이란 사이트에서 다운로드를 받아라라고 설정을 해놓은 것이다. 필요하면 특정 사이트를 입력해서 다운받게 하면 된다.

- HellSpringApplication

```java
package hello.hellspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellSpringApplication.class, args);
	}

}
```

java의 실행 메소드인 main메소드가 있고 안에 해당 파일의 클래스 와 인자를 파라미터에 담고 특정 메소드를 실행한다.~~~~

해당 파일을 실행시키면 콘솔에

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cb42a852-fd7e-4f40-9220-36adc3431c34/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114715Z&X-Amz-Expires=86400&X-Amz-Signature=2ede4ef2fb1c4f5c587d283b027d8b2b86a69d5f22b103afe64ec134a0a6493e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

위와 같이 로그가 찍힌다.

그리고 localhost:8080에 접속해보면

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2870805d-a51d-4c43-a319-9dc61f715a9f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114729Z&X-Amz-Expires=86400&X-Amz-Signature=2023a77633cb131d052dd644ee0852625b022c9d3ddce4fd1ae532b71e90126d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

위와 같이 표시가 되면 성공한것이다.

- 스프링 부트는 톰캣을 내장하고 있어 따로 설정해주지 않아도 자체적으로 톰캣서버를 실행시켜준다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/dd750272-f806-4ef8-9995-cc10576f178f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114756Z&X-Amz-Expires=86400&X-Amz-Signature=38040ad70f6a64db11d1980a91bd24124778d90904b51a7b3151ad8246c2b688&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- **인텔리제이의 설정에 가서 build tool에서 gradle에 가면 빨간색으로 마크한 부분에 gradle로 설정이 되어있는걸 IntelliJ IDEA로 변경해주면 서버를 띄울때 gradle을 통하지 않고 인텔리제이 툴에서 바로 자바를 실행시켜 훨씬 빨리 서버를 실행시킬 수 있다.**

# 라이브러리 살펴보기

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cf787a52-bb05-43be-be6e-ef36f1b00a3f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114822Z&X-Amz-Expires=86400&X-Amz-Signature=c8555b37162e44763c32d7965123ccef2da71c8159dd9fa9de2e2d7a01b70f8e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- 프로젝트의 라이브러리를 살펴보면 생각지도 못하게 엄청난 양의 라이브러리가 존재할 것이다.
- gradle이나 maven 같은 빌드 툴들은 의존 관계를 다 관리를 해준다.
    - spring-starter-web 라이브러리만 땡겨도 필요한 spring-starter-web 에 관련된 라이브러리 들까지 땡겨오는것이다.

![표시해놓은 gradle버튼을 누르면 오른쪽에 gradle정보가 표시가 된다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ba8404e1-7e19-43b4-83af-da095033684b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114858Z&X-Amz-Expires=86400&X-Amz-Signature=d760ff6218fb395ca53cef0f10c18e03adc1cebf4eb55f0189458258b0df762f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

표시해놓은 gradle버튼을 누르면 오른쪽에 gradle정보가 표시가 된다.

![기본적으로 spring-boot-starter-thymeleaf와 spring-boot-starter-web 라이브러리가 있고 해당 라이브러리들과 관련된 라이브러리들까지 땡겨오는걸 확인할 수 있다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4b29b317-d224-4db7-b39d-e27ba4f2afeb/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114931Z&X-Amz-Expires=86400&X-Amz-Signature=0fdaf227854826095f0c2bb3afe8813b06866d2e783d9225c1a2a48fe59ffec9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

기본적으로 spring-boot-starter-thymeleaf와 spring-boot-starter-web 라이브러리가 있고 해당 라이브러리들과 관련된 라이브러리들까지 땡겨오는걸 확인할 수 있다.

### 스프링 부트 라이브러리

- spring-boot-starter-web
    - spring-boot-starter-tomcat : 톰캣(웹서버)
    - spring-webmvc : 스프링 웹 MVC
- spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
- spring-boot-starter(공통) : 스프링 부트 + 스프링 코어 + 로깅
    - spring-boot
        - spring-core
    - spring-boot-starter-logging
        - logback, slf4j

### 테스트 라이브러리

- spring-boot-starter-test
    - junit : 테스트 프레임워크
    - mockito : 목 라이브러리
    - assertj : 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    - spring-test : 스프링 통합 테스트 지원

# View 환경설정

## Welcome Page 만들기

```html
<!DOCTYPE HTML>
<html>
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```

- 스프링 부트가 제공하는 Welcome Page 기능
    - static/index.html 을 올려두면 Welcome page 기능을 제공한다.
    - http://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page
    - [spring.io](http://spring.io) 스프링 참고 사이트

- thymeleaf 템플릿 엔진
    - - thymeleaf 공식 사이트 : http://www.thymeleaf.org/
    - 스프링 공식 튜토리얼 : https://spring.io/guides/gs/serving-web-content/
    - 스프링부트 메류얼 : https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-template-engines

## 동작 환경 그림

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/998d1801-b49d-404f-a90f-7c9bc0215e28/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T114958Z&X-Amz-Expires=86400&X-Amz-Signature=5c8274ba87d267f26ba2e32cf78060e7651806955cefa3751a192e86bc05d55a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- 컨트롤러에서 리턴 ㄱ밧으로 문자를 반환하면 뷰 리졸버(`viewResolver`)가 화면을 찾아서 처리한다.
    - 스프링 부트 템플릿엔진 기본 viewName 매핑
    - `resoureces:templates/` + {ViewName} + `.html`


> 참고: `spring-boot-devtools` 라이브러리를 추가하면, `html` 파일을 컴파일만 해주면 서버 재시지가 없이 View 파일 변경이 가능한다.
인텔리J 컴파일 방법 : 메뉴 build → Recompile
>

# 빌드하고 실행하기

## 콘솔로 이동

1. ./gradlew build
2. cd build/libs
3. java -jar hell-spring-0.0.1-SNAPSHOT.jar
4. 실행 확인

# 스프링 웹 개발 기초

- 정적 컨텐츠
- MVC와 템플릿 엔진
- API

## 정적 컨텐츠

- 스프링 부트 정적 컨텐츠 기능
- [https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static)-content

`resources/static/hello-static.html`

```html
<!DOCTYPE html>
<html>
<head>
    <title>static contnet</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
정적 컨텐츠 입니다.
</body>
</html>
```

*실행*

- `http://localhost:8080/hello-static.html`

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/13105a63-98e6-40cf-b063-d503a5288d40/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T115018Z&X-Amz-Expires=86400&X-Amz-Signature=784f4138dd18f375df5ec3765fa95c971f50ac0ac00f61375e7fb09534f8f83a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

*정적 컨텐츠 이미지*

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/eeaec0b7-fab3-4a13-89c9-1130e713664c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221225T115030Z&X-Amz-Expires=86400&X-Amz-Signature=b6ed570bc29670de193c67238b2882735ece2b5d8061394828e2e8b90841334d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)
# MVC와 템플릿 엔진

- MVC: Model, View, Controller
- 과거에는 View와 Controller가 분리되어 있지않고 View에서 모든걸 다 처리했다.
  - `모델 1` 방식이라고 한다.
- View는 화면에 관련된 일만 처리
- Controller는 비즈니스 로직과 서버 뒷단에 관련된 일만 처리

`HelloController`

```java
@Controller
public class HelloController {
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
```
※인텔리제이 팁 RequestParam에 커서를 넣고 ctrl + p 입력시 디폴트 값을 알 수 있다.

`hello-template`

```html
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>
</body>
</html>
```

*실행*

- [`http://localhost:8080/hello-mvc?name=spring`](http://localhost:8080/hello-mvc?name=spring)

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b1a6b59c-2e09-4c28-b8e2-c6ec77847b18/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221226%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221226T134006Z&X-Amz-Expires=86400&X-Amz-Signature=03077826a7c52bb7a64522a30ac406e2e0837e2ae3e41cc33f760c92a553243a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- ${name}에 spring이 들어간걸 확인할 수 있다.

# API

`@ResponseBody 문자 반환`

```java
@Controller
public class HelloController {
	
		@GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring"
    }
}
```

- `@ResponseBody`를 사용하면 뷰 리졸버 (`viewResolver`)를 사용하지 않음
- 대신에 HTTP의 BODY에 문자 내용을 직접 반화(HTML BODY TAG를 말하는 것이 아님)

*실행*

- [`http://localhost:8080/hello-string?name=spring`](http://localhost:8080/hello-string?name=spring)

`@ResponseBody 객체 반환`

```java
@Controller
public class HelloController {

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
```

※인텔리제이 팁 Getter 와 Setter 자동 생성키 중에 Win방식으로 alt + insert 키를 입력시 자동 생성이 가능한다.

- `@ResponseBody`를 사용하고, 객체를 반환하면 객체가  JSON으로 변환됨
- Getter와 Setter같은 `프로퍼티 접근방식`이라고도 불린다.

*실행*

- [`http://localhost:8080/hello-api?name=spring`](http://localhost:8080/hello-api?name=spring)

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/55544f35-1f76-43ab-9cda-57807fcab03f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221226%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221226T134120Z&X-Amz-Expires=86400&X-Amz-Signature=c7156ca3b8785aa2252fe57238d1fa1054dfe813d7e4f870a63cd608af2a5a13&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- `@ResponseBody`를 사용
  - HTTP의 BODY에 문자 내용을 직접 반환
  - `viewResolver`대신에 `httpMessageConverter`가 동작
  - 기본 문자처리: `StringHttpMessageConverter`
  - 기복 객체처리: `MappingJackson2HttpMessageConverter`
  - byte 처리 등등 기타 여러  HttpMessageConverter가 기본으로 등록되어 있음

> 참고: 클라이언트의 HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서
`HttpMessageConverter`가 선택된다.더 자세한 내용은 스프링 MVC강의에서 설명하겠다.
>

※클라이언의 HTTP Accept 해더: 클라이언트에서 서버에 요청시 Accept 값에 받고자 하는 형식을 입력해 해당 형식으로 받을 수 있다. ex) Ajax 또는 Axios에서 사용 가능
# 회원 도메인과 리포지토리 만들기

*회원 객체*

```java
package hello.hellspring.domain;

public class Member {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

*회원 리포지토리 인터페이스*

```java
package hello.hellspring.repository;

import hello.hellspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
```

*회원 리포지토리 구현체*

```java
package hello.hellspring.repository;

import hello.hellspring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member>  store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
```

findByName 메소드에서 Lambda 방식을 사용
Collection.values(): 해당 컬렉션의 value값들을 Collection을 반환
Collection.stream(): Collection 형식을 Stream으로 반환
Stream.filter(boolean): 인수로 받은 프리디케이트(boolean을 반환하는 함수)의 값에 의해 true를 만족하는 모든 요소를 Stream으로 반환
Stream.findAny(): Stream에서 가장 먼저 탐색되는 요소를 반환

# 회원 리포지토리 테스트 케이스 작성

개발한 기능을 실행해서 테스트 할 때 자바의 main메서드를 통해서 실행하거나, 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프로임워크로 테스트를 실행해서 이러한 문제를 해결한다.

*회원 리포지토리 메모리 구현체 테스트*

`src/test/java`하위 폴더에 생성한다.

```java
package hello.hellspring.repository;

import hello.hellspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
```

*클래스 명*

```java
class MemoryMemberRepositoryTest {
}
```

1. 평소 클래스와 다르게 앞에 public 이 빠져있는데 테스트 케이스이기에 굳이 public으로 안해줘도 된다.
2. 테스트 하고자하는 클래스명에 뒤에 Test를 붙여 작성한다.

*save1*

```java
@Test
public void save() {
    Member member = new Member();
    member.setName("spring");
    
    repository.save(member);
    
    Member result = repository.findById(member.getId()).get();
    Asserions.assertEquals(result, member);
}
```

1. repository.findById 메소드의 반환값이 Optional이므로 get() 함수를 통해 Member를 반환받을 수 있다.
2. 위와 같이 바로 get()으로 값을 받는 방법은 좋은 방법이 아니지만 테스트 코드이므로 바로 반환 받도록 작성하였다.
3. Assertions.assertEquals(expected, actual); expected(기대값)과 actual(실제값)을 비교해주는 함수이다.

*실행*

![실행을 하면 그냥 아무 출력된 로그없이 위와 같이 초록색으로 체크 모양이 표시됨.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/690133d2-3853-4dfc-b973-d5c0155a11a8/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115237Z&X-Amz-Expires=86400&X-Amz-Signature=67851e65215d6f08d99702857faddc225bedbd6322299960e27c2331a1506c21&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

실행을 하면 그냥 아무 출력된 로그없이 위와 같이 초록색으로 체크 모양이 표시됨.

*실행 - 인자가 서로 다를 경우*

![`Assertions.*assertEquals*(null, member);`
실행시 X 모양이 표시가 되고 에러로그가 출력된다. 필요(expected) 값이 null이고 실제(actual)값이 member의 객체값이 표시된다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6a5bdded-1b72-4f40-900c-2672f1251a28/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115255Z&X-Amz-Expires=86400&X-Amz-Signature=22037100bda4ce985ce815badf6960839bdb02104749a0e99b2ec724297f33d3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

`Assertions.*assertEquals*(null, member);`
실행시 X 모양이 표시가 되고 에러로그가 출력된다. 필요(expected) 값이 null이고 실제(actual)값이 member의 객체값이 표시된다.

*save2*

```java
import static org.assertj.core.api.Assertions.assertThat;

@Test
public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    assertThat(member).isEqualTo(result);
}
```

1. save1에서 사용한 Assertions는 JUnit에 내장되어 있는 클래스인데 요즘에는 assertj.core에 내장되어있는 Assertions가 사용하기 편해 많이 쓰는 추세입니다.
2. Assertions.assertThat(member).isEqualTo(result);에서 Assertions에 커서를 놓고 alt + enter를 입력시 org.assertj.core.api.Assertions.assertThat를 import해서 그냥 assertThat을 사용가능하다.
3. assertThat(actual).isEqualTo(expected); 똑같이 expected(기대값)과 actual(실제값)을 비교해주는 함수이다.

*findByName*

```java
@Test
public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);
}
```

*실행*

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6427e5b6-cb7d-4812-a374-0b62fdee1363/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115314Z&X-Amz-Expires=86400&X-Amz-Signature=9a9b04e318e6fa83183fe25ecc0b497751acb0c0647e92d6c1e9fab4902c9c96&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

*실행 - 인자가 서로 다를 경우*

![*`assertThat*(result).isEqualTo(member2);`
필요값에 member1의 객체값이 표시,
실제값에 member2의 객체값이 표시된다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/34a4f220-0dac-4758-8b1f-21dda3513644/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115330Z&X-Amz-Expires=86400&X-Amz-Signature=929b8d788f979eefd3d900b82b4f36e5a82b23045c8733593a3361a37a45d2df&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

*`assertThat*(result).isEqualTo(member2);`
필요값에 member1의 객체값이 표시,
실제값에 member2의 객체값이 표시된다.

*findAll*

```java
@Test
public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);
}
```

*실행*

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0f4e9ce1-2df1-4d31-9917-fddbf259f129/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115354Z&X-Amz-Expires=86400&X-Amz-Signature=3bb0bb684c7d19adfe37cc88d6e9594feff4549f06bac7454941d3dac9f5ab4b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

*실행 - 인자가 서로 다를 경우*

![*`assertThat*(result.size()).isEqualTo(3);`
위와 같이 필요값과 실제값이 표시된다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e9459388-aa47-4f4a-9200-090b49a0ecb2/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115406Z&X-Amz-Expires=86400&X-Amz-Signature=b75c7ed4efecc86ade8b54d9d33bc34a6599e10c69d0fdda42c2bcf7c067a323&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

*`assertThat*(result.size()).isEqualTo(3);`
위와 같이 필요값과 실제값이 표시된다.

*테스트 클래스를 한번에 실행*

![빨갛게 표시된 부분을 클릭하면 정의되어 있는 테스트들이 한번에 모두 실행이 된다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1963393e-6a9e-4c91-ab61-234ea6d739c6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115420Z&X-Amz-Expires=86400&X-Amz-Signature=feca427d371fb07f8319e2710c1a0ecf53ef6849665c2b1f31b3d772dd9f7a56&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

빨갛게 표시된 부분을 클릭하면 정의되어 있는 테스트들이 한번에 모두 실행이 된다.

*현재 테스트 클래스 소스*

```java
package hello.hellspring.repository;

import hello.hellspring.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
```

*실행*

![findAll()이 먼저 실행되고 findByName()이 실패한걸 확인 할 수 있다.
테스트 소스를 한번에 실행 시 순서보장이 안되기 때문에 MemoryMemberRepository의 로컬변수 store에는 findAll() 함수에서 member 객체가 두 개 들어가고 findByName() 함수에서 또 name값이 같은 member 객체가 두 개가 들어가서 findByName에서 두 객체를 비교할때 result에 반환된 객체가 findAll() 함수에서 입력한 member객체이기에 실패하는 것을 확인할 수 있다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f4a216c3-9912-4e9d-910c-99ec31ff37d2/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221228%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221228T142219Z&X-Amz-Expires=86400&X-Amz-Signature=d5e0caef418785aa3a5edcba2820f9eb2ceff0b559ade0f28783e7f82304bf4d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

findAll()이 먼저 실행되고 findByName()이 실패한걸 확인 할 수 있다.
테스트 소스를 한번에 실행 시 순서보장이 안되기 때문에 MemoryMemberRepository의 로컬변수 store에는 findAll() 함수에서 member 객체가 두 개 들어가고 findByName() 함수에서 또 name값이 같은 member 객체가 두 개가 들어가서 findByName에서 두 객체를 비교할때 result에 반환된 객체가 findAll() 함수에서 입력한 member객체이기에 실패하는 것을 확인할 수 있다.

*해결방법*

*MemoryMemberRepository*

```java
public void clearStore() {
    store.clear();
}
```
MemoryMemberRepository 클래스에 해당 함수를 정의해준다.
store.clear() → Collection에 값들을 비워준다.

*MemoryMemberRepositoryTest*

`MemberRepository repository -> MemoryMemberRepository repository로 변경`

```java
@AfterEach
public void afterEach() {
    repository.clearStore();
}
```
@AfterEach는 테스트 메소드가 끝나고 호출되는 callback 메소드이다.

*실행*

![모두 정상적으로 실행되는걸 확인할 수 있다.](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/09a0a8aa-c2cb-4aac-a705-a1d83df87193/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221227%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221227T115454Z&X-Amz-Expires=86400&X-Amz-Signature=0b4e42e6f1a98c0185975dce22e58f0a4418a0314ab2919506a16ea6fff99cad&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

모두 정상적으로 실행되는걸 확인할 수 있다.

### 테스트 주도 개발 (Test Driven Development의 약자 TDD)

- 반복 테스트를 이용한 소프트웨어 방법~~~~론으로 작은 단위의 테스트 케이스를 작성하고 이를 통과하는 코드를 추가하는 단계를 반복하여 구현하는것을 말한다.
