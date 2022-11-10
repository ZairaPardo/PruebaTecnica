$(document).ready(function() {
	$('#tableC').DataTable({
		ajax: {
			url: 'http://localhost:9090/prueba/all'
		},
		columns: [

			{ data: "numDocumento" },
			{ data: "nombre" },
			{ data: "apellido" },
			{ data: "fechaNacimiento" },
			{ data: "ciudad" },
			{ data: "correo" },
			{ data: "telefono" },
			{ data: "ocupacion" },
			{ defaultContent: "<button class='btn btn-success'>Editar</button>" }
		]
	});
});


$(document).ready(function () {
    $('#example').DataTable();
});


function eliminar(){

	var numDocumento = document.getElementById("txt_id").value;
	location.href="/prueba/cliente/eliminar/" + numDocumento;
	
}

function confirmar(numDocumento){
	document.getElementById("txt_id").value=numDocumento;

}

function calcularEdad(fecha) {
    var hoy = new Date();
    var cumpleanos = new Date(fecha);
    var edad = hoy.getFullYear() - cumpleanos.getFullYear();
    var m = hoy.getMonth() - cumpleanos.getMonth();

    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }

    console.log(edad);
    
    var esviable = "";
 
 	if(edad >= 18 && edad <=68){
		 
		 esviable = "Viable";
	 }else{
		 esviable = "No Viable";
	 }
	 document.getElementById("via").value=esviable;
}


var input = document.getElementById("myinput");
new Awesomplete(input, {
	list: ["Ada", "Java", "JavaScript", "Brainfuck", "LOLCODE", "Node.js", "Ruby on Rails"]
});