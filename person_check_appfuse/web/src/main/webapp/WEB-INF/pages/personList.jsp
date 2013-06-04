<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personList.title"/></title>
    <meta name="menu" content="PersonMenu"/>
</head>

<div class="span10">
    <h2><fmt:message key="personList.heading"/></h2>

    <form method="get" action="${ctx}/persons" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="personList.message"/>

    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/editPerson'/>" >
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
        </a>
        <a class="btn" href="<c:url value="/mainMenu"/>" >
            <i class="icon-ok"></i> <fmt:message key="button.done"/>
        </a>
    </div>

    <display:table name="persons" class="table table-condensed table-striped table-hover" requestURI="" id="personList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="editPerson" media="html"
            paramId="id" paramProperty="id" titleKey="person.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="person.id"/>
        <display:column property="name" sortable="true" titleKey="person.name"/>
        <display:column property="age" sortable="true" titleKey="person.age"/>
        <display:column property="sex" sortable="true" titleKey="person.sex"/>
        <display:column property="idCard" sortable="true" titleKey="person.idCard"/>
        
        <display:column sortProperty="ifPic" sortable="true" titleKey="person.ifPic">
            <input type="checkbox" disabled="disabled" <c:if test="${personList.ifPic}">checked="checked"</c:if>/>
        </display:column>
        
         <display:column property="job" sortable="true" titleKey="person.job"/>
        <display:column sortProperty="ifBeon" sortable="true" titleKey="person.ifBeon">
            <input type="checkbox" disabled="disabled" <c:if test="${personList.ifBeon}">checked="checked"</c:if>/>
        </display:column>
        <display:column property="politicLevel" sortable="true" titleKey="person.politicLevel"/>
        
       <display:column property="gpsCard" sortable="true" titleKey="person.gpsCard"/>
        <display:column property="lightCard" sortable="true" titleKey="person.lightCard"/>
        
        <display:column property="normalTime" sortable="true" titleKey="person.normalTime"/>
        
        <display:column sortProperty="specType" sortable="true" titleKey="person.specType">
            <input type="checkbox" disabled="disabled" <c:if test="${personList.specType}">checked="checked"</c:if>/>
        </display:column>
        <display:column property="workCard" sortable="true" titleKey="person.workCard"/>
        <display:column property="workType" sortable="true" titleKey="person.workType"/>
        
        <display:column property="team.name" sortable="true" titleKey="person.team"/>
        <display:column property="unit.name" sortable="true" titleKey="person.unit"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="personList.person"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="personList.persons"/></display:setProperty>

        <display:setProperty name="export.excel.filename"><fmt:message key="personList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="personList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="personList.title"/>.pdf</display:setProperty>
    </display:table>
</div>
