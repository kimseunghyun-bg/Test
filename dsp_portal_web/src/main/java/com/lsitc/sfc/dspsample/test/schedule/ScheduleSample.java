package com.lsitc.sfc.dspsample.test.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Slf4j
public class ScheduleSample {

	@Scheduled(cron = "0 0/10 * * * ?")
	public void start() {
		log.debug("{} - {}", this.getClass().getName(), LocalTime.now());
	}

}
