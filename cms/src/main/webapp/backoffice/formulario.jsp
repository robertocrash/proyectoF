<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../plantillas/cabecera.jsp"/>
<jsp:include page="../plantillas/menu.jsp"/>

<main class="container">


	 <h1>${titulo}</h1>
        <form action="backoffice/personajes-editar" method="post" class="w-50">

			<p class="text-warning">ID esta oculto</p>
            <input type="text" 
                   name="id"                   
                   id="id"
                   value="${personaje.id}"
                   required            
                   readonly       
                   class="form-control">

            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" 
                   name="nombre"                   
                   id="nombre"
                   value="${personaje.nombre}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="Nombre sin apellidos">
                   
          
			
			<label for="nacionalidad" class="form-label">Nacionalidad:</label>
			<select name="idNacionalidad" class="form-select">
				<c:forEach items="${nacionalidades}" var="n">
					<option value="${n.id}"   ${ ( n.id == personaje.nacionalidad.id ) ? "selected" : "" }  >${n.nombre}</option>
				</c:forEach>	
			</select>
			
			<label for="ocupacion" class="form-label">Ocupacion:</label>
			<select name="idOcupacion" class="form-select">
				<c:forEach items="${ocupaciones}" var="o">
					<option value="${o.id}"   ${ ( o.id == personaje.ocupacion.id ) ? "selected" : "" }  >${o.nombre}</option>
				</c:forEach>	
			</select>
			
				<label for="poderAtaque" class="form-label">Poder de Ataque:</label>
            <input type="text" 
                   name="poderAtaque"                   
                   id="poderAtaque"
                   value="${personaje.poderAtaque}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="poderAtaque">
			
			<label for="vida" class="form-label">Vida:</label>
            <input type="text" 
                   name="vida"                   
                   id="vida"
                   value="${personaje.vida}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="vida">
			
			<label for="mana" class="form-label">Mana:</label>
            <input type="text" 
                   name="mana"                   
                   id="mana"
                   value="${personaje.mana}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="mana">
                   
            <label for="defensa" class="form-label">Defensa:</label>
            <input type="text" 
                   name="defensa"                   
                   id="defensa"
                   value="${personaje.defensa}"
                   required 
                   autofocus 
                   class="form-control" 
                   placeholder="defensa">
               

            <input type="submit" value="${ ( personaje.id == 0 ) ? 'Crear' : 'Editar' }" class="btn btn-block btn-primary mt-4">
        </form>

</main> 

<jsp:include page="../plantillas/footer.jsp"/>