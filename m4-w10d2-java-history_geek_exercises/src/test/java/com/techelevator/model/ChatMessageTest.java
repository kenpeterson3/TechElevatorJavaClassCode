package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChatMessageTest {

	@SuppressWarnings("deprecation")
	@Test
	public void returned_date_should_equal_local_date() {
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setSentDate(LocalDateTime.of(LocalDate.of(2017, Month.FEBRUARY, 03), LocalTime.of(4, 45)));
		
		assertEquals(new Date("2017 Feb 03 04:45"), chatMessage.getSentDateAsDate());
	}

}
