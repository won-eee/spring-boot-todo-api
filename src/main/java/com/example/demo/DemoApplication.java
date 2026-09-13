package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(MemberRepository memberRepository){
		return args -> {
			memberRepository.save(new Member("홍길동"));
			memberRepository.save(new Member("이순신"));
			System.out.println("샘플 데이터 저장 완료");
		};
	};

}



