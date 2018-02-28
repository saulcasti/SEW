<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes"/>
<xsl:template match="recetas">
<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;</xsl:text>
<html lang="es">
	<head>
		<title>Ejercicio 2 - Tarea 3</title>
		<link rel="stylesheet" type="text/css" href="estilo.css" />
	</head>
	<body>
		<xsl:for-each select="receta">
		<xsl:if test="ingrediente='Pollo'">
			<h1><xsl:value-of select="nombre"></xsl:value-of></h1>
			<h2><xsl:value-of select="tipoPlato"></xsl:value-of></h2>
			<p>Ingredientes:</p> 
			<ul>
			<xsl:for-each select="ingrediente">
				<li> <xsl:value-of select="@cantidad"></xsl:value-of>&#160;<xsl:value-of select="@medida"></xsl:value-of> de <xsl:value-of select="."></xsl:value-of></li>
			</xsl:for-each>
			</ul>
			<p>Paso/s:</p> 
			<ul>
			<xsl:for-each select="paso">
				<li><xsl:value-of select="."></xsl:value-of></li>
			</xsl:for-each>
			</ul>
			<p>Útil/es necesario/s:</p> 
			<ul>
			<xsl:for-each select="elementoUtilizado">
				<li><xsl:value-of select="."></xsl:value-of></li>
			</xsl:for-each>
			</ul>
			<p>Tiempo necesario: <xsl:value-of select="tiempoElaboracion"></xsl:value-of> min</p>
			<p>Origen: <xsl:value-of select="origen"></xsl:value-of></p>
			<p>Nivel de complejidad: <xsl:value-of select="dificultad"></xsl:value-of></p>
			<p>Calorías: <xsl:value-of select="calorias"></xsl:value-of>kcal</p>
			</xsl:if>
		</xsl:for-each>
		<footer>
      <a href="https://validator.w3.org/check?uri=referer"><img
          src="https://www.w3.org/html/logo/badge/html5-badge-h-solo.png"
          alt="HTML5 Válido" title="HTML5 Válido" height="64" width="63" /></a>
        <a href=" http://jigsaw.w3.org/css-validator/check/referer ">
       <img src=" http://jigsaw.w3.org/css-validator/images/vcss"
          alt="Valid CSS!" height="31" width="88" /></a>
      
    </footer>
	</body>
</html>
</xsl:template>

</xsl:stylesheet>