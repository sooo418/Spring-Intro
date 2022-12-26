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

- `@ResponseBody`를 사용하고, 객체를 반환하면 객체가  JSON으로 변환됨
- Getter와 Setter같은 `프로퍼티 접근방식`이라고도 불린다.

*실행*

- [`http://localhost:8080/hello-api?name=spring`](http://localhost:8080/hello-api?name=spring)

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/55544f35-1f76-43ab-9cda-57807fcab03f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221226%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221226T134120Z&X-Amz-Expires=86400&X-Amz-Signature=c7156ca3b8785aa2252fe57238d1fa1054dfe813d7e4f870a63cd608af2a5a13&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject~~~~)

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