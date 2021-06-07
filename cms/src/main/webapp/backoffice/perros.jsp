<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

 <main class="container">
    <h1>Listado Perros</h1>
    
    <div class="row">
    
    	<div class="col">
	     <table class="table table-striped table-hover">
	        <thead>
	          <tr>
	            <th scope="col">#</th>
	            <th scope="col">nombre</th>
	            <th scope="col">raza</th>
	            <th scope="col">historia</th>            
	          </tr>
	        </thead>
	        <tbody>
	             
		        <c:forEach var="p" items="${perros}">
		          <tr>
		            <th scope="row">${p.id}</th>	           
		            <td>${p.nombre}</td>
		            <td>${p.raza.nombre}</td>
		            <td>${p.historia}</td>
		          </tr>
		         </c:forEach> 
		         
	        <!-- terminamos de recorrer -->
	        </tbody>
	      </table>
	   </div>
	   <!-- 1º columna -->
	      
       <div class="col">
       
       		<form method="post" action="perros">
       		
       			<input type="text" name="nombre" value="${perro.nombre}" placeholder="Nombre del perro" class="form-control">
       		
       		
       			<select name="idraza" class="form-select">
       				<c:forEach var="r" items="${razas}">
       					<option ${ ( r.id == perro.raza.id ) ? "selected" : "" } value="${r.id}">${r.nombre}</option>       				
       				</c:forEach>
       			</select>
       			
       			<label class="mt-3">Historia del perro:</label>	
       			<textarea name="historia"  class="form-control mb-3">${perro.historia}</textarea>
       		
       			<input type="submit" value="crear" class="btn btn-primary btn-block">
       		
       		</form>
       
       </div>
       <!-- 2º columna -->     
            
   </div>
   <!-- .row -->         
</main> 

<jsp:include page="../plantillas/footer.jsp"/>