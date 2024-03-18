package com.test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseAsciiTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReverseSingleContent() throws Exception {
		List<String> content = new ArrayList<String>();
		content.add("ABC");
		List<String> reverseContent = ReverseAsciiFileContents.reverseContent(content);
		assertTrue(reverseContent.size() == 1 && reverseContent.contains("CBA"));		
	}
	
	@Test
	void testReverseMultipleContent() throws Exception {
		List<String> content = new ArrayList<String>();
		content.add("ABC DEF");
		content.add("MNO");

		List<String> reverseContent = ReverseAsciiFileContents.reverseContent(content);
		assertTrue(reverseContent.size() == 2 &&  reverseContent.contains("FED CBA") && reverseContent.contains("ONM"));		
	}
	
	@Test
	void testReverseNonAsciiContent() throws Exception {
		List<String> content = new ArrayList<String>();
		content.add("é");

		Throwable exception = assertThrows(Exception.class, () -> ReverseAsciiFileContents.reverseContent(content));
	    assertEquals("content is non ASCII", exception.getMessage());
	}

}
