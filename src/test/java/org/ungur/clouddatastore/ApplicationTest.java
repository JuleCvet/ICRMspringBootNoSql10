package org.ungur.clouddatastore;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
// @SpringBootTest
// @WebMvcTest(UserController.class)
public class ApplicationTest {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void rendersForm() throws Exception {
		mockMvc.perform(get("/login")).andExpect(content().string(containsString("Form")));
	}

	@Test
	public void submitsForm() throws Exception {
		mockMvc.perform(post("/login").param("email", "julijana.cvetkovska@gmail.com").param("password", "Julijana123"))
				.andExpect(content().string(containsString("welcome")))
				.andExpect(content().string(containsString("email: julijana.cvetkovska@gmail.com")));
	}

}
