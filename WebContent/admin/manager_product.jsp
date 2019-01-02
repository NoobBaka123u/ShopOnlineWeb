<%-- 
    Document   : manager_product
    Created on : 19-May-2016, 7:33:54 PM
    Author     : TUNGDUONG
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
<%
ProductDAO dao = new ProductDAO();
ArrayList<Product> listProduct = dao.getListProduct();
%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quan li san pham</h3>

                    
                 <a href="/ShopOnline/admin/insert_product.jsp" >Them san pham</a>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">Ma san pham</th>
                            <th class="data">Ten san pham</th>
                            <th class="data">Ma danh muc</th>
                            <th class="data">Hinh anh </th>
                            <th class="data">Gia</th>
                            <th class="data">Mo ta san pham</th>
                            
                            <th class="data" width="75px">Tuy chon</th>
                        </tr>
                         <%
                            int count = 0;
                            for(Product product : listProduct){
                                count++;
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=product.getProductID() %></td>
                            <td class="data"><%=product.getProductName() %></td>
                            <td class="data"><%=product.getCategoryID() %></td>
                            <td class="data"><img src="<%=product.getProductImage()%>"></td>
                            <td class="data"><%=product.getProductPrice() %></td>
                            <td class="data"><%=product.getProductDescription() %></td>
                            
                            <td class="data" width="75px">
                        <center>
                            <a href="/ShopOnline/admin/update_product.jsp?command=update&product_id=<%=product.getProductID()%>">Sua</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                            <a href="/ShopOnline/ManagerProductServlet?command=delete&product_id=<%=product.getProductID()%>">Xoa</a>
                        </center>
                        </td>
                        </tr>
                       <%}%>
                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
