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
    //Partial.Widgets.InstallmentOptions.dataValue = 'NoOfInstallments';
};

Partial.createInstalmntScheduleClick = function($event, widget) {

    var installmentSchedule = new Array();
    var amount = '';
    var remainder = 0;
    var installmentSize = '';

    //Psuedo code start
    //check if numOfInstallmetn is selected 
    if (Partial.Widgets.InstallmentOptionRadio.datavalue == 'NoOfInstallments') {
        installmentSize = Partial.Variables.NoOfInstallments.dataSet.datavalue;
        amount = Partial.Widgets.ParrTotal.datavalue / Partial.Variables.NoOfInstallments.dataSet.datavalue;
    }
    //check if amtPerInstallment is selected 
    if (Partial.Widgets.InstallmentOptionRadio.datavalue == 'AmtPerInstallment') {
        remainder = Partial.Widgets.ParrTotal.datavalue % Partial.Variables.AmountPerInstallment.dataSet.dataValue;
        installmentSize = parseInt(Partial.Widgets.ParrTotal.datavalue / Partial.Variables.AmountPerInstallment.dataSet.dataValue);
        amount = Partial.Variables.AmountPerInstallment.dataSet.dataValue;
        var lastInstallmentAmount = 0;
        if (remainder !== 0) {
            installmentSize = installmentSize + 1;
            lastInstallmentAmount = remainder;
            //input logic to add remainder into the last row of the collection PaymentInstallment, if it exists 
        }
        //ask abou installment Schedule size limitations 
    }
    // //Psuedo code End
    for (var i = 0; i < installmentSize; i++) {

        var collectionPaymentInstallment = {};
        collectionPaymentInstallment.sequenceId = i + 1;
        var tempDate = '';
        if (i == installmentSize - 1 && remainder !== 0) {
            amount = lastInstallmentAmount;
        }
        if (i > 0) {
            tempDate = new Date(installmentSchedule[i - 1].date);
        } else {
            tempDate = new Date();
        }
        if (Partial.Widgets.RecurrenceDropdown.datavalue == 'Weekly') {

            tempDate = new Date(tempDate.setDate(tempDate.getDate() + 7));
            collectionPaymentInstallment.date = new Date(tempDate);
            // collectionPaymentInstallment.date = tempDate.getMonth() + "/" + tempDate.getDate() + "/" + tempDate.getFullYear();
        } else if (Partial.Widgets.RecurrenceDropdown.datavalue == 'Bi-Weekly') {

            tempDate = new Date(tempDate.setDate(tempDate.getDate() + 15));
            collectionPaymentInstallment.date = new Date(tempDate);
            //collectionPaymentInstallment.date = tempDate.getMonth() + "/" + tempDate.getDate() + "/" + tempDate.getFullYear();
        } else if (Partial.Widgets.RecurrenceDropdown.datavalue == 'Monthly') {

            tempDate = new Date(tempDate.setMonth(tempDate.getMonth() + 1));
            collectionPaymentInstallment.date = new Date(tempDate);
            //collectionPaymentInstallment.date = tempDate.getMonth() + "/" + tempDate.getDate() + "/" + tempDate.getFullYear();
        } else {

            tempDate = new Date(tempDate.setMonth(tempDate.getMonth() + 1));
            collectionPaymentInstallment.date = new Date(tempDate);
            //collectionPaymentInstallment.date = tempDate.getMonth() + "/" + tempDate.getDate() + "/" + tempDate.getFullYear();
        }

        collectionPaymentInstallment.amount = amount;
        if (i === 0) {
            //collectionPaymentInstallment.cummPmtAmount = collectionPaymentInstallment.amount;
        } else {
            //collectionPaymentInstallment.cummPmtAmount = installmentSchedule[i - 1].amount + collectionPaymentInstallment.amount;
        }
        installmentSchedule.push(collectionPaymentInstallment);
    }
    Partial.Variables.isCreateScheduleClicked.dataSet.datavalue = 'true';
    Partial.Variables.ParrInstallmentSchedule.dataSet.splice(0, 1);
    Partial.Variables.ParrInstallmentSchedule.dataSet.push(...installmentSchedule);
    Variables.createPaymentArrangement.dataSet.installments.dataset.push(...installmentSchedule);
};

Partial.noOfInstlmntChange = function($event, widget, newVal, oldVal) {

    Partial.Variables.NoOfInstallments.dataSet.datavalue = newVal;
};

Partial.CancelClick = function($event, widget) {

    Partial.Variables.ParrPageName.dataSet.dataValue = 'ParrList';
};
Partial.RecurrenceDropdownChange = function($event, widget, newVal, oldVal) {

};
Partial.ParrTotalChange = function($event, widget, newVal, oldVal) {};

Partial.InstallmentOptionRadioChange = function($event, widget, newVal, oldVal) {

    Partial.Variables.NoOfInstallments.dataSet.datavalue = 0;
    Partial.Variables.AmountPerInstallment.dataSet.dataValue = 0;

};

Partial.ClearButtonClick = function($event, widget) {
    Partial.Variables.isCreateScheduleClicked.dataSet.datavalue = false;
};

Partial.ClearScheduleClick = function($event, widget) {
    Partial.Widgets.Comments.datavalue = '';
};