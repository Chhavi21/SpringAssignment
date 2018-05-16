<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html style="width: 1271px; height: 792px">
<head>
<style type="text/css">
html, body {
    height: 100%;
}
html {
    display: table;
    margin: auto;
 position: relative;
    height: 100%;
    width: 100%;
}
body {
  display: table-cell;
  font: 13px/20px 'Lucida Grande', Tahoma, Verdana, sans-serif;
  color: #404040;
  background: #ffffff;
  text-align: center;
}
div {
 margin-left: 2 px;
 text-align: left;
}
table {
text-align:center;
font-family:Arial, Helvetica, sans-serif;
color:#000;
font-size:14px;
text-shadow: 1px 1px 0px #fff;
background:#ededed;
margin:20px;
border:#ccc 1px solid;
-moz-border-radius:3px;
-webkit-border-radius:3px;
border-radius:3px;
-moz-box-shadow: 0 1px 2px #d1d1d1;
-webkit-box-shadow: 0 1px 2px #d1d1d1;
box-shadow: 0 1px 2px #d1d1d1;

}
table th {
padding:21px 25px 22px 25px;
border-top:1px solid #fafafa;
border-bottom:1px solid #e0e0e0;
background: #ededed;
background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
}
table a:link {
color: #666;
font-weight: bold;
text-decoration:none;
}
table a:visited {
color: #999999;
font-weight:bold;
text-decoration:none;
}
table a:active,
table a:hover {
color: #bd5a35;
text-decoration:underline;
}
table tr:first-child th:first-child {
-moz-border-radius-topleft:3px;
-webkit-border-top-left-radius:3px;
border-top-left-radius:3px;
}
table tr:first-child th:last-child {
-moz-border-radius-topright:3px;
-webkit-border-top-right-radius:3px;
border-top-right-radius:3px;
}
table tr {
text-align: left;
padding-left:20px;
}
table td:first-child {
text-align: left;
padding-left:20px;
border-left: 0;
}
table td {
padding:18px;
border-top: 1px solid #ffffff;
border-bottom:1px solid #e0e0e0;
border-left: 1px solid #e0e0e0;
background: #ffffff;
background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table tr.even td {
background: #ffffff;
background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table tr:last-child td {
border-bottom:0;
}
table tr:last-child td:first-child {
-moz-border-radius-bottomleft:3px;
-webkit-border-bottom-left-radius:3px;
border-bottom-left-radius:3px;
}
table tr:last-child td:last-child {
-moz-border-radius-bottomright:3px;
-webkit-border-bottom-right-radius:3px;
border-bottom-right-radius:3px;
}
table tr:hover td {
background: #f2f2f2;
background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);
}
</style>
<spring:url value="/app/dashboard" var="pageurl" />
<link href="${style}" rel="stylesheet" />
<title>Assignment_Country Example</title>
</head>

<body><div class="container" style="margin: 10px; border: 1px solid green; ">
			<div>
				<form action="/logout" method="post">
					<button type="submit" class="btn btn-danger">Log Out</button>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				</form>
			</div>
			<div>
				<c:set var="pageListHolder" value="${countries}" scope="session" />
				<table cellspacing="0" width="100%">
					<thead>
						<tr>
							<td colspan="28"><h1>Country Information</h1></td>
						</tr>
						<tr>
							<td>Name</td>
							<td><strong>Alpha2code</strong></td>
							<td><strong>Alpha3code</strong></td>
							<td><strong>Capital</strong></td>
							<td><strong>Region</strong></td>
							<td><strong>Subregion</strong></td>
							<td><strong>Population</strong></td>
							<td><strong>Demonym</strong></td>
							<td><strong>Area</strong></td>
							<td><strong>Gini</strong></td>
							<td><strong>Nativename</strong></td>
							<td><strong>Numericcode</strong></td>
							<td><strong>Relevance</strong></td>
							<td><strong>Languages</strong></td>
							<td><strong>Currencies</strong></td>
							<td><strong>Timezones</strong></td>
							<td><strong>Callingcodes</strong></td>
							<td><strong>Latlng</strong></td>
							<td><strong>Topleveldomain</strong></td>
							<td><strong>Altspellings</strong></td>
							<td><strong>Borders</strong></td>
							<td><strong>De</strong></td>
							<td><strong>Es</strong></td>
							<td><strong>Fr</strong></td>
							<td><strong>Ja</strong></td>
							<td><strong>It</strong></td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="country" items="${pageListHolder.pageList}">
							<tr>
								<td>${country.name}</td>
								<td>${country.alpha2Code}</td>
								<td>${country.alpha3Code}</td>
								<td>${country.capital}</td>
								<td>${country.region}</td>
								<td>${country.subregion}</td>
								<td>${country.population}</td>
								<td>${country.demonym}</td>
								<td>${country.area}</td>
								<td>${country.gini}</td>
								<td>${country.nativeName}</td>
								<td>${country.numericCode}</td>
								<td>${country.relevance}</td>
								<td>${country.languages}</td>
								<td>${country.currencies}</td>
								<td>${country.timezones}</td>
								<td>${country.callingCodes}</td>
								<td>${country.latlng}</td>
								<td>${country.topLevelDomain}</td>
								<td>${country.altSpellings}</td>
								<td>${country.borders}</td>
								<td>${country.translations.de}</td>
								<td>${country.translations.es}</td>
								<td>${country.translations.fr}</td>
								<td>${country.translations.ja}</td>
								<td>${country.translations.it}</td>
								<td><a href="/app/editCountry?name=${country.name}">Edit</a></td>
								<td><a href="/app/deleteCountry?name=${country.name}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<span style="float: left;"> <c:choose>
							<c:when test="${pageListHolder.firstPage}">Prev</c:when>
							<c:otherwise>
								<a href="${pageurl}/prev">Prev</a>
							</c:otherwise>
						</c:choose>
					</span> <span> <c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
    &nbsp;&nbsp;
    <c:choose>
								<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
								<c:otherwise>
									<a href="${pageurl}/${loop.index}">${loop.index+1}</a>
								</c:otherwise>
							</c:choose>
    &nbsp;&nbsp;
    </c:forEach>
					</span> <span> <c:choose>
							<c:when test="${pageListHolder.lastPage}">Next</c:when>
							<c:otherwise>
								<a href="${pageurl}/next">Next</a>
							</c:otherwise>
						</c:choose>
					</span>
				</div>
				<h3>
					<a href="/app/addCountry">Add Country</a>
				</h3>

			</div>
		</div><div>
		
</body>
</html>