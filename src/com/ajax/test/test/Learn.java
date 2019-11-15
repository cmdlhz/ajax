package com.ajax.test.test;

public class Learn {
	
}

/*

Java, HTML, JavaScript, jsp, Tomcat, Maven, git, jenkins, Linux
devops, hadoop, R, ....

trimDirectiveWhitespaces="true" // white spaces 제거

<% 실행문 
<%@ 지시자
<%! 선언문
<%= 표현식

jsp file : browser에서 번역되는 게 아니다
servlet 자바로 만들고 => class로 만들고
그 다음 일련의 과정을 통해 번역되는 것이다.

WebContent
WEB-INF : 외부에서 접근 안 됨!

Servlets => 기본은 doGet & doPost

JSTL => mvnrepository에서 download! 하거나 build path를 추가하지 않았는데
lib에서 extension 추가해서 계속 왔다갔다하는 것도 메모리 소비
없어도 pom.xml에 추가하면 (maven directory) in WebContent
<!-- jstl 1.2 --> 

 */
/*
scope: request > page

index.jsp

<c:set var="name" value="Page Scope" />
<c:set var="name" value="Request Scope" scope="request"/>
<% request.setAttribute("name", "Request Scope"); %>
// 둘이 같은 것 (위, 바로 위)

${name}                             				 // Page Scope
${requestScope.name}				// Request Scope
<%= request.setAttribute("name") %>	// Request Scope

다른 page로 가면 요청이 사라짐
name of req scope : ${name} <br>							// (아무것도 안 나옴)
name of req scope : <%= request.setAttribute("name") %><br>		// null
name of parameter : ${param.name}						// (아무것도 안 나옴)
=> parameter 값으로 뭘 안 넣어줬다면


jspl은 빈 문자열로 처리하지만
jsp에서는 null로 처리함 => map 구조여서

해결방법 : forward를 해주면 됨
RequestDispatcher rd = request.getRequestDispatcher(“(링크)”);
rd.forward(request, response);

 */
/*

Server - Client
(server가 client에게 요청을 보낼 수 없음)
=> 보낼 수 있게 하려면 web socket을 사용해야 함

socket 통신
=> 자바로 만드는 건 쉬움
        => Tomcat도 socket으로 만들어짐
=> C에서는 어려움


그런데, 이해하는 게 쉽지 않음 
=> Thread를 이해해야함
(다방향 통신)

 */