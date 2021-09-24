package com.example.CharusatUniversity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CharusatUniversityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void getsAllDetails() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/department")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getsSingleDetail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/department/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	@Test
	public void returnsNotFoundForInvalidSingleCourse() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/department/40000000")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}
	@Test
	public void addsNewDepartment() throws Exception {
		String newCourse = "{\"name\":\"Dummy department\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/department")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newCourse)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andReturn();
	}


}
