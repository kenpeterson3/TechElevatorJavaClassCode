# Form Validation

## Login Form

Create a page that allows the user to _login_ to the site (it doesn't actually log them in). This page will ask the user for and validate the following information:

| Field | Rules |
|-------|-------|
| `Email` | Required, Valid Email Address |
| `Password` | Required |

### Login Validation Screen

![Failed Validation](etc/Login-Validation.png)

### Login Success Screen

![Confirmation Page](etc/Login-Success.png)

<p style="page-break-before: always;"></p>

## Registration Form

Create a page that allows the user to _register_ to the site (it doesn't actually register them). This page will ask the user for and validate the following information:

| Field | Rules |
|-------|-------|
| `First Name` | Required, Max Length (20) |
| `Last Name` | Required, Max Length (20) |
| `Email` | Required, Valid Email Address | 
| `Confirm Email` | Must Match `Email` |
| `Password` | Required, Minimum Length (8) |
| `Confirm Password` | Must Match `Password` |
| `Birth Date` | Required, Valid Date |
| `Number of Tickets` | Required, Valid Range (1 to 10) |

### New Registration Page

![New Registration Page](etc/New-Registration.png)

### Registration Validation Screen

![Registration Validation Errors](etc/Registration-Validation.png)

### Registration Success Screen

![Registration Success Screen](etc/Registration-Success.png)