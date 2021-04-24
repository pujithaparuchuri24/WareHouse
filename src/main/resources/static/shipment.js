$(document).ready(function(){
	    alert("hi");
            $("#modeError").hide();
            $("#codeError").hide();
            $("#enableError").hide();
            $("#gradeError").hide();
            $("#descError").hide();

            var modeError = false;
            var codeError = false;
            var enableError = false;
            var gradeError = false;
            var descError = false;

            function validate_shipmentMode() {
                var val = $("#shipmentMode").val();
                 alert(val);
                if(val=='') {
	 alert(val);
                   $("#modeError").show(); 
                   $("#modeError").html("Please choose <b> Shipment Mode</b>");
                   $("#modeError").css('color','red'); 
                   modeError = false;
                } else {
	 alert(val);
                    $("#modeError").hide(); 
                    modeError = true;
                }
                return modeError;
            }

            function validate_shipmentCode() {
                var val = $("#shipmentCode").val();
                var exp =/^[A-Z0-9\.\-]{4,12}$/;
                if(val=='') {
                    $("#codeError").show();
                    $("#codeError").html("Enter <b>Shipment Code</b>");
                    $("#codeError").css('color','red');
                    codeError = false;
                } else if(!exp.test(val)) {
                    $("#codeError").show();
                    $("#codeError").html("Invaild <b>Shipment Code</b>");
                    $("#codeError").css('color','red');
                    codeError = false;
                } 
                 else {
                    $("#codeError").hide();
                    codeError = true;
                }
                return codeError;
            }

         function validate_enableShipment() {
                var val = $("#enableShipment").val();
                if(val=='') {
                   $("#enableShipment").show(); 
                   $("#enableShipment").html("Please choose <b> Shipment Mode</b>");
                   $("#enableShipment").css('color','red'); 
                   enableShipment = false;
                } else {
                    $("#enableShipment").hide(); 
                    enableShipment = true;
                }
                return enableShipment;
            }
            function validate_shipmentGrade() {
                var len = $('[name="shipmentGrade"]:checked').length;
                if(len==0) {
                    $("#gradeError").show();
                    $("#gradeError").html("Please choose one Option");
                    $("#gradeError").css('color','red');
                    gradeError = false;
                } else {
                    $("#gradeError").hide();
                    gradeError = true;
                }
                return gradeError;
            }

            function validate_shipmentDescription(){
                var val = $("#shipmentDescription").val();
                var exp =/^[A-Za-z0-9\.\,\s\-]{5,150}$/;
                if(val=='') {
                    $("#descError").show();
                    $("#descError").html("Description <b> can not be empty</b>");
                    $("#descError").css('color','red');
                    descError = false;
                } else if(!exp.test(val)) {
                    $("#descError").show();
                    $("#descError").html("Description <b> must bte 5-150 chars only</b>");
                    $("#descError").css('color','red');
                    descError = false;
                } else {
                    $("#descError").hide();
                    descError = true;
                }
                return descError;
            }

            $("#shipmentMode").change(function(){
               validate_shipmentMode();
            })
            $("#shipmentCode").keyup(function(){
                $(this).val($(this).val().toUpperCase());
                validate_shipmentCode();
            })
            $("enableShipment").change(function(){
               validate_enableShipment();
            })
            $("[name='shipmentGrade']").change(function(){
                validate_shipmentGrade();
            })
            $("#shipmentDescription").keyup(function(){
                validate_shipmentDescription();
            })

            $("#shipRegForm").submit(function(){
                validate_shipmentMode();
                validate_shipmentCode();
                validate_enableShipment();
                validate_shipmentGrade();
                validate_shipmentDescription();

                if(modeError && codeError 
                && enableError && gradeError
                && descError ) 
                    return true; //means submit form
                else 
                    return false;//dont  submit form
            });
        });