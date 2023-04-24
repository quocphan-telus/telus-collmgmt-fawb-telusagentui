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

    debugger;
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
Partial.button1Click = function($event, widget) {
    debugger;

    Partial.Widgets.createNoteButton.hidePopover();

    Partial.Widgets.CreateUserNotesdialog1.open();



};

Partial.button3Click = function($event, widget) {

    if (Partial.Widgets.fileupload1.selectedFiles != undefined) {

        Partial.Widgets.fileupload1.selectedFiles[0].name;
    }
    debugger;
    const message = document.getElementById("p01");
    message.innerHTML = "";

    if (Partial.Widgets.textarea1.datavalue == undefined || Partial.Widgets.textarea1.datavalue == "") {
        try {
            isError = true;
            throw "Please enter the note"
        } catch (err) {
            message.innerHTML = err;
        }
    } else {
        var banId = Partial.Widgets.getEntityDetailsTable1_1.selecteditem.banId;
        var note = Partial.Widgets.textarea1.datavalue;
        var entityId = Partial.Widgets.getEntityDetailsTable1_1.dataset[0].entityId;

        Partial.Variables.saveNote.setInput({

            'entityId': entityId,
            'banId': banId,
            'notes': note

        });
    }



    //         Partial.Variables.saveNote.invoke({}, function(data) {
    //             // Success Callback
    //             console.log("success", data);
    //         }, function(error) {
    //             // Error Callback
    //             console.log("error", error)

    //         });
    //     }
    // }


};
Partial.anchor1Click = function($event, widget) {

    debugger;

    Partial.Widgets.getEntityDetailsTable1_1.selecteditem = false;

};