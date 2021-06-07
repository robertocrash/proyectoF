<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

 <main class="container">
    <h1>${fn:length(personajes)} Personajes</h1>
    <a href="backoffice/personajes-editar?id=0">Nuevo Personaje</a>
    
    <form action="backoffice/personajes-listar" method="get">
	    <div class="input-group">
		  <div class="form-outline">
		    <input type="search" name="filtro"
		           value="${filtro}" 
		           class="form-control"		           
		           placeholder="Nombre, apellidos o email"/>	    
		  </div>
		  <button type="submit" class="btn btn-primary">
		    <i class="fas fa-search"></i>
		  </button>
		</div>
	</form>
    
   
    <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre</th>
            <th scope="col">Editar</th>
          </tr>
        </thead>
        <tbody>
        <!-- 
        	recorrer atributo con la lista de particpantes y pintar TR
        	items="$ { participantes}" => Nombre del atributo que nos envia en controlador
        	var="pIteracion"           => nombre de la variable que iteramos que es un Participante 
        
        	${p.nombre} es lo mismo que p.getNombre(), es una forma abreviada
        	
        	for ( Participante pIteracion : participantes )
        
        -->
        
	        <c:forEach var="pIteracion" items="${personajes}">
	          <tr>
	            <th scope="row">${pIteracion.id}</th>
	            <td>${pIteracion.nombre}</td>
	            <td><a href="backoffice/personajes-editar?id=${pIteracion.id}" class="btn btn-outline-primary">Editar</a></td>

	          </tr>
	         </c:forEach> 
	         
        <!-- terminamos de recorrer -->
        </tbody>
      </table>
     
        
</main> 

<jsp:include page="../plantillas/footer.jsp"/>