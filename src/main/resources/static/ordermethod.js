$(document).ready(function(){
alert("hi");

$("#modeError").hide();
$("#codeError").hide();
$("#descError").hide();
$("#typeError").hide();
$("#orderAcptError").hide();
var modeError=false;
var codeError=false;
var descError=false;
var typeError=false;
var orderAcptError=false;
$("[name='orderMode']").change(function()
{
validate_orderMode();
}
);

$("#orderCode").keyup(function()
{
 $(this).val($(this).val().toUpperCase());
              
validate_odercode();
}
);

$("#orderDesc").keyup(function(){
validateorder_desc();
}
);
           
    $("#orderType").change(function(){
               validate_orderType();
            })
            
 $("[name='orderAcpt']").change(function(){
            validate_orderAcpt();
        })
            
                   
function validate_orderMode(){
alert("validate");
var len = $('[name="orderMode"]:checked').length;
                if(len==0) {
                    $("#modeError").show();
                    $("#modeError").html("Please choose one Option");
                    $("#modeError").css('color','red');
                    modeError = false;
                } else {
                   alert(len);
                    $("#modeError").hide();
                    modeError= true;
                }
                return  modeError;
                }
                
 function validate_odercode() {
                var val = $("#orderCode").val();
                var exp =/^[A-Z0-9\.\-]{4,12}$/;
                if(val=='') {
                    $("#codeError").show();
                    $("#codeError").html("Enter <b>Order Code</b>");
                    $("#codeError").css('color','red');
                    codeError = false;
                } else if(!exp.test(val)) {
                    $("#codeError").show();
                    $("#codeError").html("Invaild <b>order Code</b>");
                    $("#codeError").css('color','red');
                    codeError = false;
                } 
                 else {
                    $("#codeError").hide();
                    codeError = true;
                }
                return codeError;
            } 
            
function validateorder_desc() {
                var val = $("#orderDesc").val();
                var exp =/^[A-Za-z0-9\.\-]{4,12}$/;
                if(val=='') {
                    $("#descError").show();
                    $("#descError").html("Enter <b>Order desc</b>");
                    $("#descError").css('color','red');
                    descError = false;
                } else if(!exp.test(val)) {
                    $("#descError").show();
                    $("#descError").html("Invaild <b>order desc</b>");
                    $("#descError").css('color','red');
                    descError = false;
                } 
                 else {
                    $("#descError").hide();
                    descError = true;
                }
                return descError;
            } 
 function validate_orderType(){
 
 var v=$("#orderType").val();
 if(v=='')
 {
  $("#typeError").show();
                    $("#typeError").html("Enter <b>Order desc</b>");
                    $("#typeError").css('color','red');
                    typeError=false;
                   
 }
 else
 {
 $("#typeError").hide();
 typeError=true;
 }
 return typeError;
 };
 
 
 function validate_orderAcpt() {
            var len = $("[name='orderAcpt']:checked").length;
            if(len==0) {
                $("#orderAcptError").show();
                $("#orderAcptError").html("*Choose at least<b> one Option</b>");
                $("#orderAcptError").css('color','red');
                orderAcptError = false;
            } else {
                $("#orderAcptError").hide();
                orderAcptError = true;
            }
            return orderAcptError;
        }
          $("#orderMethodForm").submit(function () {
          //validate all input again
          validate_orderMode();
          validate_odercode();
          validate_orderType();
          validate_orderAcpt();
          validateorder_desc();

          //if all are ture then submit form
          if (modeError && codeError 
          && typeError && orderAcptError
          && descError ) return true;
          //else do not submit form
          else return false;
        });
      });
        
 
