package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
import org.apache.naming.java.javaURLContextFactory;

import com.bean.Attraction;
import com.bean.URIGenerate;
import com.bean.User;
import com.db.DAO.AttractionDAO;
import com.db.DAO.UserDAO;

/**
 * Servlet implementation class AddAttraction
 */
@WebServlet("/AddAttraction")
public class AddAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttraction() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			String name="" ,address="" ,phone="" ,email="" ,level="",introduce="",
					price="",length="",begin="",end="",filePath="";
			
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        List items = null;
	        try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        Iterator iter = items.iterator();// ���������ύ���������� 
	        while (iter.hasNext()) {
	            FileItem item = (FileItem) iter.next();
	            if (item.isFormField()) { // ����Ǳ��� �����Ƿ��ļ��ϴ�Ԫ��
	                String value = item.getString("UTF-8"); // ��ȡvalue���Ե�ֵ��������Ҫָ��UTF-8��ʽ���������������������
	                if (item.getFieldName().equals("name")) {// ��Ӧform�����Ե�����
	                    name = value;
	                } 
	                else if (item.getFieldName().equals("address")) {
	                    address = value;
	                }
	                else if (item.getFieldName().equals("phone")) {
	                	phone=value;
	                }
	                else if (item.getFieldName().equals("email")) {
	                    email = value;
	                }
	                else if (item.getFieldName().equals("level")) {
	                    level = value;
	                }
	                else if (item.getFieldName().equals("introduce")) {
	                    introduce = value;
	                }
	                else if (item.getFieldName().equals("price")) {
	                    price = value;
	                }
	                else if (item.getFieldName().equals("length")) {
	                    length = value;
	                }
	                else if (item.getFieldName().equals("begin")) {
	                    begin = value+":00";
	                }
	                else if (item.getFieldName().equals("end")) {
	                    end = value+":00";
	                }
	            } else {
	            	//���web��������Ŀ¼
	            	String webroot =this.getClass().getClassLoader().getResource("").getPath();
	            	int index = webroot.indexOf(".metadata");
	            	webroot=webroot.substring(0, index-1);
	            	webroot=webroot+"\\"+request.getServletContext().getContextPath().substring(1)+"\\"+"WebContent";
	            	String fileName = item.getName();
	                // �����ļ�������·������
	                index = fileName.lastIndexOf(".");
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
	        //System.out.println(AttractionDAO.nameIsExist(name));
	        if(AttractionDAO.nameIsExist(name)){
			    PrintWriter out = response.getWriter();
			    out.print("<script>alert('������ľ��������Ѿ����ڣ����������뾰����Ϣ!');window.location.href='admin.jsp'</script>");
	        }
			else{
				System.out.println(name+" "+level+" "+price+" "+length+" "+begin+" "+end);
				int levelInt = Integer.parseInt(level);
				float priceFloat = Float.parseFloat(price);
				int playTime = Integer.parseInt(length);
				SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");//��ʽ������
				java.util.Date d1,d2;
			    try {
			    		d1 = format.parse(begin);
			    		d2 = format.parse(end);
			    		java.sql.Time time1 = new java.sql.Time(d1.getTime()), time2 = new java.sql.Time(d2.getTime());
						Attraction attraction = new Attraction(name, address, phone, email, levelInt, introduce, priceFloat, playTime, time1, time2, filePath);
				        AttractionDAO.insert(attraction);
				        attraction= AttractionDAO.selectByName(name).get(0);
				        response.setCharacterEncoding("utf-8");
				        PrintWriter out = response.getWriter();
				        out.print("<script>alert('ע�ᾰ��ɹ�!');window.location.href='admin.jsp'</script>");
			        } catch (Exception e) {
			            e.printStackTrace();
			            response.setCharacterEncoding("utf-8");
				        PrintWriter out = response.getWriter();
				        out.print("<script>alert('������Ϣ����ע�������Ϣʧ��!');window.location.href='admin.jsp'</script>");
			        }
			}
		}catch(Exception e){
			System.out.println(e);
			response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        out.print("<script>alert('������Ϣ����ע�������Ϣʧ��!');window.location.href='admin.jsp'</script>");
		}
	}
}
