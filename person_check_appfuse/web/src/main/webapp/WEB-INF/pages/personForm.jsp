<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="personDetail.title" /></title>
<meta name="heading" content="<fmt:message key='personDetail.heading'/>" />
</head>

<c:set var="delObject" scope="request">
	<fmt:message key="personList.person" />
</c:set>
<script type="text/javascript">
	var msgDelConfirm = "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
	<h2>
		<fmt:message key="personDetail.heading" />
	</h2>
	<fmt:message key="personDetail.message" />
</div>

<div class="span7">
	<s:form id="personForm" action="savePerson" method="post"
		validate="true" cssClass="well form-horizontal">
		<s:hidden key="person.id" />
		<s:textfield key="person.name" required="true" maxlength="200" />
		<s:textfield key="person.age" required="false" maxlength="255" />
		
		<s:select list="#{getText('') }"/>
		
		<s:textfield key="person.gpsCard" required="false" maxlength="200" />
		<s:textfield key="person.idCard" required="true" maxlength="20" />
		<s:checkbox key="person.ifBeon" theme="css_xhtml" />
		<s:checkbox key="person.ifPic" theme="css_xhtml" />
		<s:textfield key="person.job" required="false" maxlength="200" />
		<s:textfield key="person.lightCard" required="false" maxlength="200" />
		
		<s:textfield key="person.normalTime" required="true" maxlength="255" />
		<s:textfield key="person.politicLevel" required="false"
			maxlength="200" />
		
		<s:checkbox key="person.specType" theme="css_xhtml" />
		<s:textfield key="person.workCard" required="true" maxlength="200" />
		<s:textfield key="person.workType" required="false" maxlength="200" />

		<s:doubleselect key="person.unit" name="person.unit.id" list="units"
			listKey="id" listValue="name" doubleList="top.getTeams()"
			doubleName="person.team.id" doubleListKey="id" doubleListValue="name"/>

		<div id="actions" class="form-actions">
			<s:submit type="button" cssClass="btn btn-primary" method="save"
				key="button.save" theme="simple">
				<i class="icon-ok icon-white"></i>
				<fmt:message key="button.save" />
			</s:submit>
			<c:if test="${not empty person.id}">
				<s:submit type="button" cssClass="btn btn-warning" method="delete"
					key="button.delete" onclick="return confirmMessage(msgDelConfirm)"
					theme="simple">
					<i class="icon-trash icon-white"></i>
					<fmt:message key="button.delete" />
				</s:submit>
			</c:if>
			<s:submit type="button" cssClass="btn" method="cancel"
				key="button.cancel" theme="simple">
				<i class="icon-remove"></i>
				<fmt:message key="button.cancel" />
			</s:submit>
		</div>
	</s:form>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['personForm']).focus();
			});
</script>
