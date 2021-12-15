import StockManagement.UserActions
//Abstraction
abstract class User(): UserActions{
    abstract fun getUserName():String;
    abstract fun getPassword():String;
    abstract fun getPermission():Boolean;
}