<jsp:include page="plantillas/cabecera.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>

	<div class="container">
		<p style="color:red">${mensaje}</p>
	
		<p>Podemos hacer la peticion por GET mediante un enlace </p>
		<a href="calcular?numero1=4&numero2=8">peticion GET <b>calcular?numero1=4&numero2=8</b></a>
	
		
		<p>Podemos hacer la peticion por POST mediante un formulario </p>
		<form method="post" action="calcular" >
			<select name="operacion" class="form-select">
				<option value="s">Sumar</option>
				<option value="r">Restar</option>
				<option value="d">Dividir</option>
				<option value="m">Multiplicar</option>
			</select>
			<br>
			<input type="text" name="numero1" required placeholder="numero 1" class="form-control">
			<br>
			<input type="text" name="numero2" required placeholder="numero 2" class="form-control">
			<br>
			<input type="submit" value="Calcular" class="btn btn-primary mb-4">
		</form>	
		
		<figure>
			<img src="images/calculadora.jpg" alt="flujo de navegacion" style="width: 100%">
			<figcaption>Flujo de navegación</figcaption>
		</figure>
	</div>

 <jsp:include page="plantillas/footer.jsp"/>