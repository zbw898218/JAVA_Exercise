package charles.news_manage.servlet;

import java.io.*;
import javax.servlet.*;
/**
 * Created by Charles Zheng on 2017/8/2.
 */

public class EncodingFilter implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request,response);
    }
    public void init(FilterConfig filterConfig) throws ServletException{}
    public void destroy(){}
}