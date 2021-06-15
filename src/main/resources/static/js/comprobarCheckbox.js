// $(document).ready(function(){
// 		var cantidadMaxima=2;
// 	// Evento que se ejecuta al soltar una tecla en el input
// 	$("#cantidad").keydown(function(){
// 		$("input[type=checkbox]").prop('checked', false);
// 		$("#seleccionados").html("0");
// 	});
 
// 	// Evento que se ejecuta al pulsar en un checkbox
// 	$("input[type=checkbox]").change(function(){
 
// 		// Cogemos el elemento actual
// 		var elemento=this;
// 		var contador=0;
 
// 		// Recorremos todos los checkbox para contar los que estan seleccionados
// 		$("input[type=checkbox]").each(function(){
// 			if($(this).is(":checked"))
// 				contador++;
// 		});
 

 
// 		// Comprovamos si supera la cantidad máxima indicada
// 		if(contador>cantidadMaxima)
// 		{
// 			alert("Has seleccionado mas checkbox que los indicados");
 
// 			// Desmarcamos el ultimo elemento
// 			$(elemento).prop('checked', false);
// 			contador--;
// 		}
 
// 		$("#seleccionados").html(contador);
// 	});
// });