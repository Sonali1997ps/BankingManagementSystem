package dao;

import java.sql.SQLException;

import model.Branch;

public interface BranchDAO {
	
	int createBranch(Branch branch) throws SQLException;

    void removeBranch(int branch_id) throws SQLException;
    
    Branch getBranchById(int branch_id) throws SQLException;

	int updateBranch(String columnName, String value, int branchId) throws SQLException;

}
