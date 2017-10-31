package com.techelevator.project;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcDestinyDao implements DestinyDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcDestinyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Member> getMemberList() {
		List<Member> memberList = new ArrayList<>();
		String sqlSelectMemberList = "SELECT * FROM members";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMemberList);
		while(results.next()) {
			Member member = new Member();
			member.setId(results.getLong("id"));
			member.setFirstName(results.getString("first_name"));
			member.setLastName(results.getString("last_name"));
			member.setWins(results.getInt("wins"));
			member.setLosses(results.getInt("losses"));
			memberList.add(member);
		}
		return memberList;
	}	
	
	@Override
	public void saveNewMember(Member postNewMember) {
		String sqlInsertMember = "INSERT INTO members(first_name, last_name, wins, losses) VALUES (?,?,?,?) RETURNING id";
		Long id = jdbcTemplate.queryForObject(sqlInsertMember, Long.class, postNewMember.getFirstName(), postNewMember.getLastName(), postNewMember.getWins(), postNewMember.getLosses());
		postNewMember.setId(id);
	}
	@Override
	public void updateWinsAndLosses(Member updateWinsAndLosses) {
		String sqlInsertUpdateWinsAndLosses = "Update members(id, wins, losses) VALUES (?,?,?) ";
		jdbcTemplate.queryForObject(sqlInsertUpdateWinsAndLosses, Long.class, updateWinsAndLosses.getWins(), updateWinsAndLosses.getLosses());
		
	}
}
