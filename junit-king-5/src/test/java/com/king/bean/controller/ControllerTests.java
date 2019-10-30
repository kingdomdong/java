package com.king.bean.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@ExtendWith(SpringExtension.class)

// Fix me 1:
// Did not detect default resource location for test class [com.king.controller.ControllerTests]: 
// class path resource [com/king/controller/ControllerTests-context.xml] does not exist

// Fix Me 2: why TemplateConfig.class error?
//@ContextConfiguration(classes = { JunitApplication.class }) // (locations = "classpath*:/TemplateConfig.class")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) // , classes = ControllerTests.class)
public class ControllerTests {

	@MockBean
	public TestRestTemplate restTemplate;

	@Test
	public void controllerTest() {
		String msg = restTemplate.getForObject("http://localhost:8080/test/hello", String.class);
		assertEquals("Hello World!", msg);
	}

}
