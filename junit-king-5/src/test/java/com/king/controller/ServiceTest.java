package com.king.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.king.service.PropertyService;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration // https://stackoverflow.com/questions/55500144/java-lang-illegalstateexception-the-webapplicationcontext-for-test-context
//@ContextConfiguration
//@ExtendWith(MockitoExtension.class)
class ServiceTest {

//	@InjectMocks // Not @Mock
	@Autowired
	PropertyService propertyService;

//	PropertyService propertyService = mock(PropertyService.class);

	@Test
	public void test() {
		assertAll(() -> assertEquals("XinKing", propertyService.getAdmin().getName()),
				() -> assertEquals("654321", propertyService.getAdmin().getPassword()));
	}

}