<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../includes/header.jsp"%>
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>   
  <script>
    var count = 0;
    $(document).ready(function(){
     $(".btn_add").on('click',function(){
    	 if(count == 6) return;
      $(".depth_div").append("<label><input type='number' min=1 max=45 name=manual"+count+" id=lnum"+count+" required></label><br/>");
		count++;
    });
    $(".btn_mi").on('click',function(){
    	if(count == 0) return;
        $(".depth_div label:last").remove();
        $(".depth_div br:last").remove();
        if(count > 0) count--;
     });
});
    
    function overcheck(){
    	  for(var i=0; i<=count; i++){
    		  console.log(count);
    	    for(var j=i+1; j<count; j++){
    	   		if( document.getElementById('lnum'+i).value == document.getElementById('lnum'+j).value ){
    	   			alert("중복발생");
    	   			return false;
    	   		} 
    	  }
    	}
    }
    
    $(document).on("keypress", "input[name]", function() {$(this).val( $(this).val().replace(/[^ㄱ-힣a-zA-Z]/gi,"") );})
    
    </script>
      <div class="masthead">
    <div class="masthead-bg"></div>
    <div class="container h-100">
      <div class="row h-100">
        <div class="col-12 my-auto">
          <div class="masthead-content text-white py-5 py-md-0">
            <h1 class="mb-3" style="font-size:3.3rem">로또 번호 추첨기</h1>
	<form action="/lotto/cal" method="post" name="form1" onsubmit="return overcheck();">
	이름: <input class="form-control" id="name" type="text" name="name" required> <br>
	생년: <input class="form-control" type="number" min=1 max=9999 name="year" placeholder="ex)1994" required> <br>
	생월: <input class="form-control" type="number" min=1 max=12 name="month" required> <br>
	생일: <input class="form-control" type="number" min=1 max=31 name="day" required> <br><br>
	::수동 입력칸	추가 버튼::<br>
	<div class=depth_div>         
	<input type="button" class="btn_add btn-secondary" value="추가">
	<input type="button" class="btn_mi btn-secondary" value="삭제"><br><br>
	
	</div>
	<input class="btn btn-secondary" type="submit" value="로또번호 확인">
	</form>
	              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>