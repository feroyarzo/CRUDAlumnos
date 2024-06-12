function eliminar(id) {
swal({
	title: "Esta seguro de Eliminar?",
	text: "",
	icon: "warning",
	buttons: true,
	dangerMode: true,
})
.then((OK) => {
	if (OK) {
	$.ajax({
	url:"/alumnos/"+id,
	success:function(res) {
	console.log(res)
	location.href="/alumnos";
	},
 });
}
});
}