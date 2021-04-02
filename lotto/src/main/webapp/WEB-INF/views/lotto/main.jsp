<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>        
  <script>
    var count = 0;
    $(document).ready(function(){
     $(".btn_add").on('click',function(){
    	 if(count == 6) return;
      $(".depth_div").append("<label><input type='number' min=1 max=45 name=manual"+count+" required></label><br/>");
		count++;
    });
    $(".btn_mi").on('click',function(){
    	if(count == 0) return;
        $(".depth_div label:last").remove();
        $(".depth_div br:last").remove();
        if(count > 0) count--;
     });
});
    var check = [];
    function check(){
    	  for(var i=0; i<count; i++){
    		  var a = document.getElementsByName("manual"+count).values;
    		  check[i] = a;
    	    for(var j=0; j<i; j++){
    	   		if(check[i]==check[j]){
    	   			alert("중복발생");
    	   		} 
    	  }
    	}
    }
    </script>
</head>
<body>
	로또 생성기
	<form action="/lotto/cal" method="post" name="form1" onsubmit="check()">
	생년: <input type="number" min=1 max=9999 name="year" placeholder="ex)1994" required> <br>
	생월: <input type="number" min=1 max=12 name="month" required> <br>
	생일: <input type="number" min=1 max=31 name="day" required> <br><br>
	::수동 입력칸	추가 버튼::<br>
	<div class=depth_div>         
	<input type="button" class="btn_add" value="추가">
	<input type="button" class="btn_mi" value="삭제"><br>
	
	</div>
	<button type="submit">로또번호 확인</button>
	</form>
</body>
</html>