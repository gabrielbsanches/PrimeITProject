<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="google" content="notranslate" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Language" content="en">
    <title>Row Editing Grid Example</title>
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/extjs/examples/shared/example.css"/>" />

    <!-- GC -->

    <script src="<c:url value="/resources/extjs/examples/shared/include-ext.js" />"></script>
    <script src="<c:url value="/resources/extjs/examples/shared/options-toolbar.js" />"></script>
    <script src="<c:url value="/resources/extjs/examples/grid/row-editing.js" />"></script>

    <style type="text/css">
        .employee-add {
            background-image: url('/resources/extjs/examples/shared/icons/fam/user_add.gif') !important;
        }

        .employee-remove {
            background-image: url('/resources/extjs/examples/shared/icons/fam/user_delete.gif') !important;
        }
    </style>
</head>
<body>
    <h1>Row Editing Grid Example</h1>
    <p>This example shows how to create a grid with inline row based editing using the row editing plugin.</p>
    <p>Note that the js is not minified so it is readable. See <a href="/resources/extjs/examples/grid/row-editing.js">row-editing.js</a>.</p>
    <div id="editor-grid"></div>
</body>
</html>