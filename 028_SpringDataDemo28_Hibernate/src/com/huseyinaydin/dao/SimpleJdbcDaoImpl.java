package com.huseyinaydin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SimpleJdbcDaoImpl extends JdbcDaoSupport {
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM circle";
		List<Map<String, Object>> lists = this.getJdbcTemplate().queryForList(sql);
		lists.forEach(i->System.out.println(i));
		int value = 0;
		for(int i = 0; i < lists.size(); i++) {
			value = (int) lists.get(i).get("name");
		}
		return value;
	}
}
