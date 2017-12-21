<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>MK8 - FooBarQix</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
td, th {
	border : 1px solid black;
	text-align: center;
	margin: 0px;
}

</style>
</head>
<body>

<form action='<spring:url value="/mk8"/>' method="post">
	<table>
		<thead>
			<tr>
				<th rowspan="2">#</th>
				<th rowspan="2">Nom</th>
				<th colspan="4">Vitesse</th>
				<th rowspan="2">Accél</th>
				<th rowspan="2">Poids</th>
				<th colspan="4">Maniabilitée</th>
				<th rowspan="2">Traction</th>
				<th rowspan="2">Turbo</th>
			</tr>
			<tr>
				<th>sol</th>
				<th>antig</th>
				<th>eau</th>
				<th>vol</th>
				<th>sol</th>
				<th>antig</th>
				<th>eau</th>
				<th>vol</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td rowspan="2"><input type="submit" value="u"></td>
				<td>Joueur 1</td>
				<td>${player1.landSpeed}</td>
				<td>${player1.antiGravSpeed}</td>
				<td>${player1.waterSpeed}</td>
				<td>${player1.glidingSpeed}</td>
				<td>${player1.acceleration}</td>
				<td>${player1.weight}</td>
				<td>${player1.landHandling}</td>
				<td>${player1.antiGravHandling}</td>
				<td>${player1.waterHandling}</td>
				<td>${player1.glidingHandling}</td>
				<td>${player1.traction}</td>
				<td>${player1.miniTurbo}</td>
			</tr>
			<tr>
				<td>Joueur 2</td>
				<td>${player2.landSpeed}</td>
				<td>${player2.antiGravSpeed}</td>
				<td>${player2.waterSpeed}</td>
				<td>${player2.glidingSpeed}</td>
				<td>${player2.acceleration}</td>
				<td>${player2.weight}</td>
				<td>${player2.landHandling}</td>
				<td>${player2.antiGravHandling}</td>
				<td>${player2.waterHandling}</td>
				<td>${player2.glidingHandling}</td>
				<td>${player2.traction}</td>
				<td>${player2.miniTurbo}</td>
			</tr>
			<c:forEach items="${drivers}" var="stat">
				<tr>
					<td>
						<input type="radio" name="driver1" value="${stat.id}" <c:if test="${player1.driver.id==stat.id}">checked="checked"</c:if>>
						<input type="radio" name="driver2" value="${stat.id}" <c:if test="${player2.driver.id==stat.id}">checked="checked"</c:if>>
					</td>
					<td><c:forEach items="${stat.names}" var="name">${name} </c:forEach></td>
					<td>${stat.landSpeed}</td>
					<td>${stat.antiGravSpeed}</td>
					<td>${stat.waterSpeed}</td>
					<td>${stat.glidingSpeed}</td>
					<td>${stat.acceleration}</td>
					<td>${stat.weight}</td>
					<td>${stat.landHandling}</td>
					<td>${stat.antiGravHandling}</td>
					<td>${stat.waterHandling}</td>
					<td>${stat.glidingHandling}</td>
					<td>${stat.traction}</td>
					<td>${stat.miniTurbo}</td>
				</tr>
			</c:forEach>
			<tr><td colspan="14" style="text-align: center">Kart</td></tr>
			<c:forEach items="${karts}" var="stat">
				<tr>
					<td>
						<input type="radio" name="kart1" value="${stat.id}" <c:if test="${player1.kart.id==stat.id}">checked="checked"</c:if>>
						<input type="radio" name="kart2" value="${stat.id}" <c:if test="${player2.kart.id==stat.id}">checked="checked"</c:if>>
					</td>
					<td><c:forEach items="${stat.names}" var="name">${name} </c:forEach></td>
					<td>${stat.landSpeed}</td>
					<td>${stat.antiGravSpeed}</td>
					<td>${stat.waterSpeed}</td>
					<td>${stat.glidingSpeed}</td>
					<td>${stat.acceleration}</td>
					<td>${stat.weight}</td>
					<td>${stat.landHandling}</td>
					<td>${stat.antiGravHandling}</td>
					<td>${stat.waterHandling}</td>
					<td>${stat.glidingHandling}</td>
					<td>${stat.traction}</td>
					<td>${stat.miniTurbo}</td>
				</tr>
			</c:forEach>
			<tr><td colspan="14" style="text-align: center">Pneu</td></tr>
			<c:forEach items="${tires}" var="stat">
				<tr>
					<td>
						<input type="radio" name="tire1" value="${stat.id}" <c:if test="${player1.tire.id==stat.id}">checked="checked"</c:if>>
						<input type="radio" name="tire2" value="${stat.id}" <c:if test="${player2.tire.id==stat.id}">checked="checked"</c:if>>
					</td>
					<td><c:forEach items="${stat.names}" var="name">${name} </c:forEach></td>
					<td>${stat.landSpeed}</td>
					<td>${stat.antiGravSpeed}</td>
					<td>${stat.waterSpeed}</td>
					<td>${stat.glidingSpeed}</td>
					<td>${stat.acceleration}</td>
					<td>${stat.weight}</td>
					<td>${stat.landHandling}</td>
					<td>${stat.antiGravHandling}</td>
					<td>${stat.waterHandling}</td>
					<td>${stat.glidingHandling}</td>
					<td>${stat.traction}</td>
					<td>${stat.miniTurbo}</td>
				</tr>
			</c:forEach>
			<tr><td colspan="14" style="text-align: center">Aile</td></tr>
			<c:forEach items="${wings}" var="stat">
				<tr>
					<td>
						<input type="radio" name="wing1" value="${stat.id}" <c:if test="${player1.wing.id==stat.id}">checked="checked"</c:if>>
						<input type="radio" name="wing2" value="${stat.id}" <c:if test="${player2.wing.id==stat.id}">checked="checked"</c:if>>
					</td>
					<td><c:forEach items="${stat.names}" var="name">${name} </c:forEach></td>
					<td>${stat.landSpeed}</td>
					<td>${stat.antiGravSpeed}</td>
					<td>${stat.waterSpeed}</td>
					<td>${stat.glidingSpeed}</td>
					<td>${stat.acceleration}</td>
					<td>${stat.weight}</td>
					<td>${stat.landHandling}</td>
					<td>${stat.antiGravHandling}</td>
					<td>${stat.waterHandling}</td>
					<td>${stat.glidingHandling}</td>
					<td>${stat.traction}</td>
					<td>${stat.miniTurbo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>


</html>
