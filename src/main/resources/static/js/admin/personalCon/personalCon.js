$().ready(function () {
    var validator = $('#c_person_form').validate({
        errorElement: 'span', //default input error message container
        errorClass: 'error-tips', // default input error message class
        rules: {
            newPassword: {
                equalTo: "#password1"
            },
            phoneNumber1: {
                phoneUS: true
            },
            phoneNumber2: {
                phoneUS: true
            },
            email: {
                email: true
            },
        },

        messages: {
            newPassword: {
                equalTo: "两次输入密码不一致"
            },
            phoneNumber1: {
                phoneUS: "请输入正确的手机号"
            },
            phoneNumber2: {
                phoneUS: "请输入正确的手机号"
            },
            email: {
                email: "请输入正确的邮箱"
            }
        }
    });

    $('#reset').click(function () {
        $("input[disabled!='disabled']").val('');
        $("input[name='sex']").attr('checked',false);
    });
    $('#saveCon').click(function () {
        var userId = $('#userId').val();
        if(validator.form()) {
            AjaxTool.post('personalCon/updateIndividualMessage', $('#c_person_form').serialize()+"&id="+userId,function (data) {
                alert(data.message);
            })
        } else {
            alert("保存失败");
        }
    });
});


