<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match='/'>
        <html>
            <xsl:apply-templates/>
        </html>
    </xsl:template>
    <xsl:template match='Agenda'>
        <head>
            <title>LISTADO DE CONTACTOS</title>
        </head>
        <body>
            <h1>LISTA DE CONTACTOS</h1>
            <table border='1'>
                <tr>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Direcion</th>
                    <th>CodPostal</th>
                    <th>Debo</th>
                    <th>Cantidad</th>

                </tr>
                <xsl:apply-templates select='DatosContacto'/>
            </table>
        </body>
    </xsl:template>
    <xsl:template match='DatosContacto'>
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match='Nombre|Telefono|Direcion|CodPostal|Debo|Cantidad'>
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>