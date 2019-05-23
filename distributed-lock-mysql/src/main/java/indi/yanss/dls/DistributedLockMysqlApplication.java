package indi.yanss.dls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DistributedLockMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedLockMysqlApplication.class, args);
	}

}
