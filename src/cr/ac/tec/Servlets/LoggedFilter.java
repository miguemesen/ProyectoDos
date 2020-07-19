package cr.ac.tec.Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/*")
public class LoggedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpSession session = request.getSession();
            HttpServletResponse response=(HttpServletResponse) servletResponse;
            PrintWriter printWriter=response.getWriter();
            printWriter.println("Su su suscribete y dale like si quieres ");
            String phrase=(String) session.getAttribute("logged");
            if(phrase=="True");
        }
        catch (Exception e){

        }
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
