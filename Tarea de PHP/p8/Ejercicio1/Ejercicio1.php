<!DOCTYPE html>
<html lang="es">
<head>
    <title>Ejercicio 1</title>
    <meta charset="utf-8"/>
    
    <meta name="author" content="UO251370" /> 

    <link href="Ejercicio1.css" rel="stylesheet" />
</head>
    
<body>
    
    <h1>Ejercicio 1</h1>
    
    <section>
        <?php
        
            echo "<h2>Mostrar contenido del archivo</h2>";
            require("Ejercicio1_archivo.php");
            $fichero = new ArchivoTexto ("Prueba.txt");
            $fichero->createFile();
            $fichero->writeFile("Comienza la prueba");
            $fichero->viewFile();
            echo "<h2>Añadir contenido al archivo</h2>";
            $fichero->modifyFile(" (p8 de SEW)");
            $fichero->viewFile();
            echo "<h2>Eliminar todo el contenido del archivo</h2>";
            $fichero->deleteInfoFile();
            $fichero->writeFile("//Se ha borrado todo");
            $fichero->viewFile();
            echo "<h2>Eliminar archivo</h2>";
            $fichero->deleteFile();
            $fichero->viewFile();
        ?> 
    </section>

</body>
</html>