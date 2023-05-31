package org.example.webapps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/bank/doGet")
public class BankAccountServletGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            File file = new File("C:\\Users\\My\\Desktop\\Account.txt");
            BufferedReader bufferedReader = new BufferedReader((new FileReader(file)));
            String line = null;
            while((line = bufferedReader.readLine())!= null){
            out.println("<br>" + line + "</br>");
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }


        out.close();
    }

}
