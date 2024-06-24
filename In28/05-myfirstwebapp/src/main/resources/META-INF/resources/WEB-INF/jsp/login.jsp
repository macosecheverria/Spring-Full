<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h1>Login Page</h1>
    <h2>Welcome to the login page</h2>
    <form method="post"> 
        <span>Name</span>
        <input type="text" name="name" placeholder="Writte your name">
        <span>Password</span>
        <input type="password" name="password" placeholder="Writte your password">
        <input type="submit" >
    </form>
    <p>Error: ${errorMessage}</p>
</body>
</html>