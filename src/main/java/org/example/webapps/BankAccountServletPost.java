package org.example.webapps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/bank")
public class BankAccountServletPost extends HttpServlet {
    public List<NewAccount> base = new ArrayList<>();

    private Connection connection;

    @Override
    public void init() {
        Properties properties = new Properties();
        try {

            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");
            Class.forName(driverClassName);

            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        } catch (IOException exp) {
            throw new IllegalStateException(exp);
        } catch (SQLException exp) {
            throw new IllegalStateException(exp);
        } catch (ClassNotFoundException exp) {
            throw new IllegalStateException(exp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Boolean bool = false;

        String userName = request.getParameter("username");
        String inNumber = request.getParameter("number");
        String create = request.getParameter("create");



        if (create.equals("yes")) {
            bool = true;
            NewAccount newAccount = new NewAccount(userName, inNumber);
            base.add(newAccount);
        }
        try {
            File file = new File("C:\\Users\\My\\Desktop\\Account.txt");
            BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(file)));
            for (NewAccount gg : base) {
                //     bufferedWriter.write(gg.getName() + " / ");
                //      bufferedWriter.write(gg.getBankAccount());
                bufferedWriter.write(gg + System.lineSeparator());
                System.out.println(gg);
            }
            bufferedWriter.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO bank_account_test(name_account,number_account,status_account)VALUES (?,?,?)");
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,inNumber);
            preparedStatement.setBoolean(3,bool);
            preparedStatement.execute();

            System.out.println(preparedStatement);
        }catch(SQLException exp){
            throw new IllegalStateException(exp);
        }



        try {
            out.println("<p>Name: " + userName + "</p>");
            out.println("<p>Number: " + inNumber + "</p>");
            out.println("<p>Number: " + bool + "</p>");

            for (NewAccount on : base) {
                out.print("<br>" + on + "</br>");
            }

        } finally {
            out.close();
        }

    }
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
