function checkcedula(){
	var feedback_cedula = document.getElementById('feedback_cedula');
		if(this.value.length < 5){
			feedback_cedula.textContent = 'Por favor incgrese la cedula';
		}else{
			feedback_cedula.textContent = '';
		}
}


function checknombre(){
	 var feedback_nombre=document.getElementById('feedback_nombre');
	 if(this.value.length < 5){
		 feedback_nombre.textContent = "Por favor ingrese el nombre";
	 }else{
		 feedback_nombre.textContent ='';
	 }
}


	
function checkapellido(){
	var feedback_apellido=document.getElementById('feedback_apellido');
	if(this.value.length < 5){
		feedback_apellido.textContent = "Por favor ingrese el apellido";
	}else {
		feedback_apellido.textContent ="";
	}
}


function checkcurso(){
	var feedback_curso = document.getElementById('feedback_curso');
	if(this.value.length < 5){
		feedback_curso.textContent="Por favor ingrese el nombre del curso";
	}else{
		feedback_curso.textContent="";
	}
}

window.onload = function(){
	var lacedula = document.getElementById('cedula');
	lacedula.onblur = checkcedula;
	
	var elnombre = document.getElementById('nombre');
	elnombre.onblur = checknombre;
	
	var elapellido = document.getElementById('apellido');
	elapellido.onblur = checkapellido;
	
	var elcurso = document.getElementById('curso');
	elcurso.onblur =checkcurso;
}