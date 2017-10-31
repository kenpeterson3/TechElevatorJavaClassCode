package com.techelevator.project;

import java.util.List;

public interface DestinyDAO {
	
	public List<Member> getMemberList();
	public void saveNewMember(Member postNewMember);
	public void updateWinsAndLosses(Member updateWinsAndLosses);

}
