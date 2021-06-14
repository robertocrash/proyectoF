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
		           placeholder="Nombre a buscar "/>	    
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
            <th scope="col">Nacionalidad</th>
            <th scope="col">Ocupacion</th>
            <th scope="col">Poder de Ataque</th>
            <th scope="col">Vida</th>
            <th scope="col">Mana</th>
            <th scope="col">Defensa</th>
            <th scope="col">Editar</th>
            <th scope="col">Eliminar</th>
            
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
		            <td>${pIteracion.nacionalidad.nombre}</td>
		            <td>${pIteracion.ocupacion.nombre}</td>
		            <td>${pIteracion.poderAtaque}</td>
	             	<td>${pIteracion.vida}</td>
	             	<td>${pIteracion.mana}</td>
	             	<td>${pIteracion.defensa}</td>
	             	
	             	
	            <td><a href="backoffice/personajes-editar?id=${pIteracion.id}" class="btn btn-outline-primary">Editar</a></td>
				<td><a onclick="confirmarEliminacion('${pIteracion.nombre}')" class="btn btn-outline-danger" href="backoffice/personajes-eliminar?id=${pIteracion.id}">Eliminar</a></td>
	          </tr>
	         </c:forEach> 
	         
        <!-- terminamos de recorrer -->
        </tbody>
      </table>
     
     <script>
      	
      	function confirmarEliminacion(nombre){
      		
      		if ( window.confirm("¿ Quieres Eliminar a " + nombre + " ?") ){
      			console.debug('eliminamos');
      		}else {
      			event.preventDefault(); // prevenir que el ancla haga su funcion
      			console.debug('No Eliminamos');
      		}
      		
      	}
      
      </script>
        
</main> 

<jsp:include page="../plantillas/footer.jsp"/>