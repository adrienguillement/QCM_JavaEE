<%@ include file="header.jspf"%>
<title>Acc�s restreint</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="./Navbars/navbar_noConnected.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<h2>Acc�s restreint</h2>
				Vous devez �tre connecter pour acc�der au site. Retourner � l'<a
					href="<%=request.getContextPath()%>">accueil</a>.
			</div>
		</div>
	</div>
</body>
</html>