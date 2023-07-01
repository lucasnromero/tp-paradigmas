# tp-paradigmas
Turismo en la Tierra Media

¡Bienvenidos a nuestro programa!

La interacción con él es muy simple, éste interactúa con tres archivos de entrada: 
- Archivo de Atracciones.
- Archivo de Promociones.
- Archivo de Usuarios.

Todos estos archivos poseen ciertas similitudes en cuanto a su formato:

- Cada linea representa un registro diferente.
- Cada campo de un registro se encuentra separado por | (pipes). 

## El archivo de Atracciones 
Posee todas las atracciones incluidas en el parque, y éstas tienen tres tipos:

- Aventura
- Paisaje
- Degustación 

Dicho archivo posee el siguiente formato:   

Nombre de la atraccion|Costo de la visita|Tiempo de duracion|Cupo de atracción|Tipo de atracción

por ejemplo: 

* EL REINO DE THANOS|4|12|25|AVENTURA
* LA CASA DE ELMER|8|5|66|DEGUSTACION
* PALACIO DE LA ARAÑA|3|5|15|PAISAJE

## El archivo de promociones 
Posee las promociones de atracciones que tendrá el parque. Éstas pueden ser: 

- Absolutas: descuenta un valor absoluto al costo total de todas las atracciones ofrecidas en dicha promoción.
- Porcentual: descuenta un porcentaje del costo total de todas las atacciones incluidas en la promoción.
- AxB: UNA de las atracciones ofrecidas será gratuita.

El formato de las promociones dependen de su tipo:

- Formato Promoción Absoluta: 
atraccion 1;atraccion 2;atraccion N|valor Absoluto de descuento|Tipo de atraccion (indica el tipo de atraccion que tendrá dicha promocion)

ejemplo Pormocion absoluta: 
el mar rojo; salto elegante; pelea en la selva|70|Aventura

- Formato Promoción Porcentual:
atraccion 1;atraccion 2;atraccion N|valor Porcentual de descuento|Tipo de atraccion (indica el tipo de atraccion que tendrá dicha promocion) 

ejemplo Pormocion Porcentual:
castillo glotón; el gran banquete;mesa vikinga|35|Degustacion

- Formato Promoción AxB:
atraccion 1;atraccion 2;atraccion N|Atracción gratuita(entre las que se encuentran en la lista del campo anterior)|Tipo de atraccion (indica el tipo de atraccion que tendrá dicha promocion) 

ejemplo Pormocion AxB: 
Muro de escudos; dragón negro; laberinthia|dragón negro|Aventura

Podemos obvservar que en lo unico que difieren los 3 tipos de promociones es en su segundo campo, el cual está sujeto al tipo pertinente.
Por lo contrario, podemos observar que el campo 1 (las listas de atracciones incluidas en la promoción) y el campo 3 (el tipo de atracción
que incluyen) se manejará de la misma manera. Pero prestemos atención al campo 1, ya que como ya se mencionó anteriormente, contiene la lista de 
atracciones, en la cual cada una de ellas se encontrará separada por un ";" (punto y coma).

## El archivo de Usuario 
Posee el siguiente formato:

Nombre del usuario|tiempo disponible|presupuesto|atraccion de preferencia

Un ejemplo del mismo sería:

Lucas Romero|18|600|Aventura 
