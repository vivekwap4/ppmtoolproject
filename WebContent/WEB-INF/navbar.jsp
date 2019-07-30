<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <!-- NavBar Component Code -->
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        <div class="container">
            <a class="navbar-brand" href="dashboard.jsp">
                Personal Kanban Tool
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                <span class="navbar-toggler-icon" />
            </button>

            <div class="collapse navbar-collapse" id="mobile-nav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/ppmtoolproject/dashboard.jsp">
                            Dashboard
                        </a>
                    </li>
                </ul>

                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link " href="register.jsp">
                            Sign Up
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">
                            Login
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- End of NavBar -->

</body>
</html>