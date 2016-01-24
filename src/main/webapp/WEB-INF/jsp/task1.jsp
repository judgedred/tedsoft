<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 1</title>
    <script type="text/javascript" src="resources/js/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#keyForm").submit(function (event) {
                event.preventDefault();
                var keyword = $("#keyword").val();
                $.ajax({
                    url: "toggleJSON", data: {"keyword": keyword}, dataType: "json", success: function (data) {
                        $("#result").text(data.deviceMsg);
                    }
                });
            });
        });
    </script>
</head>
<body>
<h3>Device state change</h3>

<form action=""  id="keyForm">
    <label for="keyword">Enter key </label>
    <input type="text" id="keyword"/>
    <input type="submit" value="Send"/>
</form>

<div id="result"></div>
</body>
</html>
