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

    App.showRowExpansionEntityViewHome = function(row, data) {
        debugger;
        Partial.Widgets.custRisk.caption = row.risk;
        Partial.Widgets.custValue.caption = row.entityValue;
        Partial.Widgets.collStatus.caption = row.entityCollectionStatus;
        Partial.Widgets.manualColl.caption = row.manualFlag;
        Partial.Widgets.lastTRMT.caption = row.lastTreatment;
        Partial.Widgets.workCategory.caption = row.primeWorkCategory;
        Partial.Widgets.subPortfolio.caption = row.portfolioSubCategory;
    }
};