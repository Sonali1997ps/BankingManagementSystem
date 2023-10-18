package dao;

import model.Branch;

public interface BranchDAO {
	
	int createBranch(Branch branch);
	
	void updateBranch(Branch branch);

    void removeBranch(int branch_id);
    
    Branch getBranchById(int branch_id);

}
