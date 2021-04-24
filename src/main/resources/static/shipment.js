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
                
          function   validate_shipmentMode()
          {
          var v=$("#shipmentMode").val();
          if(v=='')
          {
          alert("if");
          $("#modeError").show();
           $("#modeError").html("please <b>select one</b>");
            $("#modeError").css('color','red');
            modeError=false
            }
            else
            {
            alert("else");
             $("#modeError").hide();
             modeError=true;
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
            function validate_enableShipment()
            {
            alert("enable");
            var v=$("#enableShipment").val();
            alert(v);
            if(v=='')
            {
            alert("if");
            $("#enableError").show();
            $("#enableError").html("<b>select one</b>");
            $("#enableError").css('color','red');
            enableError=false;
            }
            else
            {
             alert("else");
            $("#enableError").hide();
            enableError=true;
           }
           return enableError;
            }
        
            function validate_shipmentGrade() {
                var len = $('[name="grade"]:checked').length;
                if(len==0) {
                    $("#gradeError").show();
                    $("#gradeError").html("Please choose one Option");
                    $("#gradeError").css('color','red');
                    gradeError = false;
                } else {
                   alert(len);
                    $("#gradeError").hide();
                    gradeError = true;
                }
                return gradeError;
            }

            function validate_shipmentDescription(){
            alert("vlaidate");
                var val = $("#desc").val();
                var exp =/^[A-Za-z0-9\.\,\s\-]{5,150}$/;
                if(val=='') {
                    $("#descError").show();
                    $("#descError").html("Description <b> can not be empty</b>");
                    $("#descError").css('color','red');
                    descError = false;
                    alert("if");
                } else if(!exp.test(val)) {
                    $("#descError").show();
                    $("#descError").html("Description <b> must bte 5-150 chars only</b>");
                    $("#descError").css('color','red');
                    descError = false;
                    alert("elseif");
                } else {
                    $("#descError").hide();
                    descError = true;
                    alert("else");
                    
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
            $("#enableShipment").change(function(){
               validate_enableShipment();
            })
            $("[name='grade']").change(function(){
                validate_shipmentGrade();
            })
            $("#desc").keyup(function(){
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