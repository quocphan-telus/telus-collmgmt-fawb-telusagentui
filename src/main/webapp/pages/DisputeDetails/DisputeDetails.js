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


Partial.anchor3Click = function($event, widget) {
    Partial.Variables.DisputePageName.dataSet.dataValue = 'DisputeList';
};

/* for panel expand and collapse*/
Partial.disputeHistoryExpand = function($event, widget) {
    Partial.IsExpandedIS = true;
};
Partial.disputeHistoryCollapse = function($event, widget) {
    Partial.IsExpandedIS = false;
};


Partial.CancelDisputeSubmitClick = function($event, widget) {
    debugger;
    Partial.Widgets.cancelledReasonValue.datavalue;
    Partial.Widgets.CommentsCancelDispute.datavalue;


    Partial.Variables.updateDisputeService.setInput({
        "id": 10,
        "CollectionDisputeUpdate": {
            'CollectionDisputeStatus': [{
                'reason': Partial.Widgets.cancelledReasonValue.datavalue.dataValue
            }]
        }
    });


    Partial.Variables.updateDisputeService.invoke();

    Partial.Widgets.cancelDisputeConfirmation.close()

};