<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      async function drawChart() {

    	var dataAry = []; // 멤버별로 사용자의 건수 정보를 dataAry배열에 지정
    	dataAry.push(['userName', 'Count Per Member']);
    	
    	let r1 = await fetch('chartJson.do');
    	let r2 = await r1.json();
    	r2.forEach(item => {
    		console.log(item);
    		dataAry.push([item.userName, item.cnt])
    	})
    	
    	
        var data = google.visualization.arrayToDataTable(dataAry);

        var options = {
          title: '사용자별 작성건수',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
