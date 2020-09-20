<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改用户</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.8.0/jquery-1.8.0.min.js"></script>
</head>
<body>
<form method="post" action="/app/" id="update">
    <input type="hidden" name="id" value="${user.id}" readonly/>

    name:
    <label>
        <input type="text" id="userName" name="userName" value="${user.userName}"/>
    </label>
    <br/>

    phone:
    <label>
        <input type="text" id="phone" name="phone" value="${user.phone}"/>
    </label>
    <br/>

    email:
    <label>
        <input type="text" id="email" name="email" value="${user.email}"/>
    </label>
    <br/>

    address:
    <label>
        <input type="text" id="address" name="address" value="${user.address}"/>
    </label>
    <br/>

    <input type="submit" name="提交"/>
</form>
</body>
<script>

    /*$("#update").submit(function () {
        let userName = $("#userName").val();
        console.log(userName);
        let phone = $("#phone").val();
        console.log(phone);
        let email = $("#email").val();
        console.log(email);
        let address = $("#address").val();
        console.log(address);
        let id = $("#id").val();
        console.log(id);

        $.ajaxSetup({
            contentType: 'application/json'
        });

        $.ajax({
            url: "/app/one",
            type: "post",
            data: {
                "userName": userName,
                "id": id,
                "phone": phone,
                "email": email,
                "address": address
            },
            dataType: "json",

            success: function (data) {
                if (data) {
                    console.log("修改成功!");
                    window.location.herf = "/app/list";
                }
                //
                else {
                    alert("修改失败!");
                }
            },

            error: function (data) {
                console.log(data);
                alert("修改失败!");
            }
        })
    })*/
</script>
</html>
