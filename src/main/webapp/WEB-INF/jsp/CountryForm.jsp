<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Edit Country</title>
</head>
<body>
    <div align="center">
        <h1>Add/Edit Country</h1>
        <form:form action="/app/saveCountry" method="post" modelAttribute="country">
        <table>
            <tr><td>Name</td> <td><form:input path="name" /></td></tr>
			<tr><td>Alpha2code</td> <td><form:input path="alpha2Code" /></td></tr>
			<tr><td>Alpha3code</td> <td><form:input path="alpha3Code" /></td></tr>
			<tr><td>Capital</td> <td><form:input path="capital" /></td></tr>
			<tr><td>Region</td> <td><form:input path="region" /></td></tr>
			<tr><td>Subregion</td> <td><form:input path="subregion" /></td></tr>
			<tr><td>Population</td> <td><form:input path="population" /></td></tr>
			<tr><td>Demonym</td> <td><form:input path="demonym" /></td></tr>
			<tr><td>Area</td> <td><form:input path="area" /></td></tr>
			<tr><td>Gini</td> <td><form:input path="gini" /></td></tr>
			<tr><td>Nativename</td> <td><form:input path="nativeName" /></td></tr>
			<tr><td>Numericcode</td> <td><form:input path="numericCode" /></td></tr>
			<tr><td>Relevance</td> <td><form:input path="relevance" /></td></tr>
			<tr><td>Languages</td> <td><form:input path="languages" /></td></tr>
			<tr><td>Currencies</td> <td><form:input path="currencies" /></td></tr>
			<tr><td>Timezones</td> <td><form:input path="timezones" /></td></tr>
			<tr><td>Callingcodes</td> <td><form:input path="callingCodes" /></td></tr>
			<tr><td>Latlng</td> <td><form:input path="latlng" /></td></tr>
			<tr><td>Topleveldomain</td> <td><form:input path="topLevelDomain" /></td></tr>
			<tr><td>Altspellings</td> <td><form:input path="altSpellings" /></td></tr>
			<tr><td>Borders</td> <td><form:input path="borders" /></td></tr>
			<tr><td>De</td> <td><form:input path="translations.de" /></td></tr>
			<tr><td>Es</td> <td><form:input path="translations.es" /></td></tr>
			<tr><td>Fr</td> <td><form:input path="translations.fr" /></td></tr>
			<tr><td>Ja</td> <td><form:input path="translations.ja" /></td></tr>
			<tr><td>It</td> <td><form:input path="translations.it" /></td></tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>