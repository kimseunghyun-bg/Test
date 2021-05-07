package com.lsitc.sfc.dspsample.test.schedule;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleSample {

	@Scheduled(cron="0/10 * * * * ?")
	public void start(){
		System.out.println(this.getClass().getName() + "-" + LocalTime.now());
	}

}
