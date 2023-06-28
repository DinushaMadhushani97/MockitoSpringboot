package lk.icta.mockito.mockito;

import org.junit.Before;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lk.icta.mockito.mockito.entity.Response;
import lk.icta.mockito.mockito.entity.User;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
class MockitoApplicationTests {
	
private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@org.junit.Test
	public void addUserTest() throws Exception {
	User user = new User();
	user.setName("icta");
	user.setRole("Admin");
	System.out.println("000000000000000000000000000");
	String JsonRequest = objectMapper.writeValueAsString(user);
	
	MvcResult result = mockMvc.perform(post("/user/userRegistration").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk()).andReturn();
	
	String resultContext = result.getResponse().getContentAsString();
	
	Response response = objectMapper.readValue(resultContext, Response.class);
	
	Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
	}
	
	@org.junit.Test
	public void getUserTest() throws Exception {
	
	MvcResult result = mockMvc.perform(get("/user/userDetails").contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk()).andReturn();
	
	String resultContext = result.getResponse().getContentAsString();
	
	Response response = objectMapper.readValue(resultContext, Response.class);
	
	Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
	}	
	

}