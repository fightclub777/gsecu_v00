#gsecu_v0.0

1. 개요.
	gsecu_v0.0은 Spring Security 단계별 스터디 프로젝트를 진행하기 위한 기반 프로젝트이다.
	이 프로젝트는 웹 및 Spring Web, Spring Security 프로젝트를 진행하기 위한 
	라이브러리를 등록하고 본격적으로 시작하기 위한 준비작업을 한다.
	또한, 차후 단계별로 진행할 Spring Security의 테스트 시나리오를 작성한다.
	
	본 프로젝트는 Maven Project의 webapp 1.0 모듈을 통해 만들었으며,
	Servlet3.0을 지원하기 위해 '.settings' 디렉토리에 
	'org.eclipse.wst.common.project.facet.core.xml'파일의 
	'jst.web'의 버전을 '3.0'으로 변경한다.
	JDK는 1.8을 사용한다.
	WAS는 tomcat을 사용할 것이나, Servlet3.0을 지원하는 7.0이후로 사용하여야 한다.
	테스트는 8.5로 할 것이다.
  
2. 목표.
	1) Maven(pom.xml)에 Servlet,JSP,JSTL를 추가하여 기본 웹프로젝트를 시작할 수 있도록 한다.
	2) Maven(pom.xml)에 Spring WebMVC를 추가하여 Spring기반 웹프로젝트를 시작할 수 있도록 한다.
	3) Maven(pom.xml)에 Spring Security를 추가하여 Spring Security를 시작할 수 있도록 한다.
	4) 프로젝트를 tomcat서버를 통해 실행하여 WEB 화면(index.jsp)이 출력되는 것을 확인한다.
	5) Spring Security를 통한 사용자 인증 및 권한 처리에 대한 테스트 시나리오 수립.
	6) 테스트 시나리오에 따른 디렉토리 구조 생성.
	7) 테스트 시나리오에 따른 파일 구조 생성.

3. 주요내용.
	3.1. Spring WEB(MVC) + Spring Security를 Maven(pom.xml)에 추가.
		1) pom.xml에 Servlet 추가.
			<dependency>
				<groupId>javax.servlet</groupId>
				<artifactId>javax.servlet-api</artifactId>
				<version>3.0.1</version>
				<scope>provided</scope>
			</dependency>
			
		2) pom.xml에 JSP 추가.
			<dependency>
				<groupId>javax.servlet.jsp</groupId>
				<artifactId>javax.servlet.jsp-api</artifactId>
				<version>2.3.1</version>
				<scope>provided</scope>
			</dependency>
			
		3) pom.xml에 JSTL 추가.
			<dependency>
				<groupId>javax.servlet</groupId>
				<artifactId>jstl</artifactId>
				<version>1.2</version>
				<scope>runtime</scope>
			</dependency>
		
		4) pom.xml에 Spring WebMVC 추가.
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-webmvc</artifactId>
				<version>4.2.9.RELEASE</version>
			</dependency>
			
		5) pom.xml에 Spring Security 추가.
			<dependency>
				<groupId>org.springframework.security</groupId>
				<artifactId>spring-security-web</artifactId>
				<version>${spring-framework-security.version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework.security</groupId>
				<artifactId>spring-security-config</artifactId>
				<version>${spring-framework-security.version}</version>
			</dependency>
	3.2. web.xml, servlet-context.xml을 설정.
		1) web.xml 설정.
			<servlet>
				<servlet-name>dispatcher</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>contextConfigLocation</param-name>
					<param-value>/WEB-INF/spring-servlet.xml</param-value>
				</init-param>
				<load-on-startup>1</load-on-startup>
			</servlet>
			<servlet-mapping>
				<servlet-name>dispatcher</servlet-name>
				<url-pattern>/</url-pattern>
			</servlet-mapping>
			
		2) servlet-context.xml 설정.
			<context:component-scan base-package="net.gongple.gsecu" />
			<mvc:annotation-driven />
			<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			    <property name="prefix">
			        <value>/WEB-INF/views/</value>
			    </property>
			    <property name="suffix">
			        <value>.jsp</value>
			    </property>
			</bean>
			
	3.3. 사용자 인증 및 권한 처리에 대한 테스트 시나리오 수립.
		1) 사용자의 역할을 구분하자.
			1-1) 사용자는 '관리자'와 '사용자'로 역할을 구분한다.
			1-2) 관리자는 '최고관리자', '중간관리자', '실무관리자'로 역할을 구분한다.
			
		2) 각각의 역할별로 로그인 사용자를 만들자.
			2-1) 최고관리자.
				- id/pw : hadmin/1234
			2-2) 중간관리자.
				- id/pw : madmin/1234
			2-3) 실무관리자.
				- id/pw : ladmin/1234
			2-4) 사용자.
				- id/pw : user/1234
			2-5) 실무관리자이면서 사용자.
				- id/pw : adminuser/1234
		
		3) 사이트 맵을 구성하자.
			3-1) 최고관리자 화면.
				- url : /admin/h
				- jsp : /WEB-INF/views/admin/high_admin.jsp
			3-2) 중간관리자 화면.
				- url : /admin/m
				- jsp : /WEB-INF/views/admin/medium_admin.jsp
			3-3) 실무관리자 화면.
				- url : /admin/l
				- jsp : /WEB-INF/views/admin/low_admin.jsp
			3-4) 사용자 화면 IN.
				- url : /user/in
				- jsp : /WEB-INF/views/in.jsp
			3-5) 사용자 화면 OUT.
				- url : /user/out
				- jsp : /WEB-INF/views/out.jsp
			3-6) 로그아웃.
				- url : /logout
				- jsp : 없음
				
		4) URL별로 접근가능한 역할을 설정하자.
			4-1) /admin/h
				- 접근가능 역할 : 
					최고관리자
			4-2) /admin/m
				- 접근가능 역할 : 
					중간관리자
					최고관리자
			4-3) /admin/l
				- 접근가능 역할 : 
					실무관리자
					중간관리자
					최고관리자
			4-4) /user/in
				- 접근가능 역할 : 
					사용자
					실무관리자
					중간관리자
					최고관리자
			4-5) /user/out
				- 접근가능 역할 : 
					사용자
					실무관리자
					중간관리자
					최고관리자
			
		5) 화면(index.jsp)에 테스트용 메뉴를 만들고 메뉴별로 url을 연결하자.
			4-1) 메뉴 첫째줄.
				- '최고관리자', '중간관리자', '실무관리자', '사용자IN', '사용자OUT'
			4-2) 메뉴 둘째줄.
				- 'LOGOUT'
		
		6) 권한을 갖지 않는 역할을 눌렀을 때 Spring Security가 작동하여 접근이 불가능한지 확인하자.
		
		7) 로그아웃 기능을 만들고 올바로 작동하는지 확인하자.	
	