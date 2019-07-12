package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem; 
import org.apache.commons.fileupload.FileUploadException; 
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload; 
import org.apache.commons.io.FileUtils;

import com.bean.URIGenerate;
import com.bean.User;
import com.db.DAO.UserDAO;
import com.sun.xml.internal.bind.v2.runtime.Location;

/**
 * Servlet implementation class ChangeInfo
 */
@WebServlet("/ChangeInfo")
public class ChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try{
			// TODO Auto-generated method stub
			User user = (User)request.getSession().getAttribute("User");
			String name="" ,password="" ,gender="" ,tel="" ,address="" ,mail="",filePath="";;
			response.setContentType("text/html");
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        List items = null;
	        try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
	        while (iter.hasNext()) {
	            FileItem item = (FileItem) iter.next();
	            if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
	                String value = item.getString("UTF-8"); // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
	                if (item.getFieldName().equals("reset-name")) {// 对应form中属性的名字
	                    name = value;
	                } 
	                else if (item.getFieldName().equals("reset-pass")) {
	                    password = value;
	                }
	                else if (item.getFieldName().equals("reset-gender")) {
	                	if(value.equals("man"))
	                		gender = "man";
	                	else 
	                		gender = "woman";
	                }
	                else if (item.getFieldName().equals("reset-tel")) {
	                    tel = value;
	                }
	                else if (item.getFieldName().equals("reset-address")) {
	                    address = value;
	                }
	                else if (item.getFieldName().equals("reset-mail")) {
	                    mail = value;
	                }
	            } else {
	            	//获得web服务器根目录
	            	String webroot =this.getClass().getClassLoader().getResource("").getPath();
	            	int index = webroot.indexOf(".metadata");
	            	webroot=webroot.substring(0, index-1);
	            	webroot=webroot+"\\"+request.getServletContext().getContextPath().substring(1)+"\\"+"WebContent";
	            	String fileName = item.getName();
	            	index = fileName.lastIndexOf(".");
	            	if(index == -1){
	            		filePath = user.getHeader();
	            		break;
	            	}
	                String typeString = fileName.substring(index);
	                String saveName = URIGenerate.getRandomString(10) + typeString;
	                File root = new File(webroot);
	                String mimeType = item.getContentType();
	                String fileType = mimeType.substring(0, mimeType.indexOf("/"));
	                File dirFile = new File(root, fileType);
	                dirFile.mkdir();
	                File child = new File(dirFile, saveName);
	                filePath = child.getAbsolutePath();
	                index = filePath.lastIndexOf("\\",filePath.lastIndexOf("\\")-1);
	                filePath = filePath.substring(index+1);
	                index = filePath.lastIndexOf("\\");
	                StringBuilder sb = new StringBuilder(filePath);
	                sb.replace(index, index+1, "/");
	                filePath = ""+sb;
	                try {
						item.write(child);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
	        System.out.println(filePath);
        	if(user!=null){
        		if(UserDAO.nameIsExist(name)&&!user.getUserName().equals(name)){
 		        	response.setCharacterEncoding("utf-8");
 	 		        PrintWriter out = response.getWriter();
 	 		        out.print("<script>alert('您申请修改的用户名已经存在，请重新修改个人信息!');window.location.href='changeinfo.jsp'</script>");
 		        }
        		else{
        			if(filePath.contains("application"))
        				filePath = user.getHeader();
        			String ID = user.getUserID();
        			String label=user.getLabel();
        			User user2 = new User(name, password, gender, tel, mail, address,filePath);
        			user2.setUserID(ID);
        			user2.setLabel(label);
     		        HttpSession session = request.getSession();
     		        session.setAttribute("User", user2);
     		        UserDAO.update(user2);
     		        response.setCharacterEncoding("utf-8");
     		        PrintWriter out = response.getWriter();
     		        if(user.getLabel().equals("admin"))
     		        	out.print("<script>alert('修改个人信息成功!');window.location.href='admin.jsp'</script>");
     		        else {
     		        	out.print("<script>alert('修改个人信息成功!');window.location.href='index.jsp'</script>");
					}
        		}
        	}
 	        else{
 	        	//不可能出现的状况，应在登录后进入个人信息界面点击进行信息更改。
 	        	response.setCharacterEncoding("utf-8");
 		        PrintWriter out = response.getWriter();
 		        out.print("<script>alert('您未登录');window.location.href='index.jsp'</script>");
 	        }
		}catch(Exception e){
			System.out.println(e);
			response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        out.print("<script>alert('修改个人信息失败!');window.location.href='index.jsp'</script>");
		}
	}

}
