
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
</head>
<body>

${msg}


<select style="width:500px;" class="js-example-basic-single"  name="state">
    <option value="AL">Alabama</option>
    <option value="WY">Wyoming</option>
</select>

<br/>

<select style="width:500px;"  class="js-example-basic-single" multiple="multiple" name="state">
    <option value="AL">Alabama</option>
    <option value="WY">Wyoming</option>
</select>
</body>
</html>

<script>
    $(document).ready(function() {
        $('.js-example-basic-single').select2();
    });

    $(".js-example-basic-multiple-limit").select2({
        maximumSelectionLength: 2
    });



</script>