package dao;

import java.sql.SQLException;

import model.Branch;

public interface BranchDAO {
	
	int createBranch(Branch branch) throws SQLException;

    void removeBranch(String branch_id) throws SQLException;
    
    Branch getBranchById(String branch_id) throws SQLException;

	int updateBranch(String columnName, String value, String branchId) throws SQLException;

}
