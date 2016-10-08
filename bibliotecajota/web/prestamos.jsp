<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

    
<hr>
<div class="row">
		
        
        <div class="col-md-12">
            <h1 style="text-align: center">Lista de Prestamos</h1>
            <br>
            <br>
        <div class="table-responsive">

                
              <table id="mytable" class="table table-bordred table-striped">
                   
                 
    
    
    <thead>

        <tr>
            <th><input type="checkbox" id="checkall" /></th>
            <th>Nombre libros</th>
            <th>Fecha de prestamo</th>
            <th>Fecha de devolución</th>
            
   
          
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                
                <td></td>
                        <td><c:out value="${fila.titulo}"/></td>
                         <td><c:out value="${fila.fechaprestamo}"/></td>
                        <td><c:out value="${fila.fechadevolucion}"/></td>
               
                
            </tr>
        </c:forEach>
    </tbody>
</table>
