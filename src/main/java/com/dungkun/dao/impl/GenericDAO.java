package com.dungkun.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dungkun.dao.IGenericDAO;
import com.dungkun.mapper.IRowMapper;

public class GenericDAO<T> implements IGenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/testproject";
			String user = "root";
			String password = "Dg142001";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public void setParamaters(PreparedStatement statement, Object... parameters) {
		if (parameters != null) {
			int index = 1;
			try {
				for (Object param : parameters) {
					if (param instanceof Long) {
						statement.setLong(index, (Long) param);
					} else if (param instanceof String) {
						statement.setString(index, (String) param);
					} else if (param instanceof Timestamp) {
						statement.setTimestamp(index, (Timestamp) param);
					}  else if (param instanceof Integer) {
						statement.setInt(index, (Integer) param);
					}
					++index;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> mapper, Object... parameters) {
		List<T> allLists = new ArrayList<>();

		// connect database
		Connection connection = getConnection();

		// query database
		ResultSet resultSet = null;
		PreparedStatement statement = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				setParamaters(statement, parameters);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					allLists.add(mapper.mapRow(resultSet));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				try {
					if (statement != null)
						statement.close();
					if (resultSet != null)
						resultSet.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return allLists;
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Long id = null;

		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				setParamaters(statement, parameters);
				statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					id = resultSet.getLong(1);
				}

				connection.commit();
				return id;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {

				try {
					if (statement != null)
						statement.close();
					if (resultSet != null)
						resultSet.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return null;

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				statement = connection.prepareStatement(sql);
				setParamaters(statement, parameters);
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {

				try {
					if (statement != null)
						statement.close();
					if (resultSet != null)
						resultSet.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		int count = 0;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				setParamaters(statement, parameters);
				resultSet = statement.executeQuery();
				if (resultSet.next()) {
					count = resultSet.getInt(1);
				}

				return count;
			} catch (SQLException e) {
					e.printStackTrace();
			} finally {

				try {
					if (statement != null)
						statement.close();
					if (resultSet != null)
						resultSet.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return 0;
	}
}
