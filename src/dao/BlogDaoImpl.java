package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import model.Blog;

import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	public void insertBlog(Blog blog) throws ClassNotFoundException,Exception {

		ConnectionManager con = new ConnectionManager();
		
		
		int id = blog.getBlogId();
		String blogtitile = blog.getBlogTitle();
		String blogDescription = blog.getBlogDescription();
		LocalDate postedon = blog.getPostedOn();
			
		
			String sql ="insert into blog(BLOGID,BLOGTITLE,blogDescription,postedOn)VALUES(?,?,?,?)";
			PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
			
			st.setInt(1, id);
			st.setString(2,blogtitile );
			st.setString(3, blogDescription);
			st.setDate(4, java.sql.Date.valueOf(postedon));
			System.out.println("Testing");
			System.out.println(id);
			System.out.println(blogtitile);
			System.out.println(java.sql.Date.valueOf(postedon));
			
			st.executeQuery();
			
		
	}

	public List<Blog> selectAllBlogs() {
		
		List<Blog> blogs = new ArrayList<Blog>();
		ConnectionManager con = new ConnectionManager();
		
		try {
			Statement st = ConnectionManager.getConnection().createStatement();
			String sql = "select * from  BLOG";
			ResultSet res = st.executeQuery(sql);
			while(res.next()) {
				int blogId =res.getInt("blogId");
				String blogTitle = res.getString("blogTitle");
				String blogDescription = res.getString("blogDescription");
				Blog b = new Blog();
				b.setBlogDescription(blogDescription);
				b.setBlogId(blogId);
				b.setBlogTitle(blogTitle);
		
				blogs.add(b);
			}
			
			return blogs;

			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
	
}