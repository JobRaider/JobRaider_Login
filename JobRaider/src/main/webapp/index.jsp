

<form action="Login">
	NOmbre:<input type="text" name="name" /><br /> Password:<input
		type="password" name="pass" /><br /> <input type="submit"
		value="login" />
</form>

<a>Insertar usuarios</a>
<form action="httpPostServlet">
	Name:<input type="text" name="name" /><br /> Password:<input
		type="password" name="pass" /><br /> Apellido:<input type="text"
		name="ape" /><br /> Dni:<input type="password" name="dni" /><br /> <input
		type="submit" value="Insertar" />
</form>
<a>Insertar Log</a>
<form action="httpPostServletLog">
	Name:<input type="text" name="name" /><br /> 
	Apellido:<input type="text" name="ape" /><br /> 
		
	Estado:<input type="text" name="est" /><br /> <input type="submit"
		value="Insertar-Log" />
</form>


