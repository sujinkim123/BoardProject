  function doAction() {
	  
	$.ajax({ 
    type: 'GET', 
    //전달 방식
    url: "/admin/test",
    //controller에서 호출 할 URL
    dataType: "json",
    data: {
	  userId : userId, 
	  codeType: codeType
    }, 
    success: function(data){
      if( typeof(data.cateList) != "undefined" ) {

	  //가져온 data가 있을 경우 변수에 담아준다.
	    var list = data.cateList;
	    
	    console.log('>>> ' + list);

     //가져온 값들 중 codsType code2에 담아주고
     $("#" + code2).html("<option value=''>-선택하세요-</option>");

     //두번째 select박스의 첫번째는 기본으로 선택하라는텍스트를 넣어준다.
     $(list).each(function(i) {
       var code = list[i].code;
       var code_name = list[i].code_name;
       //그리고 값들은 여러 값이기때문에 list에 담아서 뿌려주기~
       $("#" + code2).append("<option value='" + code + "'>" + code_name + "</option>");
      });
     } else if(data.result == "error") {
      alert("오류");
     }
    },
    error: function(error) {
     alert(error);
    }
  });
   
  }
  
 