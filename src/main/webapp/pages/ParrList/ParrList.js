/*
 *  Use following services as dependency injection:
 * 'Utils' for Utility service
 * 'DialogService' for Dialog service
 * 'i18nService' for i18n service
 * 'SpinnerService' for Spinner service
 * 'ToasterService' for Toaster service
 * 'HttpService' for Http service
 * example: var utils = App.getDependency('Utils');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
};

Partial.CreateClick = function($event, widget) {
    App.Variables.errorMsg.dataSet.dataValue = null;
    App.Variables.successMessage.dataSet.dataValue = null;
    Partial.Variables.ParrPageName.dataSet.dataValue = 'CreateParr';
};

Partial.getPaymentArrangementTable1_idOnClick = function($event, widget, row) {



    Partial.Variables.ParrPageName.dataSet.dataValue = 'ParrDetail';
};

App.refreshParrList = function() {

    Partial.Variables.CollectionEntityGetPaymentArrangement.setInput({

        "entityId": Partial.pageParams.entityId
    });
    Partial.Variables.CollectionEntityGetPaymentArrangement.invoke();
};

/*Partial.CollectionEntityGetPaymentArrangementonError = function(variable, data, xhrObj){
	
};*/