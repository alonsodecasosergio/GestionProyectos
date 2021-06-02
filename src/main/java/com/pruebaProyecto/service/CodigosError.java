package com.pruebaProyecto.service;


public interface CodigosError {
	
	//codIGOS DE ESTADO 100 -> INFORMATIVOS
	
	public final String[] cod_100 = {"100", "Continua, el navegador sigue con la peticion mandada"};
	public final String[] cod_102 = {"102", "Peticion procesada"};
	public final String[] cod_103 = {"103", "Continua, el navegador sigue con la peticion mandada"};
	
	//codIGOS DE ESTADO 200 -> ACEPTACION
	public final String[] cod_200 = {"200", "Todo se ha procesado de forma correcta"};
	public final String[] cod_201 = {"201", "La peticion se ha procesado y como resultado se ha creado un nuevo recurso"};
	public final String[] cod_202 = {"202", "La peticion ha sido aceptada pero todavia no se ha completado"};
	public final String[] cod_203 = {"203", "Recurso obtenido de otro servidor"};
	public final String[] cod_204 = {"204", "La peticion se ha procesado con exito pero el resultado esta vacio"};
	public final String[] cod_205 = {"205", "La peticion se ha procesado con exito pero el resultado esta vacio, el navegador recarga la misma pagina"};
	public final String[] cod_206 = {"206", "Se esta devolviendo el contenido pedido de forma parcial"};
	public final String[] cod_207 = {"207", "Devuleve varias peticiones a la vez"};
	public final String[] cod_208 = {"208", "Ya se devolvio el listado de elementos asi que no se vuelve a listar"};
	
	//codIGOS DE ESTADO 260 -> ERRORES CLIENTE PROYECTO
	public final String[] cod_260 = {"260", "Proyecto creado"};
	public final String[] cod_261 = {"261", "Proyecto eliminado"};
	public final String[] cod_263 = {"263", "Proyecto actualizado"};
	
	//codIGOS DE ESTADO 270 -> ERRORES CLIENTE TAREAS
	public final String[] cod_270 = {"270", "Tarea creada"};
	public final String[] cod_271 = {"271", "Tarea eliminada"};
	public final String[] cod_273 = {"273", "Tarea actualizada"};
	
	//codIGOS DE ESTADO 280 -> ERRORES CLIENTE USUARIO
	public final String[] cod_280 = {"280", "Usuario creado"};
	public final String[] cod_281 = {"281", "Usuario correcto"};
	
	
	//codIGOS DE ESTADO 300 -> REDIRECCIONES
	public final String[] cod_300 = {"300", "Existen varias alternativas para el contenido pedido por el usuario"};
	public final String[] cod_301 = {"301", "La pagina que busca se ha movido de ubicacion"};
	public final String[] cod_302 = {"302", "La pagina esta disponible en otra ubicacion"};
	public final String[] cod_303 = {"303", "La pagina esta disponible en otra ubicaion"};
	public final String[] cod_304 = {"304", "Existen varias alternativas para el contenido pedido por el usuario"};
	public final String[] cod_305 = {"305", "Este recurso solo esta disponible desde un proxy"};
	public final String[] cod_307 = {"307", "Indica al navegador que este recurso o pagina se ha movido de sitio, pero todavia esta disponible en esta direccion"};
	public final String[] cod_308 = {"308", "La pagina ha cambiado de lugar permanentemente"};
	
	//codIGOS DE ESTADO 400 -> ERRORES DEL CLIENTE
	public final String[] cod_400 = {"400", "Algo ha ido mal con la peticion, refresca la pagina"};
	public final String[] cod_401 = {"401", "No tienes permisos para recibir ese contenido"};
	public final String[] cod_403 = {"403", "La peticion es correcta pero el servidor se niega a ofrecerte el recurso. Es posible que necesites iniciar sesion"};
	public final String[] cod_404 = {"404", "Algo ha ido mal"};
	public final String[] cod_405 = {"405", "No se permite el uso de ese metodo"};
	public final String[] cod_406 = {"406", "La peticion no es aceptable"};
	public final String[] cod_407 = {"407", "Se requiere al cliente que se identifique mediante un proxy"};
	public final String[] cod_408 = {"408", "El servidor ha esperado mucho tiempo la respuesta del cliente"};
	public final String[] cod_409 = {"409", "La peticion no se pudo completar porque hubo un problema con ella"};
	public final String[] cod_410 = {"410", "Esa pagina fue borrada"};
	public final String[] cod_411 = {"411", "El cliente debía indicar la longitud del contenido, pero no lo hizo"};
	public final String[] cod_412 = {"412", "El servidor no cumple las indicaciones previas que se indicaban en la peticion"};
	public final String[] cod_413 = {"413", "La peticion es demasiado larga y el servidor se niega a procesarla"};
	public final String[] cod_414 = {"414", "La dirección web es demasiado larga"};
	public final String[] cod_415 = {"415", "El tipo de archivo que se ha recibido es distinto al que se esperaba"};
	public final String[] cod_416 = {"416", "El cliente ha pedido una porcion de un recurso que es incorrecta"};
	public final String[] cod_417 = {"417", "El servidor no puede cumplir con las expectaciones de la cabecera"};
	public final String[] cod_422 = {"422", "La peticion era correcta pero tenia algun error semantico"};
	public final String[] cod_423 = {"423", "Este recurso esta bloqueado"};
	public final String[] cod_424 = {"424", "Este recurso depende de otra respuesta que fallo"};
	public final String[] cod_426 = {"426", "El cliente debe usar un protocolo distinto"};
	public final String[] cod_428 = {"428", "El servidor requiere que la peticion sea condicional"};
	public final String[] cod_429 = {"429", "Se han enviado demasiaddas peticiones en un corto periodo de tiempo"};
	public final String[] cod_431 = {"431", "La cabecera o algunos campos son demasiado grandes"};
	public final String[] cod_452 = {"452", "El servidor deniega el acceso a este recurso por motivos legales"};
	
	//codIGOS DE ESTADO 460 -> ERRORES CLIENTE PROYECTO
	public final String[] cod_460 = {"460", "No se ha podido crear el proyecto"};
	public final String[] cod_461 = {"461", "No se ha podido eliminar el proyecto"};
	public final String[] cod_462 = {"462", "Debe eliminar las tareas del proyecto para poder borrar el proyecto"};
	public final String[] cod_463 = {"463", "No se ha podido actualizar el proyecto"};
	public final String[] cod_464 = {"464", "No se pueden mostrar las tareas del proyecto"};
	
	//codIGOS DE ESTADO 470 -> ERRORES CLIENTE TAREAS
	public final String[] cod_470 = {"470", "No se ha podido crear la tarea"};
	public final String[] cod_471 = {"471", "No se ha podido eliminar la tarea"};
	public final String[] cod_473 = {"473", "No se ha podido actualizar la tarea"};
	
	//codIGOS DE ESTADO 480 -> ERRORES CLIENTE USUARIO
	public final String[] cod_480 = {"480", "Los datos no son correctos"};
	public final String[] cod_481 = {"481", "El usuario no pudo ser creado"};
	public final String[] cod_483 = {"483", "Los datos son incorrectos"};
	public final String[] cod_484 = {"484", "Es necesario que este logueado"};
	
	
	//codIGOS DE ESTADO 500 -> ERRORES DE SERVIDOR
	public final String[] cod_500 = {"500", "Error en la conexion con la base de datos"};
	public final String[] cod_501 = {"501", "Error en la conexion con el servidor"};
	public final String[] cod_502 = {"502", "El servidor ha recibido una respuesta invalida"};
	public final String[] cod_503 = {"503", "El servidor esta sobrecargado"};

}
