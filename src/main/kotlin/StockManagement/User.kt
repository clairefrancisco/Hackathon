import StockManagement.UserActions
//Abstraction
abstract class User(): UserActions{
    abstract fun getUserName():String;
    abstract fun getPassword():String;
    abstract fun getPermission():Boolean;
}
// Extension Functions
fun User.loginMessage() = println("\nLogged in successfully")

fun User.logoutMessage() = println("\nLogged out successfully")
