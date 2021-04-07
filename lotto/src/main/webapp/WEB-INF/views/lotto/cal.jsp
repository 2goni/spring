<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../includes/header.jsp"%>

 <div class="masthead" style= "width:100%;">
    <div class="masthead-bg" style="transform:none;"></div>
    <div class="container h-100" >
      <div class="row h-100">
        <div class="col-12 my-auto">
          <div class="masthead-content text-white py-5 py-md-0" style="text-align: center">
<h1 class="mb-3" style="font-size:3.3rem; text-align: center" >:: 행운의 번호 ::</h1>
<h2 ></h2>
	  <script src="https://d3js.org/d3.v5.min.js"></script>
  <script>

    var ColorScale =  d3.scaleQuantize().domain([1,50]) //color 범위 지정함
      .range(["orange","blue","red","black","green"]);

    var data= [${lotto[0]},${lotto[1]},${lotto[2]},${lotto[3]},${lotto[4]},${lotto[5]}];

    var svg = d3.select("h2").append("svg")
      .attr("width",1000)
      .attr("height",50)
      //.style("background-color","yellow")
      .append("g")
      .attr("transform", "translate(" + 20 + "," + 20 + ")");

      var circle = svg.selectAll("circle").data(data) //볼 circle
          circle.enter().append("circle")
            .attr("cx",function(d,i){ return i*50+100;})
            .attr("cy",5)
            .attr("r",20)
            .attr("fill",function(d){return ColorScale(d); })
          circle.exit().remove();

      var text = svg.selectAll("text").data(data) //번호 text
          text.enter().append("text")
          .attr("x",function(d,i){ return i*50+90;})
          .attr("y",15)
          .attr("fill","white")
          .attr("font-size","25px")
          .text(function(d){return d;})
          text.exit().remove();

      var chtext = svg.append("text")  //회차 text
          .attr("x",0)
          .attr("y",15)
          .attr("fill","blue")
          .attr("font-size","25px")

  </script>
	<br>
	<button style="" class="btn btn-secondary" onclick="location.href = 'main'" >메인으로</button>
	 </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
	
	
	
</body>
</html>