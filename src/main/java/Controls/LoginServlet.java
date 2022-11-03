package Controls;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
        private String password;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		username = req.getParameter("username");
		password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    //Conexion a bd
                    
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","22130");
                        
                        // Consulta sql
			String query=("select * from usuarios where usuarios.User =(?) and usuarios.Pass=(?);");
                        
                        //Preparamos la consulta el nombre de usuario y la contraseña
                        
                        
                        ResultSet rs = null;
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, username);
                        pst.setString(2, password);
                        rs = pst.executeQuery();
                         // Validamos y redireccionamos a el login
                         
                         
                         // Nota: usuario: walter      Contraseña: admin 
                         
                         
                        if(rs.next()) {
				res.sendRedirect("Login.jsp");
			}
			else {
                                out.println("");
                                out.println("");
                                out.println("");
				out.println("<h1  text-align='center'>");
                                
				out.println("Nombre de usuario o contraseña incorrecto");
				out.println("</h1");
			}
                    
		}
		catch(Exception e) {
			    out.println("<h1 text-align='center'>");
			    out.println("Some Error Occured. Please contact the development team"+e);
			    out.println("</h1>");
			    System.out.println(e);
		}
	
	}

}