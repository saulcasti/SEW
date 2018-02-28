<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes"/>
<xsl:template match="articulos">
<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;</xsl:text>
<html lang="es">
	<head>
		<title>Ejercicio 1 - Tarea 4</title>
		<link rel="stylesheet" type="text/css" href="estilo.css" />
	</head>
	<body>
		<xsl:for-each select="articulo">
			<xsl:sort select="anio"/>
			<xsl:if test="anio&gt;=2012 and anio&lt;=2015 ">
				<h1><xsl:value-of select="nombreRevista"></xsl:value-of> nº<xsl:value-of select="numeroRevista"></xsl:value-of></h1>
				<h2><xsl:value-of select="titulo"></xsl:value-of></h2>
				<h3><xsl:value-of select="resumen"></xsl:value-of></h3>
				<p><xsl:value-of select="contenido"></xsl:value-of></p>
				<p>Autor/es:</p> 
				<ul>
				<xsl:for-each select="autor">
					<li><xsl:value-of select="."></xsl:value-of>, <xsl:value-of select="@correoElectro"></xsl:value-of></li>
				</xsl:for-each>
				</ul>
				<p>Año: <xsl:value-of select="anio"></xsl:value-of></p>
				<p>ISBN: <xsl:value-of select="@isbn"></xsl:value-of></p>
				<p>De la página <xsl:value-of select="@paginaI"></xsl:value-of> a <xsl:value-of select="@paginaF"></xsl:value-of>.</p>
				<p>Palabras clave:</p>
				<ul>
				<xsl:for-each select="palabraClave">
					<li><xsl:value-of select="."></xsl:value-of></li>
				</xsl:for-each>
				</ul>
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