<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Shopping is Fun!</title>
	<link rel="stylesheet" type="text/css" href="easyui.css">
	<link rel="stylesheet" type="text/css" href="icon.css">
	<script type="text/javascript" src="jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="jquery.easyui.min.js"></script>
	<style type="text/css">
		.products{
			list-style:none;
			margin-right:300px;
			padding:0px;
			height:100%;
		}
		.products li{
			display:inline;
			float:left;
			margin:10px;
		}
		.item{
			display:block;
			text-decoration:none;
		}
		.item img{
			border:1px solid #333;
		}
		.item p{
			margin:0;
			font-weight:bold;
			text-align:center;
			color:#000000;
		}
		.cart{
			position:fixed;
			right:0;
			top:0;
			width:300px;
			height:100%;
			background:yellow;
			padding:0px 10px;
		}
		h1{
			text-align:center;
			color:#555;
		}
		h2{
			position:absolute;
			font-size:16px;
			left:10px;
			bottom:20px;
			color:#555;
		}
		.total{
			margin:0;
			text-align:right;
			padding-right:20px;
		}
		
	</style>
	<script>
		var data = {"total":0,"rows":[]};
		var totalCost = 0;
		
		$(function(){
			$('#cartcontent').datagrid({
				singleSelect:true
			});
			$('.item').draggable({
				revert:true,
				proxy:'clone',
				onStartDrag:function(){
					$(this).draggable('options').cursor = 'not-allowed';
					$(this).draggable('proxy').css('z-index',10);
				},
				onStopDrag:function(){
					$(this).draggable('options').cursor='move';
				}
			});
			$('.cart').droppable({
				onDragEnter:function(e,source){
					$(source).draggable('options').cursor='auto';
				},
				onDragLeave:function(e,source){
					$(source).draggable('options').cursor='not-allowed';
				},
				onDrop:function(e,source){
					var name = $(source).find('p:eq(0)').html();
					var price = $(source).find('p:eq(1)').html();
					addProduct(name, parseFloat(price.split('Rs.')[1]));
				}
			});
		});
		
		function addProduct(name,price){
			function add(){
				for(var i=0; i<data.total; i++){
					var row = data.rows[i];
					if (row.name == name){
						row.quantity += 1;
						return;
					}
				}
				data.total += 1;
				data.rows.push({
					name:name,
					quantity:1,
					price:price
				});
			}
			add();
			totalCost += price;
			$('#cartcontent').datagrid('loadData', data);
			$('div.cart .total').html('Total: Rs.'+totalCost);

		}
	</script>
</head>
<body style="margin:0;padding:0;height:100%;">
<div style="border:1px solid #cccccc;padding: 10px;" contextmenu="mymenu">
<p><font size="30" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shopping is Fun!</font>

<menu type="context" id="mymenu">
  
</menu>

<font size="20" color="red">MOBILE PHONES</font>
		<ul class="products">
		<li>
			<a href="#" class="item">
				<img src="samsung.jpg">
				<div>
					<p>Samsung</p>
					<p>Price:Rs.25000</p>
				</div>
			</a>
		</li>
		<li>
			<a href="#" class="item">
				<img src="nokia.jpeg">
				<div>
					<p>Nokia</p>
					<p>Price:Rs.15000</p>
				</div>
			</a>
		</li>
		<li>
			<a href="#" class="item">
				<img src="micromax.jpg">
				<div>
					<p>Micromax</p>
					<p>Price:Rs.10000</p>
				</div>
			</a>
		</li>
		<li>
			<a href="#" class="item">
				<img src="Karbonn.jpg">
				<div>
					<p>Karbonn</p>
					<p>Price:Rs.8000</p>
				</div>
			</a>
		</li>
		<li>
			<a href="#" class="item">
				<img src="asus.jpg">
				<div>
					<p>Asus</p>
					<p>Price:Rs.9999</p>
				</div>
			</a>
		</li>
		<li>
			<a href="#" class="item">
				<img src="intex.jpeg">
				<div>
					<p>Intex</p>
					<p>Price:Rs.8499</p>
				</div>
			</a>
		</li>
	</ul>
	<div class="cart">
		<h1><font size="20" color="violet">My Shopping Cart</font></h1>
		<div style="background:#ffffff">
		<table id="cartcontent" fitColumns="true" style="width:300px;height:auto;">
			<thead>
				<tr>
					<th field="name" width=140>Name</th>
					<th field="quantity" width=60 align="right">Quantity</th>
					<th field="price" width=60 align="right">Price</th>
				</tr>
			</thead>
		</table>
		</div>
		<p class="total">Total: Rs.0</p><br>
		<h2><font size="5" color="green">Drag your desired item from the palette and drop it onto the table to add it to your cart!!</font></h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button ng-click="save()">Save My Cart!!</button>	
</div>
</body>
</html>