
package com.lecky.student.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class TestUtils {

	public static <T> T generateObject(String path, Class<T> clazz) throws IOException {
		return new ObjectMapper()
				.readValue(new ClassPathResource(path).getInputStream(), clazz);
	}

	public static <T> List<T> generateList(String path, Class<T> clazz) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(
				new ClassPathResource(path).getInputStream(),
				mapper.getTypeFactory().constructCollectionType(List.class, clazz)
		);
	}

}
