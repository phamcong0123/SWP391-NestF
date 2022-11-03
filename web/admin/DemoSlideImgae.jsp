<%-- 
    Document   : DemoSlideImgae
    Created on : Nov 3, 2022, 2:10:45 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>Product Card/Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/productdetail.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
    </head>

    <body>
        <div id="big-image">
            <img src="http://lorempixel.com/400/200/sports/1/">
            <img src="http://lorempixel.com/400/200/fashion/1/">
            <img src="http://lorempixel.com/400/200/city/1/">
        </div>

        <div class="small-images">
            <img src="http://lorempixel.com/100/50/sports/1/">
            <img src="http://lorempixel.com/100/50/fashion/1/">
            <img src="http://lorempixel.com/100/50/city/1/">
        </div>
        <script>
            $(function () {
                $("#big-image img:eq(0)").nextAll().hide();
                $(".small-images img").click(function (e) {
                    var index = $(this).index();
                    $("#big-image img").eq(index).show().siblings().hide();
                });
            });
        </script>
        <script src="http://code.jquery.com/jquery-1.6.4.js"></script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
