<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

    
<hr>
<div class="row">
		
        
        <div class="col-md-12">
            <h1 style="text-align: center">Lista de libros</h1>
            <br>
            <br>

        <div class="table-responsive">

                
              <table id="mytable" class="table table-bordred table-striped">
                   
                 
    
    
    <thead>

        <tr>
            <th><input type="checkbox" id="checkall" /></th>
            <th>libros</th>
            <th>Editoriales</th>
            <th>Autores</th>
            
   
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                
                <td></td>
                        <td><c:out value="${fila.titulo}"/></td>
                         <td><c:out value="${fila.editorial}"/></td>
                        <td><c:out value="${fila.aut_nombre}"/></td>
               
                
            </tr>
        </c:forEach>
    </tbody>
</table>



