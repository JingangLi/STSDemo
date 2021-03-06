package com.ljg.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ljg.test.didispace.web.HelloController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloApplicationTest.class)
@WebAppConfiguration
public class HelloApplicationTest {

	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup( new HelloController()).build();
	}
	
	@Test
	public void hello() throws Exception {
//		mvc.perform( MockMvcRequestBuilders.get("/hello").accept( MediaType.APPLICATION_JSON ) )
//				.andExpect( status().isOk() )
//				.andExpect( status().isOk() )
//				.andExpect( content().string( HelloController.strHelloWorld ) ) ;
	}
}
