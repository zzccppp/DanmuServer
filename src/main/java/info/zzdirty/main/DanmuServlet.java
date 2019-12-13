package info.zzdirty.main;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author ZZDirty
 */
@WebServlet(name = "DanmuServlet", urlPatterns = {"/pros"})
public class DanmuServlet extends HttpServlet {

    public static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    public static final int textMaxLength = 145;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessData(request, response);
    }

    private void ProcessData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        DanmuDataBean b = new DanmuDataBean();
        b.setColor(request.getParameter("color"));
        b.setVersion(request.getParameter("version"));
        b.setContenttype(request.getParameter("content-type"));
        b.setId(request.getParameter("stuid"));
        b.setEncode(request.getParameter("encode"));
        b.setText(request.getParameter("text"));
        b.setSize(request.getParameter("fontsize"));
        b.setType(request.getParameter("type"));
        b.setTime(String.valueOf(System.currentTimeMillis()));
        if (b.getText() == null || "".equals(b.getText())) {
            //status Error
            StatusMsgBean msg = new StatusMsgBean();
            msg.setMessage("NULL Text");
            msg.setStatus("fail");
            String jMsg = JSON.toJSONString(msg);
            response.getOutputStream().println(jMsg);
        } else if (b.getText().length() > textMaxLength) {
            //status Error
            StatusMsgBean msg = new StatusMsgBean();
            msg.setMessage("Text too long.");
            msg.setStatus("fail");
            String jMsg = JSON.toJSONString(msg);
            response.getOutputStream().println(jMsg);
        } else {
            if(!FilterTools.verifyId(b.getId())){
                StatusMsgBean msg = new StatusMsgBean();
                msg.setMessage("Incorrect student ID");
                msg.setStatus("fail");
                String jMsg = JSON.toJSONString(msg);
                response.getOutputStream().println(jMsg);
                return;
            }
            if(!FilterTools.verifyText(b.getText())){
                StatusMsgBean msg = new StatusMsgBean();
                msg.setMessage("Sensitive Words");
                msg.setStatus("fail");
                String jMsg = JSON.toJSONString(msg);
                response.getOutputStream().println(jMsg);
                return;
            }
            String jsonString = JSON.toJSONString(b);
            queue.offer(jsonString);
            // status Ok
            StatusMsgBean msg = new StatusMsgBean();
            msg.setMessage("OK");
            msg.setStatus("OK");
            String jMsg = JSON.toJSONString(msg);
            response.getOutputStream().println(jMsg);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessData(request, response);
    }
}
