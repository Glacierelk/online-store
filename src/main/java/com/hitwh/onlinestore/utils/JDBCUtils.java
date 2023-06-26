package com.hitwh.onlinestore.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
	private static DataSource ds;
	static {
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pp = new Properties();
		try {
			pp.load(is);
			ds = DruidDataSourceFactory.createDataSource(pp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return ds;
	}
}