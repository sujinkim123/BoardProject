function get_option2(option1, selectOption) {
	$.ajax({
		type: 'GET',
		url: '/' + option1,
		contentType: "application/json; charset=UTF-8",
		dataType: 'json',
		success: function(result) {
			console.log(result)
			for(i = 0; i < result.length; i++) {
				selectOption.option[i] = new Option(result[i], i);
			}
		}
	}).fail(function (error) {
		alert(JSON.stringfy(error));
	})
}