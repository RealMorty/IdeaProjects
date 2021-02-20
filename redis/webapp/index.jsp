<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <title>省份查询</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            // alert(2)
            $.get("provinceServlet", {}, function (data) {
                var province = $("#province");
                alert(3)
                $(data).each(function () {
                    alert(1);
                    var option = "<option name='"+this.id+"'>"+this.name+"</option>";
                    province.append(option);
                });
            });
        });
    </script>
</head>
<body>
<select id="province">
    <option>--请选择省份--</option>
</select>
</body>
</html>