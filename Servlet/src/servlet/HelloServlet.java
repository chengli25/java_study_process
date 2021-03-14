package servlet;

import com.users.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: Zero
 * @Date: 2021/3/14 - 15:30
 * @since: jdk 1.8
 */

/**
 * @Description //TODO servlet执行方法：先执行servlet的构造方法，然后执行初始化方法，在执行doget或者是dopost方法；当程序结束的时候执行销毁方法；
 * @Author Linduse
 * @Date 17:13 2021/3/14
 * @param
 * @return
 **/

//继承httpservlet这个抽象类
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理get请求");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        out.println("<strong>Hello Servlet</strong><br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user = new User();
        String username;
        String password,email;
        try{
            username = req.getParameter("username");
            password = req.getParameter("password");
            email = req.getParameter("email");
            //多个复选按钮获得用getparametervalues()方法；对于日期格式，用simpledataformat对象调用parse来处理时间，返回一个字符串格式的日期；
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);


            //把注册成功的用户对象保存在session中
            req.getSession().setAttribute("reguser",user);
            System.out.println(user);
            //跳转到注册成功页面
            req.getRequestDispatcher("../userinfo.jsp").forward(req,resp);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
