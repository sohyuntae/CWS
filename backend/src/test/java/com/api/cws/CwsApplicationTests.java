package com.api.cws;

import com.api.cws.domain.Qstm_info;
import com.api.cws.domain.stm_info;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CwsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private JPAQueryFactory queryFactory;

	@Test
	void basic() {
		List<stm_info> test = queryFactory
				.selectFrom(Qstm_info.stm_info)
				.fetch();

		System.out.println(test);
	}

}
