<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@ page import="dao.Dao" %>
<%@ page import="model.User" %>
<%@ page import="java.sql.SQLException" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    Dao dao = new Dao();
    Blob blob = dao.getByID(User.class, id).getPhoto();

    byte byteArray[] = new byte[0];
    try {
        byteArray = blob.getBytes(1, (int)blob.length());
    } catch (SQLException e) {
        e.printStackTrace();
    }

    response.setContentType("image/jpg");
    OutputStream os = response.getOutputStream();
    os.write(byteArray);
    os.flush();
    os.close();
%>
