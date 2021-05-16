<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Suscriptor</title>
</head>
<body>

    <h1>Crear Suscriptor</h1>
    
    <form action ="suscriptor" method ="post">
    <input type="hidden" name="opcion" value="Guardar">
      <table border="1">
        <tr>
          <td>Nombre:</td>
          <td><input type="text" name="nomPila" size="50"></td>
        </tr>
        
        <tr> 
          <td>Apellido Paterno:</td>
          <td><input type="text" name="apPat" size="50"></td>
        </tr>
        
        <tr>
          <td>Apellido Materno:</td>
          <td><input type="text" name="apMat" size="50"></td>
        </tr>
        
        <tr>
          <td>Servicio:</td>
          <td><input type="text" name="servicio" size="50"></td>
        </tr>
          
        <tr>
          <td>Fecha de Nacimiento:</td>
          <td><input type="text" name="fechaNac" size="50"></td>
        </tr>
        
        <tr>
          <td>Status:</td>
          <td><input type="text" name="estatus" size="50"></td>
        </tr>
        
        <tr>
          <td>Plan:</td>
          <td><input type="text" name="plan" size="50"></td>
        </tr>
        
      </table>
      <input type="submit" value="Guardar">
    
    </form>
    
    <h1>Plan</h1>
    
    <form action ="suscriptor" method ="post">
    <input type="hidden" name="opcion2" value="Guardar">
      <table border="1">
        <tr>
          <td>Nombre:</td>
          <td><input type="text" name="nombre" size="50"></td>
        </tr>
        
        <tr> 
          <td>Importe:</td>
          <td><input type="text" name="importe" size="50"></td>
        </tr>
        
      </table>
      <input type="submit" value="Guardar">
    
    </form>

</body>
</html>