package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

interface BlogDaoInterface {
  void insertBlog (Blog blog) throws SQLException, ClassNotFoundException, Exception;
		
  
	 List<Blog> selectAllBlogs()throws SQLException;
}
