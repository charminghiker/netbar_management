        import AjaxUtils from "./ajaxUtils.js";

        let ajaxUtils = new AjaxUtils();

        function errorMsg(name) {
            document.querySelector(`#${name}Msg>.msgInfo`).classList.add("errorMsgInfo");
            document.querySelector(`#${name}Msg>.msgImage`).classList.add("errorMsgImage");
        }

        function successMsg(name) {
            document.querySelector(`#${name}Msg>.msgInfo`).classList.add("successMsgInfo");
            document.querySelector(`#${name}Msg>.msgImage`).classList.add("successMsgImage");
        }

        function deleteStyle(name) {
            document.querySelector(`#${name}Msg>.msgInfo`).innerHTML = "";
            document.querySelector(`#${name}Msg>.msgInfo`).classList.remove("successMsgInfo");
            document.querySelector(`#${name}Msg>.msgImage`).classList.remove("successMsgImage");
            document.querySelector(`#${name}Msg>.msgInfo`).classList.remove("errorMsgInfo");
            document.querySelector(`#${name}Msg>.msgImage`).classList.remove("errorMsgImage");
        }



        function checkUserName(response) {
            document.querySelector("#userNameMsg>.msgInfo").innerHTML = response.data.message;
            if (response.data.result == "ok") {
                successMsg("userName");
            } else {
                errorMsg("userName");
            }
        }
        //用户名校验
        function userNameBlurOperation() {
            let value = document.getElementById("userName").value;
            let reg = /^[a-zA-Z\d]+$/; //只能为数字和字母
            if (value == "") {
                document.querySelector("#userNameMsg>.msgInfo").innerHTML = "用户名不能为空！";
                errorMsg("userName");
            } else if (!reg.test(value)) {
                document.querySelector("#userNameMsg>.msgInfo").innerHTML = "用户名不能为中文！";
                errorMsg("userName");
            } else if (value.length < 5) {
                document.querySelector("#userNameMsg>.msgInfo").innerHTML = "用户名长度不能小于5！";
                errorMsg("userName");
            } else {
                //ajaxUtils.get("./data/userNameResponse.json?userName=" + document.getElementById("userName"), checkUserName);
                axios.get("./data/userNameResponse.json?userName=" + document.getElementById("userName"))
                    .then((response) => {
                        checkUserName(response);
                    })
                    .catch((error) => {
                        console.log(error);
                    });
            }
        }

        function userNameFocusOperation() {
            deleteStyle("userName");
        }

        function nickNameBlurOperation() {
            let value = document.getElementById("nickName").value;
            if (value == "") {
                document.querySelector("#nickNameMsg>.msgInfo").innerHTML = "用户名不能为空！";
                errorMsg("nickName");
            } else if (value.length < 2) {
                document.querySelector("#nickNameMsg>.msgInfo").innerHTML = "用户名长度不能小于5！";
                errorMsg("nickName");
            } else {
                document.querySelector("#nickNameMsg>.msgInfo").innerHTML = "输入符合要求！";
                successMsg("nickName");
            }
        }

        function nickNameFocusOperation() {
            deleteStyle("nickName");
        }

        function createProvinceOption(xhr) {
            let json = xhr.response;
            if (json.result == "ok") {
                json.data.forEach((element) => {
                    let option = document.createElement("option");
                    [option.value, option.innerHTML] = [element.code, element.name];
                    province.appendChild(option);
                });
            }
        }

        function createCityOption(xhr) {
            let provinceValue = document.getElementById("province").value;
            let json = xhr.response;
            if (json.result == "ok") {
                json.data.filter(element => element.code.substring(0, 2) == provinceValue).forEach((element) => {
                    let option = document.createElement("option");
                    [option.value, option.innerHTML] = [element.code, element.name];
                    city.appendChild(option);
                });
            }
        }

        function provinceInit() {
            let province = document.getElementById("province");
            let option = document.createElement("option");
            [option.value, option.innerHTML] = ["00", "请选择省份"];
            province.appendChild(option);
            ajaxUtils.get("./data/province.json", createProvinceOption);
        }

        function cityInit() {
            let city = document.getElementById("city");
            city.length = 0;
            let option = document.createElement("option");
            [option.value, option.innerHTML] = ["0000", "请选择城市"];
            city.appendChild(option);
            let provinceValue = document.getElementById("province").value;
            ajaxUtils.get("./data/city.json?provinceId=" + provinceValue, createCityOption);
        }

        function passwordBlurOperation() {
            let value = document.getElementById("password").value;
            if (value == "") {
                document.querySelector("#passwordMsg>.msgInfo").innerHTML = "用户名不能为空！";
                errorMsg("password");
            } else if (value.length < 6) {
                document.querySelector("#passwordMsg>.msgInfo").innerHTML = "用户名长度不能小于6！";
                errorMsg("password");
            } else {
                document.querySelector("#passwordMsg>.msgInfo").innerHTML = "密码输入符合要求！";
                successMsg("password");
            }
        }

        function passwordFocusOperation() {
            deleteStyle("password");
        }

        function rePasswordBlurOperation() {
            let password = document.getElementById("password").value;
            let rePassword = document.getElementById("rePassword").value;
            if (rePassword == "") {
                document.querySelector("#rePasswordMsg>.msgInfo").innerHTML = "用户名不能为空！";
                errorMsg("rePassword");
            } else if (password !== rePassword) {
                document.querySelector("#rePasswordMsg>.msgInfo").innerHTML = "两次输入的密码不相同！";
                errorMsg("rePassword");
            } else {
                document.querySelector("#rePasswordMsg>.msgInfo").innerHTML = "密码输入符合要求！";
                successMsg("rePassword");
            }
        }

        function rePasswordFocusOperation() {
            deleteStyle("rePassword");
        }

        function emailFocusOperation() {
            deleteStyle("email");
        }

        function emailBlurOperation() {
            let regExp = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
            let value = document.getElementById("email").value;
            if (value.length == 0) {
                document.querySelector("#emailMsg>.msgInfo").innerHTML = "邮处地址不能不为空！";
                errorMsg("email");
            } else if (!regExp.test(value)) {
                document.querySelector("#emailMsg>.msgInfo").innerHTML = "邮箱地址格式错误！";
                errorMsg("email");
            } else {
                document.querySelector("#emailMsg>.msgInfo").innerHTML = "邮箱地址格式符合要求！";
                successMsg("email");
            }
        }

        function photoBlurOperation() {
            let regExp = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
            let value = document.getElementById("photo").value;
            if (value.length == 0) {
                document.querySelector("#photoMsg>.msgInfo").innerHTML = "手机号不能不为空！";
                errorMsg("photo");
            } else if (!regExp.test(value)) {
                document.querySelector("#photoMsg>.msgInfo").innerHTML = "手机号输入错误！";
                errorMsg("photo");
            } else {
                document.querySelector("#photoMsg>.msgInfo").innerHTML = "手机号符合要求！";
                successMsg("photo");
            }
        }

        function photoFocusOperation() {
            deleteStyle("photo");
        }

        function init() {
            //前端校验
            document.getElementById("userName").addEventListener("blur", userNameBlurOperation, false);
            document.getElementById("userName").addEventListener("focus", userNameFocusOperation, false);
            document.getElementById("nickName").addEventListener("blur", nickNameBlurOperation, false);
            document.getElementById("nickName").addEventListener("focus", nickNameFocusOperation, false);
            document.getElementById("password").addEventListener("blur", passwordBlurOperation, false);
            document.getElementById("password").addEventListener("focus", passwordFocusOperation, false);
            document.getElementById("rePassword").addEventListener("blur", rePasswordBlurOperation, false);
            document.getElementById("rePassword").addEventListener("focus", rePasswordFocusOperation, false);
            document.getElementById("email").addEventListener("blur", emailBlurOperation, false);
            document.getElementById("email").addEventListener("focus", emailFocusOperation, false);
            document.getElementById("photo").addEventListener("blur", photoBlurOperation, false);
            document.getElementById("photo").addEventListener("focus", photoFocusOperation, false);
            //级联下拉列表
            provinceInit();
            document.getElementById("province").addEventListener("change", cityInit, false);
        }
        window.addEventListener("load", init, false);