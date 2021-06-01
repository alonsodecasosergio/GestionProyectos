package com.pruebaProyecto.service;


public interface CodigosError {
	
	//CODIGOS DE ESTADO 100 -> INFORMATIVOS
	
	public final String[] COD_100 = {"100", "Continua, el navegador sigue con la peticion mandada"};
	public final String[] COD_102 = {"102", "Peticion procesada"};
	public final String[] COD_103 = {"103", "Continua, el navegador sigue con la peticion mandada"};
	
	//CODIGOS DE ESTADO 200 -> ACEPTACION
	public final String[] COD_200 = {"200", "Todo se ha procesado de forma correcta"};
	public final String[] COD_201 = {"201", "La peticion se ha procesado y como resultado se ha creado un nuevo recurso"};
	public final String[] COD_202 = {"202", "La peticion ha sido aceptada pero todavia no se ha completado"};
	public final String[] COD_203 = {"203", "Recurso obtenido de otro servidor"};
	public final String[] COD_204 = {"204", "La peticion se ha procesado con exito pero el resultado esta vacio"};
	public final String[] COD_205 = {"205", "La peticion se ha procesado con exito pero el resultado esta vacio, el navegador recarga la misma pagina"};
	public final String[] COD_206 = {"206", "Se esta devolviendo el contenido pedido de forma parcial"};
	public final String[] COD_207 = {"207", "Devuleve varias peticiones a la vez"};
	public final String[] COD_208 = {"208", "Ya se devolvio el listado de elementos asi que no se vuelve a listar"};
	
	//CODIGOS DE ESTADO 260 -> ERRORES CLIENTE PROYECTO
	public final String[] COD_260 = {"260", "Proyecto creado"};
	public final String[] COD_261 = {"261", "Proyecto eliminado"};
	public final String[] COD_263 = {"263", "Proyecto actualizado"};
	
	//CODIGOS DE ESTADO 270 -> ERRORES CLIENTE TAREAS
	public final String[] COD_270 = {"270", "Tarea creada"};
	public final String[] COD_271 = {"271", "Tarea eliminada"};
	public final String[] COD_273 = {"273", "Tarea actualizada"};
	
	//CODIGOS DE ESTADO 280 -> ERRORES CLIENTE USUARIO
	public final String[] COD_280 = {"280", "Usuario creado"};
	public final String[] COD_281 = {"281", "Usuario correcto"};
	
	
	//CODIGOS DE ESTADO 300 -> REDIRECCIONES
	public final String[] COD_300 = {"300", "Existen varias alternativas para el contenido pedido por el usuario"};
	public final String[] COD_301 = {"301", "La pagina que busca se ha movido de ubicacion"};
	public final String[] COD_302 = {"302", "La pagina esta disponible en otra ubicacion"};
	public final String[] COD_303 = {"303", "La pagina esta disponible en otra ubicaion"};
	public final String[] COD_304 = {"304", "Existen varias alternativas para el contenido pedido por el usuario"};
	public final String[] COD_305 = {"305", "Este recurso solo esta disponible desde un proxy"};
	public final String[] COD_307 = {"307", "Indica al navegador que este recurso o pagina se ha movido de sitio, pero todavia esta disponible en esta direccion"};
	public final String[] COD_308 = {"308", "La pagina ha cambiado de lugar permanentemente"};
	
	//CODIGOS DE ESTADO 400 -> ERRORES DEL CLIENTE
	public final String[] COD_400 = {"400", "Algo ha ido mal con la peticion, refresca la pagina"};
	public final String[] COD_401 = {"401", "No tienes permisos para recibir ese contenido"};
	public final String[] COD_403 = {"403", "La peticion es correcta pero el servidor se niega a ofrecerte el recurso. Es posible que necesites iniciar sesion"};
	public final String[] COD_404 = {"404", "Algo ha ido mal"};
	public final String[] COD_405 = {"405", "No se permite el uso de ese metodo"};
	public final String[] COD_406 = {"406", "La peticion no es aceptable"};
	public final String[] COD_407 = {"407", "Se requiere al cliente que se identifique mediante un proxy"};
	public final String[] COD_408 = {"408", "El servidor ha esperado mucho tiempo la respuesta del cliente"};
	public final String[] COD_409 = {"409", "La peticion no se pudo completar porque hubo un problema con ella"};
	public final String[] COD_410 = {"410", "Esa pagina fue borrada"};
	public final String[] COD_411 = {"411", "El cliente debía indicar la longitud del contenido, pero no lo hizo"};
	public final String[] COD_412 = {"412", "El servidor no cumple las indicaciones previas que se indicaban en la peticion"};
	public final String[] COD_413 = {"413", "La peticion es demasiado larga y el servidor se niega a procesarla"};
	public final String[] COD_414 = {"414", "La dirección web es demasiado larga"};
	public final String[] COD_415 = {"415", "El tipo de archivo que se ha recibido es distinto al que se esperaba"};
	public final String[] COD_416 = {"416", "El cliente ha pedido una porcion de un recurso que es incorrecta"};
	public final String[] COD_417 = {"417", "El servidor no puede cumplir con las expectaciones de la cabecera"};
	public final String[] COD_422 = {"422", "La peticion era correcta pero tenia algun error semantico"};
	public final String[] COD_423 = {"423", "Este recurso esta bloqueado"};
	public final String[] COD_424 = {"424", "Este recurso depende de otra respuesta que fallo"};
	public final String[] COD_426 = {"426", "El cliente debe usar un protocolo distinto"};
	public final String[] COD_428 = {"428", "El servidor requiere que la peticion sea condicional"};
	public final String[] COD_429 = {"429", "Se han enviado demasiaddas peticiones en un corto periodo de tiempo"};
	public final String[] COD_431 = {"431", "La cabecera o algunos campos son demasiado grandes"};
	public final String[] COD_452 = {"452", "El servidor deniega el acceso a este recurso por motivos legales"};
	
	//CODIGOS DE ESTADO 460 -> ERRORES CLIENTE PROYECTO
	public final String[] COD_460 = {"460", "No se ha podido crear el proyecto"};
	public final String[] COD_461 = {"461", "No se ha podido eliminar el proyecto"};
	public final String[] COD_462 = {"462", "Debe eliminar las tareas del proyecto para poder borrar el proyecto"};
	public final String[] COD_463 = {"463", "No se ha podido actualizar el proyecto"};
	public final String[] COD_464 = {"464", "No se pueden mostrar las tareas del proyecto"};
	
	//CODIGOS DE ESTADO 470 -> ERRORES CLIENTE TAREAS
	public final String[] COD_470 = {"470", "No se ha podido crear la tarea"};
	public final String[] COD_471 = {"471", "No se ha podido eliminar la tarea"};
	public final String[] COD_473 = {"473", "No se ha podido actualizar la tarea"};
	
	//CODIGOS DE ESTADO 480 -> ERRORES CLIENTE USUARIO
	public final String[] COD_480 = {"480", "Los datos no son correctos"};
	public final String[] COD_481 = {"481", "El usuario no pudo ser creado"};
	public final String[] COD_483 = {"483", "Error al iniciar la sesion"};
	public final String[] COD_484 = {"484", "Es necesario que este logueado"};
	
	
	//CODIGOS DE ESTADO 500 -> ERRORES DE SERVIDOR
	public final String[] COD_500 = {"500", "Error en la conexion con la base de datos"};
	public final String[] COD_501 = {"501", "Error en la conexion con el servidor"};
	public final String[] COD_502 = {"502", "El servidor ha recibido una respuesta invalida"};
	public final String[] COD_503 = {"503", "El servidor esta sobrecargado"};

}
