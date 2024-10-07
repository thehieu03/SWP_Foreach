package requestData;

import java.io.*;
import java.util.ArrayList;

import com.example.migrateproject.dao.AutomakerDAO;
import com.example.migrateproject.dao.ProductDAO;
import com.example.migrateproject.model.Automaker;
import dto.GetTopProductsWithFirstAttribute;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "requestHomeServlet", value = "/requestHome-servlettt")
public class requestHome extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Toi day thanh cong");
        HttpSession session=request.getSession();
        AutomakerDAO dao= new AutomakerDAO();
        ProductDAO productDAO=new ProductDAO();
        ArrayList<Automaker> listAutomaker = dao.getAllAutomaker();
        ArrayList<GetTopProductsWithFirstAttribute> listTopProductFrist=productDAO.getTopProductsWithFirstAttribute();
        ArrayList<GetTopProductsWithFirstAttribute> listTop4Civic=productDAO.getTop4HondaCivic();
        request.setAttribute("listTop4Civic",listTop4Civic);
        session.setAttribute("listAutomaker",listAutomaker);
        session.setMaxInactiveInterval(30*30*60);
        request.setAttribute("listTopProductFrist",listTopProductFrist);
        request.getRequestDispatcher("/hondaotog3.com/index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}