$(document).ready(function(){
    $('#patientId').blur(function () {
        // if (event.keyCode === 13) // check press enter key event
        // {
        //     event.preventDefault();// prevent curent event

            var patientId = $(this).val();
            if (patientId) {
                $.ajax({
                    url: '/patients/' + patientId,
                    type: 'GET',
                    dataType: 'json',
                    success: function (patient) {
                        $('#patientName').val(patient.name);
                    }
                });
            } else {
                $('#patientName').val('');
            }
        //}
    });
});