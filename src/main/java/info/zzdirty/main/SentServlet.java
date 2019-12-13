package info.zzdirty.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ZZDirty
 */
@WebServlet(name = "SentServlet",urlPatterns = {"/get"})
public class SentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(DanmuServlet.queue.size() != 0) {
            while(DanmuServlet.queue.size() != 0){
                String str = (String) DanmuServlet.queue.poll();
                resp.getOutputStream().println(str);
            }
        } else {
            resp.getOutputStream().println("{}");
        }
    }
}
