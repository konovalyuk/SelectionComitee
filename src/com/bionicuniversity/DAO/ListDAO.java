package com.bionicuniversity.DAO;

import com.bionicuniversity.beans.List;

public interface ListDAO {
	public boolean add(List list);

	public boolean getStatus(final int id);

	public void changeStatus(final int id);
}
