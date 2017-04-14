

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tpoServlet
 */
@WebServlet("/tpoServlet")
public class tpoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public tpoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String rollno=req.getParameter("rollno");
		String toEdit=req.getParameter("edit");
		String value=req.getParameter("value");
		System.out.println(rollno);
		tpo t=new tpo();
		int a=t.editTechStudent(toEdit, rollno, value);
		if(a==1)
			resp.sendRedirect("updateSuccessful.html");
		else
			resp.sendRedirect("unupdate.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailID");
		String company=request.getParameter("company");
		String password=request.getParameter("password");
		String interest=request.getParameter("interest");
		String branch=request.getParameter("branch");
		double salary= Double.parseDouble(request.getParameter("salary"));
		int status=Integer.parseInt(request.getParameter("status"));
		double cpi= Double.parseDouble(request.getParameter("cpi"));
		//System.out.println(rollno+name);
		tpo t=new tpo();
		t.insertTechStud(rollno,name,password,emailID,cpi,
				status,company,salary,branch,interest);
		response.sendRedirect("successful.html");
}
}
