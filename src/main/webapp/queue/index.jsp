<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!-- RichFaces tag library declaration -->
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<html>
<head>
<title>Payments Queue Status</title>
</head>
<body>

	<f:view>
		<a4j:form>
			<rich:panel header="Remote EJB Test" style="width: 315px">
				<h:outputText value="Your name: " />
				<h:inputText value="#{user.name}">
					<f:validateLength minimum="1" maximum="30" />
				</h:inputText>
				<a4j:commandButton value="Get greeting" reRender="greeting" />
			</rich:panel>
		</a4j:form>

		<a4j:keepAlive beanName="paymentnotificationbean" ajaxOnly="true" />
		<h:form>
			<rich:datascroller align="left" for="payments" maxPages="2"
				page="#{paymentnotificationbean.scrollerPage}" reRender="sc2" id="sc1" />
			<rich:spacer height="30" />
			<rich:extendedDataTable value="#{paymentnotificationbean.payments}"
				var="payment" width="500px" height="500px" id="payments"
				selectedClass="dataTableSelectedRow" sortMode="single"
				selectionMode="multi" selection="#{extendedDT.selection}"
				rowKeyVar="rkvar" tableState="#{extendedDT.tableState}">

				<rich:column width="200">
					<f:facet name="header">
						<h:outputText value="Transaction Date" />
					</f:facet>
					<h:outputText value="#{payment.transactionDate}">
						<f:convertDateTime pattern="yyyy-m-dd HH:mm:ss.S" />
					</h:outputText>
				</rich:column>

				<rich:column width="200" sortable="true"
					sortBy="#{payment.invoiceNo}" sortIconAscending="dataTableAscIcon"
					sortIconDescending="dataTableDescIcon">
					<f:facet name="header">
						<h:outputText value="Invoice No" />
					</f:facet>
					<h:outputText value="#{payment.invoiceNo}" />
				</rich:column>

				<rich:column width="200">
					<f:facet name="header">
						<h:outputText value="Amount" />
					</f:facet>
					<h:outputText value="#{payment.currencyCode}. " />
					<h:outputText value="#{payment.amount}">
						<f:convertNumber groupingUsed="true" minFractionDigits="2" />
					</h:outputText>
				</rich:column>

				<rich:column width="200">
					<f:facet name="header">
						<h:outputText value="Payment Mode" />
					</f:facet>
					<h:outputText value="#{payment.paymentMode}" />
				</rich:column>


				<rich:column width="300">
					<f:facet name="header">
						<h:outputText value="Transaction Ref" />
					</f:facet>
					<h:outputText value="#{payment.transactionRef}" />
				</rich:column>

				<rich:column width="300">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{payment.status}" />
				</rich:column>

			</rich:extendedDataTable>
			<rich:datascroller align="left" for="payments" maxPages="20" page="1"
				id="sc2" reRender="sc1" />
		</h:form>
	</f:view>



</body>
</html>