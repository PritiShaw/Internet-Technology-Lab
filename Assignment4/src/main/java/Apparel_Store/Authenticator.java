package Apparel_Store;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/*")
public class Authenticator implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI();
        HttpSession session = req.getSession(false);
        if (path.startsWith("/auth")) {
            if (null != session && session.getAttribute("email") != null && !path.endsWith("/signout")) 
				res.sendRedirect("/");            
            else
                chain.doFilter(request, response);
        } 
        else {
            if (null == session || session.getAttribute("email") == null)
				res.sendRedirect("/authorization.jsp");			
            else
                chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy(){
    }
}
