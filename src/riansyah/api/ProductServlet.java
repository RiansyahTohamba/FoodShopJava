package riansyah.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jsonResponse = "{'message' : 'Success'}";
        this.outputResponse(res,jsonResponse,200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.doPost(req, res);
    }

    ////////// PRIVATE //////////
    private void outputResponse(HttpServletResponse res, String payload, int status){
        res.setHeader("Content-Type","application/json");
        try{
            res.setStatus(status);
            if (payload != null){
                OutputStream outputStream = res.getOutputStream();
                outputStream.write(payload.getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
