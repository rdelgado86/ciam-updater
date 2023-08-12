package com.pluxee.ciamupdater;

import com.pluxee.ciamupdater.domain.service.FilesStorageService;
import jakarta.annotation.Resource;
import java.time.LocalDate;
import org.apache.commons.lang3.RegExUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CiamUpdaterApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		String s = "Testing abc123.555abc";
		String result = RegExUtils.removeAll(s, "[^\\d]");


		var date = LocalDate.now().minusMonths(1).toString();
		System.out.println(date.replaceAll("-", ""));

		SpringApplication.run(CiamUpdaterApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}
}
