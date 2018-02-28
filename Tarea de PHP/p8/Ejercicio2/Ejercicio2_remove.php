<!DOCTYPE html>
<html lang="es">
<head>
    <title>BorrarFila</title>
    <meta charset="utf-8"/>
    <meta name="author" content="UO251370" /> 
    <link href="Ejercicio2.css" rel="stylesheet" />
</head>
    
<body>
    
    <header>
    <h1>Ejercicio 2</h1>

    <nav>
    <a href="Ejercicio2.html">INICIO</a>
    <a href="Ejercicio2_createDB.php">CREAR BD</a>
    <a href="Ejercicio2_createTable.php">CREAR TABLA</a>
    <a href="Ejercicio2_insert.html">INSERTAR</a>
    <a href="Ejercicio2_remove.html">BORRAR</a>
    <a href="Ejercicio2_search.html">BUSCAR</a>
</nav>
    </header>
    
    <section>
        <?php
              $db = new mysqli('localhost', 'pepito', 'password2017', 'zoo');
            if($db->connect_error) {
                echo "<p>ERROR de conexión:".$db->connect_error."</p>";
                exit();
            } else {echo "<p>##Conexión establecida##</p>";}
            
            $consultaPre = $db->prepare("SELECT * FROM animal WHERE animalID = ?");   
        
            $consultaPre->bind_param('s', $_GET["animalID"]);    
            $consultaPre->execute();
            $resultado = $consultaPre->get_result();
            if ($resultado) {
                
                echo "<h2>Los datos del animal borrados:</h2> ";
                while($row = $resultado->fetch_assoc()) {
                    $id = $row['id'];
                    echo "<ul><li>Nombre: ". $row['name']."</li>";
                    echo "<li>Especie: ". $row['species'] ."</li>"; 
                    echo "<li>Tamaño: ". $row['size'] ."</li></ul>";
                }
                
            } else {
                echo "Sin resultados";
            }
            $consultaPre = $db->prepare("DELETE FROM animal WHERE id = ?");   
        
            $consultaPre->bind_param('i', $id);    
            $consultaPre->execute();
            
            $consultaPre->close();
            
            $db->close();
            
        ?> 
    </section>

</body>
</html>