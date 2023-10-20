package controller;

import java.sql.SQLException;
import java.util.List;

import dao.BranchDAO;
import dao.BranchDAOImpl;
import model.Branch;

public class BranchController {
	BranchDAO branchDaoImpl = new BranchDAOImpl();
	public int createBranch(Branch branch) throws SQLException{
	
		return branchDaoImpl.createBranch(branch);
		
	}
	
	public int updateBranch(String columnName, String value, int branchId) throws SQLException{
	
		return branchDaoImpl.updateBranch(columnName, value, branchId);
		
	}
	
	public void removeBranch(int branchId) throws SQLException{
			
		branchDaoImpl.removeBranch(branchId);
		
	}
	
	public Branch getBranchDetails(int branchId) throws SQLException{
	
		return branchDaoImpl.getBranchById(branchId);
		
	}
	
}

