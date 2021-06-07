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

               

            <input type="submit" value="${ ( personaje.id == 0 ) ? 'Crear' : 'Editar' }" class="btn btn-block btn-primary mt-4">
        </form>

</main> 

<jsp:include page="../plantillas/footer.jsp"/>