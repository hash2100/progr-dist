<html>
  <head>
    <title> Tag cu marcaj </title>
  </head>
  <body>
  <%@ taglib uri="http://cs.unitbv.ro/mytaglib" 
      prefix="mk" %>
    <p>
    <% 
      String zi=request.getParameter("ziua");
    %>
    Ziua este:
    <mk:ziuaTag ziua="<%= zi %>" />
  </body>
</html>