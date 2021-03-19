package com.mit.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	@Test
	public void testConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/user", "book_ex", "1234");
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
			fail("앗 db 접속 실패했다");
		}
	}
}
